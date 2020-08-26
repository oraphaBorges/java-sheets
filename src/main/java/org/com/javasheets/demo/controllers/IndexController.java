package org.com.javasheets.demo.controllers;

import org.com.javasheets.demo.services.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class IndexController{
	
	@Autowired
	FileService fileService;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
    @PostMapping(value="/upload",consumes = {"multipart/form-data"})
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {

        fileService.uploadFile(file);

        return "redirect:/";
    }
}
