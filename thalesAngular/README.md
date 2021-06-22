# Prueba de conocimiento Thales Latam

Este proyecto esta dividido en 2 partes, un front (Hecho en **angular**) y un backend (Realizado en **Spring-boot**).

## Explicación de buenas prácticas

Realice el código con el fin de que sea fácilmente leído y con nombres descriptivos que concuerdan con los datos que tienen o las funcionalidades que realizan, con la menor cantidad de código repetido, teníendo en cuenta los patrones de diseño.

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
