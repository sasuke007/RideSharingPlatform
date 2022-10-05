package dao;

import constants.Gender;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User{
  private final String name;
  private final Gender gender;
  private final Integer age;

  private List<Vehicle> vehicles;

  private Integer offeredRides = 0;

  private Integer takenRides = 0;


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

  public void incrementOfferedRides(){
    this.offeredRides++;
  }

  public void incrementTakenRides(){
    this.takenRides++;
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

  public Integer getOfferedRides(){
    return offeredRides;
  }

  public Integer getTakenRides(){
    return takenRides;
  }

  @Override
  public boolean equals(Object o){
    if(this == o){
      return true;
    }
    if(!(o instanceof User user)){
      return false;
    }
    return getName().equals(user.getName());
  }

  @Override
  public int hashCode(){
    return Objects.hash(getName(), getGender(), getAge(), getVehicles());
  }
}
