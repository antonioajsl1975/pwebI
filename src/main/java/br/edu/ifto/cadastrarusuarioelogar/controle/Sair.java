package br.edu.ifto.cadastrarusuarioelogar.controle;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/sair")
public class Sair extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if(session.getAttribute("usuarioLogado") != null){
            session.invalidate();
            response.sendRedirect("index.jsp");
        }else{
            response.sendRedirect("login.jsp?mensagem="+ URLEncoder.encode("Você nem estava logado!", "UTF-8"));
        }
    }
}
