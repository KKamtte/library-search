package library.feign;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = NaverFeignClientTest.TestConfig.class)
@ActiveProfiles("test")
class NaverFeignClientTest {

    @EnableAutoConfiguration
    @EnableFeignClients(clients = NaverClient.class)
    static class TestConfig {}

    @Autowired
    NaverClient naverClient;

    @Test
    void callNaver() {
        String http = naverClient.search("http", 1, 10);
        System.out.println("http = " + http);
    }
}