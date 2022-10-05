package actions;

import dao.Ride;

import java.util.Objects;

public class RemoveRidesAction{

  private static RemoveRidesAction removeRidesAction;

  private final OfferRidesActions offerRidesActions;


  private RemoveRidesAction(){
    offerRidesActions = OfferRidesActions.getInstance();
  }

  public Ride removeRide(String vehicleNumber){
    return offerRidesActions.removeRide(vehicleNumber);
  }

  public static RemoveRidesAction getInstance(){
    if(Objects.isNull(removeRidesAction)){
      removeRidesAction = new RemoveRidesAction();
    }
    return removeRidesAction;
  }
}
