package actions;

import constants.City;
import constants.VehicleType;
import dao.Ride;
import dao.RiderDetails;
import exception.RideAlreadyPresentException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OfferRidesActions{

  private static OfferRidesActions offerRidesActions;

  private final UserActions userActions;

  private ArrayList<Ride> offeredRides;

  private FindRidesFactory findRidesFactory;

  private OfferRidesActions(){
    userActions = UserActions.getInstance();
  }

  public static OfferRidesActions getInstance(){
    if(Objects.isNull(offerRidesActions)){
      offerRidesActions = new OfferRidesActions();
    }
    return offerRidesActions;
  }

  public void offerRide(Ride ride) throws RideAlreadyPresentException{
    validateNewRide(ride);
    offeredRides.add(ride);
    userActions.getUser(ride.getOwnerName()).incrementOfferedRides();
  }

  private void validateNewRide(Ride newRide) throws RideAlreadyPresentException{
    for(Ride ride : offeredRides){
      if(ride.equals(newRide)){
        throw new RideAlreadyPresentException("Ride Already Present!", String.format("Ride with vehicle number %s is " +
                "already present as on ride from %s origin city to %s destination city", ride.getVehicleNumber(),
            ride.getOriginCity().name(), ride.getDestinationCity().name()));
      }
    }
  }

  public List<Ride> findRides(RiderDetails riderDetails){
    List<Ride> possibleRides =
        findRidesFactory.findRidesStrategy(riderDetails.getSelectionStrategy()).findRides(offeredRides, riderDetails);
    return possibleRides;
  }
}
