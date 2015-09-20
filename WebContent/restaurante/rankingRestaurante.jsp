<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"/>
	<link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>"/>
	<title>Ranking Restaurante</title>
</head>
<body>
	
	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12">
				
				<div class="col-sm-12">
					<h2><label class="control-label">Ranking dos Restaurantes</label></h2>
				</div>
				
				<div class="col-sm-12 botao text-right">
						<a href="finalizarVotacao">Encerrar</a>
					</div>
				
				<div class="col-sm-12" style="padding-top : 100px; text-align : center;">
				
					<table class="table table-striped">
						<thead>
							<th style="text-align : center;">Restaurante</th>
							<th style="text-align : center;">Quantidade de Votos</th>
						</thead>
						<tbody>
							<c:forEach items="${restaurantes}" var="restaurante">
								<tr>
									<td>${restaurante.nome}</td>
									<td>${restaurante.qdtVotos}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
				</div>
				
			</div>
		</div>
	</div>
	
	<script src="<c:url value="/resources/jquery/jquery-2.1.4.min.js"/>"></script>
	<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>