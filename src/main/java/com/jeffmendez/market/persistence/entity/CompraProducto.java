package com.jeffmendez.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "COMPRAS_PRODUCTOS")
public class CompraProducto  {

    @EmbeddedId
    public CompraProductoPK id;

    @Column(name = "CANTIDAD")
    public Integer cantidad;

    @Column(name = "TOTAL")
    public Double total;

    @Column(name = "ESTADO")
    public String estado;

    // FOREIGN KEYS
    @ManyToOne
    @MapsId("idCompra")
    @JoinColumn(name = "ID_COMPRA", insertable = false, updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "ID_PRODUCTO", insertable = false, updatable = false)
    private Compra producto;

    // GETTERS AND SETTERS
    public CompraProductoPK getId() {
        return id;
    }

    public void setId(CompraProductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Compra getProducto() {
        return producto;
    }

    public void setProducto(Compra producto) {
        this.producto = producto;
    }
}
