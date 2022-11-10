package fr.centralesupelec.edf.riseclipse.riseclipsemspoc;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import lombok.Getter;

@JsonRootName("messages")
public class MessagesService {

  public static MessagesService loadMessages(String resourcePath) throws IOException {
    Resource resource = new ClassPathResource(resourcePath);
    XmlMapper mapper = new XmlMapper();
    return mapper.readValue(resource.getInputStream(), MessagesService.class);
  }

  @Getter
  String hello;
  @Getter
  String goodbye;
}
