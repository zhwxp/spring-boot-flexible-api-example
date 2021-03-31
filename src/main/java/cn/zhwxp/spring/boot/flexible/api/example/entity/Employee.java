package cn.zhwxp.spring.boot.flexible.api.example.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Data;

@Document
@Data
@Builder
public class Employee {

    @Id
    private String id;

    private String name;

    private String gender;

    private int age;

    private Department department;

}
