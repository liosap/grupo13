# **Casos de Prueba \- Sistema de Pacientes**

## **FASE 1**

Las pruebas se realizan de manera progresiva a medida qué se incorporan o actualizan métodos y validaciones.

| **Nº** | **Prueba** | **Entrada** | **Resultado Esperado** | **Resultado Obtenido** | **¿Pasó?** |
| :---: | :--- | :--- | :--- | :--- | :---: |
| 001 | Mostrar menú principal | Ejecutar la aplicación | Qué muestre las opciones Registrar, Listar y Salir. | Se muestran las opciones Registrar, Listar y Salir. | SI |
| 002 | Opción registrar  | Opción: 1 | Que solicite ingresar los datos del paciente. | Solicita el ingreso de los datos del paciente | SI |
| 003 | Registrar paciente | ID: 1, Juan, Pérez, 35, 3511234567, juan@gmail.com | Muestre mensaje: "Paciente registrado correctamente". | Muestra mensaje: "Paciente registrado correctamente". | SI |
| 004 | Registrar paciente con ID duplicado | ID ya existente: 1 | Que muestre el mensaje "No se registró: el ID ya existe". | Muestra el mensaje "No se registró: el ID ya existe". | SI |
| 005 | Ingresar ID negativo | ID: \-5 | Solicite nuevamente el ID e informa que el valor debe ser mayor que cero. | Solicita nuevamente el ID e informa que el valor debe ser mayor que cero. | SI |
| 006 | Ingresar texto en campo ID | ID: ABC | Informe que debe ingresar un número entero y se vuelve a solicitar el dato. | Informa que debe ingresar un número entero y se vuelve a solicitar el dato. | SI |
| 007 | Ingresar nombre vacío | Nombre: "" | Informe que el dato no puede estar vacío y se vuelve a solicitar. | Informa que el dato no puede estar vacío y se vuelve a solicitar. | SI |
| 008 | Ingresar apellido vacío | Apellido: "" | Informe que el dato no puede estar vacío y se vuelve a solicitar. | Informa que el dato no puede estar vacío y se vuelve a solicitar. | SI |
| 009 | Ingresar edad mínima | Edad: 0 | Acepte la edad y continúa el registro. | Acepta la edad y continúa el registro. | SI |
| 010 | Ingresar edad máxima | Edad: 130 | Acepte la edad y continúa el registro. | Acepta la edad y continúa el registro. | SI |
| 011 | Ingresar edad negativa | Edad: \-1 | Informe que el valor debe estar entre 0 y 130 y se vuelve a solicitar. | Informa que el valor debe estar entre 0 y 130 y se vuelve a solicitar. | SI |
| 012 | Ingresar edad superior al máximo | Edad: 131 | Informe que el valor debe estar entre 0 y 130 y se vuelve a solicitar. | Informe que el valor debe estar entre 0 y 130 y se vuelve a solicitar. | SI |
| 013 | Ingresar texto en campo edad | Edad: ABC | Informe que debe ingresar un número entero y se vuelve a solicitar. | Informa que debe ingresar un número entero y se vuelve a solicitar. | SI |
| 014 | Ingresar teléfono vacío | Teléfono: "" | Informe que el dato no puede estar vacío y se vuelve a solicitar. | Informa que el dato no puede estar vacío y se vuelve a solicitar. | SI |
| 015 | Ingresar email vacío | Email: "" | Informe que el dato no puede estar vacío y se vuelve a solicitar. | Informa que el dato no puede estar vacío y se vuelve a solicitar. | SI |
| 016 | Ingresar email con formato inválido | Email: usuario@ | Muestre un mensaje de error por formato inválido. | Muestra un mensaje de error por formato inválido. | SI |
| 017 | Seleccionar opción listar con pacientes | Opción: 2 y CSV con dos pacientes | Muestre los datos de ambos pacientes y el total registrado. | Muestra los datos de ambos pacientes y el total registrado. | SI |
| 018 | Seleccionar opción listar sin pacientes | Opción: 2 y CSV vacío | Muestre el mensaje "No hay pacientes registrados". | Muestra el mensaje "No hay pacientes registrados". | SI |
| 019 | Seleccionar opción incorrecta | Opción: 5 | Muestre el mensaje "Opción incorrecta" y vuelve al menú. | Muestra el mensaje "Opción incorrecta" y vuelve al menú. | SI |
| 020 | Ingresar texto como opción de menú | Opción: ABC | Informe que debe ingresar un número entero y vuelve a solicitar la opción. | Informe que debe ingresar un número entero y vuelve a solicitar la opción. | SI |
| 021 | Seleccionar opción salir | Opción: 3 | Muestre el mensaje de despedida y finaliza la aplicación. | Muestra el mensaje de despedida y finaliza la aplicación. | SI |

