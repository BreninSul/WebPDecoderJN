
plugins {
    id("java")
    id("net.thebugmc.gradle.sonatype-central-portal-publisher") version "1.1.1"
}

group = "io.github.breninsul"
version = "1.3-b"

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    implementation("net.java.dev.jna:jna:5.14.0")
    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.8.1")
}

val javaVersion = JavaVersion.VERSION_17


java {
    sourceCompatibility = javaVersion
    withJavadocJar()
    withSourcesJar()
}

//tasks.named("test") {
//    // Use JUnit Platform for unit tests.
//    useJUnitPlatform()
//}

//tasks.jar {
//    archiveBaseName.set(rootProject.name)
//}
//tasks.javadoc {
//    title = rootProject.name+" "+version+" API";
//}
//tasks.javadocJar {
//    archiveBaseName.set(rootProject.name)
//}
//tasks.sourcesJar {
//    archiveBaseName.set(rootProject.name)
//}

tasks.compileJava {
    dependsOn.add(tasks.processResources)
}




tasks.withType<Test> {
    useJUnitPlatform()
}

signing {
    useGpgCmd()
}

centralPortal {
    pom {
        packaging = "jar"
        name.set("For of https://github.com/tduva/WebPDecoderJN library")
        val repositoryName = project.name
        url.set("https://github.com/BreninSul/$repositoryName")
        description.set(
            """
            """.trimIndent(),
        )
        licenses {
            license {
                name.set("BSD 3-Clause")
                url.set("https://github.com/BreninSul/WebPDecoderJN/blob/main/COPYING")
            }
        }
        scm {
            connection.set("scm:https://github.com/BreninSul/$repositoryName.git")
            developerConnection.set("scm:git@github.com:BreninSul/$repositoryName.git")
            url.set("https://github.com/BreninSul/$repositoryName")
        }
        developers {
            developer {
                id.set("BreninSul")
                name.set("BreninSul")
                email.set("brenimnsul@gmail.com")
                url.set("breninsul.github.io")
            }
        }
    }
}

tasks.jar {
    enabled = true
    archiveClassifier.set("")
}
