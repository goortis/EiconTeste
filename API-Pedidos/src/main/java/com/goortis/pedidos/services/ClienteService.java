package com.goortis.pedidos.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.goortis.pedidos.domain.Cliente;
import com.goortis.pedidos.repository.ClienteRepository;
import com.goortis.pedidos.services.exceptions.ClienteExistenteException;
import com.goortis.pedidos.services.exceptions.ClienteNaoEncontradoException;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> listar() {

	return clienteRepository.findAll();
    }

    public Cliente salvar(Cliente cliente) {

	if (cliente.getId() != null) {
	    Optional<Cliente> a = clienteRepository.findById(cliente.getId());

	    if (a != null) {
		throw new ClienteExistenteException("O cliente já existe.");
	    }
	}

	return clienteRepository.save(cliente);

    }

    public Optional<Cliente> buscar(Long id) {
	Optional<Cliente> cliente = clienteRepository.findById(id);

	if (cliente == null) {
	    throw new ClienteNaoEncontradoException("O cliente não pôde ser encontrado.");
	}
	return cliente;
    }

    public void deletar(Long id) {
	try {
	    clienteRepository.deleteById(id);
	} catch (EmptyResultDataAccessException e) {
	    throw new ClienteNaoEncontradoException("O cliente não pôde ser encontrado.");
	}
    }

    public void atualizar(Cliente cliente) {
	verificarExistencia(cliente);
	clienteRepository.save(cliente);
    }

    private void verificarExistencia(Cliente cliente) {
	buscar(cliente.getId());
    }
}