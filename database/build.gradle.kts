import org.jooq.meta.jaxb.SchemaMappingType

plugins {
    id("io.devmode.kotlincoroutines.library-conventions")
    alias(libs.plugins.jooq)
    alias(libs.plugins.flyway)
}

dependencies {
    implementation(libs.postgresql)
    jooqGenerator(libs.postgresql)
}

val dbUrl = "jdbc:postgresql://localhost:5432/coroutines_test"
val dbUsername = "postgres"
val dbPassword = "postgres"

jooq {
    version.set("3.18.4")
    configurations {
        val dbHost = "localhost"
        val dbUsername = "postgres"
        val dbPassword = "postgres"

        create("main") {
            generateSchemaSourceOnCompilation.set(false)
            jooqConfiguration.apply {
                jdbc.apply {
                    url = "jdbc:postgresql://$dbHost:5432/coroutines_test"
                    user = dbUsername
                    password = dbPassword
                }
                generator.apply {
                    name = "org.jooq.codegen.JavaGenerator"
                    database.apply {
                        schemata = listOf(
                            SchemaMappingType().apply {
                                inputSchema = "public"
                            }
                        )
                        name = "org.jooq.meta.postgres.PostgresDatabase"
                        isIncludeSequences = false
                        isIncludePrimaryKeys = true
                        isIncludeUniqueKeys = true
                        isIncludeForeignKeys = true
                        isIncludeCheckConstraints = true
                        isIncludeIndexes = true
                    }

                    generate.apply {
                        isRecords = true
                        isPojos = false
                        isFluentSetters = true
                    }

                    target.apply {
                        packageName = "io.devmode.kotlincoroutines.database.jooq"
                        directory = "src/main/generated"
                    }

                    strategy.name = "org.jooq.codegen.DefaultGeneratorStrategy"
                }
            }
        }
    }
}

flyway {
    locations = arrayOf("filesystem:./migrations")
    url = dbUrl
    user = dbUsername
    password = dbPassword
}