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
