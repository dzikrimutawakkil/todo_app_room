plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android) version "2.0.0"
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.example.todolistapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.todolistapp"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
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
        jvmTarget = "1.8"
    }
}
dependencies {
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.5.1")
    implementation("com.google.android.material:material:1.6.1")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Room Database
    implementation("androidx.room:room-ktx:2.5.1")
    ksp("androidx.room:room-compiler:2.5.1")
    implementation("androidx.room:room-runtime:2.5.1")
    implementation("androidx.room:room-testing:2.5.1")


    // Lifecycle components
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1")

    // Activity and Fragment KTX
    implementation("androidx.activity:activity-ktx:1.6.0")
    implementation("androidx.fragment:fragment-ktx:1.5.3")

    // Testing libraries
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
