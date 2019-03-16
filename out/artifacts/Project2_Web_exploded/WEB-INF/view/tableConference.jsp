<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="<c:out value="${lang}" default="en"/>">
<head>
    <meta name="author" content = "Zagrebelnyi">
    <title><c:out value="${title}" default="Conference"/></title>
    <link rel="stylesheet" type="text/css" href="${pageContext.servletContext.contextPath}/css/userConference.css">
</head>
<body class = "fond">
<form method="Get" action = "UserMenu" class= "form_menu">
    <input type="submit" name="UserMenu" value="<c:out value="${button_past_conference}" default="Past Conferences"/>" class="field_menu">
    <input type="submit" name="UserMenu" value="<c:out value="${button_past_conference}" default="Future Conferences"/>" class="field_menu">
    <input type="submit" name="UserMenu" value="<c:out value="${log_out}" default="Log out"/>" class="field_menu_logout">
</form>
<form method = "Get" action = "UserLanguage" class="form_language">
        <input type="submit" name="Language" value="English" class="field_language">
        <input type="submit" name="Language" value="Русский" class="field_language">
        <input type="submit" name="Language" value="Українська" class="field_language">
</form>
<form method="Get" action ="" class = "form_notification">
    <table class="table_notification">
        <tr>
            <th class="column"><c:out value="${notification}" default="Notification"/></th>
        </tr>
        <c:forEach items="${tickets}" var="ticket" >
            <tr>
                <form method="Get" action ="UserTable" class = "form_notification">
                    <td class="table_column"><c:out value="${ticket.nameCruise}" /></td>
                    <td class="table_column"><c:out value="${ticket.cityDeparture}" /></td>
                    <td class="table_column"><c:out value="${ticket.startCruise}" /></td>
                    <td class="table_column"><c:out value="${ticket.durationCruise}" /></td>
                    <td class="table_column"><c:out value="${ticket.nameShip}" /></td>
                    <td class="table_column"><c:out value="${ticket.ticketId}" /></td>
                    <td class="table_column"><c:out value="${ticket.numberOfTickets}" /></td>
                    <td class="table_column"><c:out value="${ticket.ticketClass}" /></td>
                    <input type="hidden" name="TicketId" value="<c:out value="${ticket.ticketId}" />">
                    <td><input type="submit" name="Operation" value="<c:out value="${refuse}" default="Refuse"/>" class="button_refuse"></td>
                </form>
            </tr>
        </c:forEach>
    </table>
</form>
<form method="Get" action ="UserTable" class = "form_conference">
            <span class = "info_conference">
                Conference
            </span>
    <table class="table_conference">
        <tr>
            <th class="table_column"><c:out value="${topic}" default="Topic"/></th>
            <th class="table_column"><c:out value="${countRegistered}" default="Count Registered"/></th>
            <th class="table_column"><c:out value="${countVisitors}" default="Count Visitors"/></th>
            <th class="table_column"><c:out value="${speaker_name}" default="Speaker Name"/></th>
            <th class="table_column"><c:out value="${speaker_surname}" default="Speaker Surname"/></th>
            <th class="table_column"><c:out value="${time_conduction}" default="Time Conduction"/></th>
            <th class="table_column"><c:out value="${venue}" default="Venue"/></th>
            <th class="table_column"><c:out value="${id}" default="Conference ID"/></th>
            <th class="table_column"><c:out value="${action}" default="Action"/></th>
        </tr>
        <c:forEach items="${tickets}" var="ticket" >
            <tr>
                <form method="Get" action ="UserTable" class = "form_conference">
                    <td class="table_column"><c:out value="${ticket.nameCruise}" /></td>
                    <td class="table_column"><c:out value="${ticket.cityDeparture}" /></td>
                    <td class="table_column"><c:out value="${ticket.startCruise}" /></td>
                    <td class="table_column"><c:out value="${ticket.durationCruise}" /></td>
                    <td class="table_column"><c:out value="${ticket.nameShip}" /></td>
                    <td class="table_column"><c:out value="${ticket.ticketId}" /></td>
                    <td class="table_column"><c:out value="${ticket.numberOfTickets}" /></td>
                    <td class="table_column"><c:out value="${ticket.ticketClass}" /></td>
                    <input type="hidden" name="TicketId" value="<c:out value="${ticket.ticketId}" />">
                    <td><input type="submit" name="Operation" value="<c:out value="${refuse}" default="Refuse"/>" class="button_refuse"></td>
                </form>
            </tr>
        </c:forEach>
    </table>

    <input type="submit" name="Operation" value="<c:out value="${previous}" default="Previous 10"/>" class="button_previous">
    <input type="text" name="OperationText" maxlength="20" placeholder="<c:out value="${conference_id}" default="Conference ID"/>" class = "field_find">
    <input type="submit" name="Operation" value="<c:out value="${find}" default="Find"/>" class = "button_find">
    <input type="submit" name="Operation" value="<c:out value="${next}" default="Next 10"/>" class="button_next">
</form>

</body>
<html>