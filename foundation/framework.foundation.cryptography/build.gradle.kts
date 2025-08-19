plugins {
    id("java")
}

val dataUtils = project.property("data-utils.version") as String
val cryptography = project.property("cryptography.version") as String
val bouncycastle = project.property("bouncycastle.version") as String

val jackson = project.property("jackson.version") as String
val mokito = project.property("mockito.version") as String
val junit = project.property("junit.version") as String
val junitLauncher = project.property("junit-launcher.version") as String
val assertj = project.property("assertj.version") as String

dependencies {
    implementation(project(":foundation:framework.foundation.common"))

    implementation("dev.retrotv:data-utils:$dataUtils")
    // implementation("dev.retrotv:cryptography-core:$cryptography")
    // implementation("dev.retrotv:cryptography-hash:$cryptography")
    // implementation("dev.retrotv:cryptography-cipher:$cryptography")
    // implementation("dev.retrotv:cryptography-password:$cryptography")
    implementation("org.bouncycastle:bcprov-jdk18on:$bouncycastle")

    // // 테스트용 라이브러리
    testImplementation("org.mockito:mockito-core:$mokito")
    testImplementation("org.junit.jupiter:junit-jupiter:$junit")
    testImplementation("org.junit.platform:junit-platform-launcher:$junitLauncher")
    testImplementation("org.assertj:assertj-core:$assertj")
}