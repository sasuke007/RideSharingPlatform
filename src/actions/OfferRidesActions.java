package actions;

import constants.City;
import dao.Ride;
import dao.RideDetails;
import exception.RideAlreadyPresentException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OfferRidesActions{

  private static OfferRidesActions offerRidesActions;

  private UserActions userActions;

  private ArrayList<Ride> offeredRides;

  private OfferRidesActions(){
    userActions = UserActions.getInstance();
  }

  public static OfferRidesActions getInstance(){
    if(Objects.isNull(offerRidesActions)){
      offerRidesActions = new OfferRidesActions();
    }
    return offerRidesActions;
  }

  public void offerRide(String ownerName, City originCity, City destinationCity, Integer availableSeats,
      String vehicleNumber) throws RideAlreadyPresentException{
    final Ride ride = new Ride(ownerName,originCity,destinationCity,availableSeats,vehicleNumber);
    validateNewRide(ride);
    offeredRides.add(ride);
    userActions.getUser(ownerName).incrementOfferedRides();
  }

  private void validateNewRide(Ride newRide) throws RideAlreadyPresentException{
    for(Ride ride:offeredRides){
      if(ride.equals(newRide)){
        throw new RideAlreadyPresentException("Ride Already Present!",String.format("Ride with vehicle number %s is " +
            "already present as on ride from %s origin city to %s destination city",ride.getVehicleNumber(),
            ride.getOriginCity().name(),ride.getDestinationCity().name()));
      }
    }
  }

  public List<Ride> findRides(RideDetails rideDetails){

  }
}
