package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.sortmodel;
import com.example.demo.repository.sortrepo;

@Service
public class sortservice {

	@Autowired
	public sortrepo ss;
	//post the data//
	public String savesort(sortmodel e)
	{
		ss.save(e);
		return "Successfull";
	}
	//get the data//
	public List<sortmodel> getsort()
	{
		return ss.findAll();
	}
	//sorting//
	public List<sortmodel> sortByAsc(String name)
	{
		return ss.findAll(Sort.by(name).ascending());
	}
	
	//Pagination
	public List<sortmodel> pagination(int pageNu,int pageSize)
	{
		Page<sortmodel> cont = ss.findAll(PageRequest.of(pageNu,pageSize));
		//of is a method 
		return cont.getContent();
	}
	//Pagination and sorting//
	public List<sortmodel> paginationandsorting(int pageNu,int pageSize,String name)
	{
		Page<sortmodel> cont1 = ss.findAll(PageRequest.of(pageNu,pageSize,Sort.by(name)));
		//of is a method 
		return cont1.getContent();
	}
}
