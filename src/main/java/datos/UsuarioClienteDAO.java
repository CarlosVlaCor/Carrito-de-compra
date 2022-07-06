package datos;

import dominio.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioClienteDAO {
    private static final String SQL_INSERTAR_CLIENTE = "INSERT INTO usuarios(nombre,apellido,email,password,rol) VALUES(?,?,?,?,?)";
    private static final String SQL_FIND_BY_EMAIL_AND_PASS = "SELECT id_usuario,nombre,apellido,email,rol FROM usuarios WHERE email = ? AND password = ?";
    public int insertarCliente(Usuario usuario){
        
        Connection conexion = null;
        PreparedStatement ps = null;
        int modificados=0;
        try {
            conexion = Conexion.getConexion();
            ps = conexion.prepareStatement(SQL_INSERTAR_CLIENTE);
            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getPassword());
            ps.setString(5, "cliente");
           modificados = ps.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(ps);
            Conexion.close(conexion);
        }
        return modificados;
    }
    
    public Usuario loguearUsuario(Usuario usuario){
       
        Connection conexion = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Usuario us = null;
        try {
            conexion = Conexion.getConexion();
            ps = conexion.prepareStatement(SQL_FIND_BY_EMAIL_AND_PASS);
            ps.setString(1, usuario.getEmail());
            ps.setString(2, usuario.getPassword());
            rs = ps.executeQuery();
            if(rs.next()){
                us = new Usuario(rs.getInt("id_usuario"),rs.getString("nombre"),rs.getString("apellido"),rs.getString("email"),rs.getString("rol"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }finally{
            Conexion.close(rs);
            Conexion.close(ps);
            Conexion.close(conexion);
        }
        return us;
    }



}
