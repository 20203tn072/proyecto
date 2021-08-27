<%--
  Created by IntelliJ IDEA.
  User: abrah
  Date: 7/27/2021
  Time: 6:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Modificar Usuario</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-light" style="background-color: white;">
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
        <b><font face="Arial Rounded MT" size="4" color="black">ADMINISTRADOR</font></b>
    </a>
    <a class="navbar-brand" href="${context}/readUsers" style="text-align: right">
        <b><font face="Arial Rounded MT" size="4" color="black">REGRESAR</font></b>
    </a>
</nav>
<br><br>

<h5>Modificar Usuario | Enlace</h5>

<center>
    <form action="${context}/updateUser" method="POST">
        <input type="hidden" value="update" name="action">
        <input type="hidden" value="${ user.idUser }" name="id">
        <label>Nombre(s):</label>
        <input class="form-control" type="text" name="name" value="${ user.nombre }" style="width:30%"/>
        <br>
        <label>Apellido(s):</label>
        <input class="form-control" type="text" name="lastname" value="${ user.lastname }" style="width:30%"/>
        <br>
        <label>Correo:</label>
        <input class="form-control" type="email" name="email" value="${ user.email }" style="width:30%"/>
        <br>
        <label>Contraseña:</label>
        <input class="form-control" type="password" name="password" value="${ user.password }" style="width:30%"/>
        <br>
        <label>Rol:</label>
        <select class="form-select" name="role" style="width:30%">
            <option value="2">Enlace</option>
        </select>
        <br>
        <label>Municipio:</label>
        <select class="form-select" name="municipio" style="width:30%">
            <option value="1">Amacuzac</option>
            <option value="2">Atlatlahucan</option>
            <option value="3">Axochiapan</option>
            <option value="4">Ayala</option>
            <option value="5">Coatlán del Río</option>
            <option value="6">Cuautla</option>
            <option value="7">Cuernavaca</option>
            <option value="8">Emiliano Zapata</option>
            <option value="9">Huitzilac</option>
            <option value="10">Jantetelco</option>
            <option value="11">Jiutepec</option>
            <option value="12">Jojutla</option>
            <option value="13">Jonacatepec de Leandro Valle</option>
            <option value="14">Mazatepec</option>
            <option value="15">Miacatlán</option>
            <option value="16">Ocuituco</option>
            <option value="17">Puente de Ixtla</option>
            <option value="18">Temixco</option>
            <option value="19">Tepalcingo</option>
            <option value="20">Tepoztlán</option>
            <option value="21">Tetecala</option>
            <option value="22">Tetela del Volcán</option>
            <option value="23">Tlalnepantla</option>
            <option value="24">Tlaltizapán de Zapata</option>
            <option value="25">Tlaquiltenango</option>
            <option value="26">Tlayacapan</option>
            <option value="27">Totolapan</option>
            <option value="28">Xochitepec</option>
            <option value="29">Yautepec</option>
            <option value="30">Yecapixtla</option>
            <option value="31">Zacatepec</option>
            <option value="32">Zacualpan de Amilpas</option>
            <option value="33">Temoac</option>
            <option value="34">Coatetelco</option>
            <option value="35">Xoxocotla</option>
            <option value="36">Hueyapan</option>
        </select>
        <br>
        <a href="${context}/readUsers"><button type="button" class="btn btn-secondary"><i class="fas fa-times"></i> Cancelar</button></a>
        <button type="submit" class="btn btn-primary"><i class="fas fa-edit"></i> Modificar</button>
    </form>
</center>




<script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</body>
</html>
