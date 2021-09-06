package br.com.benedetti.ConfeitariaBenedetti.controller;

import br.com.benedetti.ConfeitariaBenedetti.controller.form.AtualizacaoPedidoForm;
import br.com.benedetti.ConfeitariaBenedetti.dto.DetalhesPedidoDto;
import br.com.benedetti.ConfeitariaBenedetti.dto.PedidoDto;
import br.com.benedetti.ConfeitariaBenedetti.controller.form.PedidoForm;
import br.com.benedetti.ConfeitariaBenedetti.model.Pedido;
import br.com.benedetti.ConfeitariaBenedetti.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.transaction.Transactional;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    PedidoRepository pedidoRepository;

    @GetMapping
    public Page<PedidoDto> listaPedido(@RequestParam int page, @RequestParam int qtd, @RequestParam String ordenacao){
        Pageable paginacao = PageRequest.of(page, qtd, Sort.Direction.ASC, ordenacao);

        Page<Pedido> pedidosList = pedidoRepository.findAll(paginacao);
        return PedidoDto.convert(pedidosList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalhesPedidoDto> detalhes(@PathVariable Long id){
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isPresent()){
            return ResponseEntity.ok(new DetalhesPedidoDto(pedido.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<PedidoDto> cadastrar(@RequestBody PedidoForm form, UriComponentsBuilder uriBuilder){
        Pedido pedido = PedidoForm.convert();
        pedidoRepository.save(pedido);

        URI uri = uriBuilder.path("/pedidos/{id}").buildAndExpand(pedido.getId()).toUri();
        return ResponseEntity.created(uri).body(new PedidoDto(pedido));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<PedidoDto> atualizar(@PathVariable Long id, @RequestBody AtualizacaoPedidoForm form){
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isPresent()) {
            Pedido atualizar = form.atualizar(id, pedidoRepository);
            return ResponseEntity.ok(new PedidoDto(atualizar));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<PedidoDto> deleta(@PathVariable Long id){
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        if (pedido.isPresent()){
            pedidoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
