package com.company.singleresp;

//Handles incoming JSON requests that work on User resource/entity
public class UserController {
	//Store used by controller
    private UserPersistenceService userPersistenceService = new UserPersistenceService();
       
    //Create a new user
    public String createUser(String userJson) {
    	UserJsonParser parser = new UserJsonParser();
       User user = parser.parseUserJson(userJson);
        
        UserValidator validator = new UserValidator();
        boolean isValid = validator.validateUser(user);

        if(!isValid) {
            return "ERROR";
        }
        userPersistenceService.save(user);
          
        return "SUCCESS";
    } 

   
}