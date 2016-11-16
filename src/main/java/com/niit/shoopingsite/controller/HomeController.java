package com.niit.shoopingsite.controller;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String gotoHome()
	{
		return "index";
	}

	@RequestMapping("/register")
	public String register(Model m)
	{
		m.addAttribute("registerMessage","your successfully logged in");
		return "index";
		
	}
@RequestMapping("/validate")
public String validate(@RequestParam(name="userID") String id, @RequestParam(name="password") String pwd, Model model,HttpSession session)
{
if (id.equals("niit") && pwd.equals("niit"))
	{
		/*model.addAttribute("SucessMessage","You sucessfully logged in");*/
		session.setAttribute("SucessMessage","You sucessfully logged in");
		return "success";
	}
else 
{
		model.addAttribute("errorMessage","Invalid Credentials... please try again");
		return "index";
}

//SPA
}
	
@RequestMapping("/login")
public  ModelAndView login(Model model)
{
	ModelAndView mv=new ModelAndView("index");
	model.addAttribute("UserClickedLogin","true");
	return mv;
}


@RequestMapping("/registerHere")
public ModelAndView registerHere()
{
	ModelAndView mv=new ModelAndView("index");
	mv.addObject("UserClickedRegister","true");
	return mv;
}
/*@RequestMapping("/admin")
public ModelAndView admin(){
	ModelAndView mv=new ModelAndView("index");
	mv.addObject("UserClickedAdmin","true");
	return mv;
}*/

/*@RequestMapping("/category")
public  ModelAndView Category(Model model)
{
	ModelAndView mv=new ModelAndView("index");
	model.addAttribute("UserClickedcategory","true");
	return mv;
}
 @RequestMapping("/products")
public  ModelAndView products(Model model)
{
	ModelAndView mv=new ModelAndView("index");
	model.addAttribute("UserClickedProducts","true");
	return mv;
}
@RequestMapping("/suppliers")
public  ModelAndView suppliers(Model model)
{
	ModelAndView mv=new ModelAndView("index");
	model.addAttribute("UserClickedsupliers","true");
	return mv;
}*/


}



