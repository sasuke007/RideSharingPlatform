package actions;

import dao.Ride;
import dao.TravellerDetails;
import exception.RideAlreadyPresentException;

import java.util.List;

public interface OfferRidesStrategy{

  void offerRide(Ride ride) throws RideAlreadyPresentException;

  Ride removeRide(String vehicleNumber);

  List<List<Ride>> findRides(TravellerDetails travellerDetails);

  default void validateNewRide(Ride newRide, List<Ride> offeredRides) throws RideAlreadyPresentException{
    for(Ride ride : offeredRides){
      if(ride.equals(newRide)){
        throw new RideAlreadyPresentException("Ride Already Present!", String.format("Ride with vehicle number %s is " +
                "already present as on ride from %s origin city to %s destination city", ride.getVehicleNumber(),
            ride.getOriginCity().name(), ride.getDestinationCity().name()));
      }
    }
  }
}
