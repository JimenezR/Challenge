apply(plugin = "jacoco")

configure<JacocoPluginExtension> {
    toolVersion = "0.8.10"
}

tasks.withType<Test>().configureEach {
    finalizedBy("jacocoTestReport")
}

tasks.register("jacocoTestReport", JacocoReport::class.java) {
    dependsOn(tasks.withType<Test>())
    reports {
        xml.required.set(true)
        html.required.set(true)
        html.outputLocation.set(file("${project.buildDir}/reports/jacoco"))
        xml.outputLocation.set(file("${project.buildDir}/reports/jacoco/jacoco.xml"))
    }

    val fileFilter = listOf(
        "**/R.class",
        "**/*$*",
        "**/R$*.class",
        "**/Hilt_*.class",
        "hilt_**",
        "dagger/hilt/**",
        "**/*JsonAdapter.*",
        "**/*ViewInjector*.*",
        "**/*ViewBinder*.*",
        "**/BuildConfig.*",
        "**/Manifest*.*",
        "${project.buildDir}/**"
    )
    val debugTree = fileTree(
        mapOf(
            "dir" to "${project.buildDir}/tmp/kotlin-classes/debug",
            "excludes" to fileFilter
        )
    )

    sourceDirectories.setFrom(files(
        "src/main/java",
        "${project.rootDir}/src/main/java"
    ))
    classDirectories.setFrom(files(debugTree))
    executionData.setFrom(fileTree(mapOf("dir" to "${project.buildDir}", "includes" to listOf(
        "jacoco/*.exec",
        "outputs/code_coverage/debugAndroidTest/connected/**/*.ec"
    ))))
}
