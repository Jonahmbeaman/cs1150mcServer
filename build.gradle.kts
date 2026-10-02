plugins { java }
group = "io.github.jonahmbeaman"
version = "0.1.0"
repositories { maven("https://repo.papermc.io/repository/maven-public/") }
// Provisional target. Match the live server before deployment is enabled.
dependencies { compileOnly("io.papermc.paper:paper-api:26.3.build.141-beta") }
java { toolchain.languageVersion.set(JavaLanguageVersion.of(25)) }
tasks.jar { archiveFileName.set("class-server.jar") }
val exampleChecks by tasks.registering(JavaExec::class) {
    dependsOn(tasks.testClasses)
    classpath = sourceSets.test.get().runtimeClasspath
    mainClass.set("io.github.jonahmbeaman.classserver.ExampleChecks")
    javaLauncher.set(javaToolchains.launcherFor { languageVersion.set(JavaLanguageVersion.of(25)) })
}
tasks.check { dependsOn(exampleChecks) }
// This starter uses the plain-Java exampleChecks task, not a JUnit framework.
tasks.test { enabled = false }
