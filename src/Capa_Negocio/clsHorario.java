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
public class clsHorario {

    private int id;
    private Date fecha;
    private Time hora_inicio;
    private Time hora_fin;
    private Boolean estado;
    private clsAmbiente ambiente;

    public static int generarCodigo() throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "SELECT COALESCE(MAX(id),0) + 1 FROM horario";
            ResultSet rs = con.createStatement().executeQuery(strSQL);
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<clsHorario> listar() throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            ArrayList<clsHorario> lista = new ArrayList<>();
            String strSQL = "SELECT * FROM horario";
            ResultSet rs = con.createStatement().executeQuery(strSQL);
            while (rs.next()) {
                clsHorario objH = new clsHorario();
                objH.setId(rs.getInt(1));
                objH.setFecha(rs.getDate(2));
                objH.setHora_inicio(rs.getTime(3));
                objH.setHora_fin(rs.getTime(4));
                objH.setEstado(rs.getBoolean(5));
                objH.setAmbiente(clsAmbiente.buscar(rs.getInt(6)));
                lista.add(objH);
            }
            return lista;

        } catch (Exception e) {
            throw new Exception("Error al listar Horario");
        }
    }

    public void Registrar() throws Exception {

        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "INSERT INTO horario VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, this.id);
            ps.setDate(2, this.fecha);
            ps.setTime(3, this.hora_inicio);
            ps.setTime(4, this.hora_fin);
            ps.setBoolean(5, this.estado);
            ps.setInt(6, this.ambiente.getId());
            ps.execute();
        } catch (Exception e) {
            throw new Exception("Error al registrar Horario");
        }
    }

    public static clsHorario buscar(int id) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "SELECT * FROM horario WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                clsHorario objH = new clsHorario();
                objH.setId(rs.getInt(1));
                objH.setFecha(rs.getDate(2));
                objH.setHora_inicio(rs.getTime(3));
                objH.setHora_fin(rs.getTime(4));
                objH.setEstado(rs.getBoolean(5));
                objH.setAmbiente(clsAmbiente.buscar(rs.getInt(6)));                
                return objH;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage() + " Error al buscar Horario");
        }
    }
    
    public void modificar(clsHorario objH) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "UPDATE horario SET fecha = ?, hora_inicio = ?, hora_fin = ?, estado = ?, id_Ambiente = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setDate(1, objH.getFecha());
            ps.setTime(2, objH.getHora_inicio());
            ps.setTime(3, objH.getHora_fin());
            ps.setBoolean(4, objH.getEstado());
            ps.setInt(5,objH.getAmbiente().getId()); // revisar si funciona >.<
            ps.setInt(6, id);
            ps.execute();
        } catch (Exception e) {
            throw new Exception("Error al modificar Horario");
        }
    }
    
    public static void Eliminar(int id) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "DELETE FROM horario WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al eliminar Horario");
        }
    }
    
    public static void darBaja(int id) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "UPDATE horario SET estado = FALSE WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);         
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al dar baja Horario");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(Time hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public Time getHora_fin() {
        return hora_fin;
    }

    public void setHora_fin(Time hora_fin) {
        this.hora_fin = hora_fin;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public clsAmbiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(clsAmbiente ambiente) {
        this.ambiente = ambiente;
    }

}
