<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"/>
	<link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>"/>
	<title>Qual Restaurante Você Prefere?</title>
	<script>
		function validarDados(){
			if($(".id").val() === ""){
				alert("Por favor, selecione um restaurante");
				return false;
			}
			return true;
		}
	</script>
</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12">
				<div class="col-sm-12 texto">
					<h1><label class="control-label">Qual restaurante você prefere?</label></h1>
				</div>
				
				<div class="form-group" style="padding-left: 250px;">
					<div class="col-sm-12">
						<div class="col-sm-6">
							<div class="input-group">
								<div class="radio">
									<input name="restaurante" type="radio" value="${rest1.id}">
										<img class="imagem" src="<c:url value="/resources/imagem/${rest1.imagem}.jpg"/>"/>
									</input>
									<h3><label class="control-label">${rest1.nome}</label></h3>
								</div>
							</div>
						</div>
						<div class="col-sm-6">
							<div class="input-group">
								<div class="radio">
									<input name="restaurante" type="radio" value="${rest2.id}">
										<img class="imagem" src="<c:url value="/resources/imagem/${rest2.imagem}.jpg"/>"/>
									</input>
									<h3><label class="control-label">${rest2.nome}</label></h3>
								</div>
							</div>
						</div>
					</div>
					<form class="form-horizontal" method="post" action="cadastrarRanking" onsubmit="return validarDados();">
						<div class="col-sm-12 hidden">
							<input class="id" name="id" type="text"/>
						</div>
						<div class="col-sm-12 botao">
							<div class="col-sm-3"></div>
							<div class="col-sm-6 text-right">
								<input type="submit" class="btn btn-default" value="Votar"/>
							</div>
							<div class="col-sm-3"></div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>

	<script src="<c:url value="/resources/jquery/jquery-2.1.4.min.js"/>"></script>
	<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
	<script src="<c:url value="/resources/js/main.js"/>"></script>
</body>
</html>