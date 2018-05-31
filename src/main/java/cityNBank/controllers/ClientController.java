package cityNBank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cityNBank.entities.Client;
import cityNBank.service.interfaces.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	// Adding data to model for form on JSP
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("client", new Client());
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET })
	public String listOfClients(Model model) {
		model.addAttribute("clientList", clientService.findAll());
		return "listOfClients";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("client") Client client, ModelMap attributes) {
		clientService.save(client);
		return "redirect:/client/list";
	}

}
