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

/**
 */
public class AssociatedUser
{
  private String userId;
  private String userType;
  private String displayName;
  private Integer reputation;
  private APISite onSite;
  private String emailHash;

  public AssociatedUser()
  {
  }

  public AssociatedUser(String userId, String userType, String displayName, Integer reputation, APISite onSite, String emailHash)
  {
    this.userId = userId;
    this.userType = userType;
    this.displayName = displayName;
    this.reputation = reputation;
    this.onSite = onSite;
    this.emailHash = emailHash;
  }

  @XmlElement(name="user_id")
  public String getUserId()
  {
    return userId;
  }

  public void setUserId(String userId)
  {
    this.userId = userId;
  }

  @XmlElement(name="user_type")
  public String getUserType()
  {
    return userType;
  }

  public void setUserType(String userType)
  {
    this.userType = userType;
  }

  @XmlElement(name="display_name")
  public String getDisplayName()
  {
    return displayName;
  }

  public void setDisplayName(String displayName)
  {
    this.displayName = displayName;
  }

  @XmlElement(name="reputation")
  public Integer getReputation()
  {
    return reputation;
  }

  public void setReputation(Integer reputation)
  {
    this.reputation = reputation;
  }

  @XmlElement(name="on_site")
  public APISite getOnSite()
  {
    return onSite;
  }

  public void setOnSite(APISite onSite)
  {
    this.onSite = onSite;
  }

  @XmlElement(name="email_hash")
  public String getEmailHash()
  {
    return emailHash;
  }

  public void setEmailHash(String emailHash)
  {
    this.emailHash = emailHash;
  }

  @Override
  public String toString()
  {
    return "AssociatedUser{" +
        "userId='" + userId + '\'' +
        ", userType='" + userType + '\'' +
        ", displayName='" + displayName + '\'' +
        ", reputation=" + reputation +
        ", onSite='" + onSite + '\'' +
        ", emailHash='" + emailHash + '\'' +
        '}';
  }
}
