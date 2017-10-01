/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package myapp;

import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListServlet extends HttpServlet {
  
  private void setupHeaders(HttpServletResponse resp) {
    resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    resp.setHeader("Expires", "0"); // Proxies.
    resp.addHeader("Access-Control-Allow-Origin", "*");
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    // TODO: retrieve all items from Datastore
    Collection<Item> items = ImmutableList.of(); // empty list
   
    // Return response 
    setupHeaders(resp);
    resp.setContentType("application/json");
    resp.getWriter().println(Item.toJson(items));
  }
}
