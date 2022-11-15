package com.exercise.spring;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.exercise.spring.dao.ISimpleBbsDao;
import com.exercise.spring.service.ISimpleBbsService;


@Controller
public class MyController {
	
	@Autowired
	private ISimpleBbsService Bservice;
	
	@RequestMapping("/")
	public String root() throws Exception {
		return "redirect:list";
	}
	
	@RequestMapping("/list")
	public String userlistPage(Model model) {
		
		model.addAttribute("list", Bservice.list());
		
		int nTotalCount = Bservice.count();
		System.out.println("Count : " + nTotalCount);
		
		return "list";
	}
	
	@RequestMapping("/view")
	public String view(HttpServletRequest request, Model model) {
		
		String sId = request.getParameter("id");
		model.addAttribute("dto", Bservice.view(sId));
		
		return "view";
	}
	
	@RequestMapping("/writeForm")
	public String writeForm() {
		
		return "writeForm";
	}
	
	@RequestMapping("/write")
	public String write(HttpServletRequest request, Model model) {
		
		String sName = request.getParameter("writer");
		String sTitle = request.getParameter("title");
		String sContent = request.getParameter("content");
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("item1", sName);
		map.put("item2", sTitle);
		map.put("item1", sContent);
		
		int nResult = Bservice.write(map);
		System.out.println("write : " + nResult);
		
		return "redirect:list";
	}

	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		
		String sId = request.getParameter("id");
		int sResult = Bservice.delete(sId);
		
		System.out.println("delete : " + sResult);
		return "redirect:list";
	}
}
