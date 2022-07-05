package datos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/carritos_compras?useSSL=false";
    private static final String USERNAME="root";
    private static final String PASSWORD="12345";
    private static BasicDataSource ds= null;
    
    private static DataSource getDataSource(){
        if(ds == null){
            ds = new BasicDataSource();
            ds.setUrl(URL);
            ds.setUsername(USERNAME);
            ds.setPassword(PASSWORD);
            ds.setInitialSize(50);
            System.out.println("SADDDDD");
        }
        
        return ds;
    }
    
    public static Connection getConexion() throws SQLException{
        return getDataSource().getConnection();
    }
    
    public static void close(ResultSet rs){
        try {
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(PreparedStatement ps){
        try {
            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
    
    public static void close(Connection conexion){
        try {
            conexion.close();
            System.out.println("ceerrada");
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
