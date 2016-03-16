package home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import home.dao.ItemDAO;
import home.model.Item;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class HomeController {

	@Autowired
	private ItemDAO itemDAO;
	
	@RequestMapping(value="/")
	public ModelAndView listItem(ModelAndView model) throws IOException{
		List<Item> listItem = itemDAO.list();
		model.addObject("listItem", listItem);
		model.setViewName("bucket");
		return model;
	}
	
	@RequestMapping(value = "/newItem", method = RequestMethod.GET)
	public ModelAndView newItem(ModelAndView model) {
		model.addObject("item", new Item());
		model.setViewName("AddItemForm");

		return model;
	}
	
	@RequestMapping(value = "/saveItem", method = RequestMethod.POST)
	public ModelAndView saveItem(@ModelAttribute @Valid Item item, Errors result) {
		if(result.hasErrors()){
			return new ModelAndView("AddItemForm");
		}
		itemDAO.save(item);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/deleteItem", method = RequestMethod.GET)
	public ModelAndView deleteItem(HttpServletRequest request) {
		int itemId = Integer.parseInt(request.getParameter("id"));
		itemDAO.delete(itemId);
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editItem", method = RequestMethod.GET)
	public ModelAndView editItem(HttpServletRequest request) {
		int itemId = Integer.parseInt(request.getParameter("id"));
		Item item = itemDAO.get(itemId);
		itemDAO.update(item);
		ModelAndView model = new ModelAndView("AddItemForm");
		model.addObject("item", item);
		itemDAO.delete(itemId);
		return model;
	}
}