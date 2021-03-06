
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="paises" type="java.util.ArrayList<java.lang.String>" scope="request" />
<%
    boolean nombreB = request.getAttribute("nombreB") == null ? true : (Boolean) request.getAttribute("nombreB");

    boolean nombreExis = request.getAttribute("nombreExis") == null ? false : (Boolean) request.getAttribute("nombreExis");

%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel='stylesheet' href='https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css'/>
    <title>JSP Page</title>
</head>
<body>
<div class='container'>
    <div class="row mb-4">
        <div class="col"></div>
        <div class="col-md-6">
            <h1 class='mb-3'>Crear un Árbitro</h1>
            <form method="POST" action="<%=request.getContextPath()%>/ArbitrosServlet?action=guardar">
                <div class="form-group">
                    <label>Nombre</label>

                    <input type="text" class="form-control <%=nombreB?"":"is-invalid"%>"
                           aria-describedby="inputNombreFeedback"
                           name="nombre"
                           id="inputEmail" <%=request.getParameter("nombre")==null?"":"value='"+request.getParameter("nombre")+"'"%>>
                    <div id="inputEmailFeedback" class="invalid-feedback">
                        Este nombre ya se encuentra en la base de datos .
                    </div>
                </div>
                <div class="form-group">
                    <label>País</label>

                    <select name="pais" class="form-control">

                        <% for(String p : paises){%>
                        <option value="<%=p%>" > <%=p%></option>
                        <%}%>

                    </select>
                </div>
                <button type="submit" class="btn btn-primary">Guardar</button>
                <a href="<%= request.getContextPath()%>/ArbitrosServlet" class="btn btn-danger">Cancelar</a>
            </form>
        </div>
        <div class="col"></div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
        integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
        integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>

</body>
</html>