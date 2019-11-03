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
        org.wahlzeit.handlers.TellFriendTest.class,
        //model.persistence
        org.wahlzeit.model.persistence.DatastoreAdapterTest.class,
        //model
        org.wahlzeit.model.AccessRightsTest.class,
        org.wahlzeit.model.CoordinateTest.class,
        org.wahlzeit.model.FlagReasonTest.class,
        org.wahlzeit.model.GenderTest.class,
        org.wahlzeit.model.GuestTest.class,
        org.wahlzeit.model.LocationTest.class,
        org.wahlzeit.model.PhotoFilterTest.class,
        org.wahlzeit.model.TagsTest.class,
        org.wahlzeit.model.UserStatusTest.class,
        org.wahlzeit.model.ValueTest.class,
        //services.mailing
        org.wahlzeit.services.mailing.EmailServiceTestSuite.class,
        //services
        org.wahlzeit.services.EmailAddressTest.class,
        org.wahlzeit.services.LogBuilderTest.class,
        //utils
        org.wahlzeit.utils.StringUtilTest.class,
        org.wahlzeit.utils.VersionTest.class
        })

public class AllTests {
}
