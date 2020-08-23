buildscript {
    repositories {
        maven(Dependencies.Forge.repository)
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.Forge.classpath)
    }
}

apply(plugin = Dependencies.Forge.id)

plugins {
    kotlin("jvm") version(Dependencies.Kotlin.version)
}

version = "0.0.1"
group = "net.atlantis"
val archivesBaseName = "Glutonny"

repositories {
    mavenCentral()
    jcenter()
    maven(Dependencies.Korgelin.repository)
}

dependencies {
    "minecraft"(Dependencies.Forge.core)
    implementation(Dependencies.Korgelin.core)
}

configure<net.minecraftforge.gradle.common.util.MinecraftExtension> {
    mappings("stable", "60-1.15")
    runs {
        create("client") {
            workingDirectory(project.file("run"))
            property("forge.logging.markers", "SCAN,REGISTRIES,REGISTRYDUMP")
            property("forge.logging.console.level", "debug")

            mods {
                create(archivesBaseName) {
                    source(sourceSets.main.get())
                }
            }
        }
        create("server") {
            workingDirectory(project.file("run"))
            property("forge.logging.markers", "SCAN,REGISTRIES,REGISTRYDUMP")
            property("forge.logging.console.level", "debug")

            mods {
                create(archivesBaseName) {
                    source(sourceSets.main.get())
                }
            }
        }
        create("data") {
            workingDirectory(project.file("run"))
            property("forge.logging.markers", "SCAN,REGISTRIES,REGISTRYDUMP")
            property("forge.logging.console.level", "debug")

            args("--mod", "industrial", "--all", "--output", file("src/generated/resources/"))

            mods {
                create(archivesBaseName) {
                    source(sourceSets.main.get())
                }
            }
        }
    }
}

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
            freeCompilerArgs = listOf("-Xopt-in=kotlin.RequiresOptIn")
        }
    }

    jar {
        finalizedBy("reobfJar")
    }
}