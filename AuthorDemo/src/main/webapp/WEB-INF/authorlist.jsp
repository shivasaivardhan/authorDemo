<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Author List</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding: 20px;
            background-color: #f8f9fa;
        }
        .author-card {
            margin-bottom: 15px;
        }
    </style>
</head>
<body>

<div class="container">
    <h2 class="mb-4">List of Authors</h2>

    <div class="row">
        <c:forEach var="author" items="${authors}">
            <div class="col-md-4">
    <div class="card author-card shadow-sm">
        <div class="card-body">
            <h5 class="card-title">${author.name}</h5>
            <p><strong>Age:</strong> ${author.age}</p>
            <p><strong>Date of Birth:</strong> 
                <fmt:formatDate value="${author.dob}" pattern="dd-MM-yyyy" />
            </p>
            <p><strong>Gender:</strong> ${author.gender}</p>
            <p><strong>Contact No:</strong> ${author.contactNo}</p>
            <p><strong>Email:</strong> ${author.email}</p>
            <p><strong>Password:</strong> ${author.password}</p>
        </div>
    </div>
</div>
        </c:forEach>
         <button type="button" class="btn btn-success w-100" onclick="window.location.href='/author'" >Back</button>
    </div>
</div>

<!-- Bootstrap JS (optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
