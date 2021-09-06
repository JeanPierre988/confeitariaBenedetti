package br.com.benedetti.ConfeitariaBenedetti.repository;

import br.com.benedetti.ConfeitariaBenedetti.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
