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
package org.wahlzeit.services.mailing;

import com.google.appengine.api.datastore.Email;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.services.EmailAddress;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class EmailServiceTest {

	private EmailService emailService = null;
    private EmailAddress validAddress = null;
    private EmailAddress bccAddress   = null;

	@Before
	public void setup() throws Exception {
		emailService = EmailServiceManager.getDefaultService();
		validAddress = EmailAddress.getFromString("test@test.de");
        bccAddress = EmailAddress.getFromString("test123@test.de");
	}

	@Test
	public void testSendInvalidEmail() {
		try {
			assertFalse(emailService.sendEmailIgnoreException(validAddress, null, "lol", "hi"));
			assertFalse(emailService.sendEmailIgnoreException(null, validAddress, null, "body"));
			assertFalse(emailService.sendEmailIgnoreException(validAddress, null, "hi", "       "));


            assertFalse(emailService.sendEmailIgnoreException(validAddress, null,bccAddress, "lol", "hi"));
            assertFalse(emailService.sendEmailIgnoreException(null, validAddress,bccAddress, null, "body"));
            assertFalse(emailService.sendEmailIgnoreException(validAddress, null,bccAddress, "hi", "       "));

            assertFalse(emailService.sendEmailIgnoreException(validAddress, null,null,  "lol", "hi"));
            assertFalse(emailService.sendEmailIgnoreException(null, validAddress,null, null, "body"));
            assertFalse(emailService.sendEmailIgnoreException(validAddress, null,null, "hi", "       "));


		} catch (Exception ex) {
			Assert.fail("Silent mode does not allow exceptions");
		}
	}

	@Test
	public void testSendValidEmail() {
		try {
			assertTrue(emailService.sendEmailIgnoreException(validAddress, validAddress, "hi", "test"));

            assertTrue(emailService.sendEmailIgnoreException(validAddress, validAddress, bccAddress,  "hi", "test"));

        } catch (Exception ex) {
			Assert.fail("Silent mode does not allow exceptions");
		}
	}

	@Test
    public void testSendEmailWithoutbbc(){
        EmailAddress sendEmailAddress = EmailAddress.getFromString("test345@test.de");

        try{
            emailService.sendEmail(sendEmailAddress, validAddress,"subject","body");
        }
        catch(Exception ex){
            Assert.fail("Fail when try to send email without bcc");
        }
    }

    @Test
    public void tesSendEmailWithbbc(){
        EmailAddress sendEmailAddress = EmailAddress.getFromString("test345@test.de");

        try{
            emailService.sendEmail(sendEmailAddress, validAddress,bccAddress,"subject","body");
        }
        catch(Exception ex){
            Assert.fail("Fail when try to send email with bcc");
        }
    }

}