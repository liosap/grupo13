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
📁 [Pruebas](./pruebas/) | Archivos con las pruebas realizadas

## Conclusiones
(Qué aprendimos, qué dificultades tuvimos, qué mejoraríamos.)
