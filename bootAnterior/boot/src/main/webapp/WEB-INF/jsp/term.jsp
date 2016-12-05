<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache"> 
    <meta http-equiv="Cache-Control" content="no-cache"> 
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">
    
    <title>Term Manager | Home</title>
    
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
     <link href="static/css/style.css" rel="stylesheet">
    
</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
				
					<li><a href="new-term">New Term</a></li>
					<li><a href="all-terms">All Terms</a></li>
					
					
				</ul>
			</div>
		</div>
	</div>

<c:choose>
		<c:when test="${mode=='MODE_HOME_TERM'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to Term Manager</h1>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode=='MODE_TERMS'}">
			<div class="container text-center" id="tasksDiv">
				<h3>My Terms</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>ID</th>
								<th>Relationship Type ID</th>
								<th>Term 1 ID</th>
								<th>Term 2 ID</th>
								<th>Complete</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="term" items="${terms}">
								<tr>
									<td>${term.id}</td>
									<td>${term.relationshipTypeId}</td>
									<td>${term.term1Id}</td>
									<td>${term.term2Id}</td>
									<td>${term.complete}</td>
									<td><a href="update-term?id=${term.id}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-term?id=${term.id}"> <span
											class="glyphicon glyphicon-trash"></span>
									</a></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:when>
	
		<c:when test="${mode=='MODE_NEW' || mode=='MODE_UPDATE'}">
			<div class="container text-center">
				<h3>Manage Term</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-term">
					<input type="hidden" name="id" value="${term.id}" />
					
					<div class="form-group">
						<label class="control-label col-sm-3">Relationship Type ID:</label>
						<div class="col-sm-7">
							<input type="number" class="form-control" name="relationshipTypeId"
								value="${term.relationshipTypeID}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Term 1 ID:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="term1Id"
								value="${term.term1Id}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Term 2 ID:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="term2Id"
								value="${term.term2Id}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Complete:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="complete"
								value="${term.complete}" />
						</div>
					</div>
					
					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>

				</form>
			</div>
		</c:when>
		
</c:choose>

<script src="static/js/jquery-1.11.1.min.js"></script>    
    <script src="static/js/bootstrap.min.js"></script>
</body>
</html>