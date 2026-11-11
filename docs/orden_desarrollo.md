## **Orden de desarrollo \- Sistema Pacientes**

1. **Paciente.java (Primero)**  
   Modelo de dominio. Define los atributos, constructores, getters, setters y validaciones propias del paciente.  
2. **PacienteService.java**  
   Contiene la lógica de negocio y las operaciones CRUD: agregar, listar, buscar, modificar y eliminar pacientes.  
3. **CsvService.java**  
   Gestiona la persistencia: lectura, escritura, importación y exportación de archivos CSV mediante OpenCSV.  
4. **Main.java**  
   Punto de entrada de la aplicación. Presenta el menú de consola, recibe las opciones del usuario y coordina las llamadas a los servicios.

Hay una consideración importante: en la implementación actual, **PacienteService** utiliza **CsvService** para gestionar la persistencia. Por eso, conviene distinguir el orden de diseño del orden de construcción e integración.

## **Orden práctico para el equipo**

| Orden | Clase | Responsable | Dependencia |
| :---- | :---- | :---- | :---- |
| 1 | Paciente.java | Camila | Ninguna |
| 2 | CsvService.java | Tatiana | Paciente |
| 3 | PacienteService.java | Lionel | Paciente y CsvService |
| 4 | Main.java | Los tres | Todos los componentes |

**La arquitectura sería:** 

   *Main.java*		← Punto de entrada  
                     ↓  
          *PacienteService* 	← Lógica de negocio, operaciones CRUD.  
   ↙            ↘  
    *Paciente       CsvService* 	← Paciente (Modelo de dominio) y CsvService (Persistencia)  
         ↓  
                        *pacientes.csv*	← Archivo CSV

**Paciente** representa los datos; **CsvService** se ocupa de almacenarlos.