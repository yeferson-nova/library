# Library Management System

El **Library Management System** es una aplicación diseñada para gestionar la información relacionada con libros, préstamos y estudiantes en una biblioteca. Este proyecto utiliza Java y Maven y está organizado en varios paquetes que cubren diferentes aspectos de la funcionalidad del sistema, incluyendo la gestión de excepciones, el modelo de datos y los servicios.

## Características

- **Gestión de Libros**: Añadir, buscar y eliminar libros.
- **Gestión de Estudiantes**: Añadir, buscar y eliminar estudiantes.
- **Gestión de Préstamos**: Registrar préstamos de libros a estudiantes y generar informes de préstamos.
- **Excepciones Personalizadas**: Manejo de excepciones específicas como `BookNotFoundException`, `DuplicateBookException`, `DuplicateLoanException`, entre otras.

## Estructura del Proyecto

```plaintext
src
└── main
    └── java
        └── com
            └── ynova
                └── library
                    ├── exception
                    │   ├── BookNotFoundException.java
                    │   ├── DuplicateBookException.java
                    │   ├── DuplicateLoanException.java
                    │   ├── DuplicateStudentException.java
                    │   ├── ErrorMessages.java
                    │   ├── StudentNotFoundException.java
                    ├── model
                    │   ├── Book.java
                    │   ├── Loan.java
                    │   ├── LoanReport.java
                    │   ├── Student.java
                    ├── service
                    │   ├── impl
                    │   │   ├── BookServiceImpl.java
                    │   │   ├── LoanServiceImpl.java
                    │   │   ├── StudentServiceImpl.java
                    │   ├── IBookService.java
                    │   ├── ILoanService.java
                    │   ├── IStudentService.java
                    └── Main.java
resources
test
target
pom.xml
README.md
```

## Descripción de los Paquetes

- **exception**: Contiene clases para manejar excepciones personalizadas específicas del dominio de la biblioteca.
- **model**: Define las entidades del dominio como `Book`, `Loan`, `LoanReport` y `Student`.
- **service**: Contiene las interfaces y sus implementaciones para los servicios de negocio de la biblioteca, incluyendo `BookService`, `LoanService` y `StudentService`.
- **impl**: Implementaciones concretas de los servicios de negocio.
- **Main.java**: Punto de entrada de la aplicación.

## Clases Principales

### Book.java
- Representa un libro en la biblioteca.
- **Atributos**: `title`, `author`, `isbn`.

### Student.java
- Representa un estudiante que puede pedir prestado libros.
- **Atributos**: `name`, `dni`.

### Loan.java
- Representa un préstamo de un libro a un estudiante.
- **Atributos**: `loanDate`, `returnDate`, `book`, `student`.

### LoanReport.java
- Registro para reportar un préstamo.
- **Atributos**: `title`, `loanDate`, `returnDate`, `studentName`.

## Servicios

### BookService
- **Métodos**: `addBook`, `findBook`, `removeBook`.

### StudentService
- **Métodos**: `addStudent`, `findStudent`, `removeStudent`.

### LoanService
- **Métodos**: `registerLoan`, `reportLoan`.

## Instalación y Ejecución

1. **Clonar el repositorio:**
    ```sh
    git clone https://github.com/usuario/library-management-system.git
    ```

2. **Navegar al directorio del proyecto:**
    ```sh
    cd library-management-system
    ```

3. **Compilar y ejecutar el proyecto:**
    ```sh
    mvn clean install
    java -cp target/library-management-system-1.0-SNAPSHOT.jar com.ynova.library.Main
    ```

## Contribuciones

Las contribuciones son bienvenidas. Por favor, sigue estos pasos:

1. Haz un fork del repositorio.
2. Crea una nueva rama (`git checkout -b feature/nueva-feature`).
3. Realiza tus cambios y haz commits (`git commit -am 'Añadir nueva feature'`).
4. Sube tu rama (`git push origin feature/nueva-feature`).
5. Abre un Pull Request.

## Licencia

Este proyecto está bajo la licencia MIT. Consulta el archivo `LICENSE` para más detalles.
