plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.seleniumhq.selenium:selenium-java:4.49.0")
    implementation("io.github.bonigarcia:webdrivermanager:6.1.0")
    testImplementation("io.cucumber:cucumber-java:7.34.8")
    testImplementation("io.cucumber:cucumber-testng:7.34.8")

    testImplementation("org.testng:testng:7.12.0")

    implementation("commons-io:commons-io:2.16.1")


}
tasks.test{
    useTestNG()
}

