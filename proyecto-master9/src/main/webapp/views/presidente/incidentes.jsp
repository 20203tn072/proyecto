<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 24-ago.-21
  Time: 4:02 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<% String context = request.getContextPath(); %>
<html>
<head>
    <title>Listado de usuarios</title>
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
        <img src="${context}/assets/dist/img/icon_gobierno.png" width="60" height="60" class="d-inline-block align-top nav" alt="">
    </a>
    <a class="navbar-brand" href="${context}/views/presidente/inicio.jsp">
        <img src="${context}/assets/dist/img/icon_inicio.png" width="60" height="60" class="d-inline-block align-top nav" alt="">
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
        <b><font face="Arial Rounded MT" size="4" color="black">PRESIDENTE</font></b>
    </a>
    <a class="navbar-brand" href="${context}/views/presidente/inicio.jsp" style="text-align: right">
        <b><font face="Arial Rounded MT" size="4" color="black">REGRESAR</font></b>
    </a>
</nav>

<br>
<h5>Listar Incidentes | Presidente</h5>
<br>
<table class="table">
    <thead class="table-dark">
    <tr>
        <th>No.</th>
        <th>Nombre </th>
        <th>Descripcion</th>
        <th>Departamento</th>
        <th>Estado</th>
        <th>Acciones</th>

    </tr>
    </thead>
    <tbody>
    <c:forEach items="${ listIncidents }" var="incident" varStatus="status">
        <tr>
            <td>${ incident.idIncidente }</td>
            <td>${ incident.nombre }</td>
            <td>${ incident.descripcion }</td>
            <td>${ incident.idDepartamento.nombre }</td>
            <td>
                <c:if test="${ incident.status == 1 }">
                    <span class="badge rounded-pill bg-danger">Pendiente</span>
                </c:if>
                <c:if test="${ incident.status == 0 }">
                    <span class="badge rounded-pill bg-success">Terminado</span>
                </c:if>
            </td>
            <td>
                <c:if test="${ incident.status == 1 }">
                    <form action="${context}/getIncidentById" method="POST" style="display: inline;">
                        <input type="hidden" name="action" value="getIncidentById">
                        <input type="hidden" name="id" value="${ incident.idIncident }">
                        <button type="submit" class="btn btn-outline-primary"><i class="fas fa-edit"></i> Modificar</button>
                    </form>
                    <button onclick="deleteUser('${ incident.idIncident }','${ incident.nombre }');" type="button" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#delete"><i class="fas fa-trash"></i> Atendido</button>
                </c:if>
                <c:if test="${ incident.status == 0 }">
                    <button type="button" class="btn btn-outline-info" onclick="details('${ incident.nombre }', '${ incident.descripcion }', '${incident.idUser.nombre}', '${incident.idDepartamento.nombre}');" data-bs-toggle="modal" data-bs-target="#details"><i class="fas fa-info-circle"></i> Detalles</button>
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
            <form action="${context}/deleteIncident" method="POST">
                <input type="hidden" name="action" value="delete">
                <input type="hidden" name="id" id="id" >
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Concluir Incidente</h5>
                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                </div>
                <div class="modal-body">
                    <label>¿Concluir Incidente?</label>
                    <h5 id="text-delete"></h5>
                    <span id="name1"></span>
                </div>
                <h5 style="color:white;">Departamento</h5> <! - Se utilizará para dibujar el icono delante de la contraseña en el futuro ->
                <select name="Departamento" id="Departamento" class="form-select">
                    <option value="1">Guardia Nacional</option>
                    <option value="2">CFE</option>
                    <option value="3">SAPAC</option>
                    <option value="4">Ayuntamiento</option>
                </select>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><i class="fas fa-times"></i> Cerrar</button>
                    <button type="submit" class="btn btn-danger"><i class="fas fa-trash"></i> Terminar</button>
                </div>
            </form>
        </div>
    </div>
</div>

<div class="modal fade" id="details" tabindex="-1" aria-labelledby="exampleModalLabel2" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel2">Detalles del usuario</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <h5>Nombre:</h5>
                <label id="lbl_name"></label>
                <br>
                <h5>Descripcion:</h5>
                <label id="lbl_lastname"></label>
                <br>
                <h5>Usuario:</h5>
                <label id="lbl_municipio"></label>
                <br>
                <h5>Departamento:</h5>
                <label id="lbl_role"></label>
                <br>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal"><i class="fas fa-times"></i> Cerrar</button>
            </div>
        </div>
    </div>
</div>


<script>
    function deleteUser(id, name1){
        document.getElementById("id").value=id;
        document.getElementById("name1").innerHTML=name1;
    }
</script>
<script>
    function details(nombre, descripcion, nombreUser, nombreDepto){
        document.getElementById("lbl_name").innerHTML=nombre;
        document.getElementById("lbl_lastname").innerHTML=descripcion;
        document.getElementById("lbl_municipio").innerHTML=nombreUser;
        document.getElementById("lbl_role").innerHTML=nombreDepto;
    }
</script>

<script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="${context}/assets/dist/js/main.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
</body>
</html>
