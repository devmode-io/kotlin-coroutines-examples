package io.devmode.kotlincoroutines.app

import io.devmode.kotlincoroutines.database.jooq.tables.Customers.CUSTOMERS
import io.devmode.kotlincoroutines.database.jooq.tables.records.CustomersRecord
import io.github.serpro69.kfaker.Faker
import io.r2dbc.spi.ConnectionFactories
import io.r2dbc.spi.ConnectionFactoryOptions.*
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.runBlocking
import org.jooq.impl.DSL
import java.util.UUID

fun main(): Unit = runBlocking {
    val pooledConnectionFactory = ConnectionFactories.get(
        builder()
            .option(DRIVER, "pool")
            .option(PROTOCOL, "postgresql") // driver identifier, PROTOCOL is delegated as DRIVER by the pool.
            .option(HOST, "localhost")
            .option(PORT, 5432)
            .option(USER, "postgres")
            .option(PASSWORD, "postgres")
            .option(DATABASE, "coroutines_test")
            .build()
    )

    val dslContext = DSL.using(pooledConnectionFactory)

    val customerRepository = CustomerRepository(dslContext)

    val truncateResult = customerRepository.truncateTable()
    val insertResult = customerRepository.insertCustomers(createFakeCustomers(10))

    val records = dslContext.selectFrom(CUSTOMERS).limit(1).asFlow()

    records.onEach {
        println(it)
        delay(1000)
    }
}

fun createFakeCustomers(count: Int): List<CustomersRecord> {
    val faker = Faker()
    return generateSequence {
        CustomersRecord().apply {
            id = UUID.randomUUID().toString()
            firstName = faker.name.firstName()
            lastName = faker.name.lastName()
        }
    }.take(count)
        .toList()

}

//suspend fun insertCustomerTransaction(dslContext: DSLContext): CustomersRecord {
//    return dslContext.transactionCoroutine(::insertActor)
//}

