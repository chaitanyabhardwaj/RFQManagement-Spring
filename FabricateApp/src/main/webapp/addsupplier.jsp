<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	<link rel="stylesheet" href="/Styles/supplierPage.css" type="text/css" />
	<link rel="stylesheet" href="/Styles/app.css" type="text/css" />

	
<body class="bg-2">
<div class="error-dialog">
	<p>${error}</p>
</div>
<div id="layoutAuthentication ">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container">
				<div class="row mt-5 mb-5">
				<div class="col-12">
							<div class="row ">
								<div class="col-6">
									<h5 class="breadcrumb-item active">ADD NEW SUPPLIER</h5>
								</div>
								
							</div>
						</div>
				<div class="h-line ml-1"></div>
			</div>
			<form:form modelAttribute="supplierPartDTO" action= "addSupplier" method="post">

				<div class="mt-5">Supplier Information :</div>
				<div class="row mt-2 border rounded py-4 px-2">
					<div class="col">
						<label class="bg-white text-dark shadow-none">SupplierName</label>
						<input class="form-control"type="text" name="name" required>
					</div>
					<div class="col">
						<label class="bg-white text-dark shadow-none">E-mail</label>
						<input class="form-control" type="email" name="email" required>
					</div>
					<div class="col">
						<label class="bg-white text-dark shadow-none">Phone No.</label>
						<input class="form-control" type="tel" pattern="[6-9][0-9]{9}" name="phone" required>
					</div>
					<div class="col">
						<label class="bg-white text-dark shadow-none">Location</label>
						<input class="form-control" type="text" name="location" required>
					</div>
					<div class="col">
						<label class="bg-white text-dark shadow-none">Feedback</label>
						<input class="form-control" type="number" name="feedback" required>
					</div>
				</div>
				<div class="mt-4">Part Information :</div>
				<div class="row mt-2 border rounded py-4 px-2">
					<div class="col">
						<label class="bg-white text-dark shadow-none">Part ID</label>
						<input class="form-control" type="number" name="partId" required>
					</div>
					<div class="col">
						<label class="bg-white text-dark shadow-none">Part Name</label>
						<input class="form-control" type="text" name="partName" required>
					</div>
					<div class="col">
						<label class="bg-white text-dark shadow-none">Quantity</label>
						<input class="form-control" type="number" name="quantity" required>
					</div>
					<div class="col">
						<label class="bg-white text-dark shadow-none">Time Period</label>
						<input class="form-control" type="number" name="timePeriod" required>
					</div>
				</div>
				<div class="col d-flex justify-content-center mt-5">
					<input type="submit" class="btn btn-success text-m" value="Add supplier"/>
				</div>
			</form:form>
		
				</div>
				
				</main>
		</div>
		
	</div>
<footer style="position: absolute; bottom: 0; left: 0; right: 0;" class="text-center bg-light text-dark border">
	<%@ include file="footer.jsp"%>
</footer>

</body>
