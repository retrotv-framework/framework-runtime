plugins {
    java
    jacoco
    `maven-publish`
    id("com.vanniktech.maven.publish") version "0.32.0"
    id("org.sonarqube") version "4.0.0.2929"
}

group = "dev.retrotv"
version = "0.0.24-alpha"

// Github Action 버전 출력용
tasks.register("printVersionName") {
    description = "이 프로젝트의 버전을 출력합니다."
    group = JavaBasePlugin.DOCUMENTATION_GROUP
    println(project.version)
}

allprojects {
    version = rootProject.version
    group = rootProject.group

    repositories {
        mavenCentral()
    }
}

subprojects {
    apply(plugin = "java")
    apply(plugin = "maven-publish")
    apply(plugin = "com.vanniktech.maven.publish")

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }

    tasks.test {
        useJUnitPlatform()
    }

    val springBoot = project.property("spring-boot.version") as String
    val lombok = project.property("lombok.version") as String
    val log4j = project.property("log4j.version") as String
    val slf4j = project.property("slf4j.version") as String

    dependencies {

        // Lombok 라이브러리
        compileOnly("org.projectlombok:lombok:$lombok")
        annotationProcessor("org.projectlombok:lombok:$lombok")

        // Spring Boot 라이브러리
        implementation("org.springframework.boot:spring-boot-starter-web:$springBoot")

        // Logging 라이브러리
        implementation("org.slf4j:slf4j-api:$slf4j")
        implementation("org.apache.logging.log4j:log4j-api:$log4j")
        implementation("org.apache.logging.log4j:log4j-core:$log4j")
        implementation("org.apache.logging.log4j:log4j-slf4j2-impl:$log4j")
    }
}
