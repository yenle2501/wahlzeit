package org.wahlzeit.services;

/**
 * TestSuites to test all classes in package services
 *
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses(value = {
        //services.mailing
        org.wahlzeit.services.mailing.EmailServiceTestSuite.class,
        //services
        EmailAddressTest.class,
        LogBuilderTest.class
})

public class ServicesTestSuite {
}
