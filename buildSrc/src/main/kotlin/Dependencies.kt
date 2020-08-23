object Dependencies {
    object Kotlin {
        val version = "1.3.71"
        val classpath = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
        val stdlib = "org.jetbrains.kotlin:kotlin-stdlib:$version"
        val reflect = "org.jetbrains.kotlin:kotlin-reflect:$version"

        object Coroutines {
            val version = "1.2.2"
            val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        }
    }

    object Forge {
        val version = "1.15.2-31.2.36"
        val id = "net.minecraftforge.gradle"
        val core = "net.minecraftforge:forge:$version"
        val repository = "https://files.minecraftforge.net/maven"
        val classpath ="net.minecraftforge.gradle:ForgeGradle:3.+"
    }

    object Korgelin {
        val core = "net.toliner.korgelin:korgelin-1.15:1.1.3-1.3.71"
        val repository = "https://dl.bintray.com/toliner/Korgelin"
    }
}