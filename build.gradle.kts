import com.vanniktech.maven.publish.SonatypeHost
import java.net.URI

plugins {
    java
    jacoco
    `java-library`
    `maven-publish`
    id("com.vanniktech.maven.publish") version "0.32.0"
    id("org.sonarqube") version "4.0.0.2929"
}

group = "dev.retrotv"
version = "0.0.28-alpha"

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
    apply(plugin = "java-library")
    apply(plugin = "maven-publish")
    apply(plugin = "com.vanniktech.maven.publish")

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(17))
        }
    }

    tasks {
        compileJava {
            options.encoding = "UTF-8"
            options.release.set(17)
        }
        compileTestJava {
            options.encoding = "UTF-8"
            options.release.set(17)
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

        // Logging 라이브러리
        compileOnly("org.slf4j:slf4j-api:${slf4j}")
        testCompileOnly("org.apache.logging.log4j:log4j-core:${log4j}")
        testCompileOnly("org.apache.logging.log4j:log4j-slf4j2-impl:${log4j}")

        // Lombok 라이브러리
        compileOnly("org.projectlombok:lombok:$lombok")
        annotationProcessor("org.projectlombok:lombok:$lombok")

        // Spring Boot 라이브러리
        implementation("org.springframework.boot:spring-boot-starter-web:$springBoot")
    }

    if (project.name.startsWith("framework.")) {
        mavenPublishing {
            publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)

            signAllPublications()

            coordinates(group.toString(), project.name, version.toString())

            pom {
                name.set("framework-runtime")
                description.set("Spring boot 기반의 프레임워크 런타임 라이브러리입니다.")
                inceptionYear.set("2025")
                url.set("https://github.com/retrotv-framework/framework-runtime")

                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("https://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }

                developers {
                    developer {
                        id.set("yjj8353")
                        name.set("JaeJun Yang")
                        email.set("yjj8353@gmail.com")
                    }
                }

                scm {
                    connection.set("scm:git:git://github.com/retrotv-framework/framework-runtime.git")
                    developerConnection.set("scm:git:ssh://github.com/retrotv-framework/framework-runtime.git")
                    url.set("https://github.com/retrotv-framework/framework-runtime.git")
                }
            }

            publishing {
                repositories {

                    // Github Packages에 배포하기 위한 설정
                    maven {
                        name = "GitHubPackages"
                        url = URI("https://maven.pkg.github.com/retrotv-framework/framework-runtime")
                        credentials {
                            username = System.getenv("USERNAME")
                            password = System.getenv("PASSWORD")
                        }
                    }
                }
            }
        }

        tasks.withType<Sign>().configureEach {
            onlyIf {
                // 로컬 및 깃허브 패키지 배포 시에는 서명하지 않도록 설정
                val graph = gradle.taskGraph
                !graph.allTasks.any { task ->
                    task.path.endsWith("PublicationToMavenLocal") || task.path.endsWith("PublicationToGitHubPackagesRepository")
                }
            }
        }
    }
}

apply(from = "${rootDir}/gradle/sonarcloud.gradle")
apply(from = "${rootDir}/gradle/jacoco.gradle")
