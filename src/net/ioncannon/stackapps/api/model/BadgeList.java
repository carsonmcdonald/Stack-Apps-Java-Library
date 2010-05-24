package net.ioncannon.stackapps.api.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/**
 *
 * http://api.stackoverflow.com/0.8/help/method?method=badges
 * http://api.stackoverflow.com/0.8/help/method?method=badges/name
 * http://api.stackoverflow.com/0.8/help/method?method=badges/tags
 * 
 */

@XmlRootElement
public class BadgeList extends StackAppResponse
{
  private Badge badges[];

  public BadgeList()
  {
  }

  public BadgeList(Badge[] badges)
  {
    this.badges = badges;
  }

  public Badge[] getBadges()
  {
    return badges;
  }

  public void setBadges(Badge[] badges)
  {
    this.badges = badges;
  }

  @Override
  public String toString()
  {
    return "BadgeList{" +
        "badges=" + (badges == null ? null : Arrays.asList(badges)) +
        '}';
  }

}
