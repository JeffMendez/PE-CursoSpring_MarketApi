package com.jeffmendez.market.persistence.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

@Embeddable
public class CompraProductoPK implements Serializable {

    @Column(name = "ID_COMPRA")
    private Integer idCompra;

    @Column(name = "ID_PRODUCTO")
    private Integer idProducto;

    // GETTERS AND SETTERS
    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
