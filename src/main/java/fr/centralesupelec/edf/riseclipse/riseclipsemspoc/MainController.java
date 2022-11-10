package fr.centralesupelec.edf.riseclipse.riseclipsemspoc;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
  
  Logger logger = LoggerFactory.getLogger(MainController.class);

  @Autowired
  MessagesService messages;

  @Autowired
  ExternalCallService externalCallService;

  @Value("${helloTarget:http://localhost:8080/endpoint1}")
  String helloTarget;

  @Value("${goodbyeTarget:http://localhost:8080/endpoint2}")
  String goodbyeTarget;

  @PostMapping("/dispatch")
  public ResponseEntity<String> dispatch(@RequestBody EndpointBody body) throws InterruptedException {
    logger.info("Entered dispatch");

    String[] targets = {helloTarget, goodbyeTarget};
    List<CompletableFuture<String>> tasks = new ArrayList<>();
    
    for (String target : targets) {
      logger.info("Calling external service at: ".concat(target));
      tasks.add(externalCallService.makeCall(target, body));
    }
    
    List<String> results = tasks.stream().map(CompletableFuture::join).collect(Collectors.toList());
    
    return new ResponseEntity<>(String.join("\n", results), HttpStatus.OK);
  }

  @PostMapping("/endpoint1")
  public ResponseEntity<String> endpoint1(@RequestBody EndpointBody body) {
    logger.info("Entered endpoint1");
    
    return new ResponseEntity<>(messages.getHello().replace("{name}", body.name), HttpStatus.OK);
  }

  @PostMapping("/endpoint2")
  public ResponseEntity<String> endpoint2(@RequestBody EndpointBody body) {
    logger.info("Entered endpoint2");
    
    return new ResponseEntity<>(messages.getGoodbye().replace("{name}", body.name), HttpStatus.OK);
  }
}
