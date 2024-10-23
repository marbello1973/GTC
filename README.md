
# Institución Educativa Futuro del Saber

Esta API REST permite la gestión de estudiantes en la Institución Educativa Futuro del Saber. Los endpoints cubren la creación, actualización, consulta y eliminación de registros de estudiantes, así como consultas específicas según grado y rango de edades.

## Requisitos Previos

### Configuración de la Base de Datos

La aplicación está configurada para conectarse a una base de datos MySQL. Asegúrate de que tu base de datos esté configurada con los siguientes parámetros:

- **Host**: `localhost`
- **Base de Datos (Schema)**: `institucion`
- **Puerto**: `3306`
- **Usuario**: `root`
- **Contraseña**: `mypassword`

### Variables de Entorno

Es necesario configurar las siguientes variables de entorno para la base de datos:

```bash
MYSQL_USERNAME=root
MYSQL_PASSWORD=root
```

## Instalación

1. Clona este repositorio en tu máquina local.
2. Configura la base de datos MySQL según los detalles proporcionados.
3. Asegúrate de tener las variables de entorno correctamente configuradas para la conexión a la base de datos.
4. Ejecuta el siguiente comando para iniciar la aplicación:

   ```bash
   mvn spring-boot:run
   ```

## Configuración de la Aplicación

El archivo `application.yml` está configurado de la siguiente manera:

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/institucion
    username: ${MYSQL_USERNAME}
    password: ${MYSQL_PASSWORD}
    driver-class-name: com.mysql.cj.jdbc.Driver
  jpa:
    database-platform: org.hibernate.dialect.MySQL8Dialect
    hibernate:
      ddl-auto: update
    show-sql: true
```

## Endpoints

### 1. Crear un Estudiante

- **Método**: `POST`
- **URL**: `/estudiantes`
- **Descripción**: Permite crear un nuevo registro de estudiante.
- **Cuerpo de la Solicitud** (Ejemplo):

  ```json
  {
    "nombre": "jose",
    "apellido": "perez",
    "edad": 15,
    "fecha_nacimiento": "2024-12-25",
    "email": "david@gmail.com",
    "grado_actual": 11,
    "telefono_fijo": 3333333,
    "telefono_celular": 30445698,
    "estado": true
  }
  ```

### 2. Actualizar un Estudiante por Grado

- **Método**: `PUT`
- **URL**: `/estudiantes/grado/{grado}`
- **Descripción**: Actualiza los datos de un estudiante en un grado específico.
- **Cuerpo de la Solicitud** (Ejemplo):

  ```json
  {
    "nombre": "jois",
    "apellido": "zabala",
    "edad": 30,
    "fecha_nacimiento": "2024-12-25",
    "email": "david@gmail.com",
    "grado_actual": 11,
    "telefono_fijo": 3333333,
    "telefono_celular": 30445698,
    "estado": true
  }
  ```

### 3. Obtener Estudiantes por Grado

- **Método**: `GET`
- **URL**: `/estudiantes/grado/{grado}`
- **Descripción**: Obtiene una lista de todos los estudiantes en un grado específico.

### 4. Obtener Estudiantes por Rango de Edades

- **Método**: `GET`
- **URL**: `/estudiantes/edad/{min}-{max}`
- **Descripción**: Obtiene una lista de estudiantes dentro de un rango de edades.

### 5. Obtener Todos los Estudiantes

- **Método**: `GET`
- **URL**: `/estudiantes`
- **Descripción**: Devuelve una lista de todos los estudiantes registrados.

### 6. Obtener Detalles de un Estudiante por ID

- **Método**: `GET`
- **URL**: `/estudiantes/{id}`
- **Descripción**: Devuelve los detalles de un estudiante específico.

## Ejecución de Pruebas

Puedes utilizar herramientas como **Thunder Client**, **Insomnia**, o **Postman** para realizar pruebas de los endpoints. Asegúrate de que el servidor esté corriendo localmente en el puerto `8080`.

## Contribuir

1. Crea un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-funcionalidad`).
3. Realiza los cambios y haz commit (`git commit -m 'Agrega nueva funcionalidad'`).
4. Empuja los cambios a la rama (`git push origin feature/nueva-funcionalidad`).
5. Abre un Pull Request.

## Licencia

Este proyecto está licenciado bajo los términos de la licencia MIT.
