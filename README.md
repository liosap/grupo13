# Sistema de Pacientes
&emsp;**Grupo**: 13<br>
&emsp;**Materia**: Algoritmos y Estructuras de Datos 2 (AED2)<br>
&emsp;**Tema**: Clase 10 - Archivos de texto y CSV<br>
&emsp;**Integrantes**: Sandoval Tatiana - Villarroel Camila - Saporito Lionel<br>
&emsp;**Tablero Kanban:** 
     📊 [Miro - Grupo 13](https://miro.com/app/board/uXjVEQCZln0=/?moveToWidget=3458764689790402655&cot=14)

### Descripción del negocio
El programa permita llevar un registro de pacientes, realizar consultas, listar y exportar los datos. También se puede importar desde los archivos CSV como una suerte de backub.<br>
El programa esta dirigido principalmente a entidades de pequeña a mediana envergadura dedicadas al cuidado de la Salud que deseen llevar un registro de sus pacientes contando con: nombre, apellido, edad, telefono y email.

### Problema que resuelve
Se pretende resolver la situación caótica de no contar con estos registro o de llevarlos de forma desordenada. Poder tener una base de datos solida como punto de partida para agregar a futuro más funcionalidades.

### Tema elegido
Clase 10 - Archivos de texto y CSV<br>
Elegimos este tema ya que creemos cubre bastante lo esencial de la materia y nos permite agregar detalles extras.

### El proyecto implementará
* Maven.
* OpenCSV 5.9.
* Lectura y escritura de archivos.
* Importación y exportación de archivos CSV.
* Programación orientada a objetos.
* Separación de responsabilidades mediante paquetes y clases.

### Tecnologías
&emsp;**Lenguaje**: Java 21<br>
&emsp;**Entorno IDE**: Eclipse<br>
&emsp;**GitHub**: Repositorio<br>
&emsp;**Miro**: Tablero Kanban<br>

## Funcionalidades
1. Menú principal interactivo por consola.
2. Registro de pacientes.
3. Listado de pacientes.
4. Búsqueda por ID.
5. Modificación de pacientes.
6. Eliminación de pacientes.
7. Importación desde archivos CSV.
8. Exportación a archivos CSV.
9. Lectura de datos mediante Scanner.
10. Control básico de errores y validaciones.

## Capturas de pantalla
| Fase | Captura | Descripción | Objetivo |
| :---: | :---: | :--- | :--- |
| **1** | <img width="291" height="163" alt="fase1" src="https://github.com/user-attachments/assets/df5c412b-bdc5-4daf-ae45-e173ebb552a3" /> | La primera fase contempla las operaciones básicas de **alta** y **consulta** de pacientes, junto con las **validaciones** necesarias y el **almacenamiento persistente** de la información. | Contar con una primera versión funcional del sistema que permita administrar pacientes de manera sencilla, asegurando la validación de los datos ingresados, evitando duplicaciones de identificadores y garantizando la conservación de la información registrada. |
| **2** | <img width="260" height="188" alt="fase2" src="https://github.com/user-attachments/assets/0fbc639e-e491-425e-8762-283d750f5038" /> | La segunda fase amplía las funcionalidades del sistema **incorporando operaciones** de **modificación** y **eliminación** de pacientes, además de las operaciones de registro y consulta existentes. Mantiene las validaciones de datos y el almacenamiento persistente mediante archivos CSV. | Evolucionar el sistema hacia una herramienta más completa de gestión de pacientes, permitiendo administrar integralmente la información registrada mediante operaciones de alta, consulta, modificación y eliminación, manteniendo la integridad de los datos y evitando duplicaciones de identificadores. |
| **3** | <img width="257" height="233" alt="fase3" src="https://github.com/user-attachments/assets/b6d3b508-fa69-47ad-a42f-e231af9879be" /> | Última etapa del desarrollo. Integra las cuatro clases principales del sistema: **Main**, **Paciente**, **PacienteService** y **CsvService**. Consolida las operaciones de registro, consulta, modificación y eliminación, e incorpora la **importación y exportación** de pacientes mediante archivos **CSV**. | Consolidar una versión integrada y funcional del Sistema de Pacientes, que permita gestionar los registros de los pacientes, importar y exportar información,manteniendo la persistencia de los datos mediante archivos CSV. |

## Pruebas realizadas

Las pruebas se organizan en tres fases que acompañan la evolución del Sistema de Pacientes:

- **Fase 1:** verifica el registro y la consulta de pacientes, junto con las validaciones iniciales y la persistencia de los datos.
- **Fase 2:** comprueba la incorporación de las operaciones de búsqueda, modificación y eliminación, manteniendo las funcionalidades anteriores.
- **Fase 3:** verifica la integración de las cuatro clases principales, la importación y exportación de archivos CSV, el control de duplicados y la persistencia de los registros.

📁 [Pruebas](./pruebas/) | Archivos con las pruebas realizadas

## Documentación General
- 📑 [00-Fuentes consultadas](./docs/fuentes.md)
- 📑 [01-Análisis Pevio](./docs/analisis.md)
- 📑 [02-Arquitectura](./docs/arquitectura.md)
- 📑 [03-Requisitos](./docs/requisitos.md)
- 📑 [04-Modelo de Datos](./docs/modelo.md)
- 📑 [05-Orden de desarollo](.docs/orden_desarrollo.md)
- 📑 [06-Diagramas UML de Clases](./docs/diagramas_uml.md)
- 📑 [07-Manual de usuario](./docs/manual.md)

## Uso de la Inteligencia Artificial
Durante el desarrollo del proyecto Sistema de Pacientes se utilizó la Inteligencia Artificial (IA) como una herramienta de asistencia para acompañar distintas etapas del proceso de programación, análisis, revisión y documentación del sistema.

Su utilización tuvo como finalidad asistir a la comprensión de los conceptos de programación nuevos que queríamos incorporar, analizar las responsabilidades de las clases, crear listas para ayudar a identificar posibles errores, mejorar la organización del código y elaborar diagramas para incorporar en documentación técnica que permitiera explicar el funcionamiento del software.

La IA se incorporó como una fuente de consulta y recurso complementario al trabajo del equipo.

## Conclusiones
### **¿Qué aprendimos?**

Durante el desarrollo de Sistema de Pacientes adquirimos conocimientos y experiencia en la construcción de una aplicación utilizando Java, aplicando progresivamente conceptos de programación orientada a objetos. 

Entre los principales aprendizajes destacamos:

* Comprendimos la importancia de **distribuir las responsabilidades** entre distintas clases, evitando concentrar toda la lógica del programa en una única clase, separado la interacción con el usuario, la representación de los datos, la lógica de negocio y el acceso a los archivos.  
* **Validación de datos**, incorporando controles para verificar los identificadores, los campos obligatorios, los rangos de edad y el formato del correo electrónico.  
* Implementamos las **operaciones de creación, consulta, actualización y eliminación** de pacientes.  
* A utilizar archivos **CSV para almacenar y recuperar información**, evitando que los datos se pierdan al finalizar la ejecución.  
* **Manejo de archivos** para importar y exportar información desde archivos CSV externos.  
* Comprendimos la importancia de **controlar los errores** que pueden producirse durante el ingreso de datos y las operaciones con archivos.  
* Aprendimos a documentar las clases mediante **comentarios y Javadoc**, y a **diseñar casos de prueba** para verificar el comportamiento de las funcionalidades implementadas.

### **¿Qué dificultades tuvimos?**

Durante el desarrollo encontramos diferentes dificultades que nos permitieron comprender mejor el funcionamiento de Java y la relación entre los componentes de una aplicación.

Entre las principales dificultades identificamos:

* **Validación de entradas:** controlar que los datos ingresados por el usuario fueran correctos, contemplando valores vacíos, tipos de datos incorrectos y valores fuera de los rangos establecidos.  
* **Control de identificadores duplicados:** evitar que se registraran pacientes con identificadores existentes, tanto en las operaciones individuales como durante la importación de archivos.  
* **Manejo de archivos CSV:** trabajar con la lectura y escritura de archivos, validar sus encabezados y estructuras y controlar posibles errores durante su procesamiento.  
* **Integración de las clases:** coordinar las responsabilidades de `Main`, `Paciente`, `PacienteService` y `CsvService`, procurando mantener una organización clara y evitar la duplicación de responsabilidades.  
* **Importación y exportación:** contemplar diferentes situaciones, como archivos inexistentes, registros duplicados, estructuras incorrectas y rutas de destino no válidas.

Estas dificultades nos permitieron reconocer que desarrollar una aplicación no consiste únicamente en implementar funcionalidades, sino también en validar los datos, controlar los errores y verificar que los distintos componentes trabajen correctamente en conjunto.

### **¿Qué mejoraríamos?**

Si continuáramos evolucionando el Sistema de Pacientes, incorporaríamos mejoras orientadas a fortalecer su organización, facilidad de uso, mantenimiento y capacidad de crecimiento.

Entre las principales mejoras posibles proponemos:

* **Implementar una interfaz gráfica:** reemplazar la interacción exclusiva por consola por una interfaz visual que facilite el uso de la aplicación.  
* **Incorporar una base de datos:** evaluar la utilización de un sistema de gestión de bases de datos para administrar la información cuando aumente el volumen de registros.  
* **Fortalecer las validaciones:** ampliar los controles sobre los datos ingresados y los archivos importados, contemplando más situaciones de error.  
* **Mejorar la experiencia del usuario:** incorporar mensajes más descriptivos, confirmaciones antes de eliminar registros y opciones para facilitar la navegación.  
* **Incorporar nuevas funcionalidades:** permitir ordenar y filtrar pacientes, realizar búsquedas por nombre o apellido y generar reportes de información.  
* **Mejorar la configuración del sistema:** permitir configurar las rutas de almacenamiento y exportación sin necesidad de modificar directamente el código fuente.

