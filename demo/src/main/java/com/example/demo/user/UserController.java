package com.example.demo.user;

import com.example.demo.token.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {
    @Autowired
    UserRepository userRepository;
@GetMapping("/signup")
    public String signupForm(Model model){
    model.addAttribute("user",new User());
return "signup";
}
@PostMapping("/signup")
public String saveUser(@Validated @ModelAttribute User user, BindingResult bindingResult, RedirectAttributes attributes){
    if(bindingResult.hasErrors()){
        return "signup";
    }
if (userRepository.findByEmail(user.getEmail())!=null){
    return "redirect:/signup";
}


String token=String.format("%s", Token.generatRandomToken());
user.setToken(token);
 userRepository.save(user);
 attributes.addFlashAttribute("success_message","user created successfully");
 attributes.addFlashAttribute("success_class","alert alert-success");
 return "kala";
}
@GetMapping("/login")
    public String loginPage(){
    return "login";
}
}
