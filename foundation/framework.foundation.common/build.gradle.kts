plugins {
    id("java")
}

val springBoot = project.property("spring-boot.version") as String
val jackson = project.property("jackson.version") as String

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-logging:$springBoot")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jackson")
}