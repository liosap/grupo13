# **Requisitos \- Sistema Pacientes**

Describimos los servicios y operaciones que deberá proporcionar el sistema.

| Requisito | Descripción |
| :---- | :---- |
| Registrar pacientes | Permitir ingresar un nuevo paciente. |
| Consultar pacientes | Mostrar los pacientes registrados. |
| Buscar pacientes | Localizar un paciente mediante un identificador u otro criterio definido. |
| Modificar pacientes | Actualizar información de un paciente existente. |
| Eliminar pacientes | Eliminar un registro seleccionado. |
| Validar información | Comprobar que los datos ingresados cumplan las reglas establecidas. |
| Leer archivos CSV | Recuperar registros almacenados previamente. |
| Guardar archivos CSV | Persistir los registros del sistema. |
| Importar pacientes | Incorporar registros provenientes de un archivo CSV. |
| Exportar pacientes | Generar un archivo CSV con la información administrada. |
| Mostrar menú | Permitir acceder a las operaciones mediante opciones de consola. |
| Gestionar errores | Informar situaciones excepcionales sin interrumpir incorrectamente la aplicación. |

**Observación:** Los atributos definitivos de Paciente, el identificador único y las reglas específicas de validación deberán confirmarse durante el diseño funcional.

# **Requisitos de calidad**

Características que deberá cumplir la aplicación:

1. El código deberá organizarse en clases y paquetes con responsabilidades diferenciadas.  
2. Se utilizarán nombres descriptivos y convenciones de programación Java.  
3. El proyecto deberá poder ejecutarse en entornos compatibles con Java 21\.  
4. La información deberá conservarse entre ejecuciones mediante archivos CSV.  
5. Se deberán aplicar validaciones para evitar registros inconsistentes.  
6. Se deberán controlar excepciones y errores de entrada y salida.  
7. La lógica de negocio, el modelo, la persistencia y la interfaz deberán mantenerse separados.  
8. El código deberá administrarse mediante GitHub.  
9. El proyecto deberá incluir un tablero Kanban para asignación y seguimiento de tareas.

