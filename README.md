# Universidad Politécnica Salesiana
## Nombre: Andrés Guamán
## Materia: Plataformas Web
## Tema: Prácticas de Laboratorio - CRUD

---

## Descripción del Proyecto

Este proyecto consiste en una aplicación web que se conecta a una base de datos PostgreSQL para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre una tabla de productos. La aplicación permite registrar nuevos productos, ver una lista de todos los productos registrados, editar la información de un producto existente y eliminar productos de la base de datos.

---

## Acerca del Proyecto

Este proyecto es una aplicación web desarrollada en Java utilizando Servlets, JSP y JDBC para interactuar con una base de datos PostgreSQL. La aplicación permite realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre una tabla de productos.

### Tecnologías Utilizadas

- Java
- Servlets
- JSP (JavaServer Pages)
- JDBC (Java Database Connectivity)
- PostgreSQL

### Configuración del Proyecto

1. **Clonar el Repositorio:**
git clone https://github.com/landr3s/gojo.git
2. **Importar el Proyecto en Eclipse:**
- Abre Eclipse y selecciona `File > Import`.
- En el cuadro de diálogo, elige `Existing Projects into Workspace` y haz clic en `Next`.
- Selecciona el directorio donde clonaste el repositorio y haz clic en `Finish`.

3. **Configurar la Base de Datos:**
- Asegúrate de tener PostgreSQL instalado en tu sistema.
- Crea una base de datos llamada `gojo` y una tabla llamada `products` con la estructura adecuada. Puedes utilizar el siguiente script SQL:
  ```sql
  CREATE TABLE products (
      id SERIAL PRIMARY KEY,
      title VARCHAR(255) NOT NULL,
      description TEXT,
      quantity INT,
      price NUMERIC(10, 2)
  );
  ```

4. **Configurar la Conexión a la Base de Datos:**
- Abre el archivo `ProductDao.java` en el paquete `net.gojo.registration.dao`.
- Modifica los valores de `url`, `username` y `password` en el método `getConnection()` para que coincidan con tu configuración de PostgreSQL.

### Ejecutar el Proyecto

1. **Inicia el Servidor Tomcat:**
- Abre Eclipse y selecciona el proyecto.
- Haz clic derecho en el proyecto y selecciona `Run As > Run on Server`.
- Selecciona el servidor Tomcat y haz clic en `Next`.
- Haz clic en `Finish` para iniciar el servidor Tomcat y desplegar la aplicación web.

2. **Accede a la Aplicación:**
- Abre un navegador web y visita `http://localhost:8080/gojo/index` para acceder a la página principal de la aplicación.

---

## Capturas de Pantalla: Funcionalidad de la Web

## Página Index

![Screenshot 2024-05-06 111331](https://github.com/landr3s/gojo/assets/99095150/b9bcceaf-d153-4ca5-9762-9b904bc6932a)


## Página Registration
### Página Registration - Form

![Screenshot 2024-05-06 111556](https://github.com/landr3s/gojo/assets/99095150/5ea19f09-f783-4e0a-93a7-ea09c12b4c44)

### Página Registration - Vista estado success y vinculacion con base de datos

![Screenshot 2024-05-06 111651](https://github.com/landr3s/gojo/assets/99095150/1689069c-cc49-4cbf-a6c8-ee595f6fec5e)

### Página Registration - Vista index para verificar datos

![Screenshot 2024-05-06 111821](https://github.com/landr3s/gojo/assets/99095150/a9cff305-6f70-4979-8530-fea0b40e0d10)

## Página UpdateProduct
### Página UpdateProduct - Form

![Screenshot 2024-05-06 111907](https://github.com/landr3s/gojo/assets/99095150/f35fe470-840c-4b06-953a-c291c8b30de0)

### Página UpdateProduct - Vista index para verificar datos

![Screenshot 2024-05-06 112029](https://github.com/landr3s/gojo/assets/99095150/28cfb3c9-4e11-435d-9603-3bcb6012bfbe)


## Funcionalidad DeleteProduct

![Screenshot 2024-05-06 112156](https://github.com/landr3s/gojo/assets/99095150/9b29322b-f6ef-42c4-b225-27fadc018b65)

---

## Conclusiones

Durante el desarrollo de este proyecto, aprendí cómo utilizar Java, Servlets, JSP y JDBC para construir una aplicación web que interactúa con una base de datos PostgreSQL. Implementar las operaciones CRUD me permitió comprender mejor cómo se gestionan los datos en una aplicación web y cómo se pueden realizar cambios en la base de datos desde la interfaz de usuario.

## Revisiones
Si se desea agregar la funcionalidad de búsqueda (search), tomará más recursos de lo necesario ya que se está tomando mal el tipo de dato por no estar formateado.
