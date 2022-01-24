package br.com.carv.demoajax.service;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import br.com.carv.demoajax.domain.SocialMetaTag;

@Service
public class SocialMetaTagService {
	
	private static Logger log = org.slf4j.LoggerFactory.getLogger(SocialMetaTagService.class);
	
	public SocialMetaTag getSocialMetaTagByUrl(String url) {
		
		SocialMetaTag twitter = getTwitterCardByUrl(url);
		if(!isEmpty(twitter)) {
			return twitter;
		}
		
		SocialMetaTag openGraph = getOpenGraphyByUrl(url); 
		if(!isEmpty(openGraph)) {
			return openGraph;
		}
		
		return null;
	}
	
	public SocialMetaTag getOpenGraphyByUrl(String url) {
		
		SocialMetaTag tag = new SocialMetaTag(); 
		try {
			Document document = Jsoup.connect(url).get();
			tag.setTitulo(document.head().select("meta[property=og:title]").attr("content"));
			tag.setSite(document.head().select("meta[property=og:site_name]").attr("content"));
			tag.setImagem(document.head().select("meta[property=og:image]").attr("content"));
			tag.setUrl(document.head().select("meta[property=og:url]").attr("content"));
		} catch(IOException err) {
			log.error(err.getMessage(), err.getCause());
		}
		
		return tag;
	}
	
	public SocialMetaTag getTwitterCardByUrl(String url) {
			
			SocialMetaTag tag = new SocialMetaTag(); 
			try {
				Document document = Jsoup.connect(url).userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36") .referrer("http://www.google.com") .ignoreContentType(true) .get();
				tag.setTitulo(document.head().select("meta[name=twitter:title]").attr("content"));
				tag.setSite(document.head().select("meta[name=twitter:site]").attr("content"));
				tag.setImagem(document.head().select("meta[name=twitter:image]").attr("content"));
				tag.setUrl(document.head().select("meta[name=twitter:url]").attr("content"));
			} catch(IOException err) {
				log.error(err.getMessage(), err.getCause());
			}
			
			return tag;
		}
	
	private boolean isEmpty(SocialMetaTag tag) {
		
		if(tag.getTitulo().isEmpty() || tag.getImagem().isEmpty() || tag.getSite().isEmpty() /*|| tag.getUrl().isEmpty()*/) {
			return true;
		}
		else {
			return false;
		}
	}

}
