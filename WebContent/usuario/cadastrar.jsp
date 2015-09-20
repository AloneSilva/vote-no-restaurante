<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link rel="stylesheet" href="<c:url value="/resources/bootstrap/css/bootstrap.min.css"/>"/>
	<link rel="stylesheet" href="<c:url value="/resources/css/main.css"/>"/>
	<title>Cadastrar Usuario</title>
	<script>
		function validarDados(){
			if($(".email").val() === ""){
				alert("Por favor, digite o e-mail");
				return false;
			}else if($(".nome").val() === ""){
				alert("Por favor, digite o nome");
				return false;
			}else if($(".email").val().indexOf("@") == -1){
				alert("E-mail inválido");
				return false;
			}else{
				return true;
			}
		}
	</script>
</head>
<body>
	
	<div class="container">
		<div class="row">
			<div class="col-lg-12 col-md-12 col-sm-12">
				<div class="col-sm-12">
					<h1><label class="control-label">Cadastro de Usuario</label></h1>
				</div>
				<div class="col-sm-12" style="padding-top : 100px; padding-left: 200px;">
					<form class="form-horizontal" method="post" action="cadastrarUsuario" onsubmit="return validarDados()">
					
						<div class="form-group">
							<label class="col-sm-3 control-label">Email:</label>
							<div class="col-sm-9">
								<input name="email" class="email form-control" type="text"/>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-sm-3 control-label">Nome:</label>
							<div class="col-sm-9">
								<input name="nome" class="nome form-control" type="text"/>
							</div>
						</div>
						
						<div class="form-group botao">
							<div class="col-sm-3"></div>
							<div class="col-sm-7">
								<input class="btn btn-default" type="submit" value="Cadastrar"/>
							</div>
						</div>
					
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<script src="<c:url value="/resources/jquery/jquery-2.1.4.min.js"/>"></script>
	<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
</body>
</html>