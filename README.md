# TodoApp
Simple TodoApp with JSP and Servlets

## 🔧 Prerequisites

- Java JDK 8+
- Apache Tomcat
- Maven
- VS Code Extensions:
  - Java Extension Pack
  - Community Server Connector
  - Maven for Java

## 🚀 Steps

### 1. Build Project

Open terminal and run:

```bash
mvn clean package
```

### 2. Deploy to Tomcat

1. Press `Ctrl+Shift+P` → `Server Connector: Add Tomcat Server`
2. Press `Ctrl+Shift+P` → `Server Connector: Add Deployment` → choose WAR
3. Start the server from the Tomcat sidebar

### 3. Access in Browser

- `http://localhost:8080/TodoApp` → Servlet


## Run Default Task

- Press `Ctrl+Shift+B` to run Default Task

## Screenshots

![List Todos](src/main/webapp/images/todo-index.png "List Todos")