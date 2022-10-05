package util;

public class KeyGenerator{
  private static int count = 0;

  public static int generate(){
    return ++count;
  }
}
