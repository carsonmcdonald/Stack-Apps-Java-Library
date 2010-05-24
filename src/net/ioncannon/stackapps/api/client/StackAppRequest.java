/*
 * Copyright (c) 2010 Carson McDonald
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */

package net.ioncannon.stackapps.api.client;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.Client;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

/**
 */
public class StackAppRequest
{
  private static final String BASE_URL = "http://api.stackoverflow.com/"; // todo need urls for other services
  private static final String API_VERSION = "0.8";

  private List<String> pathParts = new ArrayList<String>();
  private Map<String, String> queryParts = new HashMap<String, String>();

  public void pushPath(String pathPart)
  {
    pathParts.add(pathPart);
  }

  public void pushPath(long pathPart)
  {
    pathParts.add(String.valueOf(pathPart));
  }

  public void addQueryPart(String key, String value)
  {
    queryParts.put(key, value);
  }

  public WebResource constructResource(Client client)
  {
    WebResource resource = client.resource(BASE_URL).path(API_VERSION);

    for(String pathPart : pathParts)
    {
      resource = resource.path(pathPart);
    }

    for(String key : queryParts.keySet())
    {
      resource = resource.queryParam(key, queryParts.get(key));
    }

    return resource;
  }
}
