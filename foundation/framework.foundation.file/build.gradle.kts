plugins {
    id("java")
}

val jackson = project.property("jackson.version") as String
val fileupload = project.property("fileupload.version") as String
val commonIo = project.property("commonIo.version") as String
val cryptography = project.property("cryptography.version") as String
val extendedFile = project.property("extended-file.version") as String

dependencies {
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jackson")
    implementation("org.apache.commons:commons-fileupload2-jakarta-servlet6:$fileupload")
    implementation("commons-io:commons-io:$commonIo")
    implementation("dev.retrotv:cryptography-hash:$cryptography")
    implementation("dev.retrotv:extended-file:$extendedFile")
}