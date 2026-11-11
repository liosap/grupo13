# **Arquitectura \- Sistema Pacientes**

## **Estructura general**
```
SistemaPacientes/  
│  
├── src/  
│   └── main/  
│       └── java/  
│           └── com/  
│               └── salud/  
│                   ├── principal/  
│                   │   └── Main.java             ➔ Interacción con el usuario (Punto de entrada) 
│                   ├── modelo/  
│                   │   └── Paciente.java         ➔ Modelo de datos (Entidades)  
│                   ├── servicio/  
│                   │   └── PacienteService.java  ➔ Lógica de negocio y procesamiento  
│                   └── archivos/  
│                       └── CsvService.java       ➔ Gestión y persistencia en archivos CSV  
│  
└── pom.xml ➔ Configuración de dependencias (Maven)
```
La arquitectura que vamos a desarrollar utiliza la separación por responsabilidades:

| Paquete | Clase | Responsabilidad |
| :---- | :---- | :---- |
| com.salud.principal | **Main** | Interacción con el usuario |
| com.salud.modelo | **Paciente** | Modelo de datos |
| com.salud.servicio | **PacienteService** | Lógica de negocio |
| com.salud.archivos | **CsvService** | Gestión de archivos CSV |

El archivo **pom.xml** contiene la configuración de Maven y la dependencia de OpenCSV.

## **Responsabilidades de los componentes**

### **Paquete modelo**

**Clase:** `Paciente`

Responsabilidad:

Representar la entidad principal del sistema, definiendo sus atributos y los métodos necesarios para trabajar con la información de cada paciente.

La clase debe contener:

* Atributos: `id`, `nombre`, `apellido`, `edad`, `telefono` y `email`.  
* Constructor: inicializa los seis atributos.  
* Getters: permite consultar los datos.  
* Setters: permite modificar los datos, excepto el identificador.  
* toString(): permite mostrar la información del paciente.

### **Paquete archivos**

**Clase:** `CsvService`

Responsabilidad:

Administrar las operaciones de lectura y escritura de archivos CSV mediante la biblioteca OpenCSV.

Deberá contemplar:

* Lectura de registros.  
* Escritura de registros.  
* Importación de información.  
* Exportación de información.  
* Manejo de excepciones de entrada y salida.

### **Paquete servicio**

**Clase:** `PacienteService`

Responsabilidad:

Centralizar la lógica de negocio y las operaciones de administración de pacientes.

Deberá contemplar:

* Registro.  
* Consulta.  
* Búsqueda.  
* Modificación.  
* Eliminación.  
* Validaciones.  
* Coordinación con el servicio de persistencia.

### **Paquete principal**

**Clase:** `Main`

Responsabilidad:

Constituir el punto de entrada de la aplicación y proporcionar la interacción con el usuario mediante un menú de consola.

Deberá coordinar las operaciones disponibles sin concentrar en esta clase la lógica de negocio ni el procesamiento de archivos.

Poseerá las siguientes funcionalidades:

1. Menú principal interactivo por consola.  
2. Registro de pacientes.  
3. Listado de pacientes.  
4. Búsqueda por ID.  
5. Modificación de pacientes.  
6. Eliminación de pacientes.  
7. Importación desde archivos CSV.  
8. Exportación a archivos CSV.  
9. Lectura de datos mediante `Scanner`.  
10. Control básico de errores y validación de edades.

## **Tecnologías y herramientas**

1. **Java 21**: Lenguaje de programación.  
2. **Maven**: Administración de dependencias y construcción del proyecto.  
3. **OpenCSV 5.9**: Procesamiento de archivos CSV.  
4. **Eclipse IDE**: Entorno de desarrollo.  
5. **GitHub**: Repositorio remoto y colaboración.  
6. **Miro**: Planificación y seguimiento mediante Kanban.

