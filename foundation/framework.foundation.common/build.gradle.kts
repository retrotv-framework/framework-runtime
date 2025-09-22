plugins {
    id("java")
}

val springBoot = project.property("spring-boot.version") as String
val jackson = project.property("jackson.version") as String
val dataUtils = project.property("data-utils.version") as String
val randomValue = project.property("random-value.version") as String

dependencies {
    compileOnly("org.springframework.boot:spring-boot-starter-logging:$springBoot")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jackson")
    implementation("dev.retrotv:data-utils:$dataUtils")
    implementation("dev.retrotv:random-value:$randomValue")
}