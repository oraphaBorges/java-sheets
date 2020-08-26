<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>
<body>

<div class="container py-5">
    <div class="row">
        <div class="col-6 mx-auto">
            <h1>Upload CSV File Example</h1>
            <form method="POST" action="/upload" enctype="multipart/form-data">
                <div class="form-group mt-3">
                    <label for="file">Select a CSV file</label>
                    <input type="file" name="file" class="form-control-file" id="file" accept=".csv" required>
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
    </div>
</div>

</body>
</html>