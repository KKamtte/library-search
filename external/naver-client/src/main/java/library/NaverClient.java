package library;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@Component
public class NaverClient {

    private final RestClient restClient;
    private final String naverUrl;
    private final String naverClientId;
    private final String naverClientSecret;

    public NaverClient(@Value("${external.naver.url}") String naverUrl,
                       @Value("${external.naver.headers.client-id}") String naverClientId,
                       @Value("${external.naver.headers.client-secret}") String naverClientSecret) {
        this.restClient = RestClient.create();
        this.naverUrl = naverUrl;
        this.naverClientId = naverClientId;
        this.naverClientSecret = naverClientSecret;
    }

    public String search(String query) {
        URI uri = UriComponentsBuilder.fromUriString(naverUrl + "/v1/search/book.json")
                .queryParam("query", query)
                .queryParam("display", 10)
                .queryParam("start", 1)
                .build()
                .encode()
                .toUri();

        System.out.println("uri = " + uri);
        System.out.println("naverUrl = " + naverUrl);
        System.out.println("naverClientId = " + naverClientId);
        System.out.println("naverClientSecret = " + naverClientSecret);

        return restClient.get()
                .uri(uri)
                .header("X-Naver-Client-Id", naverClientId)
                .header("X-Naver-Client-Secret", naverClientSecret)
                .retrieve()
                .body(String.class);
    }
}
