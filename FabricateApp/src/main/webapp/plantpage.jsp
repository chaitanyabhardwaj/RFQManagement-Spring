<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<link rel="stylesheet" href="/Styles/app.css" type="text/css" />
<link rel="stylesheet" href="/Styles/plantPage.css" type="text/css"/>
   

<body class="bg_home-2">

<div class="error-dialog">
    <p>${error}</p>
</div>
	<div id="layoutAuthentication">
		<div id="layoutAuthentication_content">
	
	<section>
        <div class="container w-50 mx-auto mt-5">
            <div class="row">
                <div class="col-12">
                        <div class="d-flex justify-content-center">
                            <a href="/viewPartsReOrder" >
                                <button type="button" class="btn btn-outline-success" style="width: 250px;">View Parts Reorder</button>
                            </a>
                        </div>
                        <div class="d-flex justify-content-center mb-5 mt-1">
                            <a href="/updateMinMaxQuantities">
                                <button type="button" class="btn btn-outline-success" style="width: 250px;">Update Min-Max Quantities</button>
                            </a>
                        </div>
                </div>
                <div class="col-12">
                    <div class="shadow-sm border rounded-lg">
                          
                        <div class="card-body d-flex justify-content-center">
                           
                            <form action="viewStockInHand"> 
                            <label class="label">Enter PartId to View Stocks</label>
                            <div class="row mt-4">
                            <input type="number" name="partid" class="form-control" required >
                           	</div>
                           	<div class="row mt-4">
                            <button type="submit" class="btn btn-outline-success">View Stocks</button>
                            </div>
                            </form>
                            
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </section>
    </div>
    </div>
<footer style="position: absolute; bottom: 0; left: 0; right: 0;" class="text-center bg-light text-dark border">
    <%@ include file="footer.jsp"%>
</footer>
</body>
