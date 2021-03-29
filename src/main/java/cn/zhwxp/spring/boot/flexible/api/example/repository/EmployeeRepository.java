package cn.zhwxp.spring.boot.flexible.api.example.repository;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.zhwxp.spring.boot.flexible.api.example.entity.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, String>, QuerydslPredicateExecutor<Employee> {
}
