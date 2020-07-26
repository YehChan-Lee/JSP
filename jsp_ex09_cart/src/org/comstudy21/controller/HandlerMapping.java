package org.comstudy21.controller;

import java.util.Hashtable;

public class HandlerMapping {
	private Hashtable<String, Controller> handler = new Hashtable<>();
	
	public HandlerMapping() {
		handler.put("shop", new ShopController());
		handler.put("bbs", new BbsController());
		handler.put("login", new LoginController());
	}
	
	public void putController(String path, Controller ctrl) {
		handler.put(path, ctrl);
	}
	
	public Controller getController(String path){
		return handler.get(path);
	}
}
