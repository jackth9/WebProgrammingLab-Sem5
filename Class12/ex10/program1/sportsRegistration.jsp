<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sports Event Registration</title>
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
        .container {
            background: #ffffff;
            border-radius: 12px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.2);
            width: 100%;
            max-width: 500px;
            padding: 35px 30px;
        }
        .header {
            text-align: center;
            margin-bottom: 25px;
        }
        .header h2 {
            color: #1e3c72;
            font-size: 26px;
            margin-bottom: 8px;
        }
        .header p {
            color: #666;
            font-size: 14px;
        }
        .form-group {
            margin-bottom: 18px;
        }
        .form-group label {
            display: block;
            margin-bottom: 6px;
            font-weight: 600;
            color: #333;
            font-size: 14px;
        }
        .form-group input,
        .form-group select {
            width: 100%;
            padding: 12px 14px;
            border: 1px solid #ccc;
            border-radius: 6px;
            font-size: 14px;
            transition: border-color 0.2s, box-shadow 0.2s;
            outline: none;
        }
        .form-group input:focus,
        .form-group select:focus {
            border-color: #2a5298;
            box-shadow: 0 0 0 3px rgba(42, 82, 152, 0.15);
        }
        .submit-btn {
            width: 100%;
            padding: 12px;
            background: #1e3c72;
            color: #ffffff;
            border: none;
            border-radius: 6px;
            font-size: 16px;
            font-weight: 600;
            cursor: pointer;
            transition: background 0.2s;
            margin-top: 10px;
        }
        .submit-btn:hover {
            background: #162c54;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="header">
            <h2>Sports Event Registration</h2>
            <p>Annual College Sports Meet</p>
        </div>
        <form action="SportsRegistrationServlet" method="POST">
            <div class="form-group">
                <label for="studentName">Student Name</label>
                <input type="text" id="studentName" name="studentName" placeholder="Enter full name" required>
            </div>

            <div class="form-group">
                <label for="rollNumber">Roll Number</label>
                <input type="text" id="rollNumber" name="rollNumber" placeholder="Enter numeric roll number" required>
            </div>

            <div class="form-group">
                <label for="department">Department</label>
                <input type="text" id="department" name="department" placeholder="e.g. Computer Science, Mechanical" required>
            </div>

            <div class="form-group">
                <label for="sportsEvent">Sports Event</label>
                <select id="sportsEvent" name="sportsEvent" required>
                    <option value="" disabled selected>-- Select an Event --</option>
                    <option value="Cricket">Cricket</option>
                    <option value="Football">Football</option>
                    <option value="Basketball">Basketball</option>
                    <option value="Athletics">Athletics</option>
                </select>
            </div>

            <div class="form-group">
                <label for="contactNumber">Contact Number</label>
                <input type="text" id="contactNumber" name="contactNumber" placeholder="Enter 10-digit mobile number" required>
            </div>

            <button type="submit" class="submit-btn">Register for Event</button>
        </form>
    </div>
</body>
</html>
