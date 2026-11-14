# **Dependencias (`import`)**

## **1. Introducción**

Las instrucciones `import` permiten establecer las dependencias que necesita cada clase para desarrollar sus responsabilidades.

En el proyecto **Sistema de Pacientes**, las dependencias las podemos clasificar en tres grupos:

- **Clases de la biblioteca estándar de Java:** herramientas proporcionadas por el lenguaje para trabajar con colecciones, archivos, expresiones regulares y entrada de datos.  
- **Clases de bibliotecas externas:** componentes de terceros que amplían las funcionalidades disponibles, como OpenCSV para el procesamiento de archivos CSV.
- **Clases propias del proyecto:** componentes desarrollados para implementar el sistema, organizados en paquetes según su responsabilidad.  


## **2. Dependencias de cada clase**

A continuación se detallan las importaciones de cada componente del sistema, agrupadas por su procedencia (Java estándar, bibliotecas externas y proyecto) y ordenadas alfabéticamente dentro de cada bloque.

### **2.1. Clase `Main`**

**Paquete:** `com.salud.principal`

La clase `Main` constituye el punto de entrada de la aplicación y se encarga de gestionar la interacción con el usuario mediante un menú de consola.

**Instrucciones import:**

| Procedencia | Importación | Función |
| :---- | :---- | :---- |
| **Java estándar** | `java.util.List` | Permite trabajar con listas de pacientes obtenidas desde el servicio. |
| | `java.util.Scanner` | Permite leer los datos ingresados por el usuario a través de la consola. |
| **Proyecto** | `com.salud.modelo.Paciente` | Permite utilizar los objetos `Paciente` para mostrar y gestionar la información de los pacientes desde la interfaz. |
| | `com.salud.servicio.PacienteService` | Permite acceder a las operaciones de gestión de pacientes implementadas en la capa de servicio. |
| | `com.salud.servicio.PacienteService.ResultadoImportacion` | Permite utilizar el record anidado que representa el resultado de una importación, incluyendo la cantidad de registros agregados y duplicados. |

**Función de las dependencias:**

Estas importaciones permiten que `Main` interactúe con el usuario, reciba sus opciones, solicite operaciones al servicio y presente los resultados.

La clase no implementa directamente las reglas de negocio ni realiza operaciones de persistencia: delega esas responsabilidades a `PacienteService`.

### **2.2. Clase `Paciente`**

**Paquete:** `com.salud.modelo`

La clase `Paciente` representa la entidad principal del sistema. Contiene los atributos que describen a cada paciente y establece las validaciones correspondientes para mantener la integridad de sus datos.

**Instrucción import:**

| Procedencia | Importación | Función |
| :---- | :---- | :---- |
| **Java estándar** | `java.util.regex.Pattern` | Permite compilar y utilizar una expresión regular para comprobar el formato básico de las direcciones de correo electrónico. |

**Función de la dependencia:**

La clase `Pattern` permite definir un patrón de búsqueda que se utiliza para verificar que el correo electrónico cumpla con una estructura básica.

Esta dependencia interviene en la validación de los datos del modelo.

La clase `Paciente` no necesita importar otras clases del proyecto porque no depende directamente de ellas. Su responsabilidad consiste en representar y validar sus propios datos.

### **2.3. Clase `CsvService`**

**Paquete:** `com.salud.archivos`

La clase `CsvService` se encarga de leer, escribir, importar y exportar la información de los pacientes utilizando archivos CSV.

**Instrucciones import:**

| Procedencia | Importación | Función |
| :---- | :---- | :---- |
| **Java estándar** | `java.io.BufferedReader` | Proporciona lectura de texto mediante un búfer. |
| | `java.io.IOException` | Representa errores que pueden producirse durante las operaciones de entrada y salida. |
| | `java.io.Writer` | Permite escribir caracteres en un flujo de salida. |
| | `java.nio.charset.StandardCharsets` | Permite especificar la codificación UTF-8 para leer y escribir archivos. |
| | `java.nio.file.AtomicMoveNotSupportedException` | Permite identificar cuándo el sistema de archivos no admite una operación de movimiento atómico. |
| | `java.nio.file.Files` | Proporciona operaciones para crear, leer, escribir, mover y eliminar archivos y directorios. |
| | `java.nio.file.Path` | Representa rutas de archivos y directorios. |
| | `java.nio.file.StandardCopyOption` | Proporciona opciones para las operaciones de copia y movimiento de archivos, como reemplazar un archivo existente y solicitar un movimiento atómico. |
| | `java.util.ArrayList` | Permite crear listas dinámicas para almacenar los pacientes leídos desde un archivo CSV. |
| | `java.util.HashSet` | Permite controlar la unicidad de los identificadores de pacientes. |
| | `java.util.List` | Define la estructura de colección utilizada para almacenar y procesar pacientes. |
| | `java.util.Set` | Define una colección de elementos únicos, utilizada para verificar identificadores duplicados. |
| **Bibliotecas externas** | `com.opencsv.CSVReader` | Permite leer registros de archivos CSV y procesar sus campos. |
| | `com.opencsv.CSVWriter` | Permite escribir registros y campos en archivos CSV. |
| | `com.opencsv.exceptions.CsvValidationException` | Representa errores que pueden producirse durante la lectura y validación de los registros CSV. |
| **Proyecto** | `com.salud.modelo.Paciente` | Permite construir objetos `Paciente` a partir de los registros leídos y acceder al guardar información. |

