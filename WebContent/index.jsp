<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>">
	<link rel="stylesheet" href="<c:url value="/resources/css/main.css" />" />
	<title>Inicio</title>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12">
				<div class="col-sm-12">
					<div class="jumbotron texto">
						<label class="control-label"><h1>Bem Vindo ao Vote no Restaurante</h1></label>
					</div>
				</div>
				<div class="col-sm-12 text-right">
					<label class="control-label"><h3>Clique no botão para começar</h3></label>
					<form class="form-horizontal" method="post" action="listarRestaurante">
						<input type="submit" class="btn btn-default" value="Começar"/>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script src="<c:url value="/resources/jquery/jquery-2.1.4.min.js"/>"></script>
	<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />"></script>
</body>
</html>