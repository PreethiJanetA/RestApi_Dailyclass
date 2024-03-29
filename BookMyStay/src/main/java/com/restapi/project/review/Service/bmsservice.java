package com.restapi.project.review.Service;
import java.util.List;
//import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.restapi.project.review.Model.bmsmodel;
import com.restapi.project.review.Repository.bmsrepo;

@Service       
public class bmsservice {

	@Autowired    
	public bmsrepo hb;
	//post the data//
	public String savebms(bmsmodel b)
	{
		hb.save(b);
		return "Data is filled successfully";
	}
	//get the data//
	public List<bmsmodel> getbms()
	{
		return hb.findAll();
	}
//	delete the data//
	public void deletebms(int id)
	{
		System.out.println("Delete");
		hb.deleteById(id);
	}
//	//get with id//
//	public Optional<bmsmodel>getUserid(int userid)
//	{
//       Optional<bmsmodel>bms=hb.findById(userid);
//       if(bms.isPresent())
//       {
//    	   return bms;
//       }
//       return null;
//	}
//	//update the data//
//	public bmsmodel updatebms(bmsmodel bm)
//	{
//		return hb.saveAndFlush(bm);
//	}
//	//delete the data//
//	public void deletebms(int id)
//	{
//		System.out.println("Delete");
//		hb.deleteById(id);
//	}
//	//delete with id//
//	public boolean deletebmsif(int bmsId)
//	{
//		if(hb.existsById(bmsId))
//		{
//			hb.deleteById(bmsId);
//		    return true;
//	}
//	return false;
//}
//	//update with id//
//	public boolean updatebmsif(int bmsId,bmsmodel bm)
//	{
//		if(hb.existsById(bmsId))
//		{
//			hb.save(bm);
//			return true;
//		}
//		return false;
//	}
	public List<bmsmodel>sortByAsc(String  cost)
	{
		return hb.findAll(Sort.by(cost).ascending());
	}
	public List<bmsmodel> pagination(int pgno,int pgs)
	{
		Page<bmsmodel> cont=hb.findAll(PageRequest.of(pgno,pgs));
		return cont.getContent();
	}
	public List<bmsmodel>paginationAndSorting(int pgno,int pgs,String cost)
	{
		Page<bmsmodel> cont1=hb.findAll(PageRequest.of(pgno,pgs,Sort.by(cost)));
		return cont1.getContent();
	}
}
