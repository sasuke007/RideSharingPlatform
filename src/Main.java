import actions.UserOperations;
import constants.City;
import constants.Gender;
import constants.SelectionStrategy;
import constants.VehicleType;
import dao.User;

public class Main{
  public static void main(String[] args){
    UserOperations.addUser("Rohan", Gender.MALE, 36);
    UserOperations.addVehicle("Rohan",VehicleType.SWIFT,"KA-01-12345");
    UserOperations.addUser("Shashank", Gender.MALE, 29);
    UserOperations.addVehicle("Shashank", VehicleType.BALENO, "TS-05-62395");
    UserOperations.addUser("Nandini", Gender.FEMALE, 29);
    UserOperations.addUser("Shipra", Gender.FEMALE, 27);
    UserOperations.addVehicle("Shipra", VehicleType.ACTIVA, "KA-12-12332");
    UserOperations.addVehicle("Shipra",VehicleType.POLO,"KA-05-41491");
    UserOperations.addUser("Gaurav", Gender.MALE, 29);
    UserOperations.addUser("Rahul", Gender.MALE, 35);
    UserOperations.addVehicle("Rahul", VehicleType.XUV, "KA-05-1234");
    UserOperations.offerRide("Rohan", City.HYDERABAD, City.BANGALORE, 1, "KA-01-12345", VehicleType.SWIFT);
    UserOperations.offerRide("Shipra", City.BANGALORE, City.MYSORE, 1, "KA-12-12332", VehicleType.ACTIVA);
    UserOperations.offerRide("Shipra", City.BANGALORE, City.MYSORE, 2, "KA-05-41491", VehicleType.POLO);
    UserOperations.offerRide("Shashank", City.HYDERABAD, City.BANGALORE, 2, "TS-05-62395", VehicleType.BALENO);
    UserOperations.offerRide("Rahul", City.HYDERABAD, City.BANGALORE, 5, "KA-05-1234", VehicleType.XUV);
    UserOperations.offerRide("Rohan", City.BANGALORE, City.PUNE, 1, "KA-01-12345", VehicleType.SWIFT);
    UserOperations.selectRide("Nandini", City.BANGALORE, City.MYSORE, 1, SelectionStrategy.MOST_VACANT,
        VehicleType.NONE);
    UserOperations.selectRide("Gaurav", City.BANGALORE, City.MYSORE, 1, SelectionStrategy.PREFERRED_VEHICLE,
        VehicleType.ACTIVA);
    UserOperations.selectRide("Shashank", City.MUMBAI, City.BANGALORE, 1, SelectionStrategy.PREFERRED_VEHICLE,
        VehicleType.BALENO);
    UserOperations.selectRide("Rohan", City.HYDERABAD, City.BANGALORE, 1, SelectionStrategy.PREFERRED_VEHICLE,
        VehicleType.BALENO);
    UserOperations.selectRide("Shashank",City.HYDERABAD,City.BANGALORE,1,SelectionStrategy.PREFERRED_VEHICLE,VehicleType.POLO);
    UserOperations.printStats();
    UserOperations.removeRide("TS-05-62395");
    UserOperations.selectRide("Rohan", City.HYDERABAD, City.BANGALORE, 1, SelectionStrategy.PREFERRED_VEHICLE,
        VehicleType.BALENO);
  }
}