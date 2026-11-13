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

