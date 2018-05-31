package cityNBank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cityNBank.entities.Account;
import cityNBank.service.interfaces.AccountService;
import cityNBank.service.interfaces.ClientService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private ClientService clientService;

	@Autowired
	private AccountService accountService;

	// Adding data to model for form on JSP
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("account", new Account());
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET })
	public String listOfClients(Model model, Long id) {
		// In case of no user id we will return list of all accounts, else return user
		// accounts
		if (id == null) {
			model.addAttribute("accountList", accountService.findAll());
			model.addAttribute("clientId", 0);
		} else {
			model.addAttribute("accountList", clientService.getAccounts(id));
			model.addAttribute("clientId", id);
		}
		return "listOfAccounts";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute("account") Account account, Long clientId, ModelMap attributes) {
		accountService.save(account, clientId);
		return ("redirect:/account/list?id=" + clientId);
	}

}
