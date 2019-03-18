<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="<c:out value="${lang}" default="en"/>">
<head>
    <meta charset="UTF-8">
    <meta name="author" content = "Zagrebelnyi">
    <title><c:out value="${title}" default="Conference"/></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/register.css">
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
<form method="Post" action ="Register" class = "form_register">
    <span class = "info_register">
        <c:out value="${registration}" default="Register"/>
    </span>
    <span class="wrong_register">
        ${Error}
    </span>
    <input type="text" name="NameRegister" placeholder="<c:out value="${name}" default="Name"/>" value = "${NameRegister}" maxlength="20" required class = "field_register">
    <input type="text" name="SurnameRegister" placeholder="<c:out value="${surname}" default="Surname"/>" value="${SurnameRegister}" maxlength="20" required class = "field_register">
    <input type="email" name="EmailRegister" placeholder="<c:out value="${email}" default="Email"/>" value = "${EmailRegister}" maxlength="20" required class = "field_register">
    <input type="password" name="PasswordRegister" placeholder="<c:out value="${password}" default="Password"/>" maxlength="20" required class = "field_register">
    <input type="password" name="RepeatPasswordRegister" placeholder="<c:out value="${repeat_password}" default="Repeat password"/>" maxlength="20" required class = "field_register">
    <input type="submit" name="Register" value="<c:out value="${register}" default="Register"/>" class="register_user">
</form>
</body>
<html>
