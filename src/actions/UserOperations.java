package actions;

import constants.City;
import constants.Gender;
import constants.SelectionStrategy;
import constants.VehicleType;
import dao.Ride;
import dao.TravellerDetails;
import dao.User;
import dao.Vehicle;
import exception.*;
import util.DisplaySeperators;
import util.StringOperation;
import validate.Validations;

import java.util.List;
import java.util.Objects;

public class UserOperations{

  private static final UserActions userActions = UserActions.getInstance();
  private static final OfferRidesActions offerRidesActions = OfferRidesActions.getInstance();
  private static final SelectRidesActions selectRidesActions = SelectRidesActions.getInstance();
  private static final StatsActions statsActions = StatsActions.getInstance();
  private static final RemoveRidesAction removeRidesAction = RemoveRidesAction.getInstance();

  public static void addUser(String name, Gender gender, Integer age){
    name = StringOperation.trimSpacesAndConvertToLowerCase(name);
    final User user = new User(name, gender, age);
    try{
      userActions.addUser(name, user);
    } catch(UserAlreadyPresentException ex){
      System.out.printf("User with name %s is already present in the system.%n", name);
    }
  }

  public static void addVehicle(String ownerName, VehicleType type, String vehicleNumber){
    ownerName = StringOperation.trimSpacesAndConvertToLowerCase(ownerName);
    vehicleNumber = StringOperation.trimSpacesAndConvertToLowerCase(vehicleNumber);
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
    ownerName = StringOperation.trimSpacesAndConvertToLowerCase(ownerName);
    vehicleNumber = StringOperation.trimSpacesAndConvertToLowerCase(vehicleNumber);
    try{
      final Ride ride = new Ride(ownerName, originCity, destinationCity, availableSeats, vehicleNumber, vehicleType);
      Validations.checkVehicleIsRegisteredWithOwner(ride);
      offerRidesActions.offerRide(ride);
    } catch(RideAlreadyPresentException e){
      System.out.printf("A ride with %s vehicle number is already offering a ride.%n", vehicleNumber);
      DisplaySeperators.displayDashedLines();
    } catch(VehicleOwnershipException e){
      System.out.printf("This vehicle with %s number is not registered with owner %s.%n", vehicleNumber, ownerName);
      DisplaySeperators.displayDashedLines();
    }
  }

  public static void selectRide(String travellerName, City originCity, City destinationCity, Integer requiredSeats,
      SelectionStrategy selectionStrategy, VehicleType vehicleType){
    travellerName = StringOperation.trimSpacesAndConvertToLowerCase(travellerName);
    try{
      Validations.checkTravellerRegistration(travellerName);
      final TravellerDetails
          travellerDetails = new TravellerDetails(travellerName, originCity, destinationCity, requiredSeats,
          selectionStrategy, vehicleType);
      List<List<Ride>> possibleRides = selectRidesActions.findRides(travellerDetails);
      for(List<Ride> rides : possibleRides){
        printRide(rides, travellerDetails);
      }
      if(possibleRides.isEmpty()){
        System.out.printf("Sorry %s, there are no rides available for this route currently!.%n", travellerName);
      }
      DisplaySeperators.displayDashedLines();
    } catch(TravellerNotRegisteredException e){
      System.out.printf("Traveller with name does not exist.%n");
    }
  }

  private static void printRide(List<Ride> ride, TravellerDetails travellerDetails){
    System.out.printf("You can reach from %s to %s via this route ", travellerDetails.getOriginCity(),
        travellerDetails.getDestinationCity());
    for(Ride node : ride){
      System.out.print(node.getOriginCity().name() + " -> " + node.getDestinationCity());
    }
    System.out.println();
  }

  public static void printStats(){
    statsActions.printStats();
  }

  public static void removeRide(String vehicleNumber){
    vehicleNumber = StringOperation.trimSpacesAndConvertToLowerCase(vehicleNumber);
    final Ride ride = removeRidesAction.removeRide(vehicleNumber);
    if(Objects.nonNull(ride)){
      System.out.printf("Vehicle with %s number, owned by %s going from %s to %s has been removed successfully.%n",
          vehicleNumber, ride.getOwnerName(), ride.getOriginCity().name(), ride.getDestinationCity().name());
      DisplaySeperators.displayDashedLines();
    } else{
      System.out.printf("Vehicle with %s number, does not exist.%n", vehicleNumber);
    }
  }
}
