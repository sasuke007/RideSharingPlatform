package actions;

import constants.City;
import constants.SelectionStrategy;
import constants.VehicleType;
import dao.Ride;
import dao.RiderDetails;

import java.util.List;
import java.util.Objects;

public class SelectRidesActions{

  private static SelectRidesActions selectRidesActions;

  private final OfferRidesActions offerRidesActions;

  private final UserActions userActions;

  private SelectRidesActions(){
    offerRidesActions = OfferRidesActions.getInstance();
    userActions = UserActions.getInstance();
  }

  public static SelectRidesActions getInstance(){
    if(Objects.isNull(selectRidesActions)){
      selectRidesActions = new SelectRidesActions();
    }
    return selectRidesActions;
  }

  public List<Ride> findRides(RiderDetails riderDetails){
    List<Ride> possibleRides = offerRidesActions.findRides(riderDetails);
    if(!possibleRides.isEmpty()){
      userActions.getUser(riderDetails.getTravellerName()).incrementTakenRides();
    }
    return possibleRides;
  }
}
