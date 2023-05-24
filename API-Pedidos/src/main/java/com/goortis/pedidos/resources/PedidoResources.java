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

import com.goortis.pedidos.domain.Pedido;
import com.goortis.pedidos.services.PedidoService;

@RestController
@RequestMapping("/pedidos")
public class PedidoResources {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<Pedido>> listar() {
	return ResponseEntity.status(HttpStatus.OK).body(pedidoService.listar());

    }

    @PostMapping(produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Void> salvar(@Valid @RequestBody Pedido pedido) {

	pedido = pedidoService.salvar(pedido);

	URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pedido.getCodPedido())
		.toUri();

	return ResponseEntity.created(uri).build();
    }

    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> buscar(@PathVariable Long id) {
	Optional<Pedido> pedido = pedidoService.buscar(id);

	CacheControl cacheControl = CacheControl.maxAge(20, TimeUnit.SECONDS);

	return ResponseEntity.status(HttpStatus.OK).cacheControl(cacheControl).body(pedido);
    }

    @GetMapping(value = "/{codPedido}/cliente/{idCliente}", produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> buscarPedidoPorCliente(@PathVariable Long codPedido,
	    @PathVariable Long idCliente) {
	Pedido pedidos = pedidoService.buscarPedidoPorCliente(codPedido, idCliente);

	return ResponseEntity.status(HttpStatus.OK).body(pedidos);
    }

    @GetMapping(value = "/cliente/{idCliente}", produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> buscarTodosPedidosDoCliente(@PathVariable Long idCliente) {
	List<Pedido> pedidos = pedidoService.buscarTodosPedidosDoCliente(idCliente);

	return ResponseEntity.status(HttpStatus.OK).body(pedidos);
    }

    @GetMapping(value = "/data/{dd}/{mm}/{yyyy}", produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> buscarTodosPedidosPorData(@PathVariable Integer dd, @PathVariable Integer mm,
	    @PathVariable Integer yyyy) {
	List<Pedido> pedidos = pedidoService.buscarTodosPedidosPorData(dd, mm, yyyy);

	return ResponseEntity.status(HttpStatus.OK).body(pedidos);
    }

    @DeleteMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
	pedidoService.deletar(id);
	return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Void> atualizar(@RequestBody Pedido pedido, @PathVariable Long id) {
	pedido.setCodPedido(id);
	pedidoService.atualizar(pedido);

	return ResponseEntity.noContent().build();
    }

}
