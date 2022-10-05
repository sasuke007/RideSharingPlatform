package constants;

public enum Gender{

  MALE('M'),
  FEMALE('F');
  private final char abbreviation;

  Gender(char abbreviation){
    this.abbreviation = abbreviation;
  }

  public char getAbbreviation(){
    return this.abbreviation;
  }
}
