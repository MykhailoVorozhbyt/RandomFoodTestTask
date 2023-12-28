import extensions.CORE_MODULE
import extensions.DATA_MODULE
import extensions.DOMAIN_MODULE
import extensions.addCompose
import extensions.addKoinDi
import extensions.addKtx
import extensions.addRetrofit2
import extensions.addTest

plugins {
    id(Plugins.androidApplication)
    id(Plugins.jetbrainsKotlinAndroid)
}

android {
    namespace = AppConfig.namespace
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }

        buildConfigField(
            "String",
            "API_BASE_URL",
            "\"https://test-task-server.mediolanum.f17y.com\""
        )
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = AppConfig.kotlinCompilerExtensionVersion
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    addKtx()
    addCompose()
    addTest()
    addKoinDi()
    addRetrofit2()
    implementation(Library.Coil.coilCompose)
    CORE_MODULE
    DOMAIN_MODULE
    DATA_MODULE
}