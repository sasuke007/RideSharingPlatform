package actions;

import constants.Gender;
import constants.VehicleType;
import dao.User;
import dao.Vehicle;
import exception.UserAlreadyPresentException;
import exception.VehicleAlreadyPresentException;

public class UserOperations{

  private static UserActions userActions = UserActions.getInstance();

  public static void addUser(String name, Gender gender, Integer age){
    final User user = new User(name, gender, age);
    try{
      userActions.addUser(name, user);
    } catch(UserAlreadyPresentException ex){

    }
  }

  public static void addVehicle(String ownerName, VehicleType type, String vehicleNumber){
    final Vehicle vehicle = new Vehicle(ownerName, type, vehicleNumber);
    try{
      userActions.addVehicle(ownerName, vehicle);
    } catch(VehicleAlreadyPresentException e){

    }
  }
}
