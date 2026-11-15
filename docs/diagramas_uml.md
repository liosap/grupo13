# **Diagrama UML de Clase**

## **1\. Paciente.java \- Modelo de dominio**

Representa la entidad principal del dominio. Contiene los atributos del paciente y sus operaciones de acceso y modificación.

<img width="561" height="472" alt="Paciente" src="https://github.com/user-attachments/assets/30d6aa7a-6ade-4e6b-8706-1b195171df59" />

**Responsabilidad**: representar a un paciente y mantener la integridad de sus propios atributos mediante validaciones.

## **2\. CsvService.java \- Persistencia**

Se encarga de gestionar los archivos CSV mediante OpenCSV. Gestiona la lectura, escritura, importación y exportación de información.

<img width="50%" alt="CsvService" src="https://github.com/user-attachments/assets/26d4339b-d3b7-4ba6-985e-de420d9a1e00" />

**Responsabilidad**: transformar registros CSV en objetos **Paciente** y objetos **Paciente** en registros CSV.

## **3\. PacienteService.java \- Lógica de negocio**

Contiene la lógica de negocio del sistema. Coordina las operaciones CRUD y la importación y exportación de pacientes, delegando la persistencia a CsvService.

<img width="50%" alt="PacienteService" src="https://github.com/user-attachments/assets/4058f623-b6e2-4aea-8ddb-26c6920b466c" />

**Responsabilidad**: controlar las operaciones **CRUD**, evitar inconsistencias y coordinar la persistencia de los pacientes.

## **4\. Main.java \- Presentación**

Es el punto de entrada de la aplicación. Gestiona el menú de consola y recibe las opciones del usuario.

<img width="50%" alt="Main" src="https://github.com/user-attachments/assets/886098b6-d604-4987-9a2e-a9ed3f022a98" />

**Responsabilidad**: permitir que el usuario interactúe con el sistema sin implementar directamente las reglas de negocio ni la persistencia. 

## **5\. Interpretación de las relaciones**
| Clase origen | Clase destino | Tipo de relación | Finalidad |
| :---- | :---- | :---- | :---- |
| Main | PacienteService | Dependencia | Solicitar operaciones |
| Main | Paciente | Dependencia | Crear y presentar pacientes |
| PacienteService | CsvService | Asociación | Gestionar persistencia |
| PacienteService | Paciente | Dependencia | Administrar pacientes |
| CsvService | Paciente | Dependencia | Leer y guardar pacientes |

<img width="75%" alt="relacion" src="https://github.com/user-attachments/assets/9d32dfd5-73e1-4dda-ba91-a2764b6e17a1" />

## **6\. Referencia de notación UML**
| Símbolo | Significado |
| :---- | :---- |
| \+ | Público (public) |
| \- | Privado (private) |
| \$ | Estático (static) |
| \--\> | Asociación o relación de uso |
| ..\> | Dependencia |
| \<\<record\>\> | Registro de Java |
