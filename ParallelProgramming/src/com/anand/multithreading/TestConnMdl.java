package com.anand.multithreading;

import java.util.List;
import java.util.stream.Collectors;

public class TestConnMdl {

	public static void main(String[] args) {
		ConnectorMdl connectorMdl = new ConnectorMdl();
		connectorMdl.setName("Testname");
		connectorMdl.setGuid("TestGuid");
		//connectorMdl.getApplicationDependency().add(new ApplicationDependency("DTM"));
		//connectorMdl.getApplicationDependency().add(new ApplicationDependency("MFT"));
		//connectorMdl.getApplicationDependency().add(new ApplicationDependency("ICRT"));

		List<String> connectorCategories = connectorMdl.getApplicationDependency().stream().map(category -> category.getConnectorCategory()).collect(Collectors.toList());
		connectorCategories.stream().forEach(cat -> System.out.println(cat));
		System.out.println(connectorCategories.isEmpty());
	}
}
