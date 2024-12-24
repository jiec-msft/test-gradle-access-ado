plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()

    maven {
        url = uri("https://pkgs.dev.azure.com/jiec-temp-org/Tooling/_packaging/mason-test-feed-in-personal-org/maven/v1")
        credentials  {
            username = "jiec-temp-org"
            password = project.findProperty("ado.artifacts.jiec-temp-org.mason-test-feed-in-personal-org.token") as String
        }
    }
}

dependencies {
    implementation("com.github.copilot:copilot-plugin-telemetry:0.0.3")

    // lombok
    compileOnly("org.projectlombok:lombok:1.18.36")
    annotationProcessor("org.projectlombok:lombok:1.18.36")

    testCompileOnly("org.projectlombok:lombok:1.18.36")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.36")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}