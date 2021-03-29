package cn.zhwxp.spring.boot.flexible.api.example.entity;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.Builder;
import lombok.Data;

@Document
@Data
@Builder
public class Employee {

    @MongoId
    private String id;

    private String name;

    private String gender;

    private int age;

    private Department department;

}
