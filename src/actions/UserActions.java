package actions;

import dao.User;
import dao.Vehicle;
import exception.UserAlreadyPresentException;
import exception.VehicleAlreadyPresentException;
import util.DisplaySeperators;
import util.StringOperation;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserActions{

  private final HashMap<String, User> userMapping;

  private final VehicleRegistrations vehicleRegistrations;

  private static UserActions userActions;

  public static UserActions getInstance(){
    if(Objects.isNull(userActions)){
      userActions = new UserActions();
    }
    return userActions;
  }

  private UserActions(){
    userMapping = new HashMap<>();
    vehicleRegistrations = VehicleRegistrations.getInstance();
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
    vehicleRegistrations.addVehicle(vehicle.getNumber(), ownerName);
    userMapping.get(ownerName).addVehicle(vehicle);
  }

  public User getUser(String name){
    return userMapping.getOrDefault(name, null);
  }

  public void printStats(){
    for(Map.Entry<String, User> user : userMapping.entrySet()){
      System.out.printf("%s: %d Taken, %d Offered.%n", user.getKey(), user.getValue().getTakenRides(),
          user.getValue().getOfferedRides());
    }
    DisplaySeperators.displayDashedLines();
  }
}
