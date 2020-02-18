package com.java.springbootconfigclient.controller;

import com.java.springbootconfigclient.DbSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class ConfigResource {
  
  @Autowired
  private DbSettings dbSettings;
  
  @Value ("${config.greeting}")
  private String greeting;
  
  @Value ("${config.my.list}")
  private List<String> myList;
  
  @RequestMapping ("/greeting")
  private String getGreeting() {
    return greeting + "\n" +
           myList + "\n" +
           dbSettings.getConnection().toString() + "\n" +
           dbSettings.getHost() + "\n" +
           dbSettings.getPort();
  }
}
