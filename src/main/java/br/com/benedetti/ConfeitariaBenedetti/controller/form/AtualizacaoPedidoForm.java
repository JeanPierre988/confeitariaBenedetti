package br.com.benedetti.ConfeitariaBenedetti.controller.form;

import br.com.benedetti.ConfeitariaBenedetti.model.Pedido;
import br.com.benedetti.ConfeitariaBenedetti.model.StatusPedido;
import br.com.benedetti.ConfeitariaBenedetti.repository.PedidoRepository;

import java.math.BigDecimal;

public class AtualizacaoPedidoForm {
    private StatusPedido statusPedido;

    public Pedido atualizar(Long id, PedidoRepository pedidoRepository){
        Pedido pedido = pedidoRepository.getById(id);
        pedido.setStatusPedido(this.statusPedido);
        return pedido;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }
}
