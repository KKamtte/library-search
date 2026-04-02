package library;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = NaverClientTest.TestConfig.class)
@ActiveProfiles("test")
class NaverClientTest {

    @ComponentScan(basePackageClasses = NaverClientTest.class)
    static class TestConfig {}

    @Autowired
    NaverClient naverClient;

    @Test
    void callNaver() {
        String http = naverClient.search("Http");
        System.out.println("http = " + http);
    }
}