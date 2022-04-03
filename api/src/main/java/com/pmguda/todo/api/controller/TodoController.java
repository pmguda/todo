package com.pmguda.todo.api.controller;

import com.pmguda.todo.api.dto.ResponseDTO;
import com.pmguda.todo.api.dto.TodoDTO;
import com.pmguda.todo.api.model.TodoEntity;
import com.pmguda.todo.api.service.TodoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController //http와 관련된 코드 및 요청/응답 매핑을 스프링이 처리
@RequestMapping("todo") //리소스 경로
public class TodoController {
    @Autowired
    private TodoService service;

    @GetMapping("/test")
    public ResponseEntity<?> testTodo() {
        String str = service.testService();
        List<String> list = new ArrayList<>();
        list.add(str);
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.ok().body(response);
    }

    @PostMapping
    public ResponseEntity<?> createTodo(
            @AuthenticationPrincipal String userId,
            @RequestBody TodoDTO dto) {
        try {
            //String temporaryUserId = "temporary-user"; // temporary user id

            TodoEntity entity = TodoDTO.toEntity(dto);

            entity.setId(null);

            entity.setUserId(userId);

            List<TodoEntity> entities = service.create(entity);

            List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());

            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            String error = e.getMessage();
            ResponseDTO<TodoDTO> response =  ResponseDTO.<TodoDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    @GetMapping
    public ResponseEntity<?> retrieveTodoList(@AuthenticationPrincipal String userId) {
        //String temporaryUserId = "temporary-user";

        List<TodoEntity> entities = service.retrieve(userId);

        List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());

        ResponseDTO<TodoDTO> respose = ResponseDTO.<TodoDTO>builder().data(dtos).build();

        return ResponseEntity.ok().body(respose);
    }

    @PutMapping
    public ResponseEntity<?> UpdateTodo(@RequestBody TodoDTO dto, @AuthenticationPrincipal String userId) {
        //String temporaryUserId = "temporary-user";
        TodoEntity entity = TodoDTO.toEntity(dto);

        entity.setUserId(userId);

        List<TodoEntity> entities = service.update(entity);

        List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());

        ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();

        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping
    public ResponseEntity<?> DeleteTodo(@RequestBody TodoDTO dto, @AuthenticationPrincipal String userId) {
        try {
//            String temporaryUserId = "temporary-user";
            TodoEntity entity = TodoDTO.toEntity(dto);
            entity.setUserId(userId);

            List<TodoEntity> entities = service.delete(entity);

            List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());

            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(dtos).build();

            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            String error = e.getMessage();
            ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }

    }


}
