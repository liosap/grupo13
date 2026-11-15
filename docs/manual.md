# **MANUAL DE USUARIO**

# **Sistema de Gestión de Pacientes**

## **1. Introducción**

Sistema de Pacientes es una aplicación desarrollada en Java que permite administrar información de pacientes mediante una interfaz de línea de comandos (consola).

El sistema ofrece herramientas para registrar nuevos pacientes, consultar los registros existentes, buscar información por identificador, modificar datos, eliminar pacientes e importar y exportar información mediante archivos CSV.

Este manual tiene como finalidad explicar, de manera sencilla y ordenada, cómo utilizar las distintas funcionalidades de la aplicación.

## **2. Requisitos para utilizar el sistema**

Para ejecutar SistemaPacientes se necesita:

* Tener instalado Java 21 o una versión compatible con el proyecto.  
* Disponer de los archivos de la aplicación.  
* Contar con la biblioteca OpenCSV 5.9 y las dependencias necesarias para su ejecución.  
* Tener permisos de lectura y escritura en el directorio donde se almacenan los archivos del sistema.

La información principal se almacena en un archivo denominado `pacientes.csv`.

## **3. Inicio de la aplicación**

Al ejecutar SistemaPacientes, se presenta un menú principal en la consola desde el cual se puede acceder a las distintas operaciones.

### **Menú principal**

El menú permite seleccionar las siguientes opciones:

1. Registrar paciente.  
2. Listar pacientes.  
3. Buscar paciente.  
4. Modificar paciente.  
5. Eliminar paciente.  
6. Importar pacientes.  
7. Exportar pacientes.  
8. Salir.

Para utilizar una funcionalidad, se debe ingresar el número correspondiente y presionar la tecla **Enter**.

## **4. Funcionalidades del sistema**

### **4.1. Registrar un paciente**

Esta opción permite incorporar un nuevo paciente al sistema.

**Procedimiento:**

1. Seleccionar la opción **Registrar paciente**.  
2. Ingresar el identificador del paciente.  
3. Ingresar el nombre.  
4. Ingresar el apellido.  
5. Ingresar la edad.  
6. Ingresar el teléfono.  
7. Ingresar el correo electrónico.

**Ejemplo de registro:**

| Campo | Dato ingresado |
| :--- | :--- |
| ID | 1 |
| Nombre | Juan |
| Apellido | Pérez |
| Edad | 35 |
| Teléfono | 3511234567 |
| Email | juan@gmail.com |

Una vez ingresados los datos correctamente, el sistema registra al paciente y muestra un mensaje de confirmación.

**Validaciones:**

* El identificador debe ser un número entero positivo.  
* No se permiten identificadores duplicados.  
* El nombre y el apellido son obligatorios.  
* La edad debe encontrarse entre 0 y 130 años.  
* El teléfono es obligatorio.  
* El correo electrónico debe tener un formato válido.  
* Los campos obligatorios no pueden quedar vacíos.

### **4.2. Listar pacientes**

Esta opción permite consultar todos los pacientes registrados en el sistema.

**Procedimiento:**

1. Seleccionar la opción **Listar pacientes**.  
2. El sistema recupera los registros almacenados.  
3. Se muestran los datos de los pacientes encontrados.

Si no existen pacientes registrados, el sistema informa que no hay pacientes disponibles.

### **4.3. Buscar un paciente**

Esta funcionalidad permite localizar un paciente utilizando su identificador.

**Procedimiento:**

1. Seleccionar la opción **Buscar paciente**.  
2. Ingresar el ID del paciente.  
3. El sistema realiza la búsqueda.  
4. Si encuentra el registro, muestra sus datos.

Si el identificador no existe, se informa que el paciente no fue encontrado.

**Ejemplo:**

Para buscar al paciente registrado con ID `1`, se debe ingresar:

`1`

El sistema mostrará la información correspondiente a ese paciente si existe.

### **4.4. Modificar un paciente**

Esta opción permite actualizar los datos de un paciente existente.

**Procedimiento:**

1. Seleccionar la opción **Modificar paciente**.  
2. Ingresar el ID del paciente que se desea modificar.  
3. Introducir los nuevos datos solicitados.  
4. El sistema valida la información ingresada.  
5. Si los datos son correctos, guarda los cambios.

El identificador del paciente se utiliza para localizar el registro y no se modifica durante esta operación.

Si el paciente no existe, el sistema informa que no fue encontrado.

**Importante:** las modificaciones se guardan en el archivo principal `pacientes.csv`, por lo que los cambios permanecen disponibles después de cerrar y volver a ejecutar la aplicación.

### **4.5. Eliminar un paciente**

Esta funcionalidad permite eliminar un registro del sistema.

**Procedimiento:**

1. Seleccionar la opción **Eliminar paciente**.  
2. Ingresar el ID del paciente que se desea eliminar.  
3. El sistema busca el registro.  
4. Si el paciente existe, elimina su información y actualiza el archivo CSV.

Si el identificador no corresponde a ningún paciente registrado, se informa que el paciente no fue encontrado.

**Importante:** la eliminación modifica el archivo principal `pacientes.csv`. Por este motivo, se recomienda verificar cuidadosamente el identificador antes de realizar esta operación.

