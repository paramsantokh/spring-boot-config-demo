package com.java.springbootconfigclient.controller;

import com.java.springbootconfigclient.DbSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
public class ConfigResource {
  
  @Autowired
  private DbSettings dbSettings;
  
  @Value ("${config.greeting}")
  private String greeting;
  
  @Value ("${config.my.list}")
  private List<String> myList;
  
  //SpEL(Spring Expression Language)
  @Value ("#{${config.dbValues}}")
  private Map<String, String> dbValues;
  
  /**
   * Demonstrate how different kind of properties can be read from properties/yml file
   * @return
   */
  @RequestMapping ("/greeting")
  public String getGreeting() {
    return greeting + "\n" +
           myList + "\n" +
           dbValues.toString()+ "\n" +
           dbSettings.getConnection() + "\n" +
           dbSettings.getHost() + "\n" +
           dbSettings.getPort();
          
  }
}
