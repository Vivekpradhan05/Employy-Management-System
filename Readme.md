# Employee Management System

A simple Java console application for managing employee records with JDBC and
an Oracle database. The project demonstrates a layered design with controller,
service, DAO, entity, exception, and database-connection packages.

## Features

- Insert an employee
- Update an employee
- Delete an employee by ID
- Find an employee by ID
- List all employees
- Custom exceptions for missing employees and empty result sets
- Prepared statements for database write and read operations

## Technology Stack

- Java 21
- Oracle Database XE
- JDBC
- Oracle JDBC driver (`ojdbc11.jar`)
- Eclipse IDE

## Project Structure

```text
src/
└── com/
    ├── Controller/
    │   └── EmployeeController.java
    ├── Service/
    │   └── EmployeeService.java
    ├── dao/
    │   └── EmployeeDao.java
    ├── entity/
    │   └── Employee.java
    ├── exception/
    │   ├── AllEmployNotFound.java
    │   ├── EmployeeNullException.java
    │   ├── EmployyNotFound.java
    │   └── SomethingWentWrong.java
    ├── jdbcConnection/
    │   └── JDBCUtil.java
    ├── main/
    │   └── EmployeeMain.java
    └── module-info.java
```

## Database Setup

The application currently connects to Oracle XE using the following JDBC
configuration:

```text
URL:      jdbc:oracle:thin:@localhost:1521:XE
Username: scott
Password: tiger
```

Make sure Oracle XE is running and that the `SCOTT` user is available. Create
the employee table before running the application:

```sql
CREATE TABLE EMPLOY (
    ID NUMBER(10),
    NAME VARCHAR2(10),
    SALARY NUMBER(10),
    CITY VARCHAR2(10)
);
```

The `EmployeeDao` class also contains a `createTable()` method that can be used
to create the table from Java when needed.

> **Security note:** The database credentials are currently defined in
> `src/com/jdbcConnection/JDBCUtil.java` for learning purposes. Do not commit
> real credentials to a public repository. For production use, load them from
> environment variables or an external configuration file.

## JDBC Driver Setup

Download the Oracle JDBC driver (`ojdbc11.jar`) from the
[Oracle JDBC Downloads](https://www.oracle.com/database/technologies/appdev/jdbc-downloads.html)
page.

In Eclipse:

1. Right-click the project and select **Properties**.
2. Open **Java Build Path** and select the **Libraries** tab.
3. Choose **Classpath**, select **Add External JARs**, and add `ojdbc11.jar`.
4. Apply the changes and rebuild the project.

The existing Eclipse classpath points to a local JAR path, so update that path
to match the location on your computer.

## Running the Application

1. Clone the repository:

   ```bash
   git clone https://github.com/Vivekpradhan05/Employy-Management-System.git
   cd Employy-Management-System
   ```

2. Import the project into Eclipse as an **Existing Projects into Workspace**
   project.
3. Configure the Oracle JDBC driver and database described above.
4. Open `src/com/main/EmployeeMain.java`.
5. Run `EmployeeMain` as a Java application.
6. Select an operation from the console menu.

The current demo entry point uses sample employee values for insert, update,
delete, and lookup operations. Replace those sample values with scanner-based
input when extending the application for interactive use.

## Application Layers

- **Entity:** `Employee` represents an employee record.
- **DAO:** `EmployeeDao` contains SQL queries and JDBC operations.
- **Service:** `EmployeeService` applies application rules and translates empty
  results into domain-specific exceptions.
- **Controller:** `EmployeeController` exposes employee operations to the main
  application.
- **Main:** `EmployeeMain` provides the console entry point.
- **JDBC utility:** `JDBCUtil` creates the Oracle database connection.

## Future Improvements

- Read employee details and menu choices from the user instead of using sample
  values.
- Keep the menu in a loop until the user chooses **Exit**.
- Move database credentials to environment variables.
- Add input validation and duplicate-ID handling.
- Add automated unit and integration tests.
- Add a Maven or Gradle build file for dependency management.

## License

No license has been specified yet. Add a license before distributing this
project or accepting external contributions
