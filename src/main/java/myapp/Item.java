package myapp;

public class Item {
  private final String name;
  private final long value;

  public Item(String name, long value) {
    this.name = name;
    this.value = value;
  }

  public String getName() { return name; }

  public long getValue() { return value; }
};
