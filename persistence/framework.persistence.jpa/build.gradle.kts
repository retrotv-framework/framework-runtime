plugins {
    id("java")
}

val querydsl = project.property("querydsl.version") as String
val springBoot = project.property("spring-boot.version") as String

dependencies {
    implementation("io.github.openfeign.querydsl:querydsl-jpa:$querydsl")
    implementation("io.github.openfeign.querydsl:querydsl-apt:$querydsl:jakarta")
    implementation("io.github.openfeign.querydsl:querydsl-core:$querydsl")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springBoot")
}