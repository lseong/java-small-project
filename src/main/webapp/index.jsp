<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<%@ page import="com.sslim.jobweb.model.User"%>
<!doctype html>
<html>
<body>
	<c:if test="${user != null}">
		<p>Welcome, ${user.userName}</p>
	</c:if>
	<form action="<c:url value="/logout"/>"><input type="submit" value="Logout"></form>
	<script src="<%=request.getContextPath()%>/js/jquery-1.9.1.min.js"></script>
</body>
</html>
