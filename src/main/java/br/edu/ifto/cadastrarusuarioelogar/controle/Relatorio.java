package br.edu.ifto.cadastrarusuarioelogar.controle;

import br.edu.ifto.cadastrarusuarioelogar.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet("/relatorio")
public class Relatorio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<Usuario> usuarios = (Set<Usuario>) request.getServletContext().getAttribute("usuariosContextoApp");
        request.setAttribute("usuariosContextoApp", usuarios);
        request.getRequestDispatcher("/WEB-INF/relatorio.jsp").forward(request, response);
    }
}
