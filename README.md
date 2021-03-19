# MicroServicio Desafio 20210318

MicroServicio Desafio 20210318 por Julio Cornejo

## Configuración del entorno de trabajo

Para revisar los programas y caracteristicas que debe configurar en su equipo, dirigirse a la Wiki de [https://github.com/pagamo](https://github.com/pagamo1979/desafio20210318/tree/feature/desafio20210318) donde en la rama de desarrollo encontrarás el documento Markdown con todo lo requerido.

## Base de Datos
 - la Estructura de la Base de Datos de Mysql (indicadores.sql) se encuentra en la carpeta src/main/resources solo hay que ejecutar el script y se cargarian las tablas.

 - para realizar la conexion desde la aplicacion, debe realizar el set de las siguientes variables en application.properties
#####spring.datasource.url=${MYSQL_URL}
#####spring.datasource.username=${MYSQL_USERNAME}
#####spring.datasource.password=${MYSQL_PASSWORD}

 - para SO Linux ir a /etc/enviroment y crear las variables de entorno.
#####MYSQL_URL=jdbc:mysql://localhost:3306/indicadores?useSSL=false
#####MYSQL_USERNAME=root
#####MYSQL_PASSWORD=1234

## Actuator
para verificar si el entorno se encuentra operativo realizar curl hacia "http://localhost:8080/actuator/desafio-20210318/health"

para verificar si el entorno esta escribiendo el log realizar curl hacia "http://localhost:8080/actuator/desafio-20210318/logfile"

## Swagger 🏁

##### GET`/api/v1/{fechaFeriado}` almacena una fecha como feriado

- 200 - OK
- 208 - AlreadyReported
- 503 - Service Unavailable

EJ: http://localhost:8080/api/v1/08-03-2021

##### GET`/api/v1/{codigoindicador}/{fecha}` entrega indicador por fecha

- 200 - OK
- 208 - AlreadyReported
- 503 - Service Unavailable

EJ: http://localhost:8080/api/v1/dolar/08-03-2021

Para visualizar el Swagger se debe copiar el script de [swagger.yaml](./swagger/swagger-valida-otp.yaml) y pegarlo en el [Swagger Editor](https://editor.swagger.io/), o simplemente arrastre y suelte su documento OpenAPI JSON o YAML en la ventana del navegador Swagger Editor.

![Swagger Editor drag and drop demo](./swagger/drag-and-drop.gif)
