/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_Datos;
import java.sql.*;
/**
 *
 * @author USER
 */
public class clsJDBC {
       
    private Connection con;
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String DATABASE = "DB_Tesis";
    private static final String HOST = "localhost";
    private static final String PORT = "5432";
    private static final String URL = String.format("jdbc:postgresql://%s:%s/%s", HOST, PORT, DATABASE);
    private static final String USER = "postgres";
    private static final String PASSWORD = "123456789";//21080809

    public static Connection getConexion() throws Exception {

        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            throw new Exception("Error al conectarse con la Base de Datos");
        }
    }
    
    public static Date fecha_actual() throws Exception {
        try (Connection con = getConexion()) {
            String strSQL = "SELECT current_date";
            ResultSet rs = con.createStatement().executeQuery(strSQL);
            rs.next();
            Date fecha_actual = rs.getDate(1);
            return fecha_actual;

        } catch (Exception e) {
            throw new Exception("Error al obtener fecha actual");
        }
    }
    //Conectar
    public void conectar() throws Exception{
        try{
           Class.forName(DRIVER);
           con=DriverManager.getConnection(URL, USER, PASSWORD);
        }catch(ClassNotFoundException | SQLException ex){
        }
    }
    //Desconectar
    public void desconectar() throws Exception{
        try{
           con.close();
        } catch (SQLException ex) {
             throw new Exception("Error al desconectar de la BD!");
        }
    }
    public Connection getCon() {
        return con;
    }
}
