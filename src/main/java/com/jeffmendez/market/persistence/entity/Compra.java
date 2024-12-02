package com.jeffmendez.market.persistence.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "COMPRAS")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMPRA")
    private Integer idCompra;

    @Column(name = "ID_CLIENTE")
    private String idCliente;

    @Column(name = "FECHA")
    private LocalDateTime fecha;

    @Column(name = "MEDIO_PAGO")
    private String medioPago;

    @Column(name = "COMENTARIO")
    private String comentario;

    @Column(name = "ESTADO")
    private String estado;

    // FOREIGN KEYS
    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE", insertable = false, updatable = false)
    private Cliente cliente;

    @OneToMany(mappedBy = "compra", cascade = {CascadeType.ALL})
    private List<CompraProducto> productos;

    // GETTERS AND SETTERS
    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<CompraProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<CompraProducto> productos) {
        this.productos = productos;
    }
}
