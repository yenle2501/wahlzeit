package org.wahlzeit;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * TestSuites to test all classes
 *
 */

@RunWith(Suite.class)

@Suite.SuiteClasses(value = {
        //handlers
        org.wahlzeit.handlers.HandlersTestSuite.class,
        //model
        org.wahlzeit.model.ModelTestSuite.class,
        //services
        org.wahlzeit.services.ServicesTestSuite.class,
        //utils
        org.wahlzeit.utils.UtilsTestSuite.class
})

public class AllTests {
}