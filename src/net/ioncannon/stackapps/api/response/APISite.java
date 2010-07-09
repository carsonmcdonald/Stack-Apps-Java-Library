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

package net.ioncannon.stackapps.api.response;

import javax.xml.bind.annotation.XmlElement;
import java.util.Arrays;

/**
 */
public class APISite
{
  private String name;
  private String logoURL;
  private String apiEndpoint;
  private String siteURL;
  private String description;
  private String iconURL;
  private String aliases[];
  private String state;
  private APISiteStyling apiSiteStyling;

  public APISite()
  {
  }

  public APISite(String name, String logoURL, String apiEndpoint, String siteURL, String description, String iconURL, String aliases[], String state, APISiteStyling apiSiteStyling)
  {
    this.name = name;
    this.logoURL = logoURL;
    this.apiEndpoint = apiEndpoint;
    this.siteURL = siteURL;
    this.description = description;
    this.iconURL = iconURL;
    this.aliases = aliases;
    this.state = state;
    this.apiSiteStyling = apiSiteStyling;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  @XmlElement(name="logo_url")
  public String getLogoURL()
  {
    return logoURL;
  }

  public void setLogoURL(String logoURL)
  {
    this.logoURL = logoURL;
  }

  @XmlElement(name="api_endpoint")
  public String getApiEndpoint()
  {
    return apiEndpoint;
  }

  public void setApiEndpoint(String apiEndpoint)
  {
    this.apiEndpoint = apiEndpoint;
  }

  @XmlElement(name="site_url")
  public String getSiteURL()
  {
    return siteURL;
  }

  public void setSiteURL(String siteURL)
  {
    this.siteURL = siteURL;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  @XmlElement(name="icon_url")
  public String getIconURL()
  {
    return iconURL;
  }

  public void setIconURL(String iconURL)
  {
    this.iconURL = iconURL;
  }

  public String[] getAliases()
  {
    return aliases;
  }

  public void setAliases(String[] aliases)
  {
    this.aliases = aliases;
  }

  public String getState()
  {
    return state;
  }

  public void setState(String state)
  {
    this.state = state;
  }

  @XmlElement(name="styling")
  public APISiteStyling getApiSiteStyling()
  {
    return apiSiteStyling;
  }

  public void setApiSiteStyling(APISiteStyling apiSiteStyling)
  {
    this.apiSiteStyling = apiSiteStyling;
  }

  @Override
  public String toString()
  {
    return "APISite{" +
        "name='" + name + '\'' +
        ", logoURL='" + logoURL + '\'' +
        ", apiEndpoint='" + apiEndpoint + '\'' +
        ", siteURL='" + siteURL + '\'' +
        ", description='" + description + '\'' +
        ", iconURL='" + iconURL + '\'' +
        ", aliases=" + (aliases == null ? null : Arrays.asList(aliases)) +
        ", state='" + state + '\'' +
        ", apiSiteStyling=" + apiSiteStyling +
        '}';
  }
}
