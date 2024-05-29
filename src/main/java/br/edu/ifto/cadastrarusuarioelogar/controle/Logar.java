package br.edu.ifto.cadastrarusuarioelogar.controle;

import br.edu.ifto.cadastrarusuarioelogar.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Set;

@WebServlet("/logar")
public class Logar extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");

        HttpSession session = request.getSession();

        if (session.getAttribute("usuarioLogado") == null) {
            if (login != null && senha != null && !login.isBlank() && !senha.isBlank()) {

                Set<Usuario> usuarios = (Set<Usuario>) getServletContext().getAttribute("usuariosContextoApp");
                boolean logou = false;
                for (Usuario u : usuarios) {
                    if (u.getLogin().equals(login) && u.getSenha().equals(senha)) {
                        session.setAttribute("usuarioLogado", u);
//                        response.sendRedirect("relatorio");
                        response.sendRedirect("index.jsp?mesnagem=" + URLEncoder.encode("Logado com sucesso!"));

                        logou = true;
                        break;
                    }
                }
                if (!logou) {
                    response.sendRedirect("index.jsp?mensagem=" + URLEncoder.encode("Login ou senha incorretos!"));
                }
            } else {
                response.sendRedirect("index.jsp?mensagem=" + URLEncoder.encode("Você precisa informar o login e a senha!"));
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=" + URLEncoder.encode("Já está logado!"));
        }
    }
}
