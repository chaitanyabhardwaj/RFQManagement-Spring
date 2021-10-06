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
<link rel="stylesheet" href="/Styles/app.css" type="text/css" />
<link rel="stylesheet" href="/Styles/supplierPage.css" type="text/css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Manufacturing RFQ Management</title>

</head>
<body class="bg-2">
	<div class="error-dialog">
		<p>${error}</p>
	</div>

	<div id="layoutAuthentication" style="margin-top: 30px">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container ">
					<div class="row">
						<div class="col-12">
							<div class="row">
								<div class="col-10">
									<h5 class="breadcrumb-item active">LIST OF SUPPLIER</h5>
								</div>
								<div class="col-2 add-sup">
									<a href="/addsupplier" class="btn btn-success text-m">Supplier <i class="fas fa-plus-circle text-white"></i></a>
								</div>
							</div>
						</div>

					</div>
					<div class="h-line ml-1 mb-4 mt-2"></div>
<div>
				
					<table class="table table-striped">
						<thead>
    						<tr>
      							<th scope="col">Supplier Id</th>
     							<th scope="col">Supplier Name</th>
      							<th scope="col">E-mail</th>
      							<th scope="col">Phone No.</th>
      							<th scope="col">Location</th>
      							<th scope="col">Feedback</th>
      							<th scope="col">Actions</th>
    						</tr>
  						</thead>
  						<tbody>
  						<c:forEach var="i" items="${supplierList}">
							<form:form modelAttribute="supplierDTO" action="ep" method="get">
    						<tr>
      							<td style="width: 20px"><input type="number" name="sid"
										class="form-control cool" value="${i.getId()}"
										readonly></td>
      							<td> <input type="text" name="sname"
										class="form-control" value="${i.getName()}"
										readonly></td>
      							<td><input type="text" name="email"
										class="form-control" value="${i.getEmail()}"
										readonly></td>
      							<td><input type="text" name="phone"
										class="form-control" value="${i.getPhone()}"
										readonly></td>
      							<td><input type="text"
										name="slocation" class="form-control"
										value="${i.getLocation()}" readonly></td>
      							<td style="width: 20px"><input type="number"
										name="sfeedback" class="form-control"
										value="${i.getFeedback()}" readonly></td>
      							<td>
      							<div class=" add-sup ">
									<input type="submit" name="submit" value="Update Feedback"
										class="btn btn-outline-success text-m" style="width: 140px;">
									<input type="submit" name="submit" value="Edit Supplier"
										   class="btn btn-outline-success text-m mt-1" style="width: 140px;">
								</div>
      							</td>
   							</tr>
							</form:form>
   						</c:forEach>
   						</tbody>
					</table>
			</div>
				</div>
			</main>
		</div>
	</div>
	<footer style="position: absolute; bottom: 0; left: 0; right: 0;" class="text-center bg-light text-dark border">
		<%@ include file="footer.jsp"%>
	</footer>

</body>
</html>