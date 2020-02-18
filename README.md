# spring-boot-config-demo
Demo application to show how a separate configration server can be setup to put all the configuration aside from main application.

Client application will access the configuration from config server. If it is not available on config server then will look in local property file.

# URLs
**Client Application**: 

http://localhost:8080/greeting

Accessing this URL will give all the configured values either from config server or  client app.

**Config server**: 

http://localhost:8888/application/default ->  *http://localhost:8888/property-file-name/profile*

http://localhost:8888/spring-boot-config-client/default  -> property file created with application name: spring-boot-config-client.yml
              
Above url will show the configurations present in properties or yml file.

**Actuator:** 

http://localhost:8080/actuator/configprops

http://localhost:8080/actuator/health

To Refresh changes done in config server yml/properties file, do a POST to below URL:

http://localhost:8080/actuator/refresh
