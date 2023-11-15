plugins {
    alias(libs.plugins.com.android.application) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
    alias(libs.plugins.io.arturbosch.detekt)
}

subprojects {
    apply(plugin = "io.gitlab.arturbosch.detekt")
    detekt {
        source.from(files("src/main/java", "src/test/java"))
        config.setFrom(file("${project.rootDir}/config/detekt/detekt.yml"))
        parallel = true
    }

    tasks.withType<io.gitlab.arturbosch.detekt.Detekt>().configureEach {
        reports {
            html {
                required.set(true)
                outputLocation.set(project.layout.buildDirectory.file("reports/detekt/detekt.html"))
            }
            xml {
                required.set(true)
                outputLocation.set(project.layout.buildDirectory.file("reports/detekt/detekt.xml"))
            }
        }
    }
}
