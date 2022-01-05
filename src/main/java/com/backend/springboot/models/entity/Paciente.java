package com.backend.springboot.models.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pacientes")
public class Paciente implements Serializable {

    // ATRIBUTOS DE LA CLASE

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // validadores del formulario
    @NotEmpty(message = "no puede estar vacio")
    @Size(min=4, max=20, message = "debe tener entre 4 y 20 caracteres")
    @Column(nullable = false)
    private String nombre;

    @NotEmpty(message = "no puede estar vacio")
    private String apellido;

    @NotNull(message = "no puede estar vacio")
    @Column(name = "documento_identidad", nullable = false, unique = true)
    private Long documentoIdentidad;

    private String genero;

    @Column(name = "lugar_nacimiento")
    private String lugarNacimiento;

    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;

    @Column(name = "tipo_sangre")
    private String tipoSangre;

    private String eps;

    private String direccion;

    private Long telefono;

    private String email;

    @Column(name = "estado_civil")
    private String estadoCivil;

    // Relacion de un cliente para muchas consultass
    @JsonIgnoreProperties({"paciente", "hibernateLazyInitializer", "handler"})
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "paciente", cascade = CascadeType.ALL)
    private List<Consulta> consultas;

    public Paciente() {
        this.consultas = new ArrayList<>();
    }


    // GETTERS AND SETTERS DE LOS ATRIBUTOS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(Long documentoIdentidad) {
        this.documentoIdentidad = documentoIdentidad;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLugarNacimiento() {
        return lugarNacimiento;
    }

    public void setLugarNacimiento(String lugarNacimiento) {
        this.lugarNacimiento = lugarNacimiento;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public String getEps() {
        return eps;
    }

    public void setEps(String eps) {
        this.eps = eps;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public List<Consulta> getConsultas() {
        return consultas;
    }

    public void setConsultas(List<Consulta> consultas) {
        this.consultas = consultas;
    }

    private static final long serialVersionUID = 1L;
}
