<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="org.afpa.hotel.jr.model.entities.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
page hotels



<form method="post" action="SelectHotel">
<h3>List de categorie</h3>

	<%
	List<Categorie> listCat = (List<Categorie>)request.getAttribute("listCategorie");
	if( listCat != null){
		for(Categorie cat : listCat){
	%>

		<li><input type="checkbox" id="categorie" name="categorie" value="<%=cat.getNucat()%>"/>
		<%=cat.getNomcat()%></li>
		
	<%	
	} }
	%> 

<h3>List de type hotel</h3>


	<%
	List<TypeHotel> listTypeHotel = (List<TypeHotel>)request.getAttribute("listTypeHotel");
	if( listTypeHotel != null){
		for(TypeHotel typeHotel : listTypeHotel){
	%>

		<li><input type="checkbox" id="typehotel" name="typehotel" value="<%=typeHotel.getNutype()%>"/>
		<%=typeHotel.getNomtype()%></li>
		
	<%	
	} }
	%> 
	
<input type="submit" value="Valider" />
</form> 
 
 
 <h3>List d'hotel</h3>
 
 	<%
	List<Hotel> listHotel = (List<Hotel>)request.getAttribute("listHotel");
	if( listHotel != null){
		for(Hotel hotel : listHotel){
	%>

		<li><input type="checkbox" id="hotel" name="hotel" value="<%=hotel.getNuhotel()%>"/>
		<%=hotel.getNomhotel()%></li>
		
	<%	
	} }
	%> 

</body>
</html>