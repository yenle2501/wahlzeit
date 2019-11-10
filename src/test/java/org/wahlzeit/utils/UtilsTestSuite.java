package org.wahlzeit.utils;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * TestSuites to test all classes in package utils
 *
 */

@RunWith(Suite.class)

@Suite.SuiteClasses(value = {
        //utils
        StringUtilTest.class,
        VersionTest.class
})

public class UtilsTestSuite {
}
