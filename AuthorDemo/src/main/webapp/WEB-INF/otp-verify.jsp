<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Email OTP Verification</title>

    <!-- Bootstrap 5 CDN -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        body {
            background-color: #f3f3f3;
            font-family: 'Segoe UI', sans-serif;
        }
        .otp-container {
            max-width: 400px;
            margin: 80px auto;
            background-color: #fff;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }
        .otp-container h3 {
            text-align: center;
            margin-bottom: 25px;
            color: #007bff;
        }
    </style>
</head>
<body>

<div class="otp-container">
    <h3>Email OTP Verification</h3>

    <form method="post" action="/verifyotp">
    <div>
               <p>The OTP has been sent  to your mailId ${email} and will be valid for 5 minutes only.</p>
       </div>
        <div class="mb-3">
            <label for="otp" class="form-label">Enter OTP sent to your email</label>
            <input type="text" class="form-control" id="otp" name="otp" placeholder="e.g. 874321" required>
        </div>

        <input type="hidden" name="email" value="${email}"/>
        <span>${msg} </span>
        <div class="d-grid">
            <button type="submit" class="btn btn-primary">Verify OTP</button>
        </div>

        <div class="mt-3 text-center">
            <a href="$/" class="btn btn-link">Resend OTP</a>
        </div>
    </form>
</div>

</body>
</html>
