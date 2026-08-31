import org.jetbrains.intellij.platform.gradle.IntelliJPlatformType

plugins {
    id("java")
    id("org.jetbrains.intellij.platform") version "2.18.1"
}

group = providers.gradleProperty("pluginGroup").get()
version = providers.gradleProperty("pluginVersion").get()

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    intellijPlatform {
        // Prefer an IDE that is already installed locally — no multi-GB download,
        // and the sandbox looks exactly like the IDE actually in use. Set it via
        //   gradle runIde -PplatformLocalPath=/Applications/WebStorm.app
        // or put `platformLocalPath` into ~/.gradle/gradle.properties.
        val localPath = providers.gradleProperty("platformLocalPath")
        if (localPath.isPresent) {
            local(localPath)
        } else {
            // IntelliJ IDEA is a single distribution since 2025.3; the old
            // IntellijIdeaCommunity (IC) coordinates stop at 2025.2.
            create(IntelliJPlatformType.IntellijIdea, providers.gradleProperty("platformVersion"))
        }
        pluginVerifier()
    }
}

intellijPlatform {
    // A theme contributes no searchable settings, and building them spawns a
    // headless IDE on every build.
    buildSearchableOptions = false

    pluginConfiguration {
        ideaVersion {
            sinceBuild = providers.gradleProperty("pluginSinceBuild")
            // No upper bound: the theme carries no code, so it keeps working
            // on newer IDEs without a rebuild.
            untilBuild = provider { null }
        }
    }

    pluginVerification {
        ides {
            recommended()
        }
    }
}
