package util;

import dao.User;
import exception.UserAlreadyPresentException;

import java.util.HashMap;
import java.util.Objects;

public class UserResolve{

  private String error = "User is Already present";
  private String message = "User with name %s is already present in the system";
  private HashMap<String,User> userMapping;

  public void addUser(String name,User user) throws UserAlreadyPresentException{
    User insertedUser = userMapping.putIfAbsent(name,user);
    if(Objects.nonNull(insertedUser)){
      throw new UserAlreadyPresentException(String.format(message, name), error);
    }
  }

  public User getUser(String name){
    return userMapping.getOrDefault(name,null);
  }
}
