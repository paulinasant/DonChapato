package com.daw.DonChapato.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "Orden_Producto")
public class OrdenProducto {
    @EmbeddedId
    private OrdenProductoId id;

    @ManyToOne
    @MapsId("idOrden")
    @JoinColumn(name = "ID_Orden")
    private Orden orden;

    @ManyToOne
    @MapsId("idProducto")
    @JoinColumn(name = "ID_Producto")
    private Producto producto;

    // Getters y Setters
    public OrdenProductoId getId() {
        return id;
    }

    public void setId(OrdenProductoId id) {
        this.id = id;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Embeddable
    public static class OrdenProductoId implements Serializable {
        private Long idOrden;
        private Long idProducto;

        // Getters y Setters
        public Long getIdOrden() {
            return idOrden;
        }

        public void setIdOrden(Long idOrden) {
            this.idOrden = idOrden;
        }

        public Long getIdProducto() {
            return idProducto;
        }

        public void setIdProducto(Long idProducto) {
            this.idProducto = idProducto;
        }


    }
}