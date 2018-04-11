package jpa;

import jpa.employee.Employee;
import jpa.employee.EmployeeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(Application.class);

        Employee employee = new Employee("John");
        EmployeeRepository employeeRepository = (EmployeeRepository) app.getBean("employeeRepository");
        employeeRepository.save(employee);
    }
}
