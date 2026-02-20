plugins {
    id("java")
}

group = "org.jikvict"
version = "1.0.0"

buildscript {
    repositories {
        mavenCentral()
        maven("https://jitpack.io")
    }
    dependencies {
        classpath("com.github.JIkvict.JIkvictTestingLibrary:JIkvictTestingPlugin:v0.0.10")
    }
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

apply(plugin = "org.jikvict.testing")
repositories {
    maven {
        url = uri("https://repo1.maven.org/maven2")
    }
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.JIkvict.JIkvictTestingLibrary:JIkvictTestingLibrary:v0.0.10")
    implementation("org.reflections:reflections:0.10.2")
}

tasks.test {
    useJUnitPlatform()
}
