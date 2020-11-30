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
public class clsAsesoria {
    
    private int id;
    private String comentarios;
    private clsDocente docente;
    private clsTesis tesis;
    private Date fecha;
    
    public static int generarCodigo() throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "SELECT COALESCE(MAX(id),0) + 1 FROM asesoria";
            ResultSet rs = con.createStatement().executeQuery(strSQL);
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public static clsAsesoria buscar(int id) throws Exception{
        try(Connection con = clsJDBC.getConexion()){
            String strSQL = "SELECT * FROM asesoria WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                clsAsesoria objA = new clsAsesoria();
                objA.setId(id);
                objA.setComentarios(rs.getString(2));
                objA.setDocente(clsDocente.buscar(rs.getInt(3)));                
                objA.setTesis(clsTesis.buscar(rs.getInt(4)));
                objA.setFecha(rs.getDate(5));
                return objA;
            }else{
                return null;
            }
        }catch(Exception e){
            throw new Exception("Error al buscar Asesoria");
        }
    }
    
    public void registrar() throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "INSERT INTO asesoria VALUES (?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, this.id);
            ps.setString(2, this.comentarios);
            ps.setInt(3, this.docente.getId());            
            ps.setInt(4, this.tesis.getId());           
            ps.setDate(5, this.fecha);           
            ps.execute();
        } catch (Exception e) {
            throw new Exception("Error al registrar Asesoria");
        }
    }
    
    public static void Eliminar(int id) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "DELETE FROM asesoria WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al eliminar Asesoria");
        }
    }
    
    public static ArrayList<clsAsesoria> listar() throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            ArrayList<clsAsesoria> lista = new ArrayList<>();
            String strSQL = "SELECT * FROM asesoria";
            ResultSet rs = con.createStatement().executeQuery(strSQL);
            while (rs.next()) {
                clsAsesoria objA = new clsAsesoria();
                objA.setId(rs.getInt(1));
                objA.setComentarios(rs.getString(2));
                objA.setDocente(clsDocente.buscar(rs.getInt(3)));                
                objA.setTesis(clsTesis.buscar(rs.getInt(4)));
                objA.setFecha(rs.getDate(5));                 
                lista.add(objA);
            }
            return lista;
        } catch (Exception e) {
            throw new Exception("Error al listar Asesoria");
        }
    }
    
    public void modificar(clsAsesoria objA) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "UPDATE asesoria SET comentarios = ?, id_Docente = ?, id_Tesis = ?, id_Horario = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setString(1, objA.getComentarios());
            ps.setInt(2, objA.getDocente().getId());
            ps.setInt(3, objA.getTesis().getId());  
            ps.setDate(4, objA.getFecha());                       
            ps.setInt(5, id);
            ps.execute();          
        } catch (Exception e) {
            throw new Exception("Error al modificar Asesoria");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public clsDocente getDocente() {
        return docente;
    }

    public void setDocente(clsDocente docente) {
        this.docente = docente;
    }

    public clsTesis getTesis() {
        return tesis;
    }

    public void setTesis(clsTesis tesis) {
        this.tesis = tesis;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
}
