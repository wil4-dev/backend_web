package com.ista.springboot.web.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ista.springboot.web.app.models.dao.IClienteDao;
import com.ista.springboot.web.app.models.entity.Cliente;

import jakarta.transaction.Transactional;


@Service
public class ClienteServiceImplement implements IClienteService {

	@Autowired	
	private IClienteDao clienteDao;
	
	@Override
	public List<Cliente> findAll() {
		return (List<Cliente>) clienteDao.findAll();
	}

	@Override
	public Cliente findById(Long id) {
		return clienteDao.findById(id).orElse(null);
	}
	
	@Override
	@Transactional
	public Cliente save(Cliente cliente) {		
		return clienteDao.save(cliente);
	}	

	@Override
	@Transactional
	public void delete(Long id) {
		clienteDao.deleteById(id);
	}

	
}
