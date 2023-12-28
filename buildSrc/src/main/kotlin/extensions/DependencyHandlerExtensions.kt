package extensions

import Library
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler


fun DependencyHandler.implementation(dependencyNotation: Any): Dependency? =
    add("implementation", dependencyNotation)

fun DependencyHandler.testImplementation(dependencyNotation: Any): Dependency? =
    add("testImplementation", dependencyNotation)

fun DependencyHandler.androidTestImplementation(dependencyNotation: Any): Dependency? =
    add("androidTestImplementation", dependencyNotation)

fun DependencyHandler.debugImplementation(dependencyNotation: Any): Dependency? =
    add("debugImplementation", dependencyNotation)

fun DependencyHandler.kapt(dependencyNotation: Any): Dependency? =
    add("kapt", dependencyNotation)


fun DependencyHandler.addKtx() {
    implementation(Library.Ktx.coreKtx)
    implementation(Library.Ktx.lifecycleRuntimeKtx)
    implementation(Library.Ktx.lifecycleViewmodelKtx)
}

fun DependencyHandler.addCompose() {
    implementation(Library.Compose.activityCompose)
    implementation(platform(Library.Compose.composeBom))
    implementation(Library.Compose.ui)
    implementation(Library.Compose.uiGraphics)
    implementation(Library.Compose.uiToolingPreview)
    implementation(Library.Compose.material3)
    implementation(Library.Compose.navigationCompose)
    debugImplementation(Library.Compose.uiTooling)
    debugImplementation(Library.Compose.uiTestManifest)
}

fun DependencyHandler.addTest() {
    testImplementation(Library.Test.junit)
    androidTestImplementation(Library.Test.androidxJunit)
    androidTestImplementation(Library.Test.espressoCore)
    androidTestImplementation(platform(Library.Compose.composeBom))
    androidTestImplementation(Library.Test.composeUiTestJunit4)
}

fun DependencyHandler.addKoinDi() {
    implementation(Library.Di.koinAndroid)
    implementation(Library.Di.koinAndroidxCompose)
}

fun DependencyHandler.addRetrofit2() {
    implementation(Library.Retrofit2.retrofit)
    implementation(Library.Retrofit2.converterGson)
    implementation(Library.Retrofit2.loggingInterceptor)
    implementation(Library.Retrofit2.gson)
}

val DependencyHandler.CORE_MODULE
    get() = implementation(project(mapOf("path" to ":core")))

val DependencyHandler.DOMAIN_MODULE
    get() = implementation(project(mapOf("path" to ":domain")))

val DependencyHandler.DATA_MODULE
    get() = implementation(project(mapOf("path" to ":data")))
