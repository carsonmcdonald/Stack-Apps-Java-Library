package net.ioncannon.stackapps.api.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/**
 *
 * http://api.stackoverflow.com/[version]/help/method?method=stats
 */

@XmlRootElement
public class StatsList
{
  private Stats statistics[];

  public StatsList()
  {
  }

  public StatsList(Stats[] statistics)
  {
    this.statistics = statistics;
  }

  public Stats[] getStatistics()
  {
    return statistics;
  }

  public void setStatistics(Stats[] statistics)
  {
    this.statistics = statistics;
  }

  @Override
  public String toString()
  {
    return "net.ioncannon.stackapps.api.model.StatsList{" +
        "statistics=" + (statistics == null ? null : Arrays.asList(statistics)) +
        '}';
  }
}
