<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
       <h2> Flight Search Results</h2>
       <h2> List Of Flights</h2>
<table border="1">
<tr>
        <tr>
         <th>Airlines </th>
         <th>Departure City</th>
         <th>Arrival City</th>
         <th>departure Time </th>
         <th>Select Flight </th>


</tr>

          <c:forEach items="${findFlight}" var="findFlight">

   <tr>
           <td>${findFlight.operatingAirlines}</td>
           <td>${findFlight.departureCity}</td>
           <td>${findFlight.arrivalCity}</td>
           <td>${findFlight.estimatedDepartureTime}</td>
           <td> <a href="showCompleteReservation?flightId=${findFlight.id}">select</a></td>
           

   </tr>


</c:forEach>

</body>
</html>