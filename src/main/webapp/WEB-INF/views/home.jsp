<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="t"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<c:url value="/resources/css" var="cssPath" />
<link rel="stylesheet" href="${cssPath}/bootstrap.min.css" />
<link rel="stylesheet" href="${cssPath}/bootstrap-theme.min.css" />
<link href="${cssPath}/cover.css" rel="stylesheet">

<c:url value="/resources/imagens" var="imagesPath" />

<title>Controle Financeiro</title>
</head>
<body>

<div class="site-wrapper">

	<div class="site-wrapper-inner">

    	<div class="container">

          <div class="inner cover">
            <h1 class="cover-heading">Controle Financeiro </h1>
            <p class="lead">Controle seus ganhos e despesas de uma forma mais rápida!</p>
            <p>Clique em "Inserir" para inserir novos dados</p>
            <p class="lead">
            	<a href="form" class="btn btn-lg btn-secondary">Inserir</a> 
            </p>
          </div>
          <table class="table table-bordered table-dark table-hover px-2">
			<tr class="table-title">
				<td>Data</td>
				<td>Título</td>
				<td>Valor</td>
			</tr>
			
				<c:forEach items="${financas}" var="financa">
					<tr>
						<td>
							<fmt:formatDate pattern="dd/MM/yyyy" value = "${financa.data.time}"/>    
						</td>
						<td>${financa.titulo}</td>
						<td>R$ ${financa.valor}</td>
						<td><a href="editar/${financa.id}" class="edit">Editar</a></td>
						<td><a href="deletar/${financa.id}"><img src="<c:url value='${contextPath}/resources/imagens/excluir.png'/>"/></a></td>
					</tr>
				</c:forEach>
			</table>
			
   			<div class="inner cover">
   				<h3>Total: R$ <span id="sum"></span></h3>
   			</div>
			
			
			<div class="centerchart">
      			<canvas id="pieChart" style="max-width: 700px;"></canvas>
  			</div>
  			
  			${pagar}

		
          	<div >
           	 <div class="inner">
              	<p>Web application by: Luiz Gustavo Pereira</p>
           	 </div>
          	</div>

        </div>

      </div>

    </div>

 
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
	<!-- Bootstrap tooltips -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/popper.min.js"></script>
	<!-- Bootstrap core JavaScript -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	<!-- MDB core JavaScript -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/mdb.min.js"></script>
    
	<script type="text/javascript">
	      //gráfico pizza
		var list = [];
	      //for do jsp
	      <t:forEach items="${financas}" var="financa">
		      var item = [];
		      item.push("<t:out value="${financa.valor}" />");
		      list.push(item);
	      </t:forEach>
	      
	      var sum = list.reduce(function(a, b){
	          return a*1 + b*1;
	      }, 0);
	      
	      document.getElementById("sum").innerHTML = sum;
	      	      
	      var i;
	      var receber = 0;
	      var pagar = 0;
	      for(i = 0; i < list.length; i++){
		      if(list[i] < 0){
			      pagar = pagar + (list[i]*-1);
			  } else {
				  receber = receber + (list[i]*1);
			  }
		  }
	      
	      var ctxP = document.getElementById("pieChart").getContext('2d');
	      var myPieChart = new Chart(ctxP, {
	        type: 'pie',
	        data: {
	          labels: 
	        	  ["Despesa", "Receita"],
	          datasets: [{
	            data: [pagar, receber],
	            backgroundColor: ["#F7464A", "#46BFBD"],
	            hoverBackgroundColor: ["#FF5A5E", "#5AD3D1"]
	          }]
	        },
	        options: {
	          responsive: true,
	          legend: {
	          	labels: {
	            	fontColor: 'white',
	            	fontSize: 20
	                 }
	              }
	           }
	      });
    	</script>
	
</body>
</html>