package com.pmguda.todo.api.service;

import com.pmguda.todo.api.model.TodoEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.transaction.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@Transactional  //테스트 시작 전에 트랜잭션을 시작하고, 테스트 완료 후에 항상 롤백
@SpringBootTest //스프링 컨테이너와 테스트를 함께 실행
class TodoServiceTest {

    @Autowired
    TodoService service;

    @Test
    void create() {
        //Given
        TodoEntity entity = TodoEntity.builder().title("title").userId("test").build();

        //When
        List<TodoEntity> entites = service.create(entity);

        //Then
        assertThat(entity.getTitle()).isEqualTo(entites.get(0).getTitle());

        TodoEntity entity2 = TodoEntity.builder().title("").build();
        //Exception 발생 검증
        RuntimeException e = assertThrows(RuntimeException.class, () -> service.create(entity2));
        assertThat(e.getMessage()).isEqualTo("Unknown user.");  //Exception 메시지 검증

    }
}