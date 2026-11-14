# **Diagrama UML de Clase**

## **1\. Paciente.java \- Modelo de dominio**

Representa la entidad principal del sistema. Contiene los atributos del paciente y sus operaciones de acceso y modificación.

[image1]

**Responsabilidad**: representar a un paciente y mantener la integridad de sus propios atributos mediante validaciones.

## **2\. CsvService.java \- Persistencia**

Se encarga de gestionar los archivos CSV mediante OpenCSV.

[image2]

**Responsabilidad**: transformar registros CSV en objetos **Paciente** y objetos **Paciente** en registros CSV.

## **3\. PacienteService.java \- Lógica de negocio**

Administra las operaciones del sistema y aplica las reglas de negocio.

[image3]

**Responsabilidad**: controlar las operaciones **CRUD**, evitar inconsistencias y coordinar la persistencia de los pacientes.

## **4\. Main.java \- Presentación**

Es el punto de entrada de la aplicación. Gestiona el menú de consola y recibe las opciones del usuario.

[image4]

**Responsabilidad**: permitir que el usuario interactúe con el sistema sin implementar directamente las reglas de negocio ni la persistencia. 

## **5\. Interpretación de las relaciones**

| Relación | Significado |
| :---- | :---- |
| Main → PacienteService | La interfaz solicita operaciones al servicio. |
| PacienteService → Paciente | El servicio administra los objetos Paciente. |
| PacienteService → CsvService | El servicio delega la persistencia. |
| CsvService → Paciente | Convierte registros CSV en objetos y viceversa. |
