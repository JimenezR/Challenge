fun getProperty(key: String): String = com.android.build.gradle.internal.cxx.configure.gradleLocalProperties(
    rootDir
).getProperty(key, "")

plugins {
    alias(libs.plugins.com.google.dagger.hilt.android.plugin) apply false
    alias(libs.plugins.com.android.application) apply false
    alias(libs.plugins.org.jetbrains.kotlin.android) apply false
    alias(libs.plugins.io.arturbosch.detekt)
    alias(libs.plugins.org.sonarqube)
}

apply(plugin = "android-reporting")

subprojects {
    apply("${project.rootDir}/jacoco-report.gradle.kts")
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

sonarqube {
    properties {
        property("sonar.host.url", getProperty("SONAR_HOST_URL"))
        property("sonar.token", getProperty("SONAR_TOKEN"))
        property("sonar.projectName", getProperty("SONAR_PROJECT_NAME"))
        property("sonar.projectKey", getProperty("SONAR_PROJECT_KEY"))
        property("sonar.modules", "app")
        property(
            "sonar.coverage.jacoco.xmlReportPaths",
            listOf(
                "${project.rootDir}/app/build/reports/jacoco/*.xml",
            )
        )
        property(
            "sonar.kotlin.detekt.reportPaths",
            listOf(
                "${project.rootDir}/app/build/reports/detekt/*.xml",
            )
        )
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}
