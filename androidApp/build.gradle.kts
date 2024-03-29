plugins {
    id("com.android.application")
    kotlin("android")
    //kotlin("kapt") version("1.3.70")
    id("org.jetbrains.kotlin.kapt") //Kapt para KMM, solo me falta  --> version("1.8.21")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.savasapp.ecommerceappmvvm.android"
    compileSdk = 33
    defaultConfig {
        applicationId = "com.savasapp.ecommerceappmvvm.android"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.4"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {
    implementation(project(":shared"))
    implementation("androidx.core:core-ktx:1.7.0")
    implementation("androidx.compose.ui:ui:1.4.3")
    implementation("androidx.compose.ui:ui-tooling:1.4.3")
    implementation("androidx.compose.ui:ui-tooling-preview:1.4.3")
    implementation("androidx.compose.foundation:foundation:1.4.3")
    implementation("androidx.compose.material:material:1.4.3")
    implementation("androidx.compose.material3:material3:1.1.1")
    implementation("androidx.activity:activity-compose:1.7.1")

    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    //Para crear el gràfico de navegaciòn
    implementation("androidx.navigation:navigation-compose:2.5.3")

    //Hilt Dagger
    implementation("com.google.dagger:hilt-android:2.44.2")
     kapt("com.google.dagger:hilt-android-compiler:2.44.2")

    //GSON convertir objetos que llegan en JSON hacia objetos  y
    //Retrofit  Para hacer peticiones al server
    implementation("com.squareup.retrofit2:retrofit:2.9.0:")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0:")

    implementation("com.squareup.moshi:moshi-kotlin:1.14.0")

    implementation("androidx.datastore:datastore-preferences:1.0.0")

    //File transformation
    implementation("commons-io:commons-io:2.7")

    //Async Image
    implementation("io.coil-kt:coil-compose:2.2.2")
}


