/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liias.desarrolloweb.libros.Modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Ale
 */
///////////////////////////////////////////////////////////////ADVERTENCIA////////////////////////////////
///////////////////////////////////////////////////////////////ADVERTENCIA////////////////////////////////
///////////////////////////////////////////////////////////////ADVERTENCIA////////////////////////////////
///////////////////////////////////////////////////////////////ADVERTENCIA////////////////////////////////
// SI CAMBIO LA CLASE uSUARIO EN EL CONSTRUPTOR SE JODE LO DEL MAIN
@Entity
public class Usuario implements Serializable {
///////////////////////////////////////////////////////////////ADVERTENCIA////////////////////////////////
///////////////////////////////////////////////////////////////ADVERTENCIA////////////////////////////////
///////////////////////////////////////////////////////////////ADVERTENCIA////////////////////////////////
///////////////////////////////////////////////////////////////ADVERTENCIA////////////////////////////////
// SI CAMBIO LA CLASE uSUARIO EN EL CONSTRUPTOR SE JODE LO DEL MAIN
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @NotNull
    @Size(min = 3, max = 16, message = "El nombre tiene que tener entre 3 y 16 caracteres")
    private String nombre;
    
    @NotNull
    @Size(min = 3, max = 64, message = "El apellido tiene que tener entre 3 y 64 caracteres")
    private String apellido;
    
    @NotNull
    @Size(min = 11, max = 11, message = "El ci tiene que tener 11 caracteres")
    private String ci;
    
    @NotNull
    @Size(min = 3, max = 16, message = "El usuario tiene que tener entre 3 y 16 caracteres")
    private String usuarios;
    
   
    private String pass;
    
    //orphanRemoval = TRUE,
    @OneToMany( mappedBy="usuario",cascade = {CascadeType.REMOVE})
    private List<Denuncia> denuncias=new ArrayList<>();
    
    @OneToMany( mappedBy="usuario",cascade = {CascadeType.REMOVE})
    private List<Notificacion> notificacion=new ArrayList<>();
    
     private String rol;
    private boolean active;

    public Usuario() {
    }

    
    public Usuario(String nombre, String apellido, String ci, String usuarios, String pass, String rol, boolean active) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ci = ci;
        this.usuarios = usuarios;
        this.pass = pass;
        this.rol = rol;
        this.active = active;
    }

    public List<Notificacion> getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(List<Notificacion> notificacion) {
        this.notificacion = notificacion;
    }

    
    public List<Denuncia> getDenuncias() {
        return denuncias;
    }

    public void setDenuncias(List<Denuncia> denuncias) {
        this.denuncias = denuncias;
    }

    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public String getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(String usuarios) {
        this.usuarios = usuarios;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
  
    
}
