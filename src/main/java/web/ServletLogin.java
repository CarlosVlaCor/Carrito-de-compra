package web;

import datos.UsuarioClienteDAO;
import dominio.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {

    private final UsuarioClienteDAO usuarioClienteDAO = new UsuarioClienteDAO();

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Usuario us = (Usuario) sesion.getAttribute("usuario");
        if (us == null) {
            request.getRequestDispatcher("WEB-INF/paginas/usuarios/login.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath());
        }

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Usuario us = (Usuario) sesion.getAttribute("usuario");
        if (us == null) {
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            Usuario usuario = new Usuario(email, password);

            usuario = usuarioClienteDAO.loguearUsuario(usuario);

            if (usuario != null) {

                sesion.setAttribute("usuario", usuario);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            } else {
                response.sendRedirect(request.getContextPath() + "/login?error");
            }
        } else {
            response.sendRedirect(request.getContextPath());
        }

    }
}
