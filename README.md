# appgate

##### Correr proyecto :  mvn spring-boot:run

Generar Sesión
##### POST - http://localhost:8085/appgate/session
##### GET - http://localhost:8085/appgate/session

Operandos
##### POST - http://localhost:8085/appgate/value
##### GET - http://localhost:8085/appgate/value
##### GET - http://localhost:8085/appgate/value/{idSession}

Operaciones
##### POST - http://localhost:8085/appgate/operator
##### GET - http://localhost:8085/appgate/operator
##### GET - http://localhost:8085/appgate/operator/{idSession}

7. indique la forma en que propone que el servicio sea elástico y escalable
##### Contenedores (en kubernetes), los cuales se puedan replicar y por medio de una balanceador de carga (en la nube) acceder.

8. Atributos de calidad.
##### En el caso de los microservicios: 
##### Independiente, disponibilidad y escalabilidad.
##### 8.1 trade-offs
##### Complejidad al momento de tener muchos microservicios.
##### Pasaría lo mismo en pruebas de integración al tener varios microservicios.
##### La comunicación entre microservicios, latencia al ser el consumo por REST, manejo de colas como o frameworks para comunicación
##### 8.2 Patrones
##### En los microservicios, se podría usar un patrón de descomposición, por ejemplo por dominio (pedidos, clientes, etc), esto con el fin de delegador responsabilidades y no generar dependecias.
##### La utilización de clean architecture, especificando la parte de tener varios conectores de acceso (BD, colas, rest, soap) y no solo servicios REST, es bueno utilizar esto cuando tenemos muchos microservicios.

9. Alternativa a Rest.
##### Se podría usar GRAPHQL, ya que en nuestro caso 2 de los 8 servicios es consulta a datos y esto podría mejorar el acceso a datos, en la forma como los podríamos consumir.
