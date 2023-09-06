# Hotel Alura

![Hotel Alura](https://i.imgur.com/eIJFowu.png)

<p align="center" > 
  <img src="https://img.shields.io/badge/Java%20JDK-v.19-green"/>
  <img src="https://img.shields.io/badge/Maven-v.3.9.0-yellow"/>
  <img src="https://img.shields.io/badge/MySQL-v.8.0.33-blue"/>
</p>

## Tabla de Contenido

- [Descripción del proyecto](#descripcion-del-proyecto)
- [Estado del proyecto](#estado-del-proyecto)
- [Vista previa](#vista-previa)
    - [Diagrama entidad relacion](#diagrama-entidad-relacion)
    - [Ventanas del programa](#ventanas-del-programa)
- [Funcionalidades](#funcionalidades)
- [Acceso al proyecto](#acceso-al-proyecto)
- [Tecnologías utilizadas](#tecnologias-utilizadas)
- [librerias utilizadas](#librerias-utilizadas)
- [Javadoc](#javadoc)
- [Autor](#autor)
- [Licencia](#licencia)


## Descripcion del proyecto

El Hotel Alura conocido por su espectaculares instalaciones y paquetes promocionales para Desarrolladores de Software implemento un sistema de escritorio con conexión a base de datos con el fin de llevar el control de las reservas hechas por sus clientes. El cual fue desarrollado en Java utilizando Maven para gestionar dependencias y Java Swing para diseñar las ventanas.

## Estado del proyecto

   ![Badge en Desarollo](https://img.shields.io/badge/ESTADO-FINALIZADO-green)

## Vista previa

###  Diagrama entidad relacion

<img src="https://i.imgur.com/f88PrqM.png" width="800px"/>

### Ventanas del programa

<img src="https://i.imgur.com/NYrUjAV.png" width="800px"/>


## Funcionalidades

*   `Registro de huespedes y reservas`: Mediante el formulario se pueden llenar los datos del huesped y la reserva los cuales se almacenaran en la base de datos.

*   `Búsqueda de registros por apellido o id`: Para buscar una reserva se debe ingresar el número de reserva y para buscar un huesped se debe ingresar el apellido, luego se cargaran los datos en una tabla.

*   `Modificación de registros`: Al hacer clic en la columna de la tabla se pude editar el dato que este allí y luego al dar click en el botón modificar se envia la actualización a la base de datos.

*   `Eliminación de registros`: Al hacer clic sobre una columna de la tabla y luego dar click en el boton eliminar se eliminara de la base de datos el elemento seleccionado.

## Acceso al proyecto

1. Descargue la versión 19 de [Java JDK.](https://www.oracle.com/java/technologies/downloads/)

2. Descargue el IDE [Eclipse.](https://www.eclipse.org/downloads/)

3. Descargue [MySQL.](https://dev.mysql.com/downloads/installer/)

4. Descargue [MySQL Workbench.](https://dev.mysql.com/downloads/workbench/)

5. Clone el repositoria mediante el siguiente enlace: https://github.com/dainercortes/challenge-one-alura-hotel-latam.git

6. Abra MySQL Workbench y ejecute el siguiente docuemento sql para crear la base de datos. [Click aquí](https://github.com/dainercortes/challenge-one-alura-hotel-latam/blob/main/MySQLDB/db.sql)

7. Abra el proyecto en el IDE Eclipse.

8. Dirijase al paquete **com.alura.hotel.factory** y en la clase **ConnectionFactory.java** y modifique los campos** setUser()** y **setPassword()** reemplazandolos por el *usuario* y la *contraseña* que asigno al instalar MySQL en su PC.

7. Compile y ejecute la aplicación, listo ✌️.

## Tecnologias utilizadas

* Java 19

* Maven

* JDBC

* MySQL

## Librerias utilizadas

*  `c3p0-0.9.5.4.jar`

* `jcalendar-1.4.jar`

* `mchange-commons-java-0.2.16.jar`

* `mysql-connector-j-8.0.32.jar`

## Javadoc

*   Clic para acceder al [**JAVADOC**](https://javadoc-hotel-alura.netlify.app/)

## Autor

|  [<img src="https://avatars.githubusercontent.com/u/95858653?v=4" width=115><br><sub>Dainer Cortés</sub>](https://github.com/dainercortes) |
| :---: |

## Licencia

> Hotel Alura está licenciado bajo la [licencia MIT](https://github.com/dainercortes/challenge-one-alura-hotel-latam/blob/main/LICENSE.md)

