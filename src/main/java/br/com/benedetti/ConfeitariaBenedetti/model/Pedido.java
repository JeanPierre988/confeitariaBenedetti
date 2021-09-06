package br.com.benedetti.ConfeitariaBenedetti.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal precoPedido;
    private LocalDateTime dataPedido = LocalDateTime.now();
    private LocalDateTime dataEntregaPedido;
    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido = StatusPedido.ORCAMENTO;

    public Pedido() {}

    public Pedido(BigDecimal precoPedido, LocalDateTime dataEntregaPedido) {
        this.precoPedido = precoPedido;
        this.dataPedido = dataPedido;
        this.dataEntregaPedido = dataEntregaPedido;
        this.statusPedido = statusPedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrecoPedido() {
        return precoPedido;
    }

    public void setPrecoPedido(BigDecimal precoPedido) {
        this.precoPedido = precoPedido;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public LocalDateTime getDataEntregaPedido() {
        return dataEntregaPedido;
    }

    public void setDataEntregaPedido(LocalDateTime dataEntregaPedido) {
        this.dataEntregaPedido = dataEntregaPedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }
}
