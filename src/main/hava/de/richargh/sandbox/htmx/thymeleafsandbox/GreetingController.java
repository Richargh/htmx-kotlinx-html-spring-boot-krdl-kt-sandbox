package de.richargh.sandbox.htmx.thymeleafsandbox;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GreetingController {

    @GetMapping("/greeting")
    public String greeting(
            @AuthenticationPrincipal UserDetails userDetails,
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Model model) {
        String userName = userDetails != null ? userDetails.getUsername() : "None";
        System.out.println("/greeting for user: "+userName);
        model.addAttribute("name", name);
        return "greeting";
    }

}
