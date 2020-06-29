# Practica-de-laboratorio-05-Gestion-Tickets-Parqueadero-

## Programacion Orientada a Objetos

## Titulo de la Practica: 

Desarrollo de una aplicación Informática basada en gestión de eventos desde una interfaz gráfica.

## Objetivos:
* Crear interfaces gráficas de usuario empleando técnicas de modelado de objetos con estándares de internacionalización.

**Version de las Herramientas**

* IDE Apache NetBeans 11.3

* Java = JDK 14

### Actividades a Desarrollar

### 1. Crear un repositorio en GitHub con el nombre “Práctica de laboratorio 05: Gestión de Tickets (Parqueadero)”.

A continuación se presentará una foto del repositorio creado en GutHub:

![GitHub](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/Github.png)

A continuación, se adjuntará el link de enlace al repositorio:

![Link](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-)

### 2.	Desarrollar una aplicación que permita la gestión de Tickets de un parqueadero de vehículos según los requerimientos planteados en las instrucciones de la práctica.

Para esta práctica primero se creo un diagrama UML, el cual, el link de enlace se encuentra a continuación: 

![UML](https://app.lucidchart.com/invitations/accept/1b019e2b-f9ce-41aa-ad4f-b09ac8064093)

Para esta practica se realizaron los prototipos que se presentaran a continuación:

![prototipo1](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/proto1.png)

![protoripo2](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/proto2.png)

![prototipo3](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/proto3.png)

![protoripo4](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/proto4.png)

![prototipo5](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/proto5.png)

![prototipo6](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/proto6.png)

![prototipo7](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/proto7.png)

Después de haber creado el diagrama se procedió a crear el proyecto en NetBeans y lo primero que se hizo fue crear sus paquetes: 

![paquetes](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/paquetes.png)

Luego se procedió con la creación de las clases que se encuentran en el paquete modelo:

![modelo](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/paquete.modelo.png)

Primero se crearon las clases Dirección y Teléfono, ya que no reciben información de ninguna otra clase. A continuación, se encuentra el link de enlace en GitHub del pseudocódigo de la clase Dirección:

![direccion](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/modelo/Direccion.java)


A continuación, el link de enlace del pseudocódigo de la clase Teléfono:

![telefono](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/modelo/Telefono.java)

A continuación, el link de enlace del pseudocódigo de la clase Ticket: 

![Ticket](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/modelo/Ticket.java)

A continuación, el link de enlace del pseudocódigo de la clase Vehículo, esta clase recibe una lista de tickets de tipo Ticket: 

![Vehiculo](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/modelo/Vehiculo.java)

A continuación, el link de enlace del pseudocódigo de la clase Cliente, la cual recibe una lista de vehículos de tipo Vehiculo: 

![Cliente](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/modelo/Vehiculo.java)

Una vez terminada las clases del paquete modelo, procedemos con las interfaces del paquete IDAO, las cuales serán implementadas en las clases del paquete DAO. 

![idao](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/paquete.DAO.png)

A continuación, el link de enlace del pseudocódigo de la interface IClienteDAO:

![IClienteDAO](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/idao/IClienteDAO.java)

A continuación, el link del pseudocódigo de la interface IVehiculoDAO:

![IVehiculoDAO](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/idao/IVehiculoDAO.java)

A continuación, el pseudocódigo de la interface ITicketDAO:

![ITicketDAO](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/idao/ITicketDAO.java)

Una vez terminado con las interfaces del paquete IDAO, procedemos a implementar estas interfaces en las clases del paquete DAO.

![dao](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/paquete.idao.png)

A continuación, el link del pseudocódigo de la clase ClienteDAO:

![ClienteDAO](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/dao/ClienteDAO.java)

A continuación, el link del pseudocódigo de la clase VehiculoDAO:

![VehiculoDAO](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/dao/VehiculoDAO.java)

A continuación, el link del pseudocódigo de la clase TicketDAO:

![TicketDAO](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/dao/TicketDAO.java)

Una vez terminado con las clases del paquete DAO, procedemos a las clases del paquete controlador. Este paquete es el encargado de mandar información al dao y de recibir información del paquete vista y en enviar información a este mismo paquete mencionado. Además, también manda información al paquete modelo.

![controlador](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/paquete.controlador.png)

A continuación, la clase ControladorCliente:

![ControladorCliente](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/controlador/ControladorCliente.java)

A continuación, la clase ControladorVehiculo:

![ControladorVehiculo](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/controlador/ControladorVehiculo.java)

A continuación, la clase ControladorTicket:

![ControladorTicket](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/controlador/ControladorTicket.java)

Una vez terminado con las clases del paquete controlador, procedemos con las clases del paquete vista. En este paquete, las clases son las interfaces gráficas que el usuario va a experimentar. Estas clases son de tipo: la VentanaPrincipalde tipo MDI Application Sample Form, y la de más son de tipo JInternalFrame.

![vista](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/paquete.vista.png)

A continuación, la VentanaPrincipal:

![VentanaPrincipal](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/vista/VentanaPrincipal.java)

A continuación, la VentanaRegistrarCliente:

![VentanaRegistrarCliente](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/vista/VentanaRegistarCliente.java)

A continuación, la VentanaRegistrarVehiculo:

![VentanaRegistrarVehiculo](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/vista/VentanaRegistrarVehiculo.java)

A continuación, la VentanaRegistrarTicket:

![VentanaRegistrarTicket](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/vista/VentanaRegistrarTicket.java)

A continuación, la VentanaSalidaTicket:

![VentanaSalidaTicket](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/vista/VentanaSalidaTicket.java)

A continuación, la VentanaListarTickets:

![VentanaListarTickets](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/vista/VentanaListarTickets.java)

A continuación, la VentanaListarClientes:

![VentanaListarClientes](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/vista/VentanaListarClientes.java)

Para la internacionalización de esta aplicación, se creó un nuevo paquete llamado idioma, en el cual existen 2 property files, los cuales son los encargados de guardar variables y un string el cual será reemplazado en las variables de las ventanas del paquete usuario.

![idioma](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/paquete.idioma.png)

A continuación, el property files de mensaje_en_UK:

![mensaje_en_UK](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/idioma/mensaje_en_UK.properties)

A continuación, el property files de mensaje_es_EC:

![mensaje_es_EC](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/blob/master/src/ec/ups/edu/idioma/mensaje_es_EC.properties)

### 3.	Realizar varios commits en la herramienta GitHub que demuestren el desarrollo de la aplicación desde principio a fin. Los commits deben ser realizados por todos los integrantes del grupo.

A continuación el link de los commits realizados:

![Commits](https://github.com/adolfojara10/Practica-de-laboratorio-05-Gestion-de-Tickets-Parqueadero-/commits/master)


### 4.	Generar el informe de la práctica con el desarrollo de cada uno de los puntos descritos anteriormente.

Al iniciar el programa, se nos abre esta ventana:

![VentanaPrincipal](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/VentanaPrincipal.png)

Lo primero que hacemos es crear un cliente:

![Venta](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/ventanaPrincipal2.png)

![RegistrarUsuario](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/registrarCliente.png)

Ahora procedemos a crear un vehículo:

![RegistrarVehiculo](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/registrarVehiculo.png)

Ahora procedemos a crear un ticket para dicho vehículo:

![RegistrarTicket](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/registrarticket.png)

Ahora vamos a crear un vehículo a un cliente que no existe, por lo que apareciera este mensaje:

![joptionespañl](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/mensajeRegistrarVehiculo.png)

Si aplastamos en el botón de “Si”, nos devolverá a la pagina de registrar cliente. Creamos un nuevo cliente: 

![cliente2](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/registrarCliente2.png)

Ahora volvemos a la página de registrar vehículo y creamos un vehículo:

![vehiculo2](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/registrarVehiculo2.png)

Ahora le vamos a asignar un ticket por la placa:

![ticket2](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/registrarticket2.png)

Ahora procedemos a listar a los clientes y sus vehículos: 

![ListarClientes](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/listarClientes.png)

Ahora vamos a emitir los tickets de salida:

![salidaticket](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/salidaTicket.png)

![salidaTicket2](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/salidaTicket2.png)

Por último, se listarán todos los tickets del sistema:

![ticketssistema](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/listarTickets.png)

Ahora las ventanas en inglés:

![rc](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/ingles1.png)

![rv](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/ingles2.png)

![rt](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/ingles3.png)

![st](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/ingles4.png)

![lc](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/ingles5.png)

![lt](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/ingles6.png)

### 5.	Implementar el README del repositorio del proyecto con la misma información del informe de la práctica (incluidas las imágenes y versiones de las herramientas).

### 6.	Subir al AVAC el informe del proyecto en formato .pdf. El informe debe contar con conclusiones apropiadas y la firma de cada estudiante.


## RESULTADO(S) OBTENIDO(S):

•	Diseñar una aplicación implementando los patrones de diseño de: MVC-DAO y además de la implementación de la interfaz gráfica de Java, y con la ayuda de las herramientas de Netbeans.

•	Implementar la internacionalización en esta aplicación creada, tanto para español como para inglés.

•	Un correcto manejo de las herramientas del paquete swing de java para la implementación de la interfaz gráfica.

•	Manejar las colecciones de java de tipo List y Set.

•	Un mayor entendimiento de los métodos de las componentes del paquete swing de java, para un correcto funcionamiento y una facilidad de uso de la aplicación.

## CONCLUSIONES:

•	En conclusión, esta práctica es muy satisfactoria para una mayor comprensión de todo lo aprendido hasta la fecha sobre Programación Orientada a Objetos, y todos los temas que conlleva dicha materia. Además, el tema de interfaz gráfica de usuario, para nuestro grupo, fue de mucha utilidad esta práctica porque aprendimos a sobrellevar nuestras ideas, tanto de prototipado y de funcionamiento, a una aplicación que es utilizada en el mundo real. Existen muchos parqueaderos en nuestra ciudad por lo que ahora tenemos una mayor compresión de como funcionan sus diferentes softwares.

•	Otra conclusión es que, en nuestro grupo aprendimos a trabajar en equipo, por lo que es muy satisfactorio ya que en la vida laboral muchas veces se trabaja de esta forma. Por lo que, si teníamos un problema en el código, no ayudaríamos mutuamente para soluciona dicho problema y lograr un correcto funcionamiento de la aplicación.

## RECOMENDACIONES:

•	Mi grupo no posee ninguna recomendación ya que todos estos temas se trabajaron con anterioridad y además muchos temas los practicamos en clase con el docente por lo que nos ayudaba con nuestras dudas y nos clarificaba muchas cosas sobre el tema.

## Firmas:

- Firma John Xavier Fárez Villa:

![firmaJohn](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/firma%202.png)

- Firma Adolfo Sebastián Jara Gavilanes

![firmaAdolfo](https://github.com/adolfojara10/Images-practicas/blob/master/imagenes%20practica05/firma%20electronica.jpg)





















