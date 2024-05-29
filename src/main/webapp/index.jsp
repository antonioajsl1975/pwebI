<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="WEB-INF/cabecalho.jsp" %>
<link rel="stylesheet" href="https://getbootstrap.com/docs/5.2/getting-started/introduction/"/>

<%
    Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

%>

<form action="cadastrar" method="post" class="centralizar">

    <label for="Nome">Nome</label>
    <input type="text" name="nome" id="nome" placeholder="Nome">

    <label for="login">Login</label>
    <input type="text" name="login" id="login" placeholder="Login">

    <label for="senha">Senha</label>
    <input type="password" name="senha" id="senha" placeholder="Senha">

    <input type="submit" value="Cadastrar">
</form>

<%
    if (session.getAttribute("usuarioLogado") == null) {
%>
<form action="logar" method="post" class="centralizar">
    <label for="login2">Login</label>
    <input type="text" name="login" id="login2" placeholder="Login">

    <label for="senha2">Senha</label>
    <input type="password" name="senha" id="senha2" placeholder="Senha">

    <input type="submit" value="Logar">
</form>
<%
    }
%>