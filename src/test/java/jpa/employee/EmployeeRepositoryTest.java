package jpa.employee;

import jpa.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository instance;

    @Autowired
    private EntityManager entityManager;

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