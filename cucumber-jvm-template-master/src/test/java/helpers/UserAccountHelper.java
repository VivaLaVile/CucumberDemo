package helpers;

import cucumber.api.java.en.And;

/**
 * Created by Adam on 14/08/2016.
 */
public class UserAccountHelper {





    @And("^I have an email address of ([^\"]*)$")
    public void iHaveAnEmailAddressOfEmail(String usersEmail) throws Throwable {
        String emailAddress = usersEmail;
    }
}
