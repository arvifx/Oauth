

package com.client.server;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;





@Controller
public class OAuth2LoginController {
	
	
	
	
	 @GetMapping("/login")
	    public String login() {
	        return "login"; 
	    }
	 
	 @GetMapping("/login/google")
	    public String google(@RegisteredOAuth2AuthorizedClient("google") OAuth2AuthorizedClient authorizedClient
	    		) {
		 //@RegisteredOAuth2AuthorizedClient("okta") OAuth2AuthorizedClient authorizedClient
		 
		 
		 
		  
		 System.out.println("@@@@@@@@@@@@@@@@@");
	        return "index"; 
	    }

	@GetMapping("/")
	public String index(Model model, @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
			@AuthenticationPrincipal OAuth2User oauth2User) {
		System.out.println("2");
		model.addAttribute("userName", oauth2User.getName());
		model.addAttribute("clientName", authorizedClient.getClientRegistration().getClientName());
		model.addAttribute("userAttributes", oauth2User.getAttributes());
		return "index";
	}

}
