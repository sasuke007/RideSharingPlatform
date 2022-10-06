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

  private final OfferRidesStrategy offerRidesStrategy;

  private OfferRidesActions(){
    userActions = UserActions.getInstance();
    offeredRides = new ArrayList<>();
    offerRidesStrategy = IndirectOfferRidesStrategy.getInstance();
  }

  public static OfferRidesActions getInstance(){
    if(Objects.isNull(offerRidesActions)){
      offerRidesActions = new OfferRidesActions();
    }
    return offerRidesActions;
  }

  public void offerRide(Ride ride) throws RideAlreadyPresentException{
    offerRidesStrategy.offerRide(ride);
    userActions.getUser(ride.getOwnerName()).incrementOfferedRides();
  }

  public Ride removeRide(String vehicleNumber){
    return offerRidesStrategy.removeRide(vehicleNumber);
  }

  public List<List<Ride> > findRides(TravellerDetails travellerDetails){
    return offerRidesStrategy.findRides(travellerDetails);
  }
}
