<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:useBean id="interestBean" class="beans.SimpleInterestBean" scope="request" />
<jsp:setProperty name="interestBean" property="*" />
<%
    // Fallback assignment to guarantee values are populated across any JSP engine
    String pVal = request.getParameter("p");
    String nVal = request.getParameter("n");
    String rVal = request.getParameter("r");

    double principal = 0;
    double time = 0;
    double rate = 0;
    boolean hasError = false;

    try {
        if (pVal != null && !pVal.trim().isEmpty()) {
            principal = Double.parseDouble(pVal.trim());
            interestBean.setP(principal);
        }
        if (nVal != null && !nVal.trim().isEmpty()) {
            time = Double.parseDouble(nVal.trim());
            interestBean.setN(time);
        }
        if (rVal != null && !rVal.trim().isEmpty()) {
            rate = Double.parseDouble(rVal.trim());
            interestBean.setR(rate);
        }
    } catch (NumberFormatException e) {
        hasError = true;
    }

    double simpleInterest = interestBean.getSimpleInterest();
    double totalAmount = interestBean.getTotalAmount();
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Simple Interest Result</title>
    <style>
        * {
            box-sizing: border-box;
            margin: 0;
            padding: 0;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        body {
            background: linear-gradient(135deg, #11998e 0%, #38ef7d 100%);
            min-height: 100vh;
            display: flex;
            align-items: center;
            justify-content: center;
            padding: 20px;
        }
        .result-card {
            background: #ffffff;
            border-radius: 12px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.15);
            width: 100%;
            max-width: 480px;
            padding: 35px 30px;
        }
        .header {
            text-align: center;
            margin-bottom: 25px;
        }
        .header h2 {
            color: #11998e;
            font-size: 26px;
            margin-bottom: 6px;
        }
        .header p {
            color: #666;
            font-size: 14px;
        }
        .result-table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 25px;
        }
        .result-table td {
            padding: 12px 14px;
            border-bottom: 1px solid #eee;
            font-size: 15px;
        }
        .result-table td.label {
            color: #555;
            font-weight: 600;
            width: 55%;
        }
        .result-table td.val {
            text-align: right;
            color: #222;
        }
        .highlight-row {
            background: #e8f5e9;
            font-weight: bold;
        }
        .highlight-row td {
            color: #2e7d32 !important;
            font-size: 17px !important;
            border-bottom: none;
        }
        .btn {
            display: block;
            width: 100%;
            text-align: center;
            text-decoration: none;
            padding: 13px;
            background: #11998e;
            color: #ffffff;
            border-radius: 6px;
            font-size: 15px;
            font-weight: 600;
            transition: background 0.2s;
        }
        .btn:hover {
            background: #0e8076;
        }
        .error-box {
            background: #ffebee;
            color: #c62828;
            padding: 15px;
            border-radius: 6px;
            margin-bottom: 20px;
            text-align: center;
        }
    </style>
</head>
<body>
    <div class="result-card">
        <div class="header">
            <h2>Calculation Result</h2>
            <p>Computed by JavaBean on Server</p>
        </div>

        <% if (hasError) { %>
            <div class="error-box">
                <strong>Error:</strong> Invalid numerical values provided for Principal, Time, or Rate.
            </div>
        <% } else { %>
            <table class="result-table">
                <tr>
                    <td class="label">Principal Amount (P):</td>
                    <td class="val">&#8377; <%= String.format("%.2f", interestBean.getP()) %></td>
                </tr>
                <tr>
                    <td class="label">Time Period (N):</td>
                    <td class="val"><%= interestBean.getN() %> year(s)</td>
                </tr>
                <tr>
                    <td class="label">Rate of Interest (R):</td>
                    <td class="val"><%= interestBean.getR() %> % per year</td>
                </tr>
                <tr class="highlight-row">
                    <td class="label">Simple Interest (SI):</td>
                    <td class="val">&#8377; <%= String.format("%.2f", simpleInterest) %></td>
                </tr>
                <tr>
                    <td class="label">Total Amount (P + SI):</td>
                    <td class="val"><strong>&#8377; <%= String.format("%.2f", totalAmount) %></strong></td>
                </tr>
            </table>
        <% } %>

        <a href="index.html" class="btn">Calculate Again</a>
    </div>
</body>
</html>
