package actions;

import constants.City;
import dao.Ride;
import dao.TravellerDetails;

import java.util.*;

public interface FindRidesStrategy{

  default List<List<Ride>> findRides(Map<City, List<Ride>> graph, TravellerDetails travellerDetails){
    List<List<Ride>> possibleRides = new ArrayList<>();
    List<Ride> current = new ArrayList<>();
    Set<City> visitedCities = new HashSet<>();
    dfs(travellerDetails.getOriginCity(), graph, travellerDetails, visitedCities, current, possibleRides);
    return findBestRides(possibleRides);
  }

  List<List<Ride>> findBestRides(List<List<Ride>> possibleRides);


  boolean check(Ride ride, TravellerDetails travellerDetails);

  default void dfs(City currentCity, Map<City, List<Ride>> graph, TravellerDetails travellerDetails,
      Set<City> visitedCities,
      List<Ride> current, List<List<Ride>> possibleRides){
    if(currentCity.equals(travellerDetails.getDestinationCity())){
      List<Ride> foundRide = new ArrayList<>(current);
      possibleRides.add(foundRide);
    }
    visitedCities.add(currentCity);
    for(int i = 0; Objects.nonNull(graph.get(currentCity)) && i < graph.get(currentCity).size(); ++i){
      Ride ride = graph.get(currentCity).get(i);
      if(check(ride, travellerDetails) && !visitedCities.contains(ride.getDestinationCity())){
        current.add(ride);
        dfs(ride.getDestinationCity(), graph, travellerDetails, visitedCities, current, possibleRides);
        current.remove(current.size() - 1);
      }
    }
  }

}
