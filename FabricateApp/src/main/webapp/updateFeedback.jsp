
<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<link rel="stylesheet" href="/Styles/supplierPage.css" type="text/css" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
	<link rel="stylesheet" href="/Styles/app.css" type="text/css" />
<style>
label {
    font-size: 15px;
    color: #191919;
}
</style>
</head>
<body class="bg-2">
<div class="error-dialog">
	<p>${error}</p>
</div>
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
			<main>
				<div class="container">
					<div class="row justify-content-center">
						<div class="col-lg-9">

							<div class="card shadow-sm border-0 rounded-lg mt-5">
								<div class="card-body">
									<form action="updateFeedback" method="post">
										<div class="form-group row mt-2">
											<label class="col-sm-6 control-label style">Supplier
												ID </label>
											<div class="col-sm-6 ">
												<input type="number" name="sid" class="form-control"
													required value="${supplier.getId()}" readonly>
											</div>
										</div>
										<div class="form-group row mt-4">
											<label class="col-sm-6 control-label style">Supplier
												FEEDBACK </label>
											<div class="col-sm-6 ">
												<input type="number" name="sfeedback" class="form-control" min="0" max="10"
													required value="${supplier.getFeedback()}">
											</div>
										</div>
										<div class="col d-flex justify-content-center mt-5">
											<input type="submit" class="btn" value="Update Feedback" />

										</div>
									</form>

								</div>


							</div>

						</div>
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