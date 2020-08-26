package org.com.javasheets.demo.controllers;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.com.javasheets.demo.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class IndexController{
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
    @PostMapping(value="/upload",consumes = {"multipart/form-data"})
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes,Model model) {

        if (file.isEmpty()) {
            model.addAttribute("message", "Please select a CSV file to upload.");
            model.addAttribute("status", false);
        } else {

            try {
            	// Leitor do arquivo recebido da requisição POST
            	Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()));

            	// Criado o Objeto CSVFormat
            	// Que define os delimitador entre os itens de cada linha
        		CSVFormat format = CSVFormat.RFC4180.withHeader().withDelimiter(',');
        		CSVParser parser = new CSVParser(reader, format);

        		// Percorrendo os arquivos da lista de acordo com o Objeto desejado
        		// e os identificadores do CSV
        		List<User> users = new ArrayList<User>();
        		for(CSVRecord record : parser){
        			User user = new User();
        			user.setId(Long.parseLong(record.get("id")));
        			user.setName(record.get("name"));
        			user.setEmail(record.get("email"));
        			user.setCountryCode(record.get("country"));
        			user.setAge(Integer.parseInt(record.get("age")));
        			users.add(user);
        		}

        		// fechando o parser
        		parser.close();

                // Passando os objetos para serem enviados na requisão para a página de listagem
        		model.addAttribute("status", true);
        		model.addAttribute("users", users);

            } catch (Exception ex) {
                model.addAttribute("message", "An error occurred while processing the CSV file.");
                model.addAttribute("status", false);
            }
        }
        
        
        return "file-upload-status";
    }
}
