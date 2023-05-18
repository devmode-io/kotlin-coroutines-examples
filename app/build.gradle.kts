plugins {
    id("io.devmode.kotlincoroutines.application-conventions")
}

dependencies {
    implementation(libs.coroutines)
}

application {
    mainClass.set("io.devmode.kotlincoroutines.app.AppKt")
}
