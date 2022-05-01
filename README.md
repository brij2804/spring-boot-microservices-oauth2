# spring-boot-microservices-oauth2
Springboot Microservices with OAuth2 projects


### Concepts
- PKCE code verifier and code challenge generator
- JWT token code 
- Custom Scope code
- Checking the scope
- Securing endpoints to a specfic role
- Checking the Role by registering JwtAuthenticationConverter to HttpSecurity
- Method level security
- PreAuthorized annotations
- Secured annotations 
- API Gateway
- Multiple Resource Servers 
- Eureka Discovery Service
- Load Balancing

### Tech Stack
- java17
- org.springframework.boot: 2.6.7
- spring-boot-starter-oauth2-resource-server
- spring-boot-starter-web
- spring-boot-devtools
- spring-cloud-starter-gateway
- spring-boot-starter-actuator
- spring-cloud-starter-netflix-eureka-client
- spring-cloud-starter-netflix-eureka-server
- Keycloak

### URLs
|Method                                      | URL|
| :----------------------------------------------|:-------------|
|Code Grant Authorize                                   | http://localhost:8080/realms/appsdeveloperrealm/protocol/openid-connect/auth?response_type=code&client_id=photo-app-client-custom-roles&state=asdfgasdf&scope=openid profile&redirect_uri=http://localhost:8083/callback (GET)|
|Exchange Code For Token                       | http://localhost:8080/realms/appsdeveloperrealm/protocol/openid-connect/token|
|User Status - Direct Call | http://localhost:8081/users/status/check |
|API Gateway User Status  | http://localhost:8082/users/status/check |
|API Gateway Get Albums                        | http://localhost:8082/albums |
|API Gateway Get Photos                        | http://localhost:8082/photos|
|Eureka                        | http://localhost:8010|
