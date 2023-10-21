package com.tp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tp.entities.client;
import com.tp.repository.clientRepository;

@Service
public class clientService
{
	@Autowired
	clientRepository cr;

	public List<client> getAllClient(){return cr.findAll();}
	public client creatClient(client c) {return cr.save(c);}
	public void deleteClient(client c) {cr.delete(c);}
	public void deleteClientById(Long id) {cr.deleteById(id);}
	public client updateClient(client c) {return cr.save(c);}


}
