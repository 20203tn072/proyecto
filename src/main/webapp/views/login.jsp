<%--
  Created by IntelliJ IDEA.
  User: abrah
  Date: 8/7/2021
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<% String context = request.getContextPath(); %>
<html>
    <head>
        <title>Iniciar Sesión</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
        <link rel="stylesheet" href="${context}/assets/dist/css/stylesLogin.css">
    </head>
    <body background="${context}/assets/dist/img/fondo_login_des.png">

    <form class="login-form" action="${context}login" method="POST">

        <div id="login-box" background="${context}/assets/dist/img/fondo_login.png">
            <h1>Iniciar Sesión</h1> <! - El título de Inicio de sesión ->
            <br>
            <div class="form">
                <div class="item"> <! - parte de nombre de usuario ->
                    <i><img class="img1" src="${context}/assets/dist/img/user-login.png"></i> <! - Se utilizará para dibujar el icono delante del nombre de usuario ->
                    <br><br>
                    <input type="text" placeholder="Correo electrónico" name="email"> <! - Entrada de nombre de usuario realizada por cuadro de texto ->
                </div>
                <br><br>
                <div class="item"> <! - parte de la contraseña ->
                    <i><img class="img2" src="${context}/assets/dist/img/user-pass-.png"></i> <! - Se utilizará para dibujar el icono delante de la contraseña en el futuro ->
                    <input type="password" placeholder="Contraseña" name="password"> <! - Entrada de contraseña usando el cuadro de texto de contraseña ->
                </div>
            </div>

            <button type="submit">ACCEDER</button> <! - Botón de inicio de sesión implementado con el botón ->
            <br>
            <a href="">Olvidó su contraseña?</a>
        </div>

    </form>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

    </body>
</html>
