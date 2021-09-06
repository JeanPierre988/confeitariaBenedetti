package br.com.benedetti.ConfeitariaBenedetti.controller.form;

import br.com.benedetti.ConfeitariaBenedetti.model.Pedido;
import br.com.benedetti.ConfeitariaBenedetti.model.StatusPedido;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PedidoForm {
    private static BigDecimal precoPedido;
    private static LocalDateTime dataPedido;
    private static LocalDateTime dataEntregaPedido;
    private static StatusPedido statusPedido;

    public static Pedido convert(){
        return new Pedido(precoPedido, dataEntregaPedido);
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
