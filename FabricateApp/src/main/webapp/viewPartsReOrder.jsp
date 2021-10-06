<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet" href="/Styles/supplierPage.css" type="text/css" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<link rel="stylesheet" href="/Styles/app.css" type="text/css" />


</head>

<body  class="bg-2">
<div class="error-dialog">
	<p>${error}</p>
</div>

	<section>


		<div>
			<div class="container">
				<div class="row mt-3">
					<div class="col-12">
						<div class="row">
							<div class="col-6">
								<h5 class="breadcrumb-item active mt-5">PART REORDER DETAILS</h5>
							</div>

						</div>
					</div>

				</div>
				<div class="h-line ml-1 mb-4 mt-2"></div>

				<c:forEach var="i" items="${partsReorder}">

					<div class="d-flex justify-content-between  hdr-sup mb-4 mt-5">
						<div>
							<h5 class="breadcrumb-item active">Part Id
								${i.getPartId()}</h5>
						</div>

					</div>



					<div class="row mt-4">
						<div class="col">
							<label class="bg-white text-dark shadow-none">Part id</label> <input type="text" name="partid"
								class="form-control" disabled="disabled"
								value="${i.getPartId()}">
						</div>
						<div class="col">
							<label class="bg-white text-dark shadow-none">Reorder Status</label> <input type="text" name="sttus"
								class="form-control" disabled="disabled"
								value="${i.getReorderStatus()}">
						</div>
						<div class="col">
							<label class="bg-white text-dark shadow-none">Reorder Date
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label> <input type="text"
								name="partid" class="form-control" disabled="disabled"
								value="${i.getReorderDate()}">
						</div>

					</div>

				</c:forEach>
			</div>

		</div>

	</section>
<footer style="position: absolute; bottom: 0; left: 0; right: 0;" class="text-center bg-light text-dark border">
	<%@ include file="footer.jsp"%>
</footer>
</body>
</html>