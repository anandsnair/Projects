package com.anand.multithreading;

public class ApplicationDependency {

	String connectorCategory;
	
	public ApplicationDependency(String connectorCategory) {
		this.connectorCategory = connectorCategory;
	}

	public String getConnectorCategory() {
		return connectorCategory;
	}

	public void setConnectorCategory(String connectorCategory) {
		this.connectorCategory = connectorCategory;
	}
	
}
