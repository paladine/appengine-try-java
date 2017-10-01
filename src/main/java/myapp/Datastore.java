package myapp;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.common.collect.ImmutableList;
import java.io.IOException;

final class Datastore {
  private static final String KIND = "item";
  private static final String PROPERTY_VALUE = "value";
  
  private final DatastoreService datastoreService = DatastoreServiceFactory.getDatastoreService();
 
  Datastore() {}

  public ImmutableList<Item> getAll() {
    ImmutableList.Builder<Item> itemBuilder = ImmutableList.builder();
    Query q = new Query(KIND);
    for (Entity entity : datastoreService.prepare(q).asIterable()) {
      itemBuilder.add(new Item(entity.getKey().getName(), (Long) entity.getProperty(PROPERTY_VALUE)));
    }
    return itemBuilder.build();
  }

  public Item get(String name) throws IOException {
    try {
      Key key = KeyFactory.createKey(KIND, name);
      Entity entity = datastoreService.get(key);
      return new Item(name, (Long) entity.getProperty(PROPERTY_VALUE));
    } catch (EntityNotFoundException e) {
      throw new IOException(e);
    }
  }

  public void put(Item item) {
    Entity entity = new Entity(KIND, item.getName());
    entity.setProperty(PROPERTY_VALUE, item.getValue());
    datastoreService.put(entity);
  }
}
