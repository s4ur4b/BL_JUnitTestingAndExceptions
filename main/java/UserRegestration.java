/**
 * <h1>User Regestration!</h1>
 * The User Regestration program validates User Input
 * to check weather the inputs are as required
 * The user of Java Regex has been done to achieve the same
 * <p>
 * <b>Note:</b> Exception Handling Has been done in case of Invalid user inputs
 *
 * @author  Saurabh Chavan
 * @version 1.0
 * @since   2021-09-14
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//This is a User Resgistration Problem where the code needs to ensure that all the validations are in place during user entry

//Created a class for validation
public class UserRegestration {
    Scanner scan = new Scanner(System.in);

     UserRegistrationInterface nameValidation = (String name) ->  {

        String nameRegex = "^[A-Z]{1}[a-z]{2,15}$";

        Pattern pattern = Pattern.compile(nameRegex);

        Matcher matcher = pattern.matcher(name);

        if (!matcher.matches()){
            throw new UserRegException("First Name is Invalid");
        }
        return matcher.matches();

    };

    UserRegistrationInterface lastNameVallidation = (String lastName) -> {

        String nameRegex = "^[A-Z]{1}[a-z]{2,15}$";

        Pattern pattern = Pattern.compile(nameRegex);

        Matcher matcher = pattern.matcher(lastName);

        if (!matcher.matches()){
            throw new UserRegException("Last Name is Invalid");
        }
        return matcher.matches();
    };

    UserRegistrationInterface checkEmail = (String email) -> {

        String emailRegex = "^[a-zA-Z0-9]+.[a-zA-Z0-9+_-]+@[a-zA-Z0-9+_-]+.[a-z]+.[a-z]+$";
//        String emailRegex = "^[a-zA-Z0-9]+.[a-zA-Z0-9+_-]+@[a-zA-Z0-9+_-]+.[a-z.]+$";

        Pattern pattern = Pattern.compile(emailRegex);

        Matcher matcher = pattern.matcher(email);

        if (!matcher.matches()){
            try {
                throw new UserRegException("Invalid Email");
            } catch (UserRegException e) {
                System.out.println(e);
            }
        }
        return matcher.matches();
    };

    void checkPhone() {
        System.out.println("Enter Your phone number");
        String phoneNo = scan.next();

        String Regex = "^[91]{2}\\s[0-9]{10}$";

        boolean result = phoneNo.matches(Regex);
        if (!result){
            try {
                throw new UserRegException("Phone Number is Invalid");
            } catch (UserRegException e) {
                System.out.println(e);
            }
        }
    }

    UserRegistrationInterface checkPassword = (String password) -> {

        String Regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!#%*?&])[A-Za-z\\d@$!#%*?&]{8,}$";

        boolean result = password.matches(Regex);

        if (!result){
            throw new UserRegException("Password is Invalid");
        }
        return result;
    };

}
