package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class BeanLifeCycleTest {
    @Test
    public void testBeanLifeCycle() {
        //interface : ConfigurableApplicationContext -> 종료 기능
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        NetworkClient client = context.getBean(NetworkClient.class);

        //Spring Container종료
        context.close();

    }

    @Configuration
    static class Config {
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("https://hello-spring.dev");
            return networkClient;
        }
    }
}
