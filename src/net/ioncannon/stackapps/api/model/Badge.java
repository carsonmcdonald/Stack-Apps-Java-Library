package net.ioncannon.stackapps.api.model;

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
