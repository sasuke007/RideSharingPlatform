package actions;

public class SelectRidesActions{

  private SelectRidesActions selectRidesActions;

  private OfferRidesActions offerRidesActions;

  private SelectRidesActions(){
    offerRidesActions = OfferRidesActions.getInstance();
  }


}
