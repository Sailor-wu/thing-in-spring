package org.thing.in.spring.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;

import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */ 
public class ActivityTest extends TestCase {
	
	
	public void deploy() {
		ProcessEngine pre =  ProcessEngines.getDefaultProcessEngine();
		Deployment deploy = pre.getRepositoryService()
		.createDeployment()
		.addClasspathResource("diagrams/MyProcess.bpmn")
		.deploy();
		System.out.println(deploy.getId());
		
	}
}
