/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package web;

import datos.ProductoDAO;
import dominio.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/producto")
public class ProductoServlet extends HttpServlet {
     private final ProductoDAO productoDAO = new ProductoDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        System.out.println(accion);
        if(null == accion){
           this.abrirModificar(request, response);
        }else switch (accion) {
             case "eliminar":
                 this.eliminarProducto(request, response);
                 break;
             default:
                response.sendRedirect(request.getContextPath());
                 break;
         }
       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        
        if(accion != null){
            switch(accion){
                case "insertar":
                    this.insertarCliente(request, response);
                    break;
                case "editar":
                    this.modificarCliente(request, response);
                    break;
            }
        }
        response.sendRedirect(request.getContextPath());
    }
    private void insertarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        
        String nombre = request.getParameter("nombre");
        double costo = Double.parseDouble(request.getParameter("costo"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        Producto producto = new Producto(nombre,costo,stock);
        System.out.println(productoDAO.insertarProducto(producto));
    }
    
     private void modificarCliente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        int idProducto = Integer.parseInt(request.getParameter("idProducto"));
        String nombre = request.getParameter("nombre");
        double costo = Double.parseDouble(request.getParameter("costo"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        Producto producto = new Producto(idProducto,nombre,costo,stock);
        System.out.println(productoDAO.editarProducto(producto));
    }
     
     private void abrirModificar(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
         int idProducto = Integer.parseInt(request.getParameter("idProducto"));
         System.out.println(idProducto);
         Producto producto = new Producto(idProducto);
         producto = productoDAO.getProducto(producto);
         request.setAttribute("producto", producto);
         request.getRequestDispatcher("WEB-INF/paginas/productos/editarProducto.jsp").forward(request, response);
     }
     
      private void eliminarProducto(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
          int idProducto = Integer.parseInt(request.getParameter("idProducto"));
          Producto producto = new Producto(idProducto);
          System.out.println(productoDAO.eliminarProducto(producto));
          response.sendRedirect(request.getContextPath());
      }
}
