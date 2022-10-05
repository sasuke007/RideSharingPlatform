package actions;

import constants.City;
import constants.Gender;
import constants.SelectionStrategy;
import constants.VehicleType;
import dao.Ride;
import dao.RiderDetails;
import dao.User;
import dao.Vehicle;
import exception.RideAlreadyPresentException;
import exception.UserAlreadyPresentException;
import exception.VehicleAlreadyPresentException;

import java.util.List;

public class UserOperations{

  private static UserActions userActions = UserActions.getInstance();
  private static OfferRidesActions offerRidesActions = OfferRidesActions.getInstance();
  private static SelectRidesActions selectRidesActions = SelectRidesActions.getInstance();

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

  public static void offerRide(String ownerName,City originCity,City destinationCity,Integer availableSeats,
      String vehicleNumber,VehicleType vehicleType){
    try{
      final Ride ride = new Ride(ownerName, originCity, destinationCity, availableSeats, vehicleNumber, vehicleType);
      offerRidesActions.offerRide(ride);
    }
    catch(RideAlreadyPresentException e){
      throw new RuntimeException(e);
    }
  }

  public static void selectRide(String travellerName, City originCity, City destinationCity, Integer requiredSeats,
      SelectionStrategy selectionStrategy, VehicleType vehicleType){
    final RiderDetails riderDetails = new RiderDetails(travellerName, originCity, destinationCity, requiredSeats,
        selectionStrategy, vehicleType);
    List<Ride> possibleRides = selectRidesActions.findRides(riderDetails);
  }
}
