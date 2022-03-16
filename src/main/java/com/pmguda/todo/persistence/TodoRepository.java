package com.pmguda.todo.persistence;

import com.pmguda.todo.model.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
//JpaRepository 인터페이스를 확장하며 첫번째 매개변수는 테이블 엔티티클래스, 두번째는 PK타입을 셋팅
public interface TodoRepository extends JpaRepository<TodoEntity, String> {


    List<TodoEntity> findByUserId(String userId);

}
