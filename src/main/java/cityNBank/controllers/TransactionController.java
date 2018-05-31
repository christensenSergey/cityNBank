package cityNBank.controllers;

import java.util.EnumSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cityNBank.entities.Transaction;
import cityNBank.service.interfaces.TransactionService;
import cityNBank.utils.TransactionType;

@Controller
@RequestMapping(value = "/transaction")
public class TransactionController {
	@Autowired
	private TransactionService transactionService;

	private Set<TransactionType> payTypes = EnumSet.allOf(TransactionType.class);

	// Adding data to model for form on JSP
	@ModelAttribute
	public void addAttributes(Model model) {
		model.addAttribute("transaction", new Transaction());
		// deleting types unnecessary for GIU
		payTypes.remove(TransactionType.DENIED);
		model.addAttribute("payTypes", payTypes);
	}

	@RequestMapping(value = "/list", method = { RequestMethod.GET })
	public String listOfTransactions(Model model) {
		model.addAttribute("transactionList", transactionService.findAll());
		return "listOfTransactions";
	}

	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String newTransaction(Model model) {
		return "newTransaction";
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String createTransaction(Model model, Transaction transaction) {
		transactionService.newTransaction(transaction);
		model.addAttribute("transactionList", transactionService.findAll());
		return "listOfTransactions";
	}

}
