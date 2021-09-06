package br.com.benedetti.ConfeitariaBenedetti.dto;

import br.com.benedetti.ConfeitariaBenedetti.model.Pedido;
import br.com.benedetti.ConfeitariaBenedetti.model.StatusPedido;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class DetalhesPedidoDto {
    private Long id;
    private BigDecimal precoPedido;
    private LocalDateTime dataPedido;
    private LocalDateTime dataEntregaPedido;
    private StatusPedido statusPedido;

    public DetalhesPedidoDto(Pedido p) {
        this.id = p.getId();
        this.precoPedido = p.getPrecoPedido();
        this.dataPedido = p.getDataPedido();
        this.dataEntregaPedido = p.getDataEntregaPedido();
        this.statusPedido = p.getStatusPedido();
    }

    public static Page<PedidoDto> convert(Page<Pedido> pedidosList) {
        return pedidosList.map(PedidoDto::new);
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getPrecoPedido() {
        return precoPedido;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public LocalDateTime getDataEntregaPedido() {
        return dataEntregaPedido;
    }
}
