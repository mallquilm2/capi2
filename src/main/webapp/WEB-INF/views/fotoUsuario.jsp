<%@page import="edu.cibertec.capi2.model.UsuarioDTO"%>
<%@page import="java.util.Base64"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Foto usuario</title>
    </head>
    <body>
        <h1>Foto Usuario</h1>
        <% if(((UsuarioDTO)request.getAttribute("usuario")).getFoto() == null){ %>
            <h2>Usuario aun sin foto.</h2>
        <% } else { %>
        <img src="<%= "data:image/jpeg;base64,"+Base64.getEncoder().encodeToString(((UsuarioDTO)request.getAttribute("usuario")).getFoto())%>" />
        <% } %>
    </body>
</html>
