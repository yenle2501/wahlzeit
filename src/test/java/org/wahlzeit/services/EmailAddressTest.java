/*
 * Copyright (c) 2006-2009 by Dirk Riehle, http://dirkriehle.com
 *
 * This file is part of the Wahlzeit photo rating application.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public
 * License along with this program. If not, see
 * <http://www.gnu.org/licenses/>.
 */

package org.wahlzeit.services;

import junit.framework.TestCase;
import org.junit.*;

/**
 * Test cases for the EmailAddress class.
 */
public class EmailAddressTest extends TestCase {

	/**
	 *
	 */
	public EmailAddressTest(String name) {
		super(name);
	}

	/**
	 * Testcase for method getEmailAddressFromString(String value)
	 */
	@Test
	public void testGetEmailAddressFromString() {
		// invalid email addresses are allowed for local testing and online avoided by Google

		assertTrue(createEmailAddressIgnoreException("bingo@bongo"));
		assertTrue(createEmailAddressIgnoreException("bingo@bongo.com"));
		assertTrue(createEmailAddressIgnoreException("bingo.bongo@bongo.com"));
		assertTrue(createEmailAddressIgnoreException("bingo+bongo@bango"));
	}

	/**
	 *
	 */
	protected boolean createEmailAddressIgnoreException(String ea) {
		try {
			EmailAddress.getFromString(ea);
			return true;
		} catch (IllegalArgumentException ex) {
			// creation failed
			return false;
		}
	}

	/**
     * Testcase for method asInternetAddress()
     * */
	@Test
	public void testAsInternetAddress(){
        String emailAddress = "thi.le@fau.de";
        EmailAddress email = EmailAddress.getFromString(emailAddress);
        assertEquals(emailAddress,email.asInternetAddress().getAddress());
    }

    /**
     * Testcase for method isEqual()
     * */
    @Test
    public void testIsEqual(){
        String emailAddress1 = "thi.le@fau.de";
        EmailAddress email1 = EmailAddress.getFromString(emailAddress1);

        String emailAddress2 = "test@test.de";
        EmailAddress email2 = EmailAddress.getFromString(emailAddress2);

        assertTrue(email1.isEqual(email1));
        assertTrue(email2.isEqual(email2));

        assertFalse(email1.isEqual(email2));
        assertFalse(email2.isEqual(email1));

    }

    /**
     * Testcase for method isValid()
     * */
    @Test
    public void testIsValid(){
        String emailAddress = "thi.le@fau.de";
        EmailAddress email = EmailAddress.getFromString(emailAddress);

        assertTrue(email.isValid());
        assertFalse(EmailAddress.EMPTY.isValid());
    }


	/**
	 * Testcase for method isEmpty()
	 */
	@Test
	public void testEmptyEmailAddress() {
		assertFalse(EmailAddress.EMPTY.isValid());
	}

}

