<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>JSP Page</title>
</head>
<body>
	<div class="container" style="margin-top: 10px;">
		<div class="row"
			style="border: 1px darkgrey solid; border-radius: 10px; width: 50%; margin: 0 auto; padding: 20px;">
			<div class="col-sm-12">

				<h2 class="myclass">Update Avatar</h2>
				<form action="UploadServlet" method="post"
					enctype="multipart/form-data">


					<div class="form-group">
						<label>Photo</label> <br /> <input type="file"
							class="form-control" name="photo" placeholder="Enter photo">
					</div>
					<button type="submit" class="btn btn-primary">Save</button>
					<a class="btn btn-primary" href="/Project/ViewProfile.jsp">Cancel</a>
				</form>
			</div>
		</div>
	</div>
</body>
</html>