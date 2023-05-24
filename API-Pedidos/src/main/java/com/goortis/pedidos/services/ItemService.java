package com.goortis.pedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.goortis.pedidos.domain.Item;
import com.goortis.pedidos.repository.ItemRepository;
import com.goortis.pedidos.services.exceptions.ItemExistenteException;
import com.goortis.pedidos.services.exceptions.ItemNaoEncontradoException;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public List<Item> listar() {

	return itemRepository.findAll();
    }

    public Item salvar(Item item) {

	if (item.getId() != null) {
	    Optional<Item> a = itemRepository.findById(item.getId());

	    if (a != null) {
		throw new ItemExistenteException("O Item já existe.");
	    }
	}

	return itemRepository.save(item);

    }

    public Optional<Item> buscar(Long id) {
	Optional<Item> Item = itemRepository.findById(id);

	if (Item == null) {
	    throw new ItemNaoEncontradoException("O item não pôde ser encontrado.");
	}
	return Item;
    }

    public void deletar(Long id) {
	try {
	    itemRepository.deleteById(id);
	} catch (EmptyResultDataAccessException e) {
	    throw new ItemNaoEncontradoException("O item não pôde ser encontrado.");
	}
    }

    public void atualizar(Item item) {
	verificarExistencia(item);
	itemRepository.save(item);
    }

    private void verificarExistencia(Item item) {
	buscar(item.getId());
    }
}