package actions;

import dao.User;
import dao.Vehicle;
import exception.UserAlreadyPresentException;
import exception.VehicleAlreadyPresentException;

import java.util.HashMap;
import java.util.Objects;

public class UserActions{

  private final HashMap<String, User> userMapping;

  private static UserActions userActions;

  public static UserActions getInstance(){
    if(Objects.isNull(userActions)){
      userActions = new UserActions();
    }
    return userActions;
  }

  private UserActions(){
    userMapping = new HashMap<>();
  }

  public void addUser(String name, User user) throws UserAlreadyPresentException{
    User insertedUser = userMapping.putIfAbsent(name, user);
    if(Objects.nonNull(insertedUser)){
      String message = "User with name %s is already present in the system";
      String error = "User is Already present";
      throw new UserAlreadyPresentException(String.format(message, name), error);
    }
  }

  public void addVehicle(String ownerName, Vehicle vehicle) throws VehicleAlreadyPresentException{
    VehicleRegistrations.addVehicle(vehicle.getNumber(), ownerName);
    userMapping.get(ownerName).addVehicle(vehicle);
  }

  public User getUser(String name){
    return userMapping.getOrDefault(name, null);
  }


}
