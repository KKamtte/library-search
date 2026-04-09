package library.feign;

import feign.Response;
import feign.codec.ErrorDecoder;
import library.NaverErrorResponse;
import org.springframework.web.ErrorResponse;
import tools.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class NaverErrorDecoder implements ErrorDecoder {
    private final ObjectMapper objectMapper;

    public NaverErrorDecoder(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public Exception decode(String s, Response response) {
        try {
            String body = new String(response.body().asInputStream().readAllBytes(), StandardCharsets.UTF_8);
            NaverErrorResponse errorResponse = objectMapper.readValue(body, NaverErrorResponse.class);
            throw new RuntimeException(errorResponse.getErrorMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
