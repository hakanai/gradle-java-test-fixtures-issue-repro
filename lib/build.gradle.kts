plugins {
    `java-library`
    `java-test-fixtures`
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:30.1.1-jre")

    testImplementation("org.junit.jupiter:junit-jupiter:5.7.2")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

configurations.matching { it.name == "compileClasspath" || it.name == "testCompileClasspath" }.configureEach {
    // Compile configurations should not include transitive dependencies - this
    // leaks jars onto the classpath which should not be there.
    setTransitive(false)
}
