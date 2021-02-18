plugins {
    java
    kotlin("jvm") version "1.4.21"
}

group = "net.eduard"
version = "1.0-SNAPSHOT"


repositories {
    mavenCentral()
    mavenLocal()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    implementation(kotlin("stdlib"))
    compileOnly("com.github.MilkBowl:VaultAPI:1.7")
    compileOnly("net.eduard:eduardapi:1.0-SNAPSHOT")
    compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT")
    testCompile("junit", "junit", "4.12")
}
java.sourceCompatibility = JavaVersion.VERSION_1_8
java.targetCompatibility = JavaVersion.VERSION_1_8
tasks.withType<Jar>{
    destinationDir = file("E:\\Tudo\\Minecraft - Server\\Servidor Teste\\plugins\\")
}
tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}