package cn.zhwxp.spring.boot.flexible.api.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import cn.zhwxp.spring.boot.flexible.api.example.entity.Department;
import cn.zhwxp.spring.boot.flexible.api.example.entity.Employee;
import cn.zhwxp.spring.boot.flexible.api.example.repository.EmployeeRepository;

@Service
public class DataInitializationService implements ApplicationRunner {

    private EmployeeRepository employeeRepository;

    @Autowired
    public DataInitializationService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public void run(ApplicationArguments args) {
        saveEmployee("employee1", "M", 30, "IT");
        saveEmployee("employee2", "F", 31, "IT");
        saveEmployee("employee3", "M", 32, "IT");
        saveEmployee("employee4", "M", 33, "IT");
        saveEmployee("employee5", "M", 34, "HR");
        saveEmployee("employee6", "F", 35, "HR");
        saveEmployee("employee7", "M", 36, "FIN");
        saveEmployee("employee8", "F", 37, "FIN");
    }

    private void saveEmployee(String name, String gender, int age, String department) {
        Employee employee = Employee.builder()
                .name(name)
                .gender(gender)
                .age(age)
                .department(new Department(department))
                .build();
        employeeRepository.save(employee);
    }

}
