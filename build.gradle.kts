plugins {
    kotlin("jvm") version "1.4.0"
    id("com.github.johnrengelman.shadow") version "6.0.0"
    java
}

group = "com.coldfire"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
//    implementation("com.github.elbekD:kt-telegram-bot:1.3.5")
//    implementation("com.sparkjava:spark-kotlin:1.0.0-alpha")
    implementation("io.github.kotlin-telegram-bot.kotlin-telegram-bot:telegram:5.0.0")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    shadowJar {
        minimize()
        manifest {
            attributes(mapOf("Main-Class" to "com.coldfire.cpe1cbot.TelegramBotKt"))
        }
        mustRunAfter(build)
    }
    task("stage") {
        dependsOn(shadowJar, clean)
    }
}


