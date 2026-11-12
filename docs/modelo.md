# **Modelo de datos \- Sistema Pacientes**

## **Descripción general**

El sistema administra la información de pacientes mediante operaciones de alta, consulta, modificación y eliminación (CRUD). Los datos se mantienen en memoria durante la ejecución y pueden persistir mediante archivos CSV.

El modelo de datos se centra inicialmente en la entidad Paciente.

## **Entidad Paciente**

Representa a una persona registrada en el sistema.

### **Atributos**

| Atributo | Tipo de dato | Restricciones |
| :---- | :---- | :---- |
| id | int | Obligatorio, positivo y único. |
| nombre | String | Obligatorio, no puede estar vacío. |
| apellido | String | Obligatorio, no puede estar vacío. |
| edad | int | Entre 0 y 130 años. |
| telefono | String | Obligatorio. |
| email | String | Debe cumplir un formato básico de correo electrónico. |

## **Reglas de integridad**

El sistema debe garantizar las siguientes condiciones:

1. Cada paciente debe tener un identificador único.  
2. El identificador debe ser un número entero positivo.  
3. Nombre y apellido son campos obligatorios.  
4. Los campos de texto deben eliminar espacios innecesarios al inicio y al final.  
5. La edad debe estar comprendida entre 0 y 130 años.  
6. El teléfono no puede estar vacío.  
7. El correo electrónico debe respetar un formato básico válido.  
8. No se deben registrar dos pacientes con el mismo identificador.

## **Modelo de dominio**

**Paciente**

ATRIBUTOS

* id: int  
* nombre: String  
* apellido: String  
* edad: int  
* telefono: String  
* email: String

MÉTODOS

* getId()  
* getNombre()  
* getApellido()  
* getEdad()  
* getTelefono()  
* getEmail()  
* setNombre()  
* setApellido()  
* setEdad()  
* setTelefono()  
* setEmail()

La clase Paciente encapsula los datos y controla sus validaciones. El modelo **Paciente** es utilizado por los servicios y el componente de archivos.

**Persistencia de datos**

La información de los pacientes se almacena en un archivo CSV.

Ejemplo ilustrativo de estructura:

*`id,nombre,apellido,edad,telefono,email`*  
*`1,Juan,Perez,35,3515551234,juan@example.com`*  
*`2,Ana,Gomez,28,3515555678,ana@example.com`*

## **Consideraciones de diseño**

* Encapsulamiento: los atributos de **Paciente** deben ser privados y accederse mediante métodos.  
* Validación: las reglas de integridad deben controlarse desde el modelo y los servicios, según corresponda.  
* Identificación: el ID permite localizar y distinguir a cada paciente.  
* Persistencia: CSV permite conservar y recuperar registros entre ejecuciones.  
* Separación de responsabilidades: el modelo representa los datos; el servicio administra las operaciones; el componente CSV gestiona la lectura y escritura.

## **Diagrama UML \- Clase Paciente**

<img width="60%" alt="modelo-uml" src="https://github.com/user-attachments/assets/9f22ae27-f9ec-4f42-be6d-41c37fb4b0a6" />
