package fr.centralesupelec.edf.riseclipse.riseclipsemspoc;

import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExternalCallService {

  private final RestTemplate restTemplate;

  public ExternalCallService() {
    this.restTemplate = new RestTemplate();
  }

  @Async
  public CompletableFuture<String> makeCall(String target, EndpointBody body) throws InterruptedException {
    String results = restTemplate.postForObject(target, body, String.class);
    // Artificial delay of 1s for demonstration purposes
    Thread.sleep(1000L);
    return CompletableFuture.completedFuture(results);
  }
}
