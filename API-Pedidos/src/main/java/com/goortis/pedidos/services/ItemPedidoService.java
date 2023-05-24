package com.goortis.pedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.goortis.pedidos.domain.ItemPedido;
import com.goortis.pedidos.repository.ItemPedidoRepository;
import com.goortis.pedidos.services.exceptions.ItemExistenteException;
import com.goortis.pedidos.services.exceptions.ItemNaoEncontradoException;

@Service
public class ItemPedidoService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    public List<ItemPedido> listar() {

	return itemPedidoRepository.findAll();
    }

    public ItemPedido salvar(ItemPedido itemPedido) {

	if (itemPedido.getId() != null) {
	    Optional<ItemPedido> a = itemPedidoRepository.findById(itemPedido.getId());

	    if (a != null) {
		throw new ItemExistenteException("O Item já existe.");
	    }
	}

	return itemPedidoRepository.save(itemPedido);

    }

    public Optional<ItemPedido> buscar(Long id) {
	Optional<ItemPedido> Item = itemPedidoRepository.findById(id);

	if (Item == null) {
	    throw new ItemNaoEncontradoException("O item não pôde ser encontrado.");
	}
	return Item;
    }

    public void deletar(Long id) {
	try {
	    itemPedidoRepository.deleteById(id);
	} catch (EmptyResultDataAccessException e) {
	    throw new ItemNaoEncontradoException("O item não pôde ser encontrado.");
	}
    }

    public void atualizar(ItemPedido item) {
	verificarExistencia(item);
	itemPedidoRepository.save(item);
    }

    private void verificarExistencia(ItemPedido item) {
	buscar(item.getId());
    }
}