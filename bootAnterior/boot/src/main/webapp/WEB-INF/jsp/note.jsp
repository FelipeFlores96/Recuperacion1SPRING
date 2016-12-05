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
    <title>Note Manager | Home</title>
    
    <link href="static/css/bootstrap.min.css" rel="stylesheet">
     <link href="static/css/style.css" rel="stylesheet">
    
    <!--[if lt IE 9]>
		<script src="static/js/html5shiv.min.js"></script>
		<script src="static/js/respond.min.js"></script>
	<![endif]-->
</head>
<body>

	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Home</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
				
					<li><a href="new-note">New Note</a></li>
					<li><a href="all-notes">All Notes</a></li>
					
					
				</ul>
			</div>
		</div>
	</div>

<c:choose>
		<c:when test="${mode=='MODE_HOME_NOTE'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to Note Manager</h1>
				</div>
			</div>
		</c:when>
		
		<c:when test="${mode=='MODE_NOTES'}">
			<div class="container text-center" id="noteDiv">
				<h3>My nOTES</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Id</th>
								<th>Student</th>
								<th>Description</th>
								<th>Date created</th>
								<th>Subject</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="note" items="${notes}">
								<tr>
									<td>${note.id}</td>
									<td>${note.name}</td>
									<td>${note.description}</td>
									<td><fmt:formatDate pattern="dd-MM-yyyy"
											value="${note.dateCreated}" /></td>
									<td>${note.subject}</td>
									<td><a href="update-note?id=${note.id}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-note?id=${note.id}"> <span
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
				<h3>Manage Note</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-note">
					<input type="hidden" name="id" value="${note.id}" />
					<div class="form-group">
						<label class="control-label col-sm-3">Name:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="name"
								value="${note.name}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Description:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="description"
								value="${note.description}" />
						</div>
					</div>

					<div class="form-group">
						<label class="control-label col-sm-3">Date created:</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" name="description"
								value="${note.subject}" />
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