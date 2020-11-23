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
public class clsTesis {
    
    private int id;
    private String titulo;
    private String tema;
    private Date fecha;
    private int nota;
    private String resolucion_Jurado;
    private Date fecha_jurado;
    private String resolucion_Asesor;
    private Date fecha_asesor;
    private String resolucion_Sustentacion;
    private Date fecha_sustentacion;
    private String url;
    private Boolean estado;
    private clsAlumno alumno;
    private clsSustentacion sustentacion;
    
    public static int generarCodigo() throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "SELECT COALESCE(MAX(id),0) + 1 FROM tesis";
            ResultSet rs = con.createStatement().executeQuery(strSQL);
            rs.next();
            return rs.getInt(1);
        } catch (Exception e) {
            throw e;
        }
    }

    public static ArrayList<clsTesis> listar() throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            ArrayList<clsTesis> lista = new ArrayList<>();
            String strSQL = "SELECT * FROM tesis";
            ResultSet rs = con.createStatement().executeQuery(strSQL);
            while (rs.next()) {
                clsTesis objT = new clsTesis();
                objT.setId(rs.getInt(1));
                objT.setTitulo(rs.getString(2));
                objT.setTema(rs.getString(3));
                objT.setFecha(rs.getDate(4));
                objT.setNota(rs.getInt(5));
                objT.setResolucionJurado(rs.getString(6));
                objT.setFecha_jurado(rs.getDate(7));
                objT.setResolucionAsesor(rs.getString(8));
                objT.setFecha_asesor(rs.getDate(9));
                objT.setResolucionSustentacion(rs.getString(10));
                objT.setFecha_sustentacion(rs.getDate(11));
                objT.setUrl(rs.getString(12));
                objT.setEstado(rs.getBoolean(13));
                objT.setAlumno(clsAlumno.buscar(rs.getInt(14)));
                objT.setSustentacion(clsSustentacion.buscar(rs.getInt(15)));               
                lista.add(objT);
            }
            return lista;
        } catch (Exception e) {
            throw new Exception("Error al listar Tesis");
        }
    }
    
    // Registra null en ID de sustentación
    public void Registrar() throws Exception {

        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "INSERT INTO tesis VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,null)";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, this.id);
            ps.setString(2, this.titulo);
            ps.setString(3, this.tema);
            ps.setDate(4, this.fecha);
            ps.setInt(5, this.nota);
            ps.setString(6, this.resolucion_Jurado);
            ps.setDate(7, this.fecha_jurado);
            ps.setString(8, this.resolucion_Asesor);
            ps.setDate(9, this.fecha_sustentacion);
            ps.setString(10, this.resolucion_Sustentacion);
            ps.setDate(11, this.fecha_sustentacion);
            ps.setString(12, this.url);
            ps.setBoolean(13, this.estado);
            ps.setInt(14, this.alumno.getId());           
            ps.execute();
        } catch (Exception e) {
            throw new Exception("Error al registrar Tesis");
        }
    }

    public static clsTesis buscar(int id_alumno) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "SELECT * FROM tesis WHERE id_alumno = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, id_alumno);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                clsTesis objT = new clsTesis();
                objT.setId(rs.getInt(1));
                objT.setTitulo(rs.getString(2));
                objT.setTema(rs.getString(3));
                objT.setFecha(rs.getDate(4));
                objT.setNota(rs.getInt(5));
                objT.setResolucionJurado(rs.getString(6));
                objT.setFecha_jurado(rs.getDate(7));
                objT.setResolucionAsesor(rs.getString(8));
                objT.setFecha_asesor(rs.getDate(9));
                objT.setResolucionSustentacion(rs.getString(10));
                objT.setFecha_sustentacion(rs.getDate(11));
                objT.setUrl(rs.getString(12));
                objT.setEstado(rs.getBoolean(13));
                objT.setAlumno(clsAlumno.buscar(rs.getInt(14)));
                objT.setSustentacion(clsSustentacion.buscar(rs.getInt(15)));                
                return objT;
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new Exception(" Error al buscar Tesis");
        }
    }
    
    public void modificar(clsTesis objT) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "UPDATE tesis SET titulo = ?, tema = ?, fecha = ?, nota = ?, resolucion_Jurado = ?, fecha_jurado = ?, resolucion_Asesor = ?, fecha_asesor = ?, resolucion_Sustentacion = ?, fecha_sustentacion = ?, url = ?, estado = ?, id_Alumno = ?, id_Sustentacion = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setString(1, objT.getTitulo());
            ps.setString(2, objT.getTema());
            ps.setDate(3, objT.getFecha());
            ps.setInt(4, objT.getNota());
            ps.setString(5, objT.getResolucionJurado());
            ps.setDate(6, objT.getFecha_jurado());
            ps.setString(7, objT.getResolucionAsesor());
            ps.setDate(8, objT.getFecha_asesor());
            ps.setString(9, objT.getResolucionSustentacion());
            ps.setDate(10, objT.getFecha_sustentacion());
            ps.setString(11, objT.getUrl());
            ps.setBoolean(12, objT.getEstado());
            ps.setInt(13, objT.getAlumno().getId()); 
            ps.setInt(14, objT.getSustentacion().getId());
            ps.setInt(15, id);
            ps.execute();
        } catch (Exception e) {
            throw new Exception("Error al modificar Tesis");
        }
    }
    
    public static void Eliminar(int id) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "DELETE FROM tesis WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al eliminar Tesis");
        }
    }
    
    // revisar estados de la tesis en los req.
    public static void darBaja(int id) throws Exception {
        try (Connection con = clsJDBC.getConexion()) {
            String strSQL = "UPDATE tesis SET estado = FALSE WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(strSQL);         
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new Exception("Error al dar baja Tesis");
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getResolucionJurado() {
        return resolucion_Jurado;
    }

    public void setResolucionJurado(String resolucion_Jurado) {
        this.resolucion_Jurado = resolucion_Jurado;
    }

    public Date getFecha_jurado() {
        return fecha_jurado;
    }

    public void setFecha_jurado(Date fecha_jurado) {
        this.fecha_jurado = fecha_jurado;
    }

    public String getResolucionAsesor() {
        return resolucion_Asesor;
    }

    public void setResolucionAsesor(String resolucion_Asesor) {
        this.resolucion_Asesor = resolucion_Asesor;
    }

    public Date getFecha_asesor() {
        return fecha_asesor;
    }

    public void setFecha_asesor(Date fecha_asesor) {
        this.fecha_asesor = fecha_asesor;
    }

    public String getResolucionSustentacion() {
        return resolucion_Sustentacion;
    }

    public void setResolucionSustentacion(String resolucion_Sustentacion) {
        this.resolucion_Sustentacion = resolucion_Sustentacion;
    }

    public Date getFecha_sustentacion() {
        return fecha_sustentacion;
    }

    public void setFecha_sustentacion(Date fecha_sustentacion) {
        this.fecha_sustentacion = fecha_sustentacion;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public clsAlumno getAlumno() {
        return alumno;
    }

    public void setAlumno(clsAlumno alumno) {
        this.alumno = alumno;
    }

    public clsSustentacion getSustentacion() {
        return sustentacion;
    }

    public void setSustentacion(clsSustentacion sustentacion) {
        this.sustentacion = sustentacion;
    }

    

    
    
    
}
