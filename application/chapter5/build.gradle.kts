apply(plugin = "kotlin-jpa")

dependencies {
    implementation(project(":common"))

//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
//    runtimeOnly("com.mysql:mysql-connector-java")

    implementation("org.springframework.boot:spring-boot-starter-security")
    testImplementation("org.springframework.security:spring-security-test")
}
