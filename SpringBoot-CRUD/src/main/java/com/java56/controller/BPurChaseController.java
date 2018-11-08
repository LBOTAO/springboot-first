package com.java56.controller;
import java.io.PrintWriter;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.java56.entity.BPurChase;
import com.java56.service.BPurChaseService;
@Controller
@RequestMapping("/bPurChase")
public class BPurChaseController {
	@Resource
	private BPurChaseService bPurChaseService;
	@RequestMapping("/list")
	public ModelAndView BPurChaseList(@RequestParam(required=true,defaultValue="1") Integer page,BPurChase bPurChase){
		   ModelAndView mav=new ModelAndView();
		   PageHelper.startPage(page, 5);
		   List<BPurChase> list = bPurChaseService.findAll(bPurChase);
		   PageInfo<BPurChase> pageInfo=new PageInfo<BPurChase>(list);
		   mav.addObject("list", list);
		   mav.addObject("page", pageInfo);
	       mav.setViewName("bPurChase");
	       return mav;
	}
	@RequestMapping("/add")
	public void BPurChaseAdd(BPurChase bPurChase,PrintWriter out){
		try {
			Boolean result = bPurChaseService.addBPurChase(bPurChase);
			if(result){
				out.println("{\"result\":\"true\"}");
			 }
			} catch (Exception e) {
				out.println("{\"result\":\"false\"}");
				e.printStackTrace();
		}
	}
	@RequestMapping("/bPurChase/{id}")
	@ResponseBody
	public BPurChase bPurChase(@PathVariable("id") String id){
		  BPurChase bPurChase = bPurChaseService.findBPurChase(id);
	      return bPurChase;
	}
	@RequestMapping(value="/delete/{id}",method=RequestMethod.GET)
	public String  BPurChaseDelete(@PathVariable("id") String id){
			 bPurChaseService.deleteBPurChase(id);
			 return "redirect:/bPurChase/list";
	}
	@RequestMapping(value="/update")
	public void  BPurChaseUpdate(BPurChase bPurChase,PrintWriter out){
		try {
			Boolean result = bPurChaseService.updateBPurChase(bPurChase);
			if(result){
				out.println("{\"result\":\"true\"}");
			}
		} catch (Exception e) {
			out.println("{\"result\":\"false\"}");
			e.printStackTrace();
		}
	}
	@RequestMapping("/deletes")
	public void  BPurChaseDeletes(HttpServletRequest request,PrintWriter out){
		     String parameter = request.getParameter("id");
		     try {
		    	 String[] ids = parameter.split(",");
		    	 int result=0;
		    	 for(int i=0;i<ids.length;i++){
		    		 bPurChaseService.deleteBPurChase(ids[i]);
		    		 result++;
		    	 }
		    	 if(result>0){
		    		 out.println("{\"result\":\"true\"}");
		    	 }
			} catch (Exception e) {
				out.println("{\"result\":\"false\"}");
				e.printStackTrace();
			}
	}
}
