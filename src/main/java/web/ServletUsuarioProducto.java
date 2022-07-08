/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import datos.UsuarioProductoDAO;
import dominio.Producto;
import dominio.Usuario;
import dominio.UsuarioProducto;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
@WebServlet("/carrito")
public class ServletUsuarioProducto extends HttpServlet {

    private final UsuarioProductoDAO usuarioProductoDAO = new UsuarioProductoDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sesion = request.getSession();
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");
        String accion = request.getParameter("accion");
        if(usuario != null){
           if(accion == null){
               List<UsuarioProducto> usuarioProductos = usuarioProductoDAO.getUsuarioProductos(usuario);
               request.setAttribute("usuarioProductos", usuarioProductos);
               request.setAttribute("total", calcularTotal(usuarioProductos));
               request.getRequestDispatcher("WEB-INF/paginas/carrito/carrito.jsp").forward(request, response);
            }else if(accion.equals("eliminar")){
               eliminar(request, response);
            } 
        }else{
            response.sendRedirect(request.getContextPath());
        }
        
        
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        HttpSession sesion = request.getSession();
        Usuario usuario = (Usuario) sesion.getAttribute("usuario");

        if (usuario != null) {
            if (accion != null) {
                switch (accion) {
                    case "insertar":
                        insertar(request, response, usuario);
                        break;
                    case "modificar":
                        modificar(request, response);
                        break;
                    default:
                        response.sendRedirect(request.getContextPath());
                        break;
                }
            }else{
                response.sendRedirect(request.getContextPath());
            }

        }else{
            response.sendRedirect(request.getContextPath());
        }
        
    }
    private int calcularTotal(List<UsuarioProducto> usuariosProductos){
        int total = 0;
        for(UsuarioProducto usuarioProducto: usuariosProductos){
            total += usuarioProducto.getProducto().getCosto() * usuarioProducto.getCantidad();
        }
        return total;
    }

    private void insertar(HttpServletRequest request, HttpServletResponse response, Usuario usuario)
            throws ServletException, IOException {

        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));

        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        String formatoFecha = df.format(date);
        UsuarioProducto usuarioProducto = new UsuarioProducto(formatoFecha, cantidad, false, new Producto(idProducto), usuario);
        usuarioProductoDAO.insertarProductoUsuario(usuarioProducto);
        response.sendRedirect(request.getContextPath()+"/carrito");

    }

    private void modificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idUsuarioProducto = Integer.parseInt(request.getParameter("idUsuarioProducto"));
       
        int cantidad = Integer.parseInt(request.getParameter("cantidad"));
        
        UsuarioProducto usuarioProducto = new UsuarioProducto(idUsuarioProducto,cantidad);
        System.out.println(usuarioProductoDAO.modificarUsuarioProducto(usuarioProducto));
        response.sendRedirect(request.getContextPath()+"/carrito");
        
    }
    
    private void eliminar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idUsuarioProducto = Integer.parseInt(request.getParameter("idUsuarioProducto"));
        
        UsuarioProducto usuarioProducto = new UsuarioProducto(idUsuarioProducto);
        System.out.println(usuarioProductoDAO.eliminarUsuarioProducto(usuarioProducto));
        response.sendRedirect(request.getContextPath()+"/carrito");
    }

}
