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
import util.DisplaySeperators;

import java.sql.SQLOutput;
import java.util.List;

public class UserOperations{

  private static final UserActions userActions = UserActions.getInstance();
  private static final OfferRidesActions offerRidesActions = OfferRidesActions.getInstance();
  private static final SelectRidesActions selectRidesActions = SelectRidesActions.getInstance();

  public static void addUser(String name, Gender gender, Integer age){
    final User user = new User(name, gender, age);
    try{
      userActions.addUser(name, user);
    } catch(UserAlreadyPresentException ex){
      System.out.println(String.format("User with name %s is already present in the system.", name));
    }
  }

  public static void addVehicle(String ownerName, VehicleType type, String vehicleNumber){
    final Vehicle vehicle = new Vehicle(ownerName, type, vehicleNumber);
    try{
      userActions.addVehicle(ownerName, vehicle);
    } catch(VehicleAlreadyPresentException e){
      System.out.printf("Vehicle with %s vehicle number is already registered with owner %s.%n",
          vehicleNumber, ownerName);
      DisplaySeperators.displayDashedLines();
    }

  }

  public static void offerRide(String ownerName, City originCity, City destinationCity, Integer availableSeats,
      String vehicleNumber, VehicleType vehicleType){
    try{
      final Ride ride = new Ride(ownerName, originCity, destinationCity, availableSeats, vehicleNumber, vehicleType);
      offerRidesActions.offerRide(ride);
    } catch(RideAlreadyPresentException e){
      System.out.printf("A ride with %s vehicle number is already offering a ride.%n", vehicleNumber);
      DisplaySeperators.displayDashedLines();
    }
  }

  public static void selectRide(String travellerName, City originCity, City destinationCity, Integer requiredSeats,
      SelectionStrategy selectionStrategy, VehicleType vehicleType){
    final RiderDetails riderDetails = new RiderDetails(travellerName, originCity, destinationCity, requiredSeats,
        selectionStrategy, vehicleType);
    List<Ride> possibleRides = selectRidesActions.findRides(riderDetails);
    for(Ride ride : possibleRides){
      System.out.printf("Hi, %s you can reach from %s to %s via %s , offered by %s having vehicle " +
              "number %s%n", travellerName, originCity.name(), destinationCity.name(), ride.getVehicleType(),
          ride.getOwnerName(), ride.getVehicleNumber());
    }
    if(possibleRides.isEmpty()){
      System.out.printf("Sorry %s, there are no rides available for this route currently!.%n",travellerName);
    }
    DisplaySeperators.displayDashedLines();
  }
}
