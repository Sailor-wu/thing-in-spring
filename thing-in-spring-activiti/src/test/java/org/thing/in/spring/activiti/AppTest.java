package org.thing.in.spring.activiti;

import org.activiti.engine.ProcessEngineConfiguration;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void createTable() {
    	ProcessEngineConfiguration pro = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration();
    	
    	pro.setJdbcDriver("com.mysql.jdbc.Driver");
    	pro.setJdbcUrl("jdbc:mysql://localhost:3306/db_activiti");
    	pro.setJdbcUsername("root");
    	pro.setJdbcPassword("123456");
    	pro.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE);
    	
    	pro.buildProcessEngine();
    }
    
    
}
