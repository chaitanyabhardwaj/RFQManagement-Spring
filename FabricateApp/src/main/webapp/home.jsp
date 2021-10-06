<%@ include file="header.jsp"%>
<%@ include file="index.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<link rel="stylesheet" href="/Styles/home.css" type="text/css" />
<body class="bg_home-2">

	<div class="error-dialog">
        <p>${error}</p>
    </div>

	<section style="padding-top: 100px;">
    <!--
	<div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="carousel">
      <div class="carousel-indicators">
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
      </div>
      <div class="carousel-inner">
        <div class="carousel-item active">
          <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRzz6hetXsrt56DUShxVLoPgBpIJ3-9S6z9DA&usqp=CAU" class="d-block w-100" alt="...">
          <div class="carousel-caption d-none d-md-block">
            <a href="/plantpage" class="btn mb-5">PLANT</a>
          </div>
        </div>
        <div class="carousel-item">
          <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRtYp2_QAOoud6IfR2-gE9MxchY8GAeMr6A1A&usqp=CAU" class="d-block w-100" alt="...">
          <div class="carousel-caption d-none d-md-block">
           <a href="/supplier" class="btn mb-5">SUPPLIER</a>
          </div>
        </div>
        <div class="carousel-item">
          <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS9eIqqy762oNlqQTjDxxKRmQj5-3OdfZ3DftmwhaoSkMWW6MkoL6g7kwsr&s=10" class="d-block w-100" alt="...">
          <div class="carousel-caption d-none d-md-block">
            <a href="/RFQ" class="btn mb-5">RFQ</a>
          </div>
        </div>
      </div>
      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
    -->
        <div class="container">
            <div class="row text-center">
                <div class="col-12 col-md-4 gx-5">
                    <div class="border rounded p-3 mb-3 shadow-sm">
                        <img src="/resources/supplier_cover.png" class="d-inline-block w-100 h-auto">
                    </div>
                    <a class="nav-link text-black" href="/supplier">
                        <button class="btn btn-outline-info">Supplier</button>
                    </a>
                </div>
                <div class="col-12 col-md-4 gx-5">
                    <div class="border rounded p-3 mb-3 shadow-sm">
                        <img src="/resources/plant_cover.png" class="d-inline-block w-100 h-auto">
                    </div>
                    <a class="nav-link text-black" href="/plantpage">
                        <button class="btn btn-outline-primary">Plant</button>
                    </a>
                </div>
                <div class="col-12 col-md-4 gx-5">
                    <div class="border rounded p-3 mb-3 shadow-sm">
                        <img src="/resources/rfq_cover.png" class="d-inline-block w-100 h-auto">
                    </div>
                    <a class="nav-link text-black" href="/RFQ">
                        <button class="btn btn-outline-info">RFQ</button>
                    </a>
                </div>
            </div>
        </div>
	</section>
    <footer style="position: absolute; bottom: 0; left: 0; right: 0;" class="text-center bg-light text-dark border">
        <%@ include file="footer.jsp"%>
    </footer>
	<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
