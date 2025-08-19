plugins {
    id("java")
}

val fileupload = project.property("fileupload.version") as String
val commonIo = project.property("commonIo.version") as String
val cryptography = project.property("cryptography.version") as String
val uuid = project.property("uuid.version") as String
val extendedFile = project.property("extended-file.version") as String

dependencies {
    implementation("org.apache.commons:commons-fileupload2-jakarta-servlet6:$fileupload")
    implementation("commons-io:commons-io:$commonIo")
    // implementation("dev.retrotv:cryptography-hash:$cryptography")
    implementation("com.github.f4b6a3:uuid-creator:$uuid")
    // implementation("dev.retrotv:extended-file:$extendedFile")
}