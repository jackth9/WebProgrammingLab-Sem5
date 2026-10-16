<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Error</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        body {
            background: linear-gradient(135deg, #1e3c72 0%, #2a5298 100%);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
        }
        .card {
            background: #ffffff;
            border-radius: 12px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.2);
            width: 100%;
            max-width: 450px;
            padding: 35px 30px;
            text-align: center;
        }
        .icon {
            width: 60px;
            height: 60px;
            background: #ffebee;
            color: #c62828;
            border-radius: 50%;
            display: inline-flex;
            align-items: center;
            justify-content: center;
            font-size: 30px;
            margin-bottom: 20px;
            font-weight: bold;
        }
        h2 {
            color: #c62828;
            margin-bottom: 12px;
            font-size: 24px;
        }
        p {
            color: #555;
            font-size: 15px;
            line-height: 1.6;
            margin-bottom: 25px;
        }
        .error-details {
            background: #fff3f3;
            border: 1px solid #ffcdd2;
            color: #b71c1c;
            padding: 10px;
            border-radius: 6px;
            margin-bottom: 20px;
            font-size: 14px;
        }
        .btn {
            display: inline-block;
            background: #1e3c72;
            color: #ffffff;
            text-decoration: none;
            padding: 12px 24px;
            border-radius: 6px;
            font-weight: 600;
            font-size: 14px;
            transition: background 0.2s;
        }
        .btn:hover {
            background: #162c54;
        }
    </style>
</head>
<body>
    <div class="card">
        <div class="icon">&#10005;</div>
        <h2>Registration Failed</h2>
        <%
            String msg = request.getParameter("msg");
            if (msg != null && !msg.trim().isEmpty()) {
        %>
            <div class="error-details">
                <strong>Reason:</strong> <%= msg %>
            </div>
        <%
            } else {
        %>
            <p>An unexpected error occurred or the input data failed validation. Please ensure all fields are properly filled and numeric values are valid.</p>
        <%
            }
        %>
        <a href="sportsRegistration.jsp" class="btn">Try Again</a>
    </div>
</body>
</html>