## **FASE 2**

Las pruebas de esta fase incorporan las nuevas funcionalidades de búsqueda, modificación y eliminación de pacientes, verificando también que se mantengan las validaciones y el almacenamiento persistente de la información.

| Nº | Prueba | Entrada | Resultado Esperado | Resultado Obtenido | ¿Pasó? |
| :---: | :---- | :---- | :---- | :---- | :---: |
| 022 | Mostrar menú principal actualizado | Ejecutar la aplicación | Que muestre las opciones Registrar, Listar, Buscar, Modificar, Eliminar y Salir. | Se muestran todas las opciones correctamente. | SI |
| 023 | Seleccionar opción buscar | Opción: 3 | Que solicite ingresar el ID del paciente. | Solicita ingresar el ID del paciente. | SI |
| 024 | Buscar paciente existente | ID: 1 | Que muestre todos los datos del paciente encontrado. | Muestra correctamente los datos del paciente. | SI |
| 025 | Buscar paciente inexistente | ID: 99 | Que muestre el mensaje "Paciente no encontrado". | Muestra el mensaje "Paciente no encontrado". | SI |
| 026 | Ingresar ID negativo al buscar | ID: \-5 | Que informe que el valor debe ser mayor que cero y vuelva a solicitarlo. | Informa que el valor debe ser mayor que cero y vuelve a solicitarlo. | SI |
| 027 | Ingresar texto como ID al buscar | ID: ABC | Que informe que debe ingresar un número entero y vuelva a solicitarlo. | Informa que debe ingresar un número entero y vuelve a solicitarlo. | SI |
| 028 | Seleccionar opción modificar | Opción: 4 | Que solicite ingresar el ID del paciente a modificar. | Solicita ingresar el ID del paciente. | SI |
| 029 | Modificar paciente existente | ID: 1 y nuevos datos personales | Que actualice los datos del paciente y muestre el mensaje "Paciente modificado correctamente". | Actualiza los datos y muestra el mensaje correctamente. | SI |
| 030 | Modificar paciente inexistente | ID: 99 | Que muestre el mensaje "Paciente no encontrado". | Muestra el mensaje "Paciente no encontrado". | SI |
| 031 | Modificar nombre vacío | Nombre: "" | Que informe que el dato no puede estar vacío y vuelva a solicitarlo. | Informa que el dato no puede estar vacío y vuelve a solicitarlo. | SI |
| 032 | Modificar apellido vacío | Apellido: "" | Que informe que el dato no puede estar vacío y vuelva a solicitarlo. | Informa que el dato no puede estar vacío y vuelve a solicitarlo. | SI |
| 033 | Modificar edad fuera de rango | Edad: 150 | Que informe que el valor debe estar entre 0 y 130 y vuelva a solicitarlo. | Informa que el valor debe estar entre 0 y 130 y vuelve a solicitarlo. | SI |
| 034 | Modificar email con formato inválido | Email: usuario@ | Que muestre un mensaje de error por formato inválido. | Muestra un mensaje de error por formato inválido. | SI |
| 035 | Verificar modificación persistente | Modificar un paciente y volver a listar | Que se muestren los nuevos datos almacenados en el archivo CSV. | Se muestran los datos actualizados correctamente. | SI |
| 036 | Seleccionar opción eliminar | Opción: 5 | Que solicite ingresar el ID del paciente a eliminar. | Solicita ingresar el ID del paciente. | SI |
| 037 | Eliminar paciente existente | ID: 1 | Que elimine el paciente y muestre el mensaje "Paciente eliminado correctamente". | Elimina el paciente y muestra el mensaje correctamente. | SI |
| 038 | Eliminar paciente inexistente | ID: 99 | Que muestre el mensaje "Paciente no encontrado". | Muestra el mensaje "Paciente no encontrado". | SI |
| 039 | Ingresar ID negativo al eliminar | ID: \-5 | Que informe que el valor debe ser mayor que cero y vuelva a solicitarlo. | Informa que el valor debe ser mayor que cero y vuelve a solicitarlo. | SI |
| 040 | Verificar eliminación persistente | Eliminar un paciente y volver a listar | Que el paciente eliminado ya no aparezca en el listado. | El paciente eliminado no aparece en el listado. | SI |
| 041 | Eliminar paciente y verificar archivo CSV | Eliminar un paciente y consultar el archivo CSV | Que el registro eliminado ya no se encuentre almacenado en el archivo. | El registro eliminado ya no se encuentra en el archivo CSV. | SI |
| 042 | Seleccionar opción salir | Opción: 6 | Que muestre el mensaje de despedida y finalice la aplicación. | Muestra el mensaje de despedida y finaliza la aplicación. | SI |

