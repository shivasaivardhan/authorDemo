<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Author Registration</title>
    <!-- Bootstrap CSS via CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Custom CSS -->
    <style>
        body {
            background-color: #f8f9fa;
        }
        h1 {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .form-container {
            max-width: 500px;
            margin: auto;
            padding: 20px;
            background-color: #ffffff;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0,0,0,0.1);
        }
        .error{
        color: red
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <h1 class="text-center text-primary">Author Registration</h1>
        <div class="form-container mt-4">
            <form:form modelAttribute="formobj" method="post" action="/author">
                <div class="mb-3">
                    <label for="name" class="form-label">Name:</label>
                    <input type="text" class="form-control" id="name" name="name" placeholder="Enter your name" value="${formobj.name}">
                    <form:errors path="name" cssClass="error" />
                </div>
                
                <div class="mb-3">
                    <label for="age" class="form-label">Age</label>
                    <input type="number" class="form-control" id="age" name="age" placeholder="Enter your age" value="${formobj.age}">
                    <form:errors path="age" cssClass="error" />
                </div>
                
                <div class="mb-3">
                    <label for="gender" class="form-label">Gender:</label>         
                    <br>
					<input type="radio" name="gender" value="Male" /> Male<br>
					<input type="radio" name="gender" value="Female" /> Female<br>
					<input type="radio" name="gender" value="Other" /> Other<br>
                    <form:errors path="gender" cssClass="error" />
                </div>
                
                <div class="mb-3">
                    <label for="dob" class="form-label">Date of Birth:</label>
                    <input type="date" class="form-control" id="dob" name="dob" placeholder="Enter your date of birth" value="${formobj.dob}">
                    <form:errors path="dob" cssClass="error" />
                </div>
                
                <div class="mb-3">
                    <label for="contactNo" class="form-label">Contact No:</label>
                    <input type="tel" class="form-control" id="contactNo" name="contactNo" placeholder="Enter your contactNo" value="${formobj.contactNo}">
                    <form:errors path="contactNo" cssClass="error" />
                </div>
                
                <div class="mb-3">
                    <label for="email" class="form-label">Email:</label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="Enter your email" value="${formobj.email}">
                    <form:errors path="email" cssClass="error" />
                </div>
                <div class="mb-3">
                    <label for="password" class="form-label">Password:</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="Enter your password" value="${formobj.password}">
                    <form:errors path="password" cssClass="error" />
                </div>
                
                <button type="submit" class="btn btn-success w-100">Submit</button>
            </form:form>
        </div>
    </div>
</body>
</html>
