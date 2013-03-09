<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<html>
  <head>
    <meta charset="utf-8">
    <title>Demo</title>
  </head>
  <body>
  <h1>Login</h1>

	<div id="content">

		<img src="<%=request.getContextPath()%>/images/icon.jpg" alt="open source" width='41' height='43'>


		<p> 2 users: ahmoi and ahboy(admin).</p>
		<form id="loginForm" name="loginForm"
			action="<c:url value="/login"/>" method="post">
			<p>
				<label>Username: <input type='text' name='username'
					value="ahmoi" /></label>
			</p>
			<p>
				<label>Password: <input type='password' name='password'
					value="password" /></label>
			</p>

			<p>
				<input name="login" value="Login" type="submit"/>
			</p>
		</form>
	</div>

    <script src="<%=request.getContextPath()%>/js/jquery-1.9.1.min.js"></script>
  </body>
</html>