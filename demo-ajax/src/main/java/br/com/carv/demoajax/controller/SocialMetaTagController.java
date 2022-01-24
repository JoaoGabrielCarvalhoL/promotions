package br.com.carv.demoajax.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.carv.demoajax.domain.SocialMetaTag;
import br.com.carv.demoajax.service.SocialMetaTagService;

@Controller
@RequestMapping("/meta")
public class SocialMetaTagController {
	
	@Autowired
	private SocialMetaTagService service;
	
	@PostMapping("/info")
	public ResponseEntity<?> getDadosViaUrl(@RequestParam("url") String url) {
		
		SocialMetaTag socialMetaTag = service.getSocialMetaTagByUrl(url);
		if (socialMetaTag != null) {
			return ResponseEntity.ok(socialMetaTag);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
