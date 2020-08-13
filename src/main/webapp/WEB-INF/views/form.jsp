<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<c:url value="/resources/css" var="cssPath" />
<link rel="stylesheet" href="${cssPath}/bootstrap.min.css" />
<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css" />
<link href="${cssPath}/cover.css" rel="stylesheet">

<title>Formulário</title>
</head>
<body>

	<div class="site-wrapper">

		<div class="site-wrapper-inner">

			<div class="container">

				<div class="inner cover">
					<h1 class="cover-heading">Controle Financeiro</h1>
					<p class="lead">Formulário</p>
				</div>

				<form action="salvar" method="POST">

					<div class="form-group">
						<label class="form-title">Título</label> <input type="text" name="titulo" class="form-control"
						placeholder="Ex.: Conta de energia">
					</div>
					<div class="form-group">
						<label class="form-title">Valor</label> <input type="text" name="valor" class="form-control"
						placeholder="Ex.: 120.00 (ganho) ou -320.89 (despesa)">
					</div>
					<div class="form-group">
						<label class="form-title">Data</label> <input type="text" name="data" class="form-control"
						placeholder="Ex.: 25/06/2020">
					</div>
					<button type="submit" class="btn btn-lg btn-secondary">Enviar</button>
				</form>

				<div class="mastfoot">
					<div class="inner">
						<p>Web application by: Luiz Gustavo Pereira</p>
					</div>
				</div>

			</div>

		</div>

	</div>

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
		integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')
	</script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
		integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
		crossorigin="anonymous"></script>
	<script src="../../dist/js/bootstrap.min.js"></script>
	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>



</body>
</html>