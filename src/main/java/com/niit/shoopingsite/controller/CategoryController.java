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

import com.niit.shopping.model.Category;
import com.niit.shoppingsite.dao.CategoryDAO;

@Controller
public class CategoryController {
	@Autowired
	private CategoryDAO categoryDAO;
	@RequestMapping(value="/Category")
	public ModelAndView getAllData(@ModelAttribute("category")Category category,BindingResult result,Model model)
	{
		ModelAndView mv = new ModelAndView("/index");
	mv.addObject("categoryList",categoryDAO.list());
	mv.addObject("UserClickedCategorys","true");
		return mv;
	}
	@RequestMapping(value="/addCategory",method = RequestMethod.POST)
	   public String addItem(@ModelAttribute("category") Category category){
			
			this.categoryDAO.save(category);
			return "redirect:/Category";
			}
	@RequestMapping(value="/editBycid/{cid}",method = RequestMethod.GET)
	public String editCategory(@PathVariable("cid") int cid, RedirectAttributes attributes) {
		System.out.println("editCategory");
		attributes.addFlashAttribute("category", this.categoryDAO.get(cid));
		
		return "redirect:/Category";
	}	
	@RequestMapping(value="/deleteBycid/{cid}",method = RequestMethod.GET)
	public String deleteItem(@PathVariable("cid") int cid)
	{
		categoryDAO.delete(cid);
		return "redirect:/Category";
		
}
}
