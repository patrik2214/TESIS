/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_Negocio;

import Capa_Datos.clsJDBC;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author USER
 */
public class clsAlumno {
    
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
            String strSQL = "SELECT COALESCE(MAX(id),0) + 1 FROM alumno";
            ResultSet rs = con.createStatement().executeQuery(strSQL);
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static clsAlumno buscar(int id) throws Exception{
        try(Connection con = clsJDBC.getConexion()){
            String strSQL = "SELECT * FROM alumno WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                clsAlumno objA = new clsAlumno();
                objA.setId(id);
                objA.setNombre(rs.getString(2));
                objA.setApellido(rs.getString(3));
                objA.setDni(rs.getString(4));
                objA.setFecha_nacimiento(rs.getDate(5));
                objA.setDireccion(rs.getString(6));               
                objA.setCorreo(rs.getString(7));               
                objA.setEstado(rs.getString(8));
                return objA;
            }else{
                return null;
            }
        }catch(Exception e){
            throw new Exception("Error al buscar Alumno");
        }
    }
    
    public static ArrayList<clsAlumno> buscarPorNombre(String nombreCompleto) throws Exception
    {
        try (Connection con = clsJDBC.getConexion()) {
            ArrayList<clsAlumno> lista = new ArrayList<>();
            String strSQL = "SELECT * FROM Alumno where CONCAT(nombre,' ',apellido ) ilike ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setString(1,"%" + nombreCompleto + "%");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clsAlumno objA = new clsAlumno();
                objA.setId(rs.getInt(1));
                objA.setNombre(rs.getString(2));
                objA.setApellido(rs.getString(3));
                objA.setDni(rs.getString(4));
                objA.setEstado(rs.getString(5));
                lista.add(objA);
            }
            return lista;
        } catch (Exception e) {
            throw new Exception(e.getMessage()+"Error al buscar Alumno");
        }
    }
    public static clsAlumno buscarPorDni(String dni)throws Exception
    {
        try(Connection con = clsJDBC.getConexion()){
            String strSQL = "SELECT * FROM alumno WHERE dni = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setString(1,dni);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                clsAlumno objA = new clsAlumno();
                objA.setDni(dni);
                objA.setNombre(rs.getString(2));
                objA.setApellido(rs.getString(3));
                objA.setFecha_nacimiento(rs.getDate(5));
                objA.setDireccion(rs.getString(6));               
                objA.setCorreo(rs.getString(7));               
                objA.setEstado(rs.getString(8));
                return objA;
            }else{
                return null;
            }
        }catch(Exception e){
            throw new Exception("Error al buscar Alumno");
        }
    }
    public void registrar() throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "INSERT INTO alumno VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1,this.id);
            ps.setString(2, this.nombre);
            ps.setString(3, this.apellido);
            ps.setString(4, this.dni);
            ps.setDate(5, this.fecha_nacimiento);
            ps.setString(6, this.direccion);            
            ps.setString(7, this.correo);           
            ps.setString(8, this.estado);
            ps.execute();
        } catch (Exception e) {
            throw new Exception(e.getMessage()+" Error al registrar Alumno");
        }
    }
    
    public static void Eliminar(int id) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "DELETE FROM alumno WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al eliminar Alumno");
        }
    }
    
    public static ArrayList<clsAlumno> listar() throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            ArrayList<clsAlumno> lista = new ArrayList<>();
            String strSQL = "SELECT * FROM alumno";
            ResultSet rs = con.createStatement().executeQuery(strSQL);
            while (rs.next()) {
                clsAlumno objA = new clsAlumno();
                objA.setId(rs.getInt(1));
                objA.setNombre(rs.getString(2));
                objA.setApellido(rs.getString(3));
                objA.setDni(rs.getString(4));
                objA.setFecha_nacimiento(rs.getDate(5));
                objA.setDireccion(rs.getString(6));               
                objA.setCorreo(rs.getString(7));               
                objA.setEstado(rs.getString(8));
                lista.add(objA);
            }
            return lista;
        } catch (Exception e) {
            throw new Exception("Error al listar Alumno");
        }
    }
    
    public void modificar(clsAlumno objA) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "UPDATE alumno SET nombre = ?, apellido = ?, dni = ?, fecha_nacimiento = ?, direccion = ?, correo = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setString(1, objA.getNombre());
            ps.setString(2, objA.getApellido());
            ps.setString(3, objA.getDni());
            ps.setDate(4, objA.getFecha_nacimiento());
            ps.setString(5, objA.getDireccion());           
            ps.setString(6, objA.getCorreo());           
            //ps.setString(7, objA.getEstado());
            ps.setInt(7, id);
            ps.execute();
            
        } catch (Exception e) {
            throw new Exception("Error al modificar Alumno");
        }
    }
    public void modificarPorDni(clsAlumno objA) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "UPDATE alumno SET nombre = ?, apellido = ?, fecha_nacimiento = ?, direccion = ?, correo = ? WHERE dni = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setString(1, objA.getNombre());
            ps.setString(2, objA.getApellido());
            ps.setDate(3, objA.getFecha_nacimiento());
            ps.setString(4, objA.getDireccion());           
            ps.setString(5, objA.getCorreo());           
            ps.setString(6, objA.getDni());
            ps.execute();
            
        } catch (Exception e) {
            throw new Exception("Error al modificar Alumno");
        }
    }
    
    public static void darBaja(int id) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "UPDATE alumno SET estado = ? WHERE dni = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setString(1, "I");
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al dar baja Alumno");
        }
    }
    
    public static void darBajaPorDni(String dni) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "UPDATE alumno SET estado = ? WHERE dni = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setString(1, "I");
            ps.setString(2, dni);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al dar baja Alumno");
        }
    }
    
    public static ArrayList<clsAlumno> busqueda_Avanzada(String dni, String nombre, String apellido) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            ArrayList<clsAlumno> lista = new ArrayList<>();
            String strSQL = "SELECT * FROM alumno WHERE dni LIKE ? or nombre LIKE ? or apellido LIKE ?";
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
                clsAlumno objA = new clsAlumno();
                objA.setId(rs.getInt(1));
                objA.setNombre(rs.getString(2));
                objA.setApellido(rs.getString(3));
                objA.setDni(rs.getString(4));
                objA.setFecha_nacimiento(rs.getDate(5));
                objA.setDireccion(rs.getString(6));               
                objA.setCorreo(rs.getString(7));               
                objA.setEstado(rs.getString(8));
                lista.add(objA);
            }
            return lista;
        } catch (Exception e) {
            throw new Exception("Error al buscar alumno");
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
