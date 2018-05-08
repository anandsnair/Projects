package com.anand.multithreading;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConnectorMdl {

	String name;
	String guid;
	List<ApplicationDependency> applicationDependency = new ArrayList<>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGuid() {
		return guid;
	}
	public void setGuid(String guid) {
		this.guid = guid;
	}
	public List<ApplicationDependency> getApplicationDependency() {
		return applicationDependency;
	}
	public void setApplicationDependency(List<ApplicationDependency> applicationDependency) {
		this.applicationDependency = applicationDependency;
	}
	
}
