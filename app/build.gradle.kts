plugins {
    id("io.devmode.kotlincoroutines.application-conventions")
}

dependencies {
    implementation(projects.database)

    implementation(libs.arrow.kt.core)
    implementation(libs.coroutines)
    implementation(libs.hikaricp)
    implementation(libs.jooq)
    implementation(libs.jooq.kotlin)
    implementation(libs.jooq.kotlin.coroutines)
    implementation(libs.r2dbc.postgresql)
    implementation(libs.r2dbc.pool)
    implementation(libs.faker)
}

application {
    mainClass.set("io.devmode.kotlincoroutines.app.AppKt")
}
