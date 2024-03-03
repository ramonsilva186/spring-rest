package br.com.springrest.controller;

import br.com.springrest.entity.Pedido;
import br.com.springrest.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/pedido")
public class PedidoController {

    @Autowired
    private PedidoService service;

    @PostMapping(value = "/save")
    public ResponseEntity<Pedido> salvarProduto(@RequestBody Pedido produto) {
        produto = service.save(produto);
        return ResponseEntity.ok().body(produto);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pedido> buscarProduto(@PathVariable Long id) {
        Pedido pedido = service.findById(id);
        return ResponseEntity.ok().body(pedido);
    }

    @GetMapping(value = "/buscar-todos")
    public ResponseEntity<List<Pedido>> buscaTodosProdutos() {
        List<Pedido> pedidos = service.findAll();
        return ResponseEntity.ok().body(pedidos);
    }
}
