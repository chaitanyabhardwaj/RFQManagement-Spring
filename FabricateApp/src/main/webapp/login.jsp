<html>
<head>
<link rel="stylesheet" href="/Styles/login.css" type="text/css">
<link rel="stylesheet" href="/Styles/footer.css" type="text/css">
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

</head>
<body>
<div class="error-dialog">
	<p>${error}</p>
</div>
	<section class="mt-5">
		<div class="container">
			<div class="row shadow-lg">
				<div class="col-5 m-primary-bg">
					<div class="card-body">
						<div class="text-center">
							<p class="login-p" style="line-height: normal;"><b>Manufacturing RFQ Management<br>A product of</b></p>
						</div>
						<div class="text-center">
							<img src="https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/2006f3ad-8e67-46dc-835d-63ec2e8db89c/d8hdl22-5dcd75cc-475c-43af-9e87-23fa2b59b83c.png/v1/fill/w_894,h_894,strp/mangekyo_sharingan_eterno_kakashi_by_vinvlogs_d8hdl22-fullview.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOjdlMGQxODg5ODIyNjQzNzNhNWYwZDQxNWVhMGQyNmUwIiwiaXNzIjoidXJuOmFwcDo3ZTBkMTg4OTgyMjY0MzczYTVmMGQ0MTVlYTBkMjZlMCIsIm9iaiI6W1t7ImhlaWdodCI6Ijw9ODk0IiwicGF0aCI6IlwvZlwvMjAwNmYzYWQtOGU2Ny00NmRjLTgzNWQtNjNlYzJlOGRiODljXC9kOGhkbDIyLTVkY2Q3NWNjLTQ3NWMtNDNhZi05ZTg3LTIzZmEyYjU5YjgzYy5wbmciLCJ3aWR0aCI6Ijw9ODk0In1dXSwiYXVkIjpbInVybjpzZXJ2aWNlOmltYWdlLm9wZXJhdGlvbnMiXX0.uL7CzG1AMr-1vr15UaWnN-OMWXE3sSE2Q7NAa5RlT8w"
								style="height: 263px; padding-left: 20px;">
						</div>
						<div class="text-center">
							<h4 class="login-h4 brand-font">AMATERASU</h4>
						</div>
					</div>
				</div>
				<div class="col-7 bg_login-2">
					<div class="reg text-center">
						<h4 class="reg-h4 col-8 offset-1">LOGIN</h4>
						
						<div class="row  mt-4 mb-3">
							<form action="auth" class="col-8 offset-1" method="get">
								<div class="form-group  mt-3 mb-3">
							
									<input type="text" class="form-control uicon"
										placeholder="&#61447; User Name" name="userid">
								</div>
								<div class="form-group  mt- mb-4">
									<input type="password" class="form-control uicon"
										placeholder="&#61475; Password" name="password">
								</div>

								<input type="submit" value="Admin Login" class="btn btn-outline-danger">
								<br><br><div class="in">
								${invalid}</div>
								
							</form>
							
							
						</div>
					</div>
				</div>
			</div>
		</div>
		
	</section>
<footer style="position: absolute; bottom: 0; left: 0; right: 0;" class="text-center bg-light text-dark border">
	<%@ include file="footer.jsp"%>
</footer>

</body>
</html>