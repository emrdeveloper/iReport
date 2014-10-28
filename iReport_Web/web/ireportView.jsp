<%-- 
    Document   : ireportView
    Created on : 27/10/2014, 10:43:16 AM
    Author     : Elvis
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3 align="center">Estas viendo un reporte!</h3>
        <div align="center">
        <object type="application/pdf" 
                data="http://localhost:8084/iReport_Web/IreportServlet"
                width="920"
                height="600" ></object>
        </div>
    </body>
</html>
