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
        org.wahlzeit.model.CartesianCoordinateTest.class,
        org.wahlzeit.model.SphericCoordinateTest.class,
        org.wahlzeit.model.FlagReasonTest.class,
        org.wahlzeit.model.GenderTest.class,
        org.wahlzeit.model.GuestTest.class,
        org.wahlzeit.model.LocationTest.class,
        org.wahlzeit.model.PhotoFilterTest.class,
        org.wahlzeit.model.TagsTest.class,
        org.wahlzeit.model.UserStatusTest.class,
        org.wahlzeit.model.ValueTest.class,
        org.wahlzeit.model.FoodPhotoTest.class,
        org.wahlzeit.model.FoodPhotoManagerTest.class,
        org.wahlzeit.model.FoodPhotoFactoryTest.class,
        org.wahlzeit.model.FoodTest.class,
        org.wahlzeit.model.FoodTypeTest.class,
        org.wahlzeit.model.FoodManagerTest.class


})

public class ModelTestSuite {
}
