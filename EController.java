package com.example.manish11.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.manish11.Repository.Erepo;
import com.example.manish11.model.Edemo;


@Controller
public class EController {
@Autowired
Erepo erepo;

@RequestMapping("index")
public String index() {
	return "index.jsp";
}
@RequestMapping("addemp")
public String addemp(Edemo edemo)
{
	erepo.save(edemo);
	return "index.jsp";
}
@RequestMapping("getemp")
public ModelAndView getemp(@RequestParam int id)
{
	ModelAndView mv = new ModelAndView("displaay.jsp");
	Edemo edemo = erepo.findById(id).orElse(new Edemo());
	mv.addObject(edemo);
	return mv;
}
@RequestMapping("deleteEmp")
public ModelAndView deleteEmp(@RequestParam int id)
{
	ModelAndView mv = new ModelAndView("delete.jsp");
	Edemo edemo = erepo.findById(id).orElse(new Edemo());
	erepo.deleteById(id);
	mv.addObject(edemo);
	return mv;

}
@RequestMapping("updateEmp")
public ModelAndView updateEmp(@RequestParam int id)
{
	ModelAndView mv = new ModelAndView("update.jsp");
	Edemo edemo = erepo.findById(id).orElse(new Edemo());
	mv.addObject(edemo);
	return mv;
}
}

