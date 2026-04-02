package library.restclient;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = NaverRestClientTest.TestConfig.class)
@ActiveProfiles("test")
class NaverRestClientTest {

    @ComponentScan(basePackageClasses = NaverRestClientTest.class)
    static class TestConfig {}

    @Autowired
    NaverClient naverClient;

    @Test
    void callNaver() {
        String http = naverClient.search("Http");
        System.out.println("http = " + http);
    }
}