## **FASE 3**

Las pruebas de esta fase verifican la integración de las cuatro clases principales del sistema (`Main`, `Paciente`, `PacienteService` y `CsvService`), así como la incorporación de las funcionalidades de importación y exportación de pacientes mediante archivos CSV. También se comprueba la validación de los archivos, el control de identificadores duplicados y la persistencia de la información.

| Nº | Prueba | Entrada | Resultado Esperado | Resultado Obtenido | ¿Pasó? |
| :---: | :--- | :--- | :--- | :--- | :---: |
| 043 | Mostrar menú principal completo | Ejecutar la aplicación | Que muestre las opciones de Registrar, Listar, Buscar, Modificar, Eliminar, Importar, Exportar y Salir. | Muestra las opciones de Registrar, Listar, Buscar, Modificar, Eliminar, Importar, Exportar y Salir. | SI |
| 044 | Seleccionar opción importar | Seleccionar la opción correspondiente a Importar | Que solicite ingresar la ruta del archivo CSV externo. | Solicita ingresar la ruta del archivo CSV externo. | SI |
| 045 | Importar pacientes desde archivo CSV | Ruta de un archivo CSV válido con pacientes nuevos | Que lea los registros del archivo, los incorpore al sistema y muestre la cantidad de pacientes agregados. | Lee los registros del archivo, los incorpora al sistema y muestra la cantidad de pacientes agregados. | SI |
| 046 | Importar archivo CSV con pacientes duplicados | Archivo CSV con identificadores que ya existen en el sistema | Que omita los pacientes cuyos ID ya se encuentran registrados e informe la cantidad de duplicados. | Omite los pacientes cuyos ID ya se encuentran registrados e informa la cantidad de duplicados. | SI |
| 047 | Importar archivo CSV con registros nuevos y duplicados | Archivo CSV con pacientes nuevos y pacientes cuyos ID ya existen | Que incorpore únicamente los pacientes nuevos e informe las cantidades agregadas y duplicadas. | Incorpora únicamente los pacientes nuevos e informa las cantidades agregadas y duplicadas. | SI |
| 048 | Importar archivo CSV sin pacientes nuevos | Archivo CSV cuyos identificadores ya existen en el sistema | Que no agregue registros duplicados y que informe cero pacientes agregados y la cantidad de duplicados detectados. | No agrega registros duplicados e informa cero pacientes agregados y la cantidad de duplicados detectados. | SI |
| 049 | Importar archivo CSV inexistente | Ruta de un archivo que no existe | Que informe el error correspondiente y no incorpore registros al sistema. | Informa el error correspondiente y no incorpora registros al sistema. | SI |
| 050 | Importar archivo CSV con encabezado incorrecto | Archivo CSV con nombres de columnas diferentes a los esperados | Que detecte el encabezado inválido e informe el error correspondiente. | Detecta el encabezado inválido e informa del error correspondiente. | SI |
| 051 | Importar archivo CSV con estructura incorrecta | Archivo CSV con una cantidad de columnas diferente a la esperada | Que detecte la estructura incorrecta e informe el error correspondiente. | Detecta la estructura incorrecta e informa del error correspondiente. | SI |
| 052 | Importar archivo CSV con identificadores duplicados internos | Archivo CSV que contiene dos o más registros con el mismo ID | Que detecte los identificadores duplicados dentro del archivo y rechace la importación si no se cumple la validación de unicidad. | Detecta los identificadores duplicados dentro del archivo y rechace la importación si no se cumple la validación de unicidad. | SI |
| 053 | Importar archivo CSV con codificación BOM | Archivo CSV UTF-8 que contiene BOM al inicio del encabezado | Que reconozca correctamente el encabezado y pueda procesar los registros del archivo. | Reconozce correctamente el encabezado y puede procesar los registros del archivo. | SI |
| 054 | Verificar persistencia de pacientes importados | Importar pacientes nuevos y volver a listar los registros | Que los pacientes importados aparezcan en el listado del sistema. | Los pacientes importados aparezcen en el listado del sistema. | SI |
| 055 | Verificar persistencia de importación en archivo principal | Importar pacientes nuevos y consultar pacientes.csv | Que los nuevos registros se encuentren almacenados en el archivo principal. | Los nuevos registros se encuentran almacenados en el archivo principal. | SI |
| 056 | Seleccionar opción exportar | Seleccionar la opción correspondiente a Exportar | Que solicite ingresar la ruta de destino del archivo CSV. | Solicita ingresar la ruta de destino del archivo CSV. | SI |
| 057 | Exportar pacientes a archivo CSV | Ruta de destino válida | Que genere un archivo CSV con los pacientes registrados y sus respectivos datos. | Genera un archivo CSV con los pacientes registrados y sus respectivos datos. | SI |
| 058 | Exportar archivo sin pacientes registrados | Sistema sin pacientes y ruta de destino válida | Que genere un archivo CSV con el encabezado correspondiente, sin registros de pacientes. | Genera un archivo CSV con el encabezado correspondiente, sin registros de pacientes. | SI |
| 059 | Verificar cantidad de pacientes exportados | Exportar una lista de pacientes registrados | Que la cantidad informada como exportada coincida con la cantidad de pacientes almacenados. | La cantidad informada como exportada coincide con la cantidad de pacientes almacenados. | SI |
| 060 | Verificar contenido del archivo exportado | Abrir el archivo CSV generado | Que contenga el encabezado esperado y los datos correspondientes a los pacientes exportados. | Contenge el encabezado esperado y los datos correspondientes a los pacientes exportados. | SI |
| 061 | Proteger archivo principal durante la exportación | Ingresar como destino de exportación la ruta del archivo pacientes.csv | Que impida sobrescribir el archivo principal del sistema. | Impide sobrescribir el archivo principal del sistema. | SI |
| 062 | Verificar importación y exportación de datos | Importar pacientes desde un archivo externo y exportar los registros del sistema | Que el archivo exportado contenga los pacientes incorporados mediante la importación, junto con los demás registros existentes. | El archivo exportado contiene los pacientes incorporados mediante la importación, junto con los demás registros existentes. | SI |
| 063 | Verificar persistencia después de reiniciar la aplicación | Registrar o importar pacientes, cerrar y volver a ejecutar el sistema | Que los registros continúen disponibles después de reiniciar la aplicación. | Los registros continúan disponibles después de reiniciar la aplicación. | SI |
| 064 | Seleccionar opción salir del menú actualizado | Seleccionar la opción correspondiente a Salir | Que muestre el mensaje de despedida y finalice la aplicación. | Muestra el mensaje de despedida y finaliza la aplicación. | SI |
