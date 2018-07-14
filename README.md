# LibraryManagementSystem

A basic implementation of Library Management System in **Java** using maven.

### Features
- Ability to add books to the system.
- Ability to add users to the system.
- Ability to lend books to users.
- Ability to return books to the library.
- Ability to limit the number of books borrowed by user.
- Ability to search a book by title, author.
- Ability to search a user by name.

- Persistance is built using in memory data structures. You need to replace the stores with db queries, if you want to move it use a db persistance.

- Search functionality is built using **Tries

### Build project

You need to have maven to build the project `https://maven.apache.org/install.html`

```
mvn clean package
```

**Entry point is com.lms.main -> App.java**


