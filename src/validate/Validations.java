package validate;

import actions.OfferRidesActions;
import actions.SelectRidesActions;
import actions.UserActions;
import actions.VehicleRegistrations;
import dao.Ride;
import exception.TravellerNotRegisteredException;
import exception.VehicleOwnershipException;

import java.util.Objects;

public class Validations{

  private static final UserActions userActions = UserActions.getInstance();
  private static final VehicleRegistrations vehicleRegistrations = VehicleRegistrations.getInstance();
  private static OfferRidesActions offerRidesActions = OfferRidesActions.getInstance();
  private static SelectRidesActions selectRidesActions = SelectRidesActions.getInstance();

  public static void checkTravellerRegistration(String travellerName) throws TravellerNotRegisteredException{
    if(Objects.isNull(userActions.getUser(travellerName))){
      throw new TravellerNotRegisteredException(String.format("Traveller with name %s is not registered. Please " +
          "register first.", travellerName), "Traveller not Registered.");
    }
  }

  public static void checkVehicleIsRegisteredWithOwner(Ride ride) throws VehicleOwnershipException{
    String owner = vehicleRegistrations.getOwner(ride.getVehicleNumber());
    if(Objects.isNull(owner) || !ride.getOwnerName().equals(owner)){
      throw new VehicleOwnershipException(String.format("Vehicle with %s number is not registered with %s owner.",
          ride.getVehicleNumber(), ride.getOwnerName()),
          "Vehicle not registered under owner.");
    }
  }

}
