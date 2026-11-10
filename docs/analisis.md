# **Análisis Previo \- Sistema Pacientes**

# **1\. Introducción**

En este documento realizaremos el análisis previo al desarrollo del **Sistema Pacientes**, estableciendo las necesidades que justifican su implementación, los objetivos que se pretenden alcanzar, los requisitos que deberá cumplir y las características generales de la solución propuesta.

**Sistema Pacientes** será una aplicación desarrollada en **Java** que permitirá administrar información de pacientes mediante operaciones de registro, consulta, modificación y eliminación. La información se almacenará utilizando archivos CSV, permitiendo conservar los datos entre distintas ejecuciones del programa.

El desarrollo se realizará de manera colaborativa, utilizando GitHub para el control de versiones y Miro para la planificación, asignación y seguimiento de las actividades.

# **2\. Descripción de la situación problemática**

Administrar la información de los pacientes requiere mecanismos que permitan registrar, consultar, actualizar y conservar los datos de manera organizada.

Cuando estas operaciones se realizan sin una estructura definida, pueden presentarse dificultades relacionadas con:

* La duplicación de registros.  
* La inconsistencia de los datos.  
* La dificultad para localizar información.  
* La modificación incorrecta de registros existentes.  
* La pérdida de información entre distintas ejecuciones.  
* La falta de mecanismos de validación.  
* La dificultad para mantener y actualizar la aplicación.

Estas situaciones justifican la necesidad de desarrollar una solución informática que centralice las operaciones de administración de pacientes y establezca criterios uniformes para el tratamiento de la información.

# **3\. Identificación del problema**

**Problema central:**

Necesidad de contar con una aplicación que permita administrar información de pacientes de manera **organizada**, **consistente** y **persistente**, mediante operaciones de gestión y almacenamiento en archivos.

**Consecuencias identificadas:**

1. Dificultad para mantener organizada la información.  
2. Posibilidad de registrar datos incorrectos o incompletos.  
3. Falta de mecanismos uniformes para realizar modificaciones y eliminaciones.  
4. Dificultad para recuperar información previamente registrada.  
5. Mayor complejidad para mantener y ampliar el sistema.

# **4\. Justificación del proyecto**

El desarrollo del **Sistema Pacientes** se justifica por la necesidad de aplicar conocimientos de programación orientada a objetos, estructuras de datos, manejo de archivos, validaciones y organización modular del software en la construcción de una solución funcional.

Desde el punto de vista técnico, el proyecto permitirá trabajar con:

* Clases y objetos.  
* Encapsulamiento y organización de responsabilidades.  
* Separación entre modelo, servicios, persistencia e interfaz.  
* Operaciones CRUD.  
* Lectura y escritura de archivos.  
* Manejo de excepciones.  
* Validación de información.  
* Gestión de dependencias mediante Maven.  
* Control de versiones y desarrollo colaborativo.

Desde el punto de vista organizacional, el proyecto permitirá incorporar prácticas de trabajo en equipo, distribución de responsabilidades, seguimiento de tareas, revisión de código e integración de cambios.

# **5\. Objetivos**

## **5.1. Objetivo general**

Desarrollar una **aplicación de gestión de pacientes** utilizando Java 21, que permita registrar, consultar, modificar y eliminar información, garantizando su almacenamiento y recuperación mediante archivos CSV.

## **5.2. Objetivos específicos**

* Diseñar una estructura de datos que represente adecuadamente a los pacientes.  
* Implementar las operaciones necesarias para administrar los registros.  
* Incorporar mecanismos de validación para evitar datos incorrectos.  
* Desarrollar servicios para separar la lógica de negocio de la interfaz.  
* Implementar la lectura y escritura de archivos CSV.  
* Incorporar mecanismos de manejo de excepciones.  
* Desarrollar una interfaz de interacción mediante un menú de consola.  
* Verificar el funcionamiento mediante pruebas.  
* Documentar la estructura y utilización del sistema.  
* Organizar el desarrollo colaborativo mediante GitHub y Miro.

# **6\. Alcance del sistema**

## **6.1. Funcionalidades incluidas**

La primera versión del Sistema Pacientes comprenderá:

1. Registro de pacientes.  
2. Consulta de pacientes.  
3. Búsqueda de registros.  
4. Modificación de información.  
5. Eliminación de pacientes.  
6. Validación de los datos ingresados.  
7. Lectura de información desde archivos CSV.  
8. Escritura y conservación de información en archivos CSV.  
9. Importación de registros.  
10. Exportación de registros.  
11. Interacción mediante un menú de consola.  
12. Manejo de errores y excepciones.

## **6.2. Funcionalidades futuras** 

Estas funcionalidades podrán considerarse en futuras versiones:

* Interfaz gráfica de usuario.  
* Aplicación web o móvil.  
* Base de datos relacional.  
* Gestión de usuarios y contraseñas.  
* Administración de roles y permisos.  
* Conexión con sistemas externos de salud.  
* Turnos y agendas médicas.  
* Historia clínica electrónica.  
* Despliegue en servidores o infraestructura en la nube.
