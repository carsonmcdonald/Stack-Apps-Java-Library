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
public class Badge
{
  private long badgeId;
  private String rank;
  private String name;
  private String description;
  private long awardCount;
  private boolean tagBased;
  private User user;
  private String badgesRecipientsUrl;

  public Badge()
  {
  }

  public Badge(long badgeId, String rank, String name, String description, long awardCount, boolean tagBased, User user, String badgesRecipientsUrl)
  {
    this.badgeId = badgeId;
    this.rank = rank;
    this.name = name;
    this.description = description;
    this.awardCount = awardCount;
    this.tagBased = tagBased;
    this.user = user;
    this.badgesRecipientsUrl = badgesRecipientsUrl;
  }

  @XmlElement(name="badge_id")
  public long getBadgeId()
  {
    return badgeId;
  }

  public void setBadgeId(long badgeId)
  {
    this.badgeId = badgeId;
  }

  public String getRank()
  {
    return rank;
  }

  public void setRank(String rank)
  {
    this.rank = rank;
  }

  public String getName()
  {
    return name;
  }

  public void setName(String name)
  {
    this.name = name;
  }

  public String getDescription()
  {
    return description;
  }

  public void setDescription(String description)
  {
    this.description = description;
  }

  @XmlElement(name="award_count")
  public long getAwardCount()
  {
    return awardCount;
  }

  public void setAwardCount(long awardCount)
  {
    this.awardCount = awardCount;
  }

  @XmlElement(name="tag_based")
  public boolean isTagBased()
  {
    return tagBased;
  }

  public void setTagBased(boolean tagBased)
  {
    this.tagBased = tagBased;
  }

  public User getUser()
  {
    return user;
  }

  public void setUser(User user)
  {
    this.user = user;
  }

  @XmlElement(name="badges_recipients_url")
  public String getBadgesRecipientsUrl()
  {
    return badgesRecipientsUrl;
  }

  public void setBadgesRecipientsUrl(String badgesRecipientsUrl)
  {
    this.badgesRecipientsUrl = badgesRecipientsUrl;
  }

  @Override
  public String toString()
  {
    return "Badge{" +
        "badgeId=" + badgeId +
        ", rank='" + rank + '\'' +
        ", name='" + name + '\'' +
        ", description='" + description + '\'' +
        ", awardCount=" + awardCount +
        ", tagBased=" + tagBased +
        ", user=" + user +
        ", badgesRecipientsUrl='" + badgesRecipientsUrl + '\'' +
        '}';
  }
}
