plugins {
    id("java")
}

val springBoot = project.property("spring-boot.version") as String
val jackson = project.property("jackson.version") as String

dependencies {
    compileOnly("org.springframework.boot:spring-boot-starter-logging:$springBoot")
    implementation("com.fasterxml.jackson.core:jackson-databind:$jackson")
    implementation("dev.retrotv:data-utils:0.24.2-alpha")
    implementation("dev.retrotv:random-value:1.2.1")
}