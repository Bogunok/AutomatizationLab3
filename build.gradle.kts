plugins {
    id("java")
}

group = "com.mohyla"
version = "1.0-SNAPSHOT"

subprojects {
    apply(plugin = "java")

    repositories {
        mavenCentral()
    }
}

dependencies {
    implementation("com.mohyla:judoka:1.0")
    implementation("com.mohyla:sambist:1.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

//Task for checking if file exists in the directory
tasks.register("checkFileExistence") {
    val filePath = "D:\\Intellij Idea workspace\\MyWorks\\2024_automatization\\Lab3\\athletes"

    doLast {
        val file = file(filePath)
        if (file.exists()) {
            println("File $filePath exists")
        } else {
            println("File $filePath not found")
        }
    }
}

task("copyFiles") {
    doLast {
        val judokaSourceDir = project(":judoka").file("judokas.txt")
        val sambistSourceDir = project(":sambist").file("sambists.txt")
        val libraryTargetDir = projectDir.resolve("library")

        if (judokaSourceDir.exists() && sambistSourceDir.exists()) {
            copy {
                from(judokaSourceDir)
                from(sambistSourceDir)
                into(libraryTargetDir)
            }
            println("Files copied successfully")
        } else {
            println("Error: Source directories not found for judoka or sambist modules")
        }
    }
}