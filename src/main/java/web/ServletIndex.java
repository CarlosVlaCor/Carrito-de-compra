
package web;

import datos.ProductoDAO;
import dominio.Producto;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/")
public class ServletIndex extends HttpServlet{
    private final ProductoDAO productoDAO = new ProductoDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        List<Producto> producto = productoDAO.getProductos();
        request.setAttribute("productos", producto);
        System.out.println(producto.size());
        request.getRequestDispatcher("WEB-INF/paginas/personal/indexPersonal.jsp").forward(request, response);
    }
}
