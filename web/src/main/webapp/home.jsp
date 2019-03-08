<%page import ="com.capgemini.heskuelita.core.beans.User" %>
<h3>HOME</h3><br/>

<%
User us = (User)session.getAttribute ("user");
Bienvenido : <%
%>