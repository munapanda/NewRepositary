<html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>   
<head>  
    <title>Reservation Form</title>  
</head>  
<h3>User_Registration_Form</h3>  
<body bgcolor="red">  
    <form:form action="save" modelAttribute="entit" method="POST">  
         User_Name:<form:input type="text" path="username"/><br>
         Email    :<form:input type="text" path="email"/> <br>
         Telicom Service Name: <form:option type="text" path="telicomeservices" value="RelianceJIO" label="Relaince_JIO"/> 
                               <form:option type="text" path="telicomeservices" value="RelianceJIO" label="Airtel"/>
                               <form:option type="text" path="telicomeservices" value="RelianceJIO" label="Vodafone"/>
                               <form:option type="text" path="telicomeservices" value="RelianceJIO" label="Idea"/>
  
        <br><br> 
        <input type="submit" value="Submit" />      
    </form:form>  
</body>  
</html>