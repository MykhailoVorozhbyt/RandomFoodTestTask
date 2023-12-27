object Library {

    object Ktx {
        const val coreKtx = "androidx.core:core-ktx:1.12.0"
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.6.2"
    }


    object Compose {
        //implementation
        val activityCompose = "androidx.activity:activity-compose:1.8.2"
        val composeBom = "androidx.compose:compose-bom:2023.08.00"
        val ui = "androidx.compose.ui:ui"
        val uiGraphics = "androidx.compose.ui:ui-graphics"
        val uiToolingPreview = "androidx.compose.ui:ui-tooling-preview"
        val material3 = "androidx.compose.material3:material3"

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

}