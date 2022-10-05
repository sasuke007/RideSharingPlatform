package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User{
  private final String name;
  private final Gender gender;
  private final Integer age;

  private List<Vehicle> vehicles;

  public User(String name, Gender gender, Integer age){
    this.name = name;
    this.gender = gender;
    this.age = age;
  }

  public void addVehicle(Vehicle vehicle){
    if(Objects.isNull(vehicles)){
      vehicles = new ArrayList<>();
    }
    vehicles.add(vehicle);
  }


  public List<Vehicle> getVehicles(){
    return vehicles;
  }

  public String getName(){
    return name;
  }

  public Gender getGender(){
    return gender;
  }

  public Integer getAge(){
    return age;
  }

}
