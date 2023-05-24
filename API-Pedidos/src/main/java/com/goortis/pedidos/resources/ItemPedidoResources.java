package com.goortis.pedidos.resources;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.goortis.pedidos.domain.ItemPedido;
import com.goortis.pedidos.services.ItemPedidoService;

@RestController
@RequestMapping("/itemsPedidos")
public class ItemPedidoResources {

    @Autowired
    private ItemPedidoService itemPedidoService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<ItemPedido>> listar() {
	return ResponseEntity.status(HttpStatus.OK).body(itemPedidoService.listar());

    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Void> salvar(@Valid @RequestBody ItemPedido item) {
	item = itemPedidoService.salvar(item);

	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(item.getId()).toUri();

	return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> buscar(@PathVariable Long id) {
	Optional<ItemPedido> itemPedido = itemPedidoService.buscar(id);

	CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

	return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(itemPedido);
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
	itemPedidoService.deletar(id);
	return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Void> atualizar(@RequestBody ItemPedido item, @PathVariable Long id) {
	item.setId(id);
	itemPedidoService.atualizar(item);

	return ResponseEntity.noContent().build();
    }

}
