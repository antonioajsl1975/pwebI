<%@ page import="java.util.Set" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="cabecalho.jsp" %>

<div class="container">
    <table class="table">
        <thead>
            <tr>
                <th>Id</th>
                <th>Nome</th>
                <th>Login</th>
                <th>Senha</th>
                <th>Deletar</th>
                <th>Editar</th>
            </tr>
        </thead>
        <tbody>
            <%
                Set<Usuario> usuarios = (Set<Usuario>) request.getAttribute("usuariosContextoApp");
                Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");

                for(Usuario u : usuarios){%>
                <tr>
                    <td><%= u.getId() %></td>
                    <td><%= u.getNome() %></td>
                    <td><%= u.getLogin() %></td>
                    <td><%= u.getSenha() %></td>
                    <td>Deletar</td>
                    <td>Editar</td>
                <%}%>
        </tbody>
    </table>
</div>