package actions;

import constants.City;
import dao.Ride;
import dao.TravellerDetails;
import exception.RideAlreadyPresentException;

import java.util.*;

public class IndirectOfferRidesStrategy implements OfferRidesStrategy{

  public static IndirectOfferRidesStrategy indirectOfferRidesStrategy;

  private final Map<City, List<Ride>> graph;
  private final List<Ride> offeredRides;

  private final FindRidesFactory findRidesFactory = FindRidesFactory.getInstance();

  private IndirectOfferRidesStrategy(){
    graph = new HashMap<>();
    offeredRides = new ArrayList<>();
  }

  public static IndirectOfferRidesStrategy getInstance(){
    if(Objects.isNull(indirectOfferRidesStrategy)){
      indirectOfferRidesStrategy = new IndirectOfferRidesStrategy();
    }
    return indirectOfferRidesStrategy;
  }

  private void addEdgeToGraph(Ride ride){
    City originCity = ride.getOriginCity();
    if(!graph.containsKey(originCity)){
      graph.put(originCity, new ArrayList<>());
    }
    graph.get(originCity).add(ride);
  }

  private Ride findRideWithVehicleNumber(String vehicleNumber){
    for(Ride ride : offeredRides){
      if(ride.getVehicleNumber().equals(vehicleNumber)){
        return ride;
      }
    }
    return null;
  }

  private void removeEdgeFromGraph(String vehicleNumber){
    Ride ride = findRideWithVehicleNumber(vehicleNumber);
    if(Objects.nonNull(ride)){
      City originCity = ride.getOriginCity();
      List<Ride> neighbours = graph.get(originCity);
      for(int i = 0; i < neighbours.size(); ++i){
        if(neighbours.get(i).getVehicleNumber().equals(vehicleNumber)){
          neighbours.remove(i);
          break;
        }
      }
    }
  }


  @Override
  public void offerRide(Ride ride) throws RideAlreadyPresentException{
    validateNewRide(ride, offeredRides);
    offeredRides.add(ride);
    addEdgeToGraph(ride);
  }

  @Override
  public Ride removeRide(String vehicleNumber){
    Ride ride = null;
    for(int i = 0; i < offeredRides.size(); ++i){
      if(offeredRides.get(i).getVehicleNumber().equals(vehicleNumber)){
        ride = offeredRides.get(i);
        offeredRides.remove(i);
        break;
      }
    }
    removeEdgeFromGraph(vehicleNumber);
    return ride;
  }

  @Override
  public List<List<Ride> > findRides(TravellerDetails travellerDetails){
    return findRidesFactory.findRidesStrategy(travellerDetails.getSelectionStrategy())
        .findRides(graph, travellerDetails);
  }
}
