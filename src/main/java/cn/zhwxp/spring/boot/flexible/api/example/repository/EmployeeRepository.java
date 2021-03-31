package cn.zhwxp.spring.boot.flexible.api.example.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import cn.zhwxp.spring.boot.flexible.api.example.entity.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String>, QuerydslPredicateExecutor<Employee> {
}
