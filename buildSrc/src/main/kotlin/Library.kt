object Library {

    object Ktx {
        const val coreKtx = "androidx.core:core-ktx:1.12.0"
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.6.2"
        const val lifecycleViewmodelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2"
    }


    object Compose {
        //implementation
        val activityCompose = "androidx.activity:activity-compose:1.8.2"
        val composeBom = "androidx.compose:compose-bom:2023.08.00"
        val ui = "androidx.compose.ui:ui:1.5.4"
        val uiGraphics = "androidx.compose.ui:ui-graphics:1.5.4"
        val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview:1.5.4"
        val material3 = "androidx.compose.material3:material3:1.1.2"
        val navigationCompose = "androidx.navigation:navigation-compose:2.7.6"

        //debugImplementation
        const val uiTooling = "androidx.compose.ui:ui-tooling"
        const val uiTestManifest = "androidx.compose.ui:ui-test-manifest"
    }

    object Test {
        const val junit = "junit:junit:4.13.2"
        const val androidxJunit = "androidx.test.ext:junit:1.1.5"
        const val espressoCore = "androidx.test.espresso:espresso-core:3.5.1"
        const val composeUiTestJunit4 = "androidx.compose.ui:ui-test-junit4"
    }

    object Retrofit2 {
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val converterGson = "com.squareup.retrofit2:converter-gson:2.9.0"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:4.12.0"
        const val gson = "com.google.code.gson:gson:2.8.6"
    }

    object Di {
        const val koinAndroid = "io.insert-koin:koin-android:3.5.3"
        const val koinAndroidxCompose = "io.insert-koin:koin-androidx-compose:3.5.3"
    }

    object Coil {
        const val coilCompose = "io.coil-kt:coil-compose:2.5.0"
    }


}