# Prueba de conocimiento Thales Latam

Este proyecto esta dividido en 2 partes, un front (Hecho en **angular**) y un backend (Realizado en **Spring-boot**).

## Explicación de buenas prácticas

Utilice mis conocimientos en buenas prácticas para el desarrollo desoftware en este caso en concreto se puede identificar que se evito la creación innecesaria de  objetos, los nombres utilizados para las clases, variables y métodos son acordes con lo que representan, no se hizo repetición de código, creando propias excepciones para partes del código de “negocio”, siempre intentando tener patrones de diseño como **Solid** o **Gang of four**.
## Requerimientos

Se necesita instalar mínino la versión 10 de node js, este trae npm integrado.

[Link-node](https://nodejs.org/en/download/)

E instalar angular para la parte del front-end.

```bash
npm install -g @angular/cli
```

Para el **Backend** se necesita tener instalado java 8.

[Java-link](https://www.java.com/es/download/ie_manual.jsp)

Instalar **Http-server** para correr el front-end compilado

```bash
npm i http-server
```

## Correr el Front-end (compilado)

Para correr el front-end compilado corremos el siguiente comando

```bash
 http-server dist/thalesAngular/
```

e ir al navegador a la url [http://127.0.0.1:8081/](http://127.0.0.1:8081/)

## Correr el Front-end (consola)

Para correr el front-end consola primero navegamos a la carpeta del proyecto de **angular**

```bash
 cd thalesAngular
```

instalar las dependencias necesarias 

```bash
 npm install
```

Luego correr el siguiente comando

```bash
 ng serve
```

e ir al navegador a la url [http://localhost:4200/](http://localhost:4200/)

## Correr el proyecto backend

Para correr el **backend** primero navegamos a la carpeta del proyecto 

```bash
 cd test
```

después instalar las dependencias necesarias 

```bash
mvn clean install
```

y luego para correr el proeycto ejecutar desde la consola

```bash
 mvn spring-boot:run
```
