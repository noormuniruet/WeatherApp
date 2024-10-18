pluginManagement {
    repositories {
        google() // Google repository for Android dependencies
        mavenCentral() // Maven Central for other libraries
        gradlePluginPortal() // Gradle Plugin Portal for plugins

        // Optional content filtering for Google repository
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS) // Ensures settings repositories are preferred
    repositories {
        google() // Primary repository for Android dependencies
        mavenCentral() // Fallback repository for other dependencies
    }
}

// Project settings
rootProject.name = "WeatherApp" // Set the root project name
include(":app") // Include the app module
