<%--
  Created by IntelliJ IDEA.
  User: antonio
  Date: 28/05/2024
  Time: 08:59
  To change this template use File | Settings | File Templates.
--%>
<%@page import="br.edu.ifto.cadastrarusuarioelogar.modelo.Usuario" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt">
<head>
    <title>Sistema de Login</title>
    <link rel="stylesheet" href="estilo.css"/>
</head>
<body>
<%
    request.setCharacterEncoding("UTF-8");
    String mensagem = (String) request.getAttribute("mensagem");
    if (mensagem != null) {
%>

<div class="mensagem">
    <%= mensagem %>
</div>
<%
    }
%>
<header>
    <h2>Sistema de Login</h2>
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
    <%
        if (session.getAttribute("usuarioLogado") != null) {
    %>
    <a href="relatorio">Relatório</a>
    <a href="sair">Sair</a>
    <%
        }
    %>
</nav>
</body>
</html>
