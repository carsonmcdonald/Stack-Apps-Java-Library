package net.ioncannon.stackapps.api.client;

import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.Client;

import java.util.List;
import java.util.ArrayList;

/**
 */
public class StackAppRequest
{
  private static final String BASE_URL = "http://api.stackoverflow.com/"; // todo need urls for other services
  private static final String API_VERSION = "0.8";

  private List<String> pathParts = new ArrayList<String>();

  public void pushPath(String pathPart)
  {
    pathParts.add(pathPart);
  }

  public void pushPath(long pathPart)
  {
    pathParts.add(String.valueOf(pathPart));
  }

  public WebResource constructResource(Client client)
  {
    WebResource resource = client.resource(BASE_URL).path(API_VERSION);

    for(String pathPart : pathParts)
    {
      resource = resource.path(pathPart);
    }

    return resource;
  }
}
