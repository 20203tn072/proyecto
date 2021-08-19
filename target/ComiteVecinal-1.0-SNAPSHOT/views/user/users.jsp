<%--
  Created by IntelliJ IDEA.
  User: abrah
  Date: 7/27/2021
  Time: 6:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Listado de usuarios</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${context}/assets/dist/css/styles.css">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<nav class="navbar navbar-light" style="background-color: #CC64F3;">
    <a class="navbar-brand" href="#">
        <font face="Arial Rounded MT" size="3">Comites Vecinales</font>
        <br>
        <font face="Arial Rounded MT" size="3">del estado de Morelos</font>
    </a>
    <a class="navbar-brand" href="#">
        <img src="${context}/assets/dist/img/icon_gobierno.png" width="60" height="60" class="d-inline-block align-top nav" alt="">
    </a>
    <a class="navbar-brand" href="#">
        <img src="${context}/assets/dist/img/icon_inicio.png" width="60" height="60" class="d-inline-block align-top nav" alt="">
    </a>
    <a class="navbar-brand" href="#">
        <img src="${context}/assets/dist/img/icon_morelos.png" width="60" height="60" class="d-inline-block align-top" alt="">
    </a>
    <a class="navbar-brand" href="#">
        <img src="${context}/assets/dist/img/morelos-utez.png" width="170" height="75" class="d-inline-block align-top" alt="">
    </a>
</nav>
<nav class="navbar navbar-light" style="background-color: #000000;" >
    <a class="navbar-brand" href="#">
        <font face="Arial Rounded MT" size="4" color="white">ADMINISTRADOR</font>
    </a>
</nav>
<br><br>

<table class="table">
    <thead class="table-dark">
    <tr>
        <th>No.</th>
        <th>Nombre completo</th>
        <th>Correo</th>
        <th>Estado</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ listUsers }" var="user" varStatus="status">
        <tr>
            <td>${ status.count }</td>
            <td>${ user.nombre } ${ user.lastname }</td>
            <td>${ user.email }</td>
            <td>
                <c:if test="${ user.status == 1 }">
                    <span class="badge rounded-pill bg-success">Activo</span>
                </c:if>
                <c:if test="${ user.status == 0 }">
                    <span class="badge rounded-pill bg-danger">Inactivo</span>
                </c:if>
            </td>
            <td>
                <c:if test="${ user.status == 1 }">
                    <form action="${context}/ServletUser" method="POST" style="display: inline;">
                        <input type="hidden" name="action" value="getUserById">
                        <input type="hidden" name="id" value="${ user.idUser }">
                        <button type="submit" class="btn btn-outline-primary"><i class="fas fa-edit"></i> Modificar</button>
                    </form>
                    <button type="button" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#delete"><i class="fas fa-trash"></i> Eliminar</button>
                </c:if>
                <c:if test="${ user.status == 0 }">
                    <button type="button" class="btn btn-outline-info"><i class="fas fa-info-circle"></i> Detalles</button>
                </c:if>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<%-- MODAL --%>
<div class="modal fade" id="delete" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Eliminar usuario</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                ...
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><i class="fas fa-times"></i> Cerrar</button>
                <button type="button" class="btn btn-danger"><i class="fas fa-trash"></i> Eliminar</button>
            </div>
        </div>
    </div>
</div>

<script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="${context}/assets/dist/js/main.js"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</body>
</html>