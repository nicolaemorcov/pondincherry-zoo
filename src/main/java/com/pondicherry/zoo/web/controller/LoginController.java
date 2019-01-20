package com.pondicherry.zoo.web.controller;

import com.pondicherry.zoo.domain.User;
import com.pondicherry.zoo.service.UserService;
import com.pondicherry.zoo.web.validators.LoginFormValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Map;


@Controller
@RequestMapping("/login.*")
public class LoginController extends SimpleFormController {

   private UserService userService;
  
   @Autowired
   public LoginController(UserService userService) {
   	this.userService = userService;
   }
   
   @RequestMapping(method = RequestMethod.GET)
   public String formBackingObject(Map<String, User> model) throws Exception {
       model.put("userCommand",new User());
       return "login";
   }

//   @Transactional
   @RequestMapping(method = RequestMethod.POST)
   public String submit(HttpServletRequest request, @ModelAttribute("userCommand") User command, BindingResult result) throws Exception {

   	new LoginFormValidator(userService).validate(command, result);
   	if (result.hasErrors()) {
   		return "login";
   	}
   	
       User user = userService.getUser(command.getUsername(), command.getPassword());

       // put the user into the session to indicate logged in status
       request.getSession().setAttribute("user", user);

       return "redirect:/home.html";
   }
 

   @InitBinder
   protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
   		 String[] allowedFields = {"username", "password"};
   		 binder.setAllowedFields(allowedFields);
   		}


}