package com.ustbyjy.configuration;

import org.apache.commons.configuration.CombinedConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class ConfigurationTest {

    @Test
    public void testAdditional() throws Exception {
        CombinedConfiguration configuration = new CombinedConfiguration();

        String path = "D:\\IdeaProjects\\daily-study\\src\\test\\resources\\config";
        String fileName = "testHierarchicalXMLConfiguration.xml";

        XMLConfiguration xmlConfiguration = new XMLConfiguration();
        xmlConfiguration.setBasePath(path);
        xmlConfiguration.setFileName(fileName);
        xmlConfiguration.setReloadingStrategy(new FileAlwaysReloadingStrategy());

        configuration.addConfiguration(xmlConfiguration);

        assertEquals("users", xmlConfiguration.getProperty("tables.table(0).name"));
        assertEquals("documents", xmlConfiguration.getProperty("tables.table(1).name"));
//        assertEquals("tasks", xmlConfiguration.getProperty("tables.table(2).name"));

        TimeUnit.SECONDS.sleep(10);

        System.out.println(xmlConfiguration.getProperty("tables.table(0).name"));
    }

}
