LlanquihueTourApp

## Descripción del Sistema
Sistema de gestión de tours para la región de Llanquihue. Permite administrar clientes, tours y guías turísticos con una interfaz gráfica intuitiva. Implementa validaciones robustas y persistencia de datos.

## Estructura del Proyecto
LlanquihueTourApp/
├── src/
│ ├── model/ # Clases del modelo de datos
│ │ ├── Registrable.java (Interfaz)
│ │ ├── Cliente.java
│ │ ├── Tour.java
│ │ └── Guia.java
│ ├── data/ # Gestión de datos
│ │ └── GestorEntidades.java
│ └── ui/ # Interfaz de usuario
│ └── MainApp.java
└── README.md

## Clases e int.

# Interfaces
- **Registrable**: Define métodos para registrar y validar entidades (`registrar()`, `validar()`)

# Model
- **Cliente**: Representa un cliente del tour
- **Tour**: Información de los tours disponibles
- **Guia**: Datos de los guías turísticos

### Data
- **GestorEntidades**: Gestiona colecciones usando `ArrayList` y valida tipos con `instanceof`

### Ui
- **MainApp**: Aplicación principal con menú interactivo usando `JOptionPane`

## Ejecución
Ejecución desde IDE (Eclipse/IntelliJ/NetBeans)
Abrir el proyecto en tu IDE

Localizar la clase MainApp.java en el paquete ui

Ejecutar como aplicación Java (Run/Execute)

Menú Principal
La aplicación muestra un menú con las siguientes opciones:

Registrar Cliente

Registrar Tour

Registrar Guía

Listar todas las entidades

Buscar por ID

Salir

Autor: Vicente Milla Espinoza
