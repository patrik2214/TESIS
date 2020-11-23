
package Capa_Negocio;
import Capa_Datos.clsJDBC;
import java.sql.*;
import java.util.ArrayList;


/**
 *
 * @author USER
 */
public class clsDocente {
    
    private int id;
    private String nombre;
    private String apellido;
    private String dni;
    private Date fecha_nacimiento;
    private String direccion;    
    private String correo;    
    private String estado; 
    
    public static int generarCodigo() throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "SELECT COALESCE(MAX(id),0) + 1 FROM docente";
            ResultSet rs = con.createStatement().executeQuery(strSQL);
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static clsDocente buscar_DNI(String DNI) throws Exception{
        try(Connection con = clsJDBC.getConexion()){
            String strSQL = "SELECT * FROM docente WHERE DNI = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setString(1, DNI);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                clsDocente objD = new clsDocente();
                objD.setId(rs.getInt(1));
                objD.setNombre(rs.getString(2));
                objD.setApellido(rs.getString(3));
                objD.setDni(rs.getString(4));
                objD.setFecha_nacimiento(rs.getDate(5));
                objD.setDireccion(rs.getString(6));              
                objD.setCorreo(rs.getString(7));              
                objD.setEstado(rs.getString(8));
                return objD;
            }else{
                return null;
            }
        }catch(Exception e){
            throw new Exception("Error al buscar Docente");
        }
    }
    
    public static clsDocente buscar(int id) throws Exception{
        try(Connection con = clsJDBC.getConexion()){
            String strSQL = "SELECT * FROM docente WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                clsDocente objD = new clsDocente();
                objD.setId(rs.getInt(1));
                objD.setNombre(rs.getString(2));
                objD.setApellido(rs.getString(3));
                objD.setDni(rs.getString(4));
                objD.setFecha_nacimiento(rs.getDate(5));
                objD.setDireccion(rs.getString(6));               
                objD.setCorreo(rs.getString(7));               
                objD.setEstado(rs.getString(8));
                return objD;
            }else{
                return null;
            }
        }catch(Exception e){
            throw new Exception("Error al buscar Docente");
        }
    }
    
    public void registrar() throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "INSERT INTO docente VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, this.id);
            ps.setString(2, this.nombre);
            ps.setString(3, this.apellido);
            ps.setString(4, this.dni);
            ps.setDate(5, this.fecha_nacimiento);
            ps.setString(6, this.direccion);            
            ps.setString(7, this.correo);           
            ps.setString(8, this.estado);
            ps.execute();
        } catch (Exception e) {
            throw new Exception("Error al registrar Docente");
        }
    }
    
    public static void Eliminar(int id) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "DELETE FROM docente WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al eliminar Docente");
        }
    }
    
    public static ArrayList<clsDocente> listar() throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            ArrayList<clsDocente> lista = new ArrayList<>();
            String strSQL = "SELECT * FROM docente";
            ResultSet rs = con.createStatement().executeQuery(strSQL);
            while (rs.next()) {
                clsDocente objD = new clsDocente();
                objD.setId(rs.getInt(1));
                objD.setNombre(rs.getString(2));
                objD.setApellido(rs.getString(3));
                objD.setDni(rs.getString(4));
                objD.setFecha_nacimiento(rs.getDate(5));
                objD.setDireccion(rs.getString(6));                
                objD.setCorreo(rs.getString(7));                
                objD.setEstado(rs.getString(8));
                lista.add(objD);
            }
            return lista;
        } catch (Exception e) {
            throw new Exception("Error al listar Docente");
        }
    }
    
    public void modificar(clsDocente objD) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "UPDATE docente SET nombre = ?, apellido = ?, dni = ?, fecha_nacimiento = ?, direccion = ?, correo = ?, estado = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setString(1, objD.getNombre());
            ps.setString(2, objD.getApellido());
            ps.setString(3, objD.getDni());
            ps.setDate(4, objD.getFecha_nacimiento());
            ps.setString(5, objD.getDireccion());         
            ps.setString(6, objD.getCorreo());          
            ps.setString(7, objD.getEstado());
            ps.setInt(8, id);
            ps.execute();            
        } catch (Exception e) {
            throw new Exception("Error al modificar Docente");
        }
    }
    
    public static void darBaja(int id) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "UPDATE docente SET estado = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setString(1, "I");
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al dar baja Docente");
        }
    }
    
    public static ArrayList<clsDocente> busqueda_Avanzada(String dni, String nombre, String apellido) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            ArrayList<clsDocente> lista = new ArrayList<>();
            String strSQL = "SELECT * FROM docente WHERE dni LIKE ? or nombre LIKE ? or apellido LIKE ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            String eval_dni = dni;
            String eval_nombre = nombre;
            String eval_apellido = apellido;
            if (dni.equalsIgnoreCase("")){
                String campo_dni = "64";
                eval_dni = campo_dni;
            }
            if (nombre.equalsIgnoreCase("")){
                String campo_nombre = "64";
                eval_nombre = campo_nombre;
            }
            if (apellido.equalsIgnoreCase("")){
                String campo_apellido = "64";
                eval_apellido = campo_apellido;
            }
            ps.setString(1, "%" + eval_dni + "%");
            ps.setString(2, "%" + eval_nombre + "%");
            ps.setString(3, "%" + eval_apellido + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clsDocente objD = new clsDocente();
                objD.setId(rs.getInt(1));
                objD.setNombre(rs.getString(2));
                objD.setApellido(rs.getString(3));
                objD.setDni(rs.getString(4));
                objD.setFecha_nacimiento(rs.getDate(5));
                objD.setDireccion(rs.getString(6));                
                objD.setCorreo(rs.getString(7));                
                objD.setEstado(rs.getString(8));
                lista.add(objD);
            }
            return lista;
        } catch (Exception e) {
            throw new Exception("Error al buscar Docente");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getFecha_nacimiento() {
        return fecha_nacimiento;
    }

    public void setFecha_nacimiento(Date fecha_nacimiento) {
        this.fecha_nacimiento = fecha_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
   
    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
}
