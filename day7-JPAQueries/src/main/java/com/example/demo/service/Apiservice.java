package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.car;
import com.example.demo.repository.carRepo;

@Service
public class Apiservice {

	@Autowired
	public carRepo crepo;
	//get the data//
	public List<car> getcar()
	{
		return crepo.findAll();
	}
	//put the data//
	public car updatecar(car cu)
	{
		return crepo.saveAndFlush(cu);
	}
	public List<car> getAllrows()
	{
		return crepo.getAllRows();
	}
	public List<car> getSpecrows(String Carname,String CarType)
	{
		return crepo.getSpecRows(Carname,CarType);
	}
	public List<car>getByName(String Carname)
	{
		return crepo.getByname(Carname);
	}
	//delete the data
	public int deleteRowByid(int id)
	{
		return crepo.deleteId(id);
	}
	public Integer updateRow(String CarType,int id)
	{
		return crepo.updateByid(CarType,id);
	}
}
