package com.pooespol;


public enum Usuario {
    AUTOR("A"),
    EDITOR("E"),
	REVISOR("R"); 
	
	private String rol;
	
	private usuario (String rol){
		this.rol = rol;
	}

	public String getRol() {
		return rol;
	}

}
