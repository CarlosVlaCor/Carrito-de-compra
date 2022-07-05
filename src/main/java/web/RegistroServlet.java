/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
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

/**
 *
 * @author carlo
 */
@WebServlet("/registro")
public class RegistroServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Usuario us = (Usuario)sesion.getAttribute("usuario");
        if(us == null){
            request.getRequestDispatcher("WEB-INF/paginas/usuarios/registro.jsp").forward(request, response);  
        }else{
           response.sendRedirect(request.getContextPath()); 
        }
      
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         HttpSession sesion = request.getSession();
        Usuario us = (Usuario)sesion.getAttribute("usuario");
        if(us == null){
             String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        Usuario usuario = new Usuario(nombre,apellido,email,password);
        
        int modificados = new UsuarioClienteDAO().insertarCliente(usuario);
        System.out.println("modificados = " + modificados);
        
        response.sendRedirect(request.getContextPath()+"/login");
        
        }else{
           response.sendRedirect(request.getContextPath()); 
        }
       
    }
   

}
