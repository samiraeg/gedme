/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package liias.desarrolloweb.libros.Modelo;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.UniqueElements;

/**
 *
 * @author Ale
 */
// el user y el pass estan en la clase LibrosApplicationTests user ale y pass 678
@Entity
public class Denuncia implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 3, max = 16, message = "El nombre tiene que tener entre 3 y 16 caracteres")
    @NotNull
    private String nombre;

    @Size(min = 3, max = 64, message = "El apellido tiene que tener entre 3 y 16 caracteres")
    @NotNull
    private String apellido;

    @Size(min = 11, max = 11, message = "El ci tiene que tener 11 caracteres")
    @NotNull
    private String Ci;

    @Size(min = 3, max = 300, message = "La descripcion debe ser entre 5 y 300 caracteres")
    @NotNull
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "area_id")
    private Area area;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    @OneToOne( mappedBy="denuncia",cascade = {CascadeType.REMOVE})
    private Reporte reporte;
    
    
    @Enumerated(EnumType.STRING)
    private Catego categoria;
    @Enumerated(EnumType.STRING)
    private Tipo tipo;

    public Denuncia() {
    }

    public Reporte getReporte() {
        return reporte;
    }

    public void setReporte(Reporte reporte) {
        this.reporte = reporte;
    }

    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Catego getCategoria() {
        return categoria;
    }

    public void setCategoria(Catego categoria) {
        this.categoria = categoria;
    }

   

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
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
        return Ci;
    }

    public void setCi(String Ci) {
        this.Ci = Ci;
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
