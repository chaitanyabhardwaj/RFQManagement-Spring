<%@ include file="header.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

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
	<link rel="stylesheet" href="/Styles/supplierPage.css" type="text/css" />
<link rel="stylesheet" href="/Styles/app.css" type="text/css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>get RFQ Of Plant</title>

</head>
<body class="bg-2">
<div class="error-dialog">
	<p>${error}</p>
</div>


	<section>


		<div >
			<div class="container w-75 mx-auto">
				<div class="row mt-5">
					<div class="col-12">
						<div class="row">
							<div class="col-6">
								<h5 class="breadcrumb-item active">RFQ OF PLANT</h5>
							</div>

						</div>
					</div>

				</div>
				<div class="h-line ml-1 mb-4 mt-2"></div>

				<c:forEach var="i" items="${rfq}">

					<div class="d-flex justify-content-between  hdr-sup mb-4 mt-5">
						<div>
							<h5 class="breadcrumb-item active">RFQ ${i.getRfqId()}</h5>
						</div>

					</div>



					<div class="row mt-4">
						<div class="col">
							<label class="bg-white text-dark shadow-none">RFQ Id</label> <input type="number" name="sid"
								class="form-control" disabled="disabled" value="${i.getRfqId()}">
						</div>
						<div class="col">
							<label class="bg-white text-dark shadow-none">Part Id</label> <input type="text" name="partid"
								class="form-control" disabled="disabled"
								value="${i.getPartId()}">
						</div>
						<div class="col">
							<label class="bg-white text-dark shadow-none">Part Name</label> <input type="text" name="partname"
								class="form-control" disabled="disabled" value="${i.getPartName()}">
						</div>
						<div class="col">
							<label class="bg-white text-dark shadow-none">Quantity</label> <input type="number" name="qty"
								class="form-control" disabled="disabled" value="${i.getQuantity()}">
						</div>
						<div class="col">
							<label class="bg-white text-dark shadow-none">Specification</label> <input type="text" name="spec"
								class="form-control" disabled="disabled" value="${i.getSpecification()}">
						</div>
						<div class="col">
							<label class="bg-white text-dark shadow-none">Time to Supply</label> <input type="text" name="tts"
								class="form-control" disabled="disabled" value="${i.getExpectedSupplyDate().toString()}">
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