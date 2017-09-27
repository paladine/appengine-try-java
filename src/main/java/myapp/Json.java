package myapp;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.Collection;

public final class Json {
  private static final Gson gson = new GsonBuilder().create();

  // do not instantiate 
  private Json() {}  
 
  static String toJson(Item item) { 
    return gson.toJson(item); 
  }

  static String toJson(Collection<Item> items) {
    return gson.toJson(items); 
  }
}
