package com.pmguda.todo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Builder    //Builder 패턴을 사용하는 것은 생성자를 이용해 오브젝트를 생성하는 것과 비슷
@NoArgsConstructor  //매개변수가 없는 생성자 구현
@AllArgsConstructor //모든 멤버 변수를 매개변수로 받는 생성자 구현
@Data   // 클래스 멤버 변수의 Getter/Setter 메서드 구현
@Entity
@Table(name = "Todo")
public class TodoEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String userId;
    private String title;
    private boolean done;
}
