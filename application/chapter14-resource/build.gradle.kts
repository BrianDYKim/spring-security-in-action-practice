apply(plugin = "org.jetbrains.kotlin.plugin.jpa")

dependencies {
    implementation(project(":common"))

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("com.mysql:mysql-connector-j")

    implementation("org.springframework.boot:spring-boot-starter-security")
    testImplementation("org.springframework.security:spring-security-test")

    // thymeleaf
    implementation("org.springframework.boot:spring-boot-starter-thymeleaf")

    // oAuth
    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")

    // OAuth Authorization Server
//    implementation("org.springframework.boot:spring-boot-starter-oauth2-authorization-server")
}
