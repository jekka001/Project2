<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="<c:out value="${lang}" default="en"/>">
<head>
    <meta charset="UTF-8">
    <meta name="author" content = "Zagrebelnyi">
    <title><c:out value="${title}" default="Conference"/></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/main.css">
</head>

<body class = "fond">
<form method="Get" action = "MainMenu" class= "form_menu">
    <input type="submit" name="Menu" value="<c:out value="${sign_in}" default="Sign in"/>" class="field_menu">
    <input type="submit" name="Menu" value="<c:out value="${register}" default="Register"/>" class="field_menu">
</form>
<form method = "Get" action = "UserLanguage" class="form_language">
    <input type="submit" name="Language" value="English" class="field_language">
    <input type="submit" name="Language" value="Русский" class="field_language">
    <input type="submit" name="Language" value="Українська" class="field_language">
</form>
<form method="Post" action ="Authorization" class = "form_sign_in">
    <span class = "info_sign_in">
        <c:out value="${sign_in}" default="Sign in"/>
    </span>
    <span class="wrong_sign_in">
        <c:out value="${wrong_sign_in}"></c:out>
    </span>
    <input type="email" name="Email" placeholder="<c:out value="${email}" default="Email"/>" maxlength="20" required class = "field_sign_in">
    <input type="password" name="Password" placeholder="<c:out value="${password}" default="Password"/>" maxlength="20" required class = "field_sign_in">
    <input type="submit" name="SignIn" value="<c:out value="${sign_in}" default="Sign in"/>" class="sign_in_user">
</form>
</body>
</html>