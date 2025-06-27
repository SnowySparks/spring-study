package study.restapi;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import study.restapi.model.UserRequest;

public class SerializationTest {

    private static ObjectMapper objectMapper;

    @BeforeAll
    public static void setup() {
        objectMapper = new ObjectMapper();
    }

    @Test
    public void serialize() throws Exception {
        var user = new UserRequest("홍길동", 10, "test@abc.com",true);
//        user.setUsername("홍길동");
//        user.setUserAge(10);
//        user.setEmail("test@abc.com");
//        user.setIsKorean(true);

//        직렬화
//        var json = objectMapper.writeValueAsString(user);
//        System.out.println("json :" + json);
// 역직렬화
        var dto = objectMapper.readValue("{\"user_names\":\"홍길동\",\"user_age\":10,\"email\":\"test@abc.com\",\"is_korean\":true}", UserRequest.class);
        System.out.println("DTO : " + dto);
    }
}
