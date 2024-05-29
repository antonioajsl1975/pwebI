package br.edu.ifto.cadastrarusuarioelogar.util;

import br.edu.ifto.cadastrarusuarioelogar.modelo.Usuario;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

import java.util.HashSet;
import java.util.Set;

@WebListener
public class Ouvinte implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent evento) {
        ServletContext aplicacao = evento.getServletContext();
        Set<Usuario> usuarios = new HashSet<>();

        Usuario usuario1 = new Usuario(1, "José", "jose", "123");
        Usuario usuario2 = new Usuario(2, "Maria", "maria", "abc");
        Usuario usuario3 = new Usuario(3, "Marcos", "marcos", "123");

        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);
        aplicacao.setAttribute("usuariosContextoApp", usuarios);
        aplicacao.setAttribute("idUsuario", 3);
    }
}
