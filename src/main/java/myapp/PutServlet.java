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

import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PutServlet extends HttpServlet {

  private void setupHeaders(HttpServletResponse resp) {
    resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    resp.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    resp.setHeader("Expires", "0"); // Proxies.
    resp.addHeader("Access-Control-Allow-Origin", "*");
  }

  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws IOException {
    String name = req.getParameter("name");
    String value = req.getParameter("value");
    if (name == null || value == null) {
      throw new IOException("Missing name or value");
    }
    new Datastore().put(new Item(name, Long.valueOf(value)));
   
    setupHeaders(resp); 
    resp.setContentType("text/plain");
    resp.getWriter().println();
  }
}
