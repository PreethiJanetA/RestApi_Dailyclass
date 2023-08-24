package com.example.demo.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.tmodel;
import com.example.demo.repository.trepo;

@Service
public class tservice {

	@Autowired
	public trepo tr;
	//post the data//
	public String savet(tmodel h)
	{
		tr.save(h);
		return "Happy to see you";
	}
	//get the data//
	public List<tmodel> gett()
	{
		return tr.findAll();
	}
	public Optional<tmodel>getUserid(int id)
	{
		Optional<tmodel> t= tr.findById(id);
		if(t.isPresent())
		{
			return t;
		}
		return null;
	}
}
