# Spring Boot를 활용한 TODO

## 개발환경
- build tool : gradle 7.4.1
- java version: 11
    - OpenJDK 11.0.13
- base skeleton : start.spring.io
- dependencies
    - spring boot 2.6.5
    - spring boot starter web
    - spring boot starter validation
    - spring data jpa
    - junit5
    - querydsl 5.0.0
    - springfox swagger 3.0.0
    - lombok 1.18.22
    - h2database 1.4.2
- Load Test
    - apache bench

## TEST

- build

- start application
```bash
java -jar -Dfile.encoding=UTF-8 build/libs/todo-0.0.1-SNAPSHOT.jar
```

## 원본자료
* React.js, 스프링 부트, AWS로 배우는 웹 개발 101
* https://github.com/fsoftwareengineer/todo-application