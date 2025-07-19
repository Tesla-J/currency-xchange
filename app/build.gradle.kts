import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

val localProperties = Properties().apply{
    load(FileInputStream(rootProject.file("local.properties")))
}

android {
    namespace = "dev.rmarcos.currencyxchange"
    compileSdk = 35

    defaultConfig {
        applicationId = "dev.rmarcos.currencyxchange"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        debug {
            resValue("string", "APP_ID", localProperties["SAMPLE_APP_ID"].toString())
            resValue("string", "TOP_AD_BAR", localProperties["SAMPLE_AD_TOP_BAR"].toString())
            resValue("string", "BOTTOM_AD_BAR", localProperties["SAMPLE_AD_BOTTOM_BAR"].toString())
            resValue("string", "APP_RETURN_AD", localProperties["SAMPLE_AD_APP_RETURN"].toString())
        }
        release {
            resValue("string", "APP_ID", localProperties["RELEASE_APP_ID"].toString())
            resValue("string", "TOP_AD_BAR", localProperties["RELEASE_AD_TOP_BAR"].toString())
            resValue("string", "BOTTOM_AD_BAR", localProperties["RELEASE_AD_BOTTOM_BAR"].toString())
            resValue("string", "APP_RETURN_AD", localProperties["RELEASE_AD_APP_RETURN"].toString())
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation("com.google.android.gms:play-services-ads:24.4.0")
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}