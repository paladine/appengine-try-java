package myapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Collection;

public class Item {
  private static final Gson gson = new GsonBuilder().create();

  private final String name;
  private final long value;

  public Item(String name, long value) {
    this.name = name;
    this.value = value;
  }

  public String getName() { return name; }

  public long getValue() { return value; }

  public String toJson() {
    return gson.toJson(this);
  }

  public static String toJson(Collection<Item> items) {
    return gson.toJson(items);
  }
};