**Función de las dependencias:**

Estas importaciones permiten que `CsvService` gestione la persistencia de los datos mediante archivos CSV.

OpenCSV se utiliza para interpretar y generar registros CSV, mientras que las clases de `java.io` y `java.nio.file` permiten administrar los flujos de lectura y escritura, las rutas y las operaciones sobre archivos.

Por otra parte, las colecciones `List` y `Set` permiten almacenar temporalmente los pacientes y controlar la unicidad de sus identificadores.

La clase `Paciente` es utilizada para transformar los datos leídos del archivo en objetos del modelo y para obtener la información que se escribirá en el archivo.

### **2.4. Clase `PacienteService`**

**Paquete:** `com.salud.servicio`

La clase `PacienteService` implementa las operaciones de gestión de pacientes y coordina la interacción entre el modelo y el servicio encargado de los archivos CSV.

**Instrucciones import:**

| Procedencia | Importación | Función |
| :---- | :---- | :---- |
| **Java estándar** | `java.io.IOException` | Permite declarar y propagar errores producidos durante las operaciones de entrada y salida. |
| | `java.util.HashSet` | Permite controlar los identificadores existentes durante el proceso de importación. |
| | `java.util.List` | Permite almacenar y manipular las colecciones de pacientes. |
| | `java.util.Set` | Define la colección utilizada para mantener identificadores únicos durante la importación. |
| **Bibliotecas externas** | `com.opencsv.exceptions.CsvValidationException` | Permite declarar y propagar errores relacionados con el análisis y la validación de archivos CSV. |
| **Proyecto** | `com.salud.archivos.CsvService` | Permite utilizar las operaciones de lectura, escritura, importación y exportación de archivos CSV. |
| | `com.salud.modelo.Paciente` | Permite trabajar con los objetos del modelo y realizar las operaciones de gestión sobre los pacientes. |

**Función de las dependencias:**

Estas importaciones permiten que `PacienteService` implemente las operaciones de alta, consulta, modificación, eliminación, importación y exportación.

La clase utiliza `Paciente` para representar los datos que administra y `CsvService` para acceder a la persistencia mediante archivos CSV.

Las colecciones `List` y `Set` permiten gestionar los registros en memoria y controlar los identificadores duplicados durante las operaciones de importación.

La clase también utiliza las excepciones `IOException` y `CsvValidationException` para comunicar los errores que pueden producirse durante las operaciones de persistencia.

## **3. Resumen general de las dependencias**

La siguiente tabla permite visualizar de manera comparativa las dependencias utilizadas por las cuatro clases principales del proyecto, agrupadas según su procedencia:

| Clase | Java estándar | Bibliotecas externas | Clases propias | Total de imports |
| :---- | :---: | :---: | :---: | :---: |
| `Main` | 2 | 0 | 3 | **5** |
| `Paciente` | 1 | 0 | 0 | **1** |
| `CsvService` | 12 | 3 | 1 | **16** |
| `PacienteService` | 4 | 1 | 2 | **7** |

*Nota: los valores representan la cantidad de instrucciones `import` explícitas de cada categoría.*

## **4. Consideraciones sobre las importaciones en Java**

Es importante tener en cuenta tres características del lenguaje:

**1. Paquete `java.lang`:**
Java importa automáticamente las clases del paquete `java.lang`. Por este motivo, no es necesario escribir instrucciones `import` para utilizar clases como `String`, `Integer`, `System` o `IllegalArgumentException`.

**2. Clases del mismo paquete:**
Cuando dos clases pertenecen al mismo paquete, no necesitan importarse explícitamente entre sí. En este proyecto, por ejemplo, `ResultadoImportacion` es un record anidado dentro de `PacienteService`, por lo que su importación en `Main` utiliza su nombre completamente calificado.

**3. Bibliotecas externas:**
Las clases de OpenCSV no forman parte de la biblioteca estándar de Java. Por lo tanto, el proyecto debe incorporar esa dependencia para poder compilar y ejecutar las operaciones de lectura y escritura de archivos CSV.

## **5. Conclusión**

El análisis de las instrucciones `import`, organizadas de forma estructurada y alfabética por bloques, permite identificar con claridad las dependencias de cada clase y comprender cómo se distribuyen las responsabilidades dentro de **SistemaPacientes**:

- `Main` depende del modelo y del servicio para gestionar la interacción con el usuario.  
- `Paciente` utiliza una herramienta de Java para validar el formato básico del correo electrónico.  
- `CsvService` concentra las dependencias necesarias para administrar los archivos CSV y la persistencia.  
- `PacienteService` coordina las operaciones de negocio y utiliza el servicio de archivos para conservar los datos.

Esta organización contribuye a la separación de responsabilidades y facilita el mantenimiento y la lectura del código fuente en la aplicación.
