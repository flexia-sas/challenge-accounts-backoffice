
Ver instrucciones en [CHALLENGE.md](CHALLENGE.md)

# Proyecto accounts-backoffice

## Intro
Este proyecto es el backend del backoffice de cuentas. El mismo implementa las siguientes funcionalidades:
- Consulta de cuentas de usuario
- [Completar]
- [Completar]

## Instrucciones para el desarrollador
Importar el proyecto en un IDE compatible con proyectos Maven. Se sugiere utilizar IntelliJ IDEA.

## Arquitectura e implementación
Se encuentra implementado en Java 21 con Spring Boot y utiliza los módulos Spring MVC y Spring Data JPA.
El proyecto consta de tres capas principales en las que se organiza el código.
Pasamos a detallarlas a continuación:
- Capa [Completar]: Define las operaciones a nivel API que vamos a exponer al frontend
- Capa [Completar]: Encapsula la lógica de la aplicación
- Capa [Completar]: Define las entidades fundamentales involucradas en el sistema

## Pruebas
Además de incorporar pruebas unitarias, se adjunta al proyecto una colección de Postman que podemos utilizar para 
ejecutar las operaciones de forma directa.

## Requerimientos a futuro
A continuación vamos a ir listando los requerimientos que podríamos incorporar en un futuro a la plataforma:
- Se deberán definir los roles Administrador y Consultivo para restringir las operaciones que cada usuario puede realizar.
