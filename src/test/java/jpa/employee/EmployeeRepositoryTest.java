package jpa.employee;

import jpa.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository instance;

    @Test
    public void shouldReadAndWrite() {
        //given
        Employee employee = new Employee("Steve");

        //when
        Employee savedEmployee = instance.save(employee);
        Employee readEmployee = instance.findOne(savedEmployee.getId());

        //then
        assertThat(readEmployee).isNotNull();
        assertThat(readEmployee.getName()).isEqualTo("Steve");
    }

}
