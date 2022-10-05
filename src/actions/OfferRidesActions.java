package actions;

import dao.Ride;
import dao.TravellerDetails;
import exception.RideAlreadyPresentException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OfferRidesActions{

  private static OfferRidesActions offerRidesActions;

  private final UserActions userActions;

  private final ArrayList<Ride> offeredRides;

  private final FindRidesFactory findRidesFactory;

  private OfferRidesActions(){
    userActions = UserActions.getInstance();
    offeredRides = new ArrayList<>();
    findRidesFactory = FindRidesFactory.getInstance();
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

  public Ride removeRide(String vehicleNumber){
    Ride ride = null;
    for(int i = 0; i < offeredRides.size(); ++i){
      if(offeredRides.get(i).getVehicleNumber().equals(vehicleNumber)){
        ride = offeredRides.get(i);
        offeredRides.remove(i);
        break;
      }
    }
    return ride;
  }

  public List<Ride> findRides(TravellerDetails travellerDetails){
    return findRidesFactory.findRidesStrategy(travellerDetails.getSelectionStrategy())
        .findRides(offeredRides, travellerDetails);
  }
}
