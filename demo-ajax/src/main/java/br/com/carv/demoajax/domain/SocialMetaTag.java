package br.com.carv.demoajax.domain;

import java.io.Serializable;

public class SocialMetaTag implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String site; 
	private String titulo; 
	private String url; 
	private String imagem;
	
	public SocialMetaTag() {
		
	}
	
	public SocialMetaTag(String site, String titulo, String url, String imagem) {
		this.site = site;
		this.titulo = titulo;
		this.url = url;
		this.imagem = imagem;
	}
	
	public String getSite() {
		return site;
	}
	
	public void setSite(String site) {
		this.site = site;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getImagem() {
		return imagem;
	}
	
	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	@Override
	public String toString() {
		return "SocialMetaTag [site=" + site + ", titulo=" + titulo + ", url=" + url + ", imagem=" + imagem + "]";
	}
	
	
	

}
