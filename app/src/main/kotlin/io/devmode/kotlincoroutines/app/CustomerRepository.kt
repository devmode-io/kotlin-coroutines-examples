package io.devmode.kotlincoroutines.app

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import io.devmode.kotlincoroutines.database.jooq.tables.Customers.CUSTOMERS
import io.devmode.kotlincoroutines.database.jooq.tables.records.CustomersRecord
import kotlinx.coroutines.reactive.awaitFirst
import org.jooq.DSLContext

class CustomerRepository(private val dslContext: DSLContext) {
    suspend fun truncateTable(): Either<Throwable, Int> = runCatching {
        dslContext.truncate(CUSTOMERS).awaitFirst().right()
    }.getOrElse { it.left() }

    suspend fun insertCustomers(customers: List<CustomersRecord>): Int? {
        return dslContext
            .insertInto(CUSTOMERS)
            .columns(
                CUSTOMERS.ID,
                CUSTOMERS.FIRST_NAME,
                CUSTOMERS.LAST_NAME
            )
            .valuesOfRecords(customers)
            .awaitFirst()
    }
}