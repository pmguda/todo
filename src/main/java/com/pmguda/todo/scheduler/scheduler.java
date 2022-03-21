package com.pmguda.todo.scheduler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class scheduler {

    @Scheduled(cron = "0/30 * * * * *") //30 초마다 실행
    public void test() {
        log.info("30초마다 수행");
    }

    @Scheduled(cron = "0 * * * * *")	// 1분마다
    public void test1() throws Exception {
        log.info("1분마다 수행");
    }

    @Scheduled(cron = "0 */5 * * * *")	// 5분마다
    public void test2() throws Exception {
        log.info("5분마다 수행");
    }

    @Scheduled(cron = "0 0 0 * * *")	// 매일 00시 정각
    public void test3() throws Exception {
        log.info("매일 00시 수행");
    }
}
