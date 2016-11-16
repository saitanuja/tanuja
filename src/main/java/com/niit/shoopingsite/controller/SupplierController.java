package com.niit.shoopingsite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.niit.shopping.model.Supplier;
import com.niit.shoppingsite.dao.SupplierDAO;

@Controller
public class SupplierController {
	
	@Autowired
	private SupplierDAO supplierDAO;
	@RequestMapping(value="/Supplier")
	public ModelAndView getAllData(@ModelAttribute("supplier")Supplier supplier,BindingResult result,Model model)
	{
		ModelAndView mv = new ModelAndView("/index");
		mv.addObject("allData",supplierDAO.list());
		mv.addObject("UserClickedsuppliers","true");
			return mv;
		}
	@RequestMapping(value="/addSupplier",method = RequestMethod.POST)
	   public String addItem(@ModelAttribute("supplier") Supplier supplier){
			
			this.supplierDAO.save(supplier);
			return "redirect:/Supplier";
			}
	@RequestMapping(value="/editBySupplier/{sid}",method = RequestMethod.GET)
	public String editProduct(@PathVariable("sid") int sid, RedirectAttributes attributes) {
		System.out.println("editsupllier");
		attributes.addFlashAttribute("supplier", this.supplierDAO.get(sid));
		
		return "redirect:/Supplier";
	}
	@RequestMapping(value="/deleteBySupplier/{sid}",method = RequestMethod.GET)
	public String deleteItem(@PathVariable("sid") int sid)
	{
		supplierDAO.delete(sid);
		return "redirect:/Supplier";
		
}
}
