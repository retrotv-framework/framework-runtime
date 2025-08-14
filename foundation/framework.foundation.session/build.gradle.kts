plugins {
    id("java")
}

val springBoot = project.property("spring-boot.version") as String
val springBootSession = project.property("spring-boot-session.version") as String

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-redis:$springBoot")
    implementation("org.springframework.session:spring-session-data-redis:$springBootSession")
}