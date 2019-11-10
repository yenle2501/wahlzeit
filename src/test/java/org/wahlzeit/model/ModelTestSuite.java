package org.wahlzeit.model;

/**
 * TestSuites to test all classes in package model
 *
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses(value = {
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
        org.wahlzeit.model. ValueTest.class,
        org.wahlzeit.model.FoodPhotoTest.class,
        org.wahlzeit.model.FoodPhotoManagerTest.class,
        org.wahlzeit.model.FoodPhotoFactoryTest.class


})

public class ModelTestSuite {
}
