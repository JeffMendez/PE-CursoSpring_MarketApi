package com.jeffmendez.market;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MarketEmApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketEmApplication.class, args);
	}

	// ¿Qué es JPA?
	// Jpa es una especificación de Java, standar, para un framework ORM. Quiere decir que son uan serie de reglas que Java define 
	// para que cualquier framework que quierea interactura con la BD de Java, tenga que seguir.

	// Spring Data
	// Spring Data NO es una implementacion de JPA, sino mas bien es un proyecto que usa JPA para ofrecer 
	// funcionalidaes extra en la gestion de tareas desde JAVA a las base de datos.
	// Auditorias transparentes

	// Spring Data Repositories
	// Operaciones sin codigo en la BD
	// CrudRepository, PagingAndSortingRepository, JPARepository

	// Query methods
	// En ocasiones se necesitan consultas mas especificas, estos los proveen la posibilidad de generar consultas

	// Patron Data Mapper - Mapstruct.org
	// Convertir o traducir dos objetos que pueden hacer una misma labor
	// No exponer directamente la base datos medianta la API
	// Esto garantiza que ningun agente externo, vizualice la forma del diseño de la base de datos
	// Desacoplar la API de una base de datos puntual

	// Inyeccion de dependencias
	// Principio de SOLID
	// Consiste en pasar la dependencia a la clase que la va a usar, en lugar de crearla internamente en esa clase

	// Inversion de control
	// Spring toma el control para hacer inyeccion de dependencias con @AutoWired, importante tiene que ser un componente de Spring
	
	// Un DTO (Data Transfer Object) es un objeto diseñado para transportar datos entre diferentes capas de una aplicación, 
	// como la capa de servicio, la capa de controlador o incluso entre microservicios. Su propósito principal es encapsular 
	// los datos que necesitas para transferir sin exponer directamente las entidades de tu base de datos (clases de entidad).

	// Docker Oracle
	// docker volume create oracle_data
	// docker run -d --name oracle-xe -p 1521:1521 -p 5500:5500 -e ORACLE_PASSWORD=123 gvenzl/oracle-xe
	// docker run -d --name oracle-xe -p 1521:1521 -p 5500:5500 -e ORACLE_PASSWORD=123 -v oracle_data:/opt/oracle/oradata gvenzl/oracle-xe
	// -> Para ver el servicio
	// docker exec -it oracle-xe bash
	// lsnrctl status
	// En Oracle para dar permisos al usuario nuevo GRANT CREATE SESSION TO market;

	// Swagger
	// http://localhost:4000/market/api/swagger-ui/index.html
}
