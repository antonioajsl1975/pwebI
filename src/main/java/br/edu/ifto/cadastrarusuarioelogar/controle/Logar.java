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
                        request.setAttribute("mensagem", "Logado com sucesso!");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                        logou = true;
                        break;
                    }
                }
                if (!logou) {
                    request.setAttribute("mensagem", "Login ou senha incorretos!");
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                }
            } else {
                request.setAttribute("mensagem", "Você precisa informar o login e a senha");
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            response.sendRedirect("index.jsp?mensagem=" + URLEncoder.encode("Já está logado!"));
        }
    }
}
