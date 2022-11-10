package fr.centralesupelec.edf.riseclipse.riseclipsemspoc;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfiguration {
  @Bean
  MessagesService getMessagesService() {
    try {
      return MessagesService.loadMessages("static/messages.xml");
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Bean
  ExternalCallService getExternalCallService() {
    return new ExternalCallService();
  }
}
