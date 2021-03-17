package cn.zhwxp.spring.boot.flexible.api.example.controller;

import net.kaczmarzyk.spring.data.jpa.domain.Between;
import net.kaczmarzyk.spring.data.jpa.domain.In;
import net.kaczmarzyk.spring.data.jpa.web.annotation.And;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Join;
import net.kaczmarzyk.spring.data.jpa.web.annotation.Spec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.zhwxp.spring.boot.flexible.api.example.entity.Employee;
import cn.zhwxp.spring.boot.flexible.api.example.repository.EmployeeRepository;

@RestController
@RequestMapping(value = "/api/v1/")
public class EmployeeController {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping(value = "employees", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<Employee> searchEmployeesBySpecification(
            @Join(path = "department", alias = "department")
            @And({
                    @Spec(path = "name", params = "name", paramSeparator = ',', spec = In.class),
                    @Spec(path = "gender", params = "gender", paramSeparator = ',', spec = In.class),
                    @Spec(path = "age", params = "age", paramSeparator = ',', spec = In.class),
                    @Spec(path = "age", params = { "ageStart", "ageEnd" }, spec = Between.class),
                    @Spec(path = "department.name", params = "department.name", paramSeparator = ',', spec = In.class)
            }) Specification<Employee> specification,
            Pageable pageable
    ) {
        return employeeRepository.findAll(specification, pageable);
    }

}
