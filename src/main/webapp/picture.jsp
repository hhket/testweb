<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="UploadAction_upload" enctype="multipart/form-data"  method="post">
目录名<input type="text" name="sort">
<input type="file" name="upload" >
<input type="file" name="upload" >
内容<textarea rows="10" cols="10" name ="fileContent"></textarea>
<input type="submit" value="上传">
</form>
</body>
</html>
