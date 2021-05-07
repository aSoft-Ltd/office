plugins {
    kotlin("js")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    js(IR) { browserLib() }
    sourceSets {
        val main by getting {
            dependencies {
                api(project(":office-word-core"))
            }
        }
    }
}

aSoftOSSLibrary(
    version = vers.asoft.office,
    description = "A kotlin/js library for rich text editing on the browser"
)