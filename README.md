# CashOnline
Trabajo hecho con Java, utilizando spring, tanto con codigo autogenerado utilizando openapi como un endpoint hecho a mano, BD Mysql

# Ambiente

Para poder probar este codigo primero debera instalar MySQL (https://www.youtube.com/watch?v=jTs1nSwAcRM), prestando especial atencion a la hora de 
realizar la instalacion en que el puerto corroborando que coincidan los datos tanto de conexion como lo son el username
(spring.datasource.username) y la password (spring.datasource.password) como la ruta de conexion a la BBDD
(spring.datasource.url) ubicados en el archivo application.properties.
Una vez instalado MySQL, hay que importar la base de datos que voy a dejar ubicada en la carpeta "docs",
para mayor simplicidad pueden seguir el tutorial que les voy a dejar aqui:

https://www.youtube.com/watch?v=hUZKNsnHe_A

una vez importada la base de datos, debera poner en una terminal del IDE que utilize "mvn clean install",
lo cual hara que se instalen tanto las dependencias como que procese el archivo api-cash-online.yml ubicado en
resources/openapi y se autogenere el codigo.
Luego de eso ya podra correr el codigo y probarlo a travez de postman, haciendo especial incapie en que
yo no utilice CamelCase en los atributos de los request, si no que utilice _, por ejemplo first_name.

