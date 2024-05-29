package br.edu.ifto.cadastrarusuarioelogar.controle;

import br.edu.ifto.cadastrarusuarioelogar.modelo.Usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.Set;

@WebServlet("/cadastrar")
public class Cadastrar extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
//        boolean isAdmin = Boolean.parseBoolean(request.getParameter("isAdmin"));

        if(nome != null && login != null && senha != null && !nome.isBlank() && !login.isBlank()
                && !senha.isBlank()){
            Set<Usuario> usuarios = (Set<Usuario>) getServletContext().getAttribute("usuariosContextoApp");
            boolean usuarioExiste = false;
            for (Usuario usuario : usuarios) {
                if(usuario.getLogin().equals(login)){
                    usuarioExiste = true;
                    break;
                }
            }

            if (!usuarioExiste) {
                Usuario u = new Usuario(pegarNovoId(), nome, login, senha);
                usuarios.add(u);
                response.sendRedirect("index.jsp?mensagem="+ URLEncoder.encode("Cadastrado com sucesso!", "UTF-8"));
            }else
                response.sendRedirect("index.jsp?mensagem="+URLEncoder.encode("ERRO! Já existe um usuário com esse login", "UTF-8"));

        }else{
            response.sendRedirect("index.jsp?mensagem="+URLEncoder.encode("Você precisa informar todos os dados do usuário!"));
        }
    }

    public int pegarNovoId(){
        int id = (Integer) getServletContext().getAttribute("idUsuario");
        id++;
        getServletContext().setAttribute("idUsuario", id);
        return id;
    }
}
