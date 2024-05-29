<%--
  Created by IntelliJ IDEA.
  User: antonio
  Date: 28/05/2024
  Time: 08:59
  To change this template use File | Settings | File Templates.
--%>
<%@page import="br.edu.ifto.cadastrarusuarioelogar.modelo.Usuario" %>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<html>
<head>
    <title>Sistema de Login</title>
<%--    <link rel="stylesheet" href="estilo.css">--%>
    <link rel="stylesheet" href="estilo.css" />
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    if (request.getParameter("mensagem") != null) {
%>

<div class="mensagem">
    <%= request.getParameter("mensagem")%>
</div>
<%
    }
%>
<header>
    <h1>Sistema de Login</h1>
    <%
        if (session.getAttribute("usuarioLogado") != null) {
    %>
    <h2>Seja bem-vindo, <%= ((Usuario) session.getAttribute("usuarioLogado")).getNome() %>
    </h2>
    <% }
    %>
</header>
<nav>
    <a href="index.jsp">Home</a>
    <%--    <a href="relatorio.jsp"></a>--%>
    <%
        if (session.getAttribute("usuarioSessao") != null) {
    %>
    <a href="sair">Sair</a>
    <%
        }
    %>
</nav>
<script src="https://getbootstrap.com/docs/5.2/getting-started/introduction/" ></script>
</body>
</html>
