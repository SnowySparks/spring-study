package hello.core.scan.filter;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.springframework.context.annotation.ComponentScan.*;

public class ComponentFilterAppConfigTest {

    @Test
    void filterScan() {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        BeanA beanA = context.getBean("beanA", BeanA.class);
        assertThat(beanA).isNotNull();
        assertThrows(
                NoSuchBeanDefinitionException.class,
                () -> context.getBean("beanB", BeanB.class)
        );


    }

    @Configuration
    @ComponentScan(
            includeFilters = @Filter(
                    type = FilterType.ANNOTATION, classes = {MyIncludeComponent.class}
            ),
            excludeFilters = @Filter(
                    type = FilterType.ANNOTATION, classes = {MyExcludeComponent.class}
            )
    )
    static class Config {


    }
}
