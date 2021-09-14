import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertEquals;

public class UserRegestrationTesting {
    UserRegestration userRegestration;

    @Before
    public void setup(){
        userRegestration = new UserRegestration();
    }

    //First Name Testing
    //Happy Test Scenario
    @Test
    public void validateNameTest(){
        String sampleName = "Saurabh";

        UserRegestration userRegestration = new UserRegestration();
        boolean actual = false;
        try {
            actual = userRegestration.checkName(sampleName);
        } catch (UserRegException e) {
            System.out.println(e);
        }

    }

    //Negative Test Scenario
    @Test
    public void validateNameTestNegative(){
        String sampleName = "SauRabh";

        UserRegestration userRegestration = new UserRegestration();
        boolean actual = false;
        try {
            actual = userRegestration.checkName(sampleName);
        } catch (UserRegException e) {
            System.out.println(e);
        }
    }

    //Last Name Testing
    //Happy Test Scenario
    @Test
    public void validateLastNameTest(){
        String sampleLastName = "Chavan";

        UserRegestration userRegestration = new UserRegestration();
        boolean actual = false;
        try {
            actual = userRegestration.checkLastName(sampleLastName);
        } catch (UserRegException e) {
            System.out.println(e);
        }
    }

    //Negative Test Scenario
    @Test
    public void validateLastNameTestNegative(){
        String sampleLastName = "ChaVan";

        UserRegestration userRegestration = new UserRegestration();
        boolean actual = false;
        try {
            actual = userRegestration.checkLastName(sampleLastName);
        } catch (UserRegException e) {
            System.out.println(e);
        }
    }

    //Password Testing
    //Happy Test Scenario
    @Test
    public void validatePasswordTest(){
        String samplePassword = "abcXYZ@123";

        UserRegestration userRegestration = new UserRegestration();
        boolean actual = false;
        try {
            actual = userRegestration.checkPassword(samplePassword);
        } catch (UserRegException e) {
            System.out.println(e);
        }
    }

    //Negative Test Scenario
    @Test
    public void validatePasswordTestNegative(){
        String samplePassword = "abc.xyz6@bl.co.in";

        UserRegestration userRegestration = new UserRegestration();
        boolean actual = false;
        try {
            actual = userRegestration.checkPassword(samplePassword);
        } catch (UserRegException e) {
            System.out.println(e);
        }
    }

    //Email Testing
    //Happy Test Scenario
    @Test
    public void validateEmailTest(){
        String sampleEmail = "abc.xyz6@bl.co.in";

        UserRegestration userRegestration = new UserRegestration();
        boolean actual = userRegestration.checkEmail(sampleEmail);

    }

    //Negative Test Scenario
    @Test
    public void validateEmailTestNegative(){
        String sampleEmail = "saurabhChavan@khj.354";

        UserRegestration userRegestration = new UserRegestration();
        boolean actual = userRegestration.checkEmail(sampleEmail);

    }

    //Parameterised Email Testing
    //Happy Test Scenario
    @ParameterizedTest
    @ValueSource(strings ={"abc@yahoo.com", "abc-100@yahoo.com" ,"abc.100@yahoo.com","abc111@abc.com","abc-100@abc.net",
            "abc.100@abc.com.au","abc@1.com","abc@gmail.com.com","abc+100@gmail.com"})
    public void validateEmailList(String input){

        UserRegestration userRegestration = new UserRegestration();
        boolean actual = userRegestration.checkEmail(input);

        assertEquals(true,actual);

    }

    //Sad Case Scenario
    @ParameterizedTest
    @ValueSource(strings ={"abc","abc@.com.my","abc123@.com","abc123@.com.com",".abc@abc.com",
            "abc()*@gmail.com","abc@%*.com","abc..2002@gmail.com","abc.@gmail.com","abc@abc@gmail.com",
            "abc@gmail.com.1a","abc@gmail.com.aa.au"})
    public void validateEmailListNegative(String input) {

        UserRegestration userRegestration = new UserRegestration();
        boolean actual = userRegestration.checkEmail(input);

        assertEquals(false, actual);

    }
}
