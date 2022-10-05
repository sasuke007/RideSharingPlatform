package actions;

import dao.Ride;
import dao.TravellerDetails;

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

  public List<Ride> findRides(TravellerDetails travellerDetails){
    List<Ride> possibleRides = offerRidesActions.findRides(travellerDetails);
    if(!possibleRides.isEmpty()){
      userActions.getUser(travellerDetails.getTravellerName()).incrementTakenRides();
    }
    return possibleRides;
  }
}
