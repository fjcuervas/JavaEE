<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="personaController" method="get">
Introducir ID de Persona: <input type="text" name="idPersona"/>
<input type="submit" value="Consultar"/>
<br>

</form>
<p>${persona.nombreCompleto.nombre}</p>
${mensaje}
</body>
</html>