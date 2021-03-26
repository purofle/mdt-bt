plugins {
    java
    kotlin("jvm") version "1.4.30"
    id("net.mamoe.mirai-console") version "2.5-RC"
}

group = "org.example"
version = "1.0-SNAPSHOT"

java.sourceCompatibility = JavaVersion.VERSION_15
java.targetCompatibility = JavaVersion.VERSION_15

repositories {
    maven("https://jitpack.io")
    maven("https://maven.aliyun.com/repository/public")
}

dependencies {
    val mindustryversion = "v123"
    implementation(kotlin("stdlib"))
    testCompile("junit", "junit", "4.12")
    compile("com.github.Anuken.Arc:arc-core:${mindustryversion}")
    compile("com.github.Anuken.Mindustry:core:${mindustryversion}")
}
