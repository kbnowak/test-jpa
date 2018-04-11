package jpa.employee;

import jpa.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository instance;

    @Autowired
    private Environment env;

    @Autowired
    private ApplicationContext context;

    @Test
    public void shouldReadAndWrite() {
        //given
        Employee employee = new Employee("Johnson");

        //when
        Employee savedEmployee = instance.save(employee);
        Employee readEmployee = instance.findOne(savedEmployee.getId());

        //then
        assertThat(readEmployee).isNotNull();
        assertThat(readEmployee.getSurname()).isEqualTo("Johnson");
    }

    @Test
    public void printStuff() {
        String[] beans = context.getBeanDefinitionNames();
        System.out.println("beans:");
        for (String bean : beans) {
            System.out.println(bean);
        }

        Object propertySourcesPlaceholderConfigurer = context.getBean("propertySourcesPlaceholderConfigurer");
        System.out.println("propertySourcesPlaceholderConfigurer.getClass() = " + propertySourcesPlaceholderConfigurer.getClass());

        boolean propertyExists = env.containsProperty("spring.datasource.url");
        System.out.println("spring.datasource.url exists? " + propertyExists);
    }
}
