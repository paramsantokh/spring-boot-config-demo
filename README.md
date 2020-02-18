# spring-boot-config-demo
Demo application to show how a separate configration server can be setup to put all the configuration aside from main application.
client will access all the configuration from confih server.

# URLs
Client Application: http://localhost:8080/greeting
Accessing this URL will give all the configured values either from client app or from config server.

Config server: http://localhost:8888/application/default
Above url will show the configurations present in properties or yml file.


