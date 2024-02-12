apply(plugin = "kotlin-jpa")

dependencies {
    implementation(project(":common"))

    // jpa
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.mysql:mysql-connector-java")

    // security
    implementation("org.springframework.boot:spring-boot-starter-security")
    testImplementation("org.springframework.security:spring-security-test")

    // thymeleaf
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
}
