<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 23-ago.-21
  Time: 4:10 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<% String context = request.getContextPath(); %>

<html>
<head>
    <title>Inicio</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-light" style="background-color:white;">
    <a class="navbar-brand" href="#">
        <b><font face="Arial Rounded MT" size="3">Comites Vecinales</font></b>
        <br>
        <b><font face="Arial Rounded MT" size="3">del estado de Morelos</font></b>
    </a>
    <a class="navbar-brand" href="#">
        <img src="${context}/assets/dist/img/icon_gobierno.png" width="60" height="60" class="d-inline-block align-top" alt="">
    </a>
    <a class="navbar-brand" href="${context}/views/user/inicio.jsp">
        <img src="${context}/assets/dist/img/icon_inicio.png" width="60" height="60" class="d-inline-block align-top" alt="">
    </a>
    <a class="navbar-brand" href="#">
        <img src="${context}/assets/dist/img/icon_morelos.png" width="60" height="60" class="d-inline-block align-top" alt="">
    </a>
    <a class="navbar-brand" href="#">
        <img src="${context}/assets/dist/img/morelos-utez.png" width="170" height="75" class="d-inline-block align-top" alt="">
    </a>
</nav>
<nav class="navbar navbar-light" style="background-color: hotpink;" >
    <a class="navbar-brand" href="#">
        <font face="Arial Rounded MT" size="4" color="black">ADMINISTRADOR</font>
    </a>
    <a class="navbar-brand" href="#">
        <font face="Arial Rounded MT" size="4" color="black" style="text-align: right">Cerrar Sesión</font>
    </a>
</nav>
<br><br>
<div class="opciones">
    <center>
    <table>
        <tr>
            <td>
                <a href="${context}/views/enlace/register.jsp">
                    <img src="${context}/assets/dist/img/add-user.png" href="${context}/views/enlace/register.jsp">
                </a>
            </td>
            <td class="columna"></td>
            <td>
                <a href="${context}/views/enlace/users.jsp">
                    <img src="${context}/assets/dist/img/list-user.png" href="${context}/views/enlace/users.jsp" >
                </a>
            </td>
        </tr>
    </table>
    </center>
</div>
<br><br><br>
<div class="opciones">
    <center>
        <table>
            <tr>
                <td>
                    <a href="${context}/views/enlace/register.jsp">
                        <img src="${context}/assets/dist/img/list-incidents.png" href="${context}/views/enlace/register.jsp">
                    </a>
                </td>
            </tr>
        </table>
    </center>
</div>

<script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="${context}/assets/dist/js/main.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</body>
</html>
