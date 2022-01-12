<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%-- Import all the necessary classes --%>    
<%@ page import="java.util.*" %>
<%@ page import="java.io.PrintWriter" %>

<%@ page import="demo.hogwarts.House" %>
<%@ page import="demo.hogwarts.HouseFacade" %>


<%
	
	// Get parameter value from link
	// Use request.getParameter( ).  
	//It is similar practice from the Servlet.
	int houseId = Integer.parseInt(request.getParameter("id"));

	// Wrap into House
	HouseFacade houseFacade = new HouseFacade();
	List<House> list = new ArrayList<House>();
	
	PrintWriter writer = response.getWriter();
	
	String houseName = "";
	String houseFounder = "";
	String houseColor = "";
	String houseMascot = "";
	
	for (House house: houseFacade.getHouses()) 
	{
		// Get house. Use house Facade
		if(houseId == house.getHouseId())
		{
			houseName = house.getName();
			houseFounder = house.getFounder();
			houseColor = house.getColor();
			houseMascot = house.getMascot();
		}	
	}
%>   
    
    
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<!-- The title bar should display the house name -->
	<title>Details Information of </title>
	</head>
	
	<body>
	
		<br><br><br>
		<!-- The heading should display the house name -->
		<h4>Details Information of </h4>
		
		<b>Name : </b><%=houseName%><br><br>
		<b>Founder : </b><%=houseFounder%><br><br>
		<b>Colors : </b><%=houseColor%><br><br>
		<b>Mascots : </b><%=houseMascot%><br><br>
	
	</body>
	
	<!--Include a footer menu-->
	<br><br>
	Click <a href="houses.jsp">here</a> to return to list of Hogwart's House.
	<jsp:include page="../footerMenu.html" />
</html>