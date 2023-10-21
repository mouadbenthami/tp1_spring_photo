package com.tp.controler;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.tp.entities.client;
import com.tp.services.clientService;

import jakarta.servlet.annotation.MultipartConfig;

@MultipartConfig
@CrossOrigin(origins = "*")
@RestController
public class clientContorler
{
	@Autowired
	clientService cs;

	@GetMapping("client")
	public List<client> getAllClient()
	{
		return cs.getAllClient();
	}

	@PostMapping("client")
	public client addClient(@RequestBody client c)
	{
		return cs.creatClient(c);
	}

	@PutMapping("client")
	public client update
	      (
			@RequestParam long id,
			@RequestParam String name,
			@RequestParam int age,
			@RequestParam  MultipartFile file
		  ) throws IllegalStateException, IOException
	{
		String path="src/main/resources/static/photos/"+id+".png";
		file.transferTo(Path.of(path));
		String url="http://localhost:8080/photos/"+id+".png";
		client c=new client(id,name,age,url);
		return cs.creatClient(c);
	}

	@DeleteMapping("client/{id}")
	public void deleteClient(@PathVariable Long id)
	{
		String path="src/main/resources/static/photos/"+id+".png";
		File f=new File(path);
		if (f.exists())f.delete();
	   cs.deleteClientById(id);
	}


}
