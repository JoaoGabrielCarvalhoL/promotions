package br.com.carv.demoajax;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.carv.demoajax.service.SocialMetaTagService;

@SpringBootApplication
public class DemoAjaxApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoAjaxApplication.class, args);
	}

	@Autowired
	SocialMetaTagService tagService;
	
	@Override
	public void run(String... args) throws Exception {
		
		/*
		//MercadoLivre, Pichau, Netshoes (OpenGraphy)
		
		SocialMetaTag tag = tagService.getOpenGraphyByUrl
				("https://www.pichau.com.br/computador-pichau-gamer-intel-i5-10400-uhd-intel-630-8gb-ddr4-ssd-240gb-desmontado?gclid=Cj0KCQiAraSPBhDuARIsAM3Js4rqfgju5Atbsoah77cZCgIIy_oLDYf6LiH8agXex52kOVoNBQVDtr4aAn-GEALw_wcB");
		System.out.println(tag);
		
		SocialMetaTag tagTw = tagService.getTwitterCardByUrl
				("https://www.pichau.com.br/maleta-pichau-gaming-pg-mlpg-bl01?gclid=Cj0KCQiAraSPBhDuARIsAM3Js4oUfFbaA7FYISWDquXyrV7YadgwU7ngYKXlV2SGl0hxKTMBS8qRxyoaAuqSEALw_wcB"); 
		System.out.println(tagTw);
		
		SocialMetaTag tag1 = tagService.getOpenGraphyByUrl
				("https://produto.mercadolivre.com.br/MLB-1934979566-2un-tapa-cover-webcam-camera-adesivo-notebook-celular-tablet-_JM?variation=89705505274#reco_item_pos=0&reco_backend=machinalis-homes-pdp-boos&reco_backend_type=function&reco_client=home_navigation-recommendations&reco_id=5dc2cae7-f756-4888-bef2-f7e22e989bcd&c_id=/home/navigation-recommendations/element&c_element_order=1&c_uid=33b1374b-2efa-4056-b615-d07aa277af3a");
		System.out.println(tag1);
		
		SocialMetaTag tag2 = tagService.getTwitterCardByUrl
				("https://produto.mercadolivre.com.br/MLB-1934979566-2un-tapa-cover-webcam-camera-adesivo-notebook-celular-tablet-_JM?variation=89705505274#reco_item_pos=0&reco_backend=machinalis-homes-pdp-boos&reco_backend_type=function&reco_client=home_navigation-recommendations&reco_id=5dc2cae7-f756-4888-bef2-f7e22e989bcd&c_id=/home/navigation-recommendations/element&c_element_order=1&c_uid=33b1374b-2efa-4056-b615-d07aa277af3a"); 
		System.out.println(tag2);
		
		SocialMetaTag tag3 = tagService.getOpenGraphyByUrl
				("https://www.netshoes.com.br/tenis-infantil-adidas-tensaur-run-tira-dupla-azul+verde-3ZP-2118-818");
		System.out.println(tag3);
		
		SocialMetaTag tag5 = tagService.getSocialMetaTagByUrl("https://www.pichau.com.br/computador-pichau-gamer-intel-i5-10400-uhd-intel-630-8gb-ddr4-ssd-240gb-desmontado?gclid=Cj0KCQiAraSPBhDuARIsAM3Js4rqfgju5Atbsoah77cZCgIIy_oLDYf6LiH8agXex52kOVoNBQVDtr4aAn-GEALw_wcB"); 
		System.out.println(tag5);
		*/
	}

}
