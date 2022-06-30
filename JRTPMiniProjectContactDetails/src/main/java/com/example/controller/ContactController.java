package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Entity.Contact;
import com.example.Service.ContactServiceImpl;

@Controller
public class ContactController {

	@Autowired
	private ContactServiceImpl serviceimpl;

	@GetMapping("/loadform")
	public String loadForm(Model model) {

		model.addAttribute("contact", new Contact());
		return "index";
	}
	
	@PostMapping("/saveContact") 
	public String saveForm(Contact contact,Model model ) {
		boolean saveContact =serviceimpl.saveContact(contact);
			  
			 if(saveContact) {
				 model.addAttribute("successmsg","record is saved succesfully"); }
			  else {
				  model.addAttribute("failuremsg","record is saved succesfully"); }
			  
			  return "index";
			  }

	/* this is for handling double posting
	 * @PostMapping("/saveContact") public String saveForm(Contact contact,Model
	 * model RedirectAttributes attributes) { boolean saveContact =
	 * serviceimpl.saveContact(contact);
	 * 
	 * if(saveContact) {
	 * attributes.addFlashAttribute("successmsg","record is saved succesfully"); }
	 * else {
	 * attributes.addFlashAttribute("failuremsg","record is saved succesfully"); }
	 * 
	 * return "redirect:/successMessage"; }
	 */
	/*
	 * @GetMapping("/successMessage") public String doubleposting(Model model) {
	 * 
	 * model.addAttribute("contact",new Contact());
	 * 
	 * return "index"; }
	 */
	@GetMapping("/findallrecords")
	public String findAllRecords(Model model) {
		List<Contact> listofrecords = serviceimpl.getAllContacts();
		model.addAttribute("contact",listofrecords);
		
	return "viewallrecords";	
	}
	
	
	
	
	@GetMapping("/edit")
	public String editClickButton(@RequestParam("cid") Integer cid,Model model) {
		//boolean updateContact = serviceimpl.updateContact(cid);
		Contact contactById = serviceimpl.getContactById(cid);
	model.addAttribute("contact",contactById);
		
		return "index";
	}
	
	
	@GetMapping("/delete")
	public String deleteClickButton(@RequestParam("cid") Integer cid) {
		//boolean updateContact = serviceimpl.updateContact(cid);
		boolean deleteContact = serviceimpl.deleteContact(cid);
	//model.addAttribute("contact",deleteContact);
		
		return "redirect:/findallrecords";
	}

}
