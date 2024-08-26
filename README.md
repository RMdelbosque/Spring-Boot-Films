# Sistema de Gestión de Cines y Películas

## Descripción del Proyecto

Este proyecto es una aplicación web desarrollada con **Spring Boot** y **IntelliJ IDEA**, diseñada para gestionar la información de cines y las películas que se proyectan en ellos. La aplicación permite realizar operaciones **CRUD** (Crear, Leer, Actualizar y Eliminar) sobre los cines, así como realizar consultas específicas sobre las películas y los cines donde se proyectan.

---

## Parte 1: Gestión de Cines

Se ha implementado la estructura necesaria para almacenar la información de los cines, incluyendo:

- **Nombre del cine**
- **Población**
- **Código postal**
- **Provincia**
- **Precio de la entrada**

Para gestionar esta información, se han implementado los siguientes métodos:

- **GET**: Recuperar la información de los cines.
- **POST**: Crear un nuevo cine.
- **PUT**: Actualizar la información de un cine existente.
- **DELETE**: Eliminar un cine de la base de datos.

---

## Parte 2: Consultas Específicas sobre Películas

Se han desarrollado consultas específicas para obtener información detallada sobre las películas y los cines donde se proyectan:

- **Cines ordenados por precio**: Obtén los cines donde se proyecta una película específica, ordenados de menor a mayor precio.
- **Cines por código postal**: Consulta los cines que proyectan una película determinada en un código postal específico.
- **Reviews de películas**: Accede a las reviews de una película, ordenadas de mayor a menor puntuación.

Cada consulta se ha implementado como una petición independiente en el controlador correspondiente, manteniendo la arquitectura **REST** y facilitando la expansión del proyecto.

---

## Parte 3: Roles de Usuario

Se ha implementado un sistema de roles para gestionar los permisos de los usuarios:

- **Usuario Especial**:
  - Puede gestionar la información de los cines y vincular películas a los mismos.
  - No puede modificar la información de las películas.
- **Admin**:
  - Tiene acceso total a todas las operaciones, incluyendo la modificación de cines y películas.

---

## Tecnologías Utilizadas

- **Spring Boot**: Framework principal para la construcción de la aplicación.
- **IntelliJ IDEA**: Entorno de desarrollo integrado (IDE) utilizado para la implementación del proyecto.
- **Java**: Lenguaje de programación.
- **RESTful API**: Arquitectura para la implementación de los servicios web.
