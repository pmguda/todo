# Spring Boot를 활용한 TODO

##IntelliJ 에서 Spring Initializr로 프로젝트 생성
- https://start.spring.io

## Project
- Gradle Project
- Spring Boot: 2.6.4
- Language: Java
- Packaging: Jar
- Java: 11

## Dependencies
```groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    implementation 'org.springframework.boot:spring-boot-starter-security'
    implementation 'org.springframework.boot:spring-boot-starter-batch'
    implementation 'io.jsonwebtoken:jjwt:0.9.1'
    implementation 'org.bgee.log4jdbc-log4j2:log4jdbc-log4j2-jdbc4.1:1.16'
    compileOnly 'org.projectlombok:lombok'
    developmentOnly 'org.springframework.boot:spring-boot-devtools'
    runtimeOnly 'com.h2database:h2'
    annotationProcessor 'org.projectlombok:lombok'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testImplementation 'org.springframework.batch:spring-batch-test'
}
```

> 원본자료
* React.js, 스프링 부트, AWS로 배우는 웹 개발 101
* https://github.com/fsoftwareengineer/todo-application