### **4.6. Importar pacientes desde un archivo CSV**

Esta funcionalidad permite incorporar pacientes desde un archivo CSV externo.

**Procedimiento:**

1. Seleccionar la opción **Importar pacientes**.  
2. Ingresar la ruta del archivo CSV que se desea importar.  
3. El sistema lee y valida el contenido del archivo.  
4. Se incorporan los pacientes cuyos identificadores no estén registrados.  
5. El sistema informa la cantidad de pacientes agregados y la cantidad de registros duplicados.

**Ejemplo de archivo CSV:**

```
id,nombre,apellido,edad,telefono,email
10,Ana,Gomez,28,3511111111,ana@gmail.com
11,Carlos,Lopez,42,3512222222,carlos@gmail.com
12,Laura,Diaz,31,3513333333,laura@gmail.com
```

**Consideraciones:**

* El archivo debe tener el encabezado esperado.  
* Los registros deben respetar la estructura de columnas del sistema.  
* Los identificadores deben ser únicos.  
* Los pacientes que ya se encuentren registrados no se incorporan nuevamente.  
* El archivo debe existir y estar disponible en la ruta indicada.  
* Los registros importados correctamente se incorporan al archivo principal.

### **4.7. Exportar pacientes a un archivo CSV**

Esta opción permite generar un archivo externo con la información de los pacientes registrados.

**Procedimiento:**

1. Seleccionar la opción **Exportar pacientes**.  
2. Ingresar la ruta donde se desea guardar el archivo.  
3. El sistema genera el archivo CSV con los registros disponibles.  
4. Se informa la cantidad de pacientes exportados.

**Ejemplo de archivo generado:**

```
id,nombre,apellido,edad,telefono,email
1,Juan,Perez,35,3511234567,juan@gmail.com
2,Maria,Lopez,29,3517654321,maria@gmail.com
```

**Consideraciones:**

* Se debe indicar una ruta de destino válida.  
* El archivo generado contiene el encabezado y los registros exportados.  
* La exportación no debe sobrescribir el archivo principal `pacientes.csv`.  
* El archivo exportado puede utilizarse posteriormente para consultar o importar información.

## **5\. Validaciones y mensajes del sistema**

Durante el uso de la aplicación, pueden aparecer mensajes que indican errores en los datos ingresados o en las operaciones realizadas.

| Situación | Comportamiento del sistema |
| :--- | :--- |
| Ingresar un ID negativo | Solicita un identificador positivo. |
| Ingresar texto en un campo numérico | Informa que se debe ingresar un número entero. |
| Ingresar un nombre vacío | Informa que el campo es obligatorio. |
| Ingresar un apellido vacío | Informa que el campo es obligatorio. |
| Ingresar una edad fuera del rango permitido | Informa que la edad debe estar entre 0 y 130\. |
| Ingresar un correo electrónico inválido | Informa que el formato del correo no es válido. |
| Registrar un ID existente | Impide registrar el identificador duplicado. |
| Buscar un ID inexistente | Informa que el paciente no fue encontrado. |
| Modificar un ID inexistente | Informa que el paciente no fue encontrado. |
| Eliminar un ID inexistente | Informa que el paciente no fue encontrado. |
| Seleccionar una opción incorrecta | Informa que la opción no es válida. |

## **6. Almacenamiento de la información**

SistemaPacientes utiliza archivos CSV para almacenar la información de los pacientes.

El archivo principal es:

`pacientes.csv`

Este archivo contiene los datos de cada paciente organizados en las siguientes columnas:

* `id`: identificador del paciente.  
* `nombre`: nombre.  
* `apellido`: apellido.  
* `edad`: edad.  
* `telefono`: número de teléfono.  
* `email`: correo electrónico.

Las operaciones de registro, modificación, eliminación e importación actualizan la información almacenada.

La exportación, por su parte, permite generar una copia externa de los registros.

## **7. Finalizar la aplicación**

Para cerrar el sistema:

1. Seleccionar la opción **Salir** en el menú principal.  
2. El sistema muestra el mensaje de despedida.  
3. La aplicación finaliza su ejecución.

Se recomienda utilizar esta opción para cerrar normalmente la aplicación.

## **8. Recomendaciones de uso**

Para utilizar correctamente Sistema de Pacientes, se recomienda:

* Ingresar los datos con atención y respetar las validaciones.  
* Verificar el identificador antes de modificar o eliminar un paciente.  
* Mantener una copia de respaldo del archivo `pacientes.csv`.  
* Comprobar que los archivos CSV externos tengan el encabezado y la estructura esperados.  
* Verificar las rutas de los archivos antes de realizar importaciones o exportaciones.  
* No modificar manualmente el archivo principal mientras la aplicación se encuentra trabajando con él.

## **9. Conclusión**

Sistema de Pacientes permite administrar información de pacientes mediante una aplicación sencilla de consola.

Sus funcionalidades facilitan el registro, la consulta, la búsqueda, la modificación y la eliminación de pacientes, además de permitir importar y exportar información utilizando archivos CSV.

El sistema proporciona controles de validación para los datos ingresados y mantiene la información almacenada de forma persistente, permitiendo continuar su utilización en distintas ejecuciones de la aplicación.
