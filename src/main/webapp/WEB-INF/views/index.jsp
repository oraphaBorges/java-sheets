<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>HELLO HTML HOME</h1>
	
	<h4>Upload Planilha:</h4>
  	<form method="POST" action="/upload" enctype="multipart/form-data">
    	<input type="file" name="file" required /> <br/><br/>
    	<button type="submit">Enviar</button>
  	</form>

</body>
</html>