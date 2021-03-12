package cn.zhwxp.spring.boot.flexible.api.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String gender;

    @Column
    private int age;

    @ManyToOne
    private Department department;

}
