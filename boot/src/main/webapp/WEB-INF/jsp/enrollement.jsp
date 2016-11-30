<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE-edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<title>Boot Sample | Home</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css">
<link rel="stylesheet" href="static/css/style.css">
</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/" class="navbar-brand">Bootsample</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="new-enrollement">New Enrollement</a></li>
					<li><a href="all-enrollements">All Enrollement</a></li>
				</ul>
			</div>
		</div>
	</div>
	
	<c:choose>
<c:when test="${mode=='MODE_HOME'}">
			<div class="container">
				<div class="jumbotron text-center" id="homeDiv">
					<h1>Welcome to Enrollement Manager</h1>
				</div>
			</div>
		</c:when>
		
		
		
		<c:when test="${mode=='MODE_ENROLLEMENTS'}">
			<div class="container text-center" id="enrollementsDiv">
				<h3>My Enrollements</h3>
				<hr />
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<thead>
							<tr>
								<th>Enrollement ID</th>
								<th>Course ID</th>
								<th>Student ID</th>
								<th>Grade</th>
								<th></th>
								<th></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="e" items="${enrollements}">
								<tr>
									<td>${e.enrollementId}</td>
									<td>${e.courseId}</td>
									<td>${e.studentId}</td>
									<td>${e.grade}</td>
									<td><a href="update-enrollement?id=${e.enrollementId}"><span
											class="glyphicon glyphicon-pencil"></span>
									</a></td>
									<td><a href="delete-enrollement?id=${e.enrollementId}"> <span
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
				<h3>Manage Enrollement</h3>
				<hr />
				<form class="form-horizontal" method="POST" action="save-enrollement">
					<input type="hidden" name="enrollementId" value="${enrollement.enrollementId}" />
					<div class="form-group">
						<label class="control-label col-sm-3">Course ID:</label>
						<div class="col-sm-7">
							<input type="number" class="form-control" name="courseId"
								value="${enrollement.courseId}" />
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-3">Student ID:</label>
						<div class="col-sm-7">
							<input type="number" class="form-control" name="studentId"
								value="${enrollement.studentId}" />
						</div>
					</div>
					
					
					<div class="form-group">
						<label class="control-label col-sm-3">Grade:</label>
						<div class="col-sm-7">
							<input type="number" class="form-control" name="grade"
								value="${enrollement.grade}" />
						</div>
					</div>

					<div class="form-group">
						<input type="submit" class="btn btn-primary" value="Save" />
					</div>

				</form>
			</div>
		</c:when>
		</c:choose>
		<script type="text/javascript" src="/static/js/jquery-3.1.1.min.js"></script>
	<script type="text/javascript" src="static/js/bootstrap.min.js"></script>
		

</body>
</html>