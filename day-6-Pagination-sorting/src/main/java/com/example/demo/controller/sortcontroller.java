package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.sortmodel;
import com.example.demo.service.sortservice;

@RestController
public class sortcontroller 
{

	      @Autowired
          public sortservice hserv;
	    //post the data//
	      @PostMapping("/postsort")
	      public String postsort(@RequestBody sortmodel ps)
	      {
	    	  hserv.savesort(ps);
	    	  return "Success";
	      }
	      //get mapping//
	      public List<sortmodel> getsortInfo()
	      {
	    	  return hserv.getsort();
	      }
	      
	      //get Mapping sort by asc//
	      @GetMapping("/sortasc/{name}")
	      public List<sortmodel> sortasc(@PathVariable("name") String name)
	      {
	    	  return hserv.sortByAsc(name);
	      }
	      //Pagination//
	      @GetMapping("/pagination/{num}/{size}")
	      public List<sortmodel> paginationEx(@PathVariable("num") int num,@PathVariable("size") int size)
	      {
	    	  return hserv.pagination(num,size);
	      }
	      //Pagination and sorting//
	      @GetMapping("/paginationsort/{num}/{size}/{name}")
	    	  public List<sortmodel> paginationsorting(@PathVariable("num") int num,@PathVariable("size") int size,@PathVariable("name") String name)
	    	  {
	    		  return hserv.paginationandsorting(num, size, name);
	    	  }
}

