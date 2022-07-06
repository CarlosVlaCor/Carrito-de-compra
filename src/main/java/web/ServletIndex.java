
package web;

import datos.ProductoDAO;
import dominio.Producto;
import dominio.Usuario;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/")
public class ServletIndex extends HttpServlet{
    private final ProductoDAO productoDAO = new ProductoDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
        HttpSession sesion = request.getSession();
        if(sesion.isNew()){
            System.out.println("Como que es nueva");
        }
        Usuario usuario = (Usuario)sesion.getAttribute("usuario");
        List<Producto> productos = productoDAO.getProductos();
        request.setAttribute("productos", productos);
        if(usuario != null){
            request.setAttribute("usuario", usuario);
            if(usuario.getRol().equals("personal")){
                
                request.getRequestDispatcher("WEB-INF/paginas/personal/indexPersonal.jsp").forward(request, response);
            }else{
                 request.getRequestDispatcher("WEB-INF/paginas/cliente/indexCliente.jsp").forward(request, response);
            }
        }else{
            request.getRequestDispatcher("WEB-INF/paginas/cliente/indexCliente.jsp").forward(request, response);
        }
        
        
    }
}
