package com.generation.vehiclesharing.enums;

public enum Ruolo {
	    ADMIN {
	    	@Override
	    	public String toString() {
	    		return "ADMIN";
	    	}
	    },
	    USER {
	    	@Override
	    	public String toString() {
	    		return "USER";
	    	}
	    
	}
}