package br.com.benedetti.ConfeitariaBenedetti.dto;

import br.com.benedetti.ConfeitariaBenedetti.model.Pedido;
import br.com.benedetti.ConfeitariaBenedetti.model.StatusPedido;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PedidoDto {
    private Long id;
    private BigDecimal precoPedido;
    private StatusPedido statusPedido;

    public PedidoDto(Pedido p) {
        this.id = p.getId();
        this.precoPedido = p.getPrecoPedido();
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

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }
}
