pluginManagement {
    repositories {
        google()
        jcenter()
        gradlePluginPortal()
        mavenCentral()
    }

    resolutionStrategy {
        eachPlugin {
            if (requested.id.namespace == "com.android") {
                useModule("com.android.tools.build:gradle:${requested.version}")
            }
        }
    }
}

rootProject.name = "office"

include(":office-word-core")
project(":office-word-core").projectDir = File("office-word/office-word-core")
include(":office-word-browser")
project(":office-word-browser").projectDir = File("office-word/office-word-browser")
include(":office-word-react")
project(":office-word-react").projectDir = File("office-word/office-word-react")
include(":sample-word-react")
project(":sample-word-react").projectDir = File("samples/word/sample-word-react")
