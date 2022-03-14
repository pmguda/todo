package com.pmguda.todo.service;

import com.pmguda.todo.model.TodoEntity;
import com.pmguda.todo.persitence.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j  //lombok 로그 어노테이션 사용
@Service
public class TodoService {
    @Autowired
    private TodoRepository repository;

    public String testService() {
        //TodoEntity 생성
        TodoEntity entity = TodoEntity.builder().title("My first todo item").build();
        // TodoEntity 저장
        repository.save(entity);
        // TodoEntity 검색
        TodoEntity saveEntity = repository.findById(entity.getId()).get();
        log.info("saveEntity :" + saveEntity);
        return saveEntity.getTitle();
    }
}
