plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.childrenprojects"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.childrenprojects"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {

    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("com.google.android.material:material:1.12.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")

    val nav_version = "2.7.7"
    // Java language implementation
    implementation("androidx.navigation:navigation-fragment:$nav_version")
    implementation("androidx.navigation:navigation-ui:$nav_version")
    // Feature module Support
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$nav_version")
    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:$nav_version")
    // Jetpack Compose Integration
    implementation("androidx.navigation:navigation-compose:$nav_version")
    implementation ("com.google.android.material:material:1.6.0")
    implementation ("androidx.navigation:navigation-fragment:2.4.2")
    implementation ("androidx.navigation:navigation-ui:2.4.2")

    val room_version = "2.6.1"
    implementation("androidx.room:room-runtime:$room_version")
    annotationProcessor("androidx.room:room-compiler:$room_version")
    // optional - Kotlin Extensions and Coroutines support for Room
    implementation("androidx.room:room-ktx:$room_version")
    // optional - RxJava2 support for Room
    implementation("androidx.room:room-rxjava2:$room_version")
    // optional - RxJava3 support for Room
    implementation("androidx.room:room-rxjava3:$room_version")
    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation("androidx.room:room-guava:$room_version")
    // optional - Test helpers
    testImplementation("androidx.room:room-testing:$room_version")
    // optional - Paging 3 Integration
    implementation("androidx.room:room-paging:$room_version")
}