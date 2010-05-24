package net.ioncannon.stackapps.api.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import java.util.Arrays;

/**
 */

@XmlRootElement
public class RepChangeList extends StackAppResponse
{
  private long total;
  private long page;
  private long pagesize;
  private RepChange repChanges[];

  public RepChangeList()
  {
  }

  public RepChangeList(long currentRateLimit, long maxRateLimit, long total, long page, long pagesize, RepChange[] repChanges)
  {
    super(currentRateLimit, maxRateLimit);
    this.total = total;
    this.page = page;
    this.pagesize = pagesize;
    this.repChanges = repChanges;
  }

  public long getTotal()
  {
    return total;
  }

  public void setTotal(long total)
  {
    this.total = total;
  }

  public long getPage()
  {
    return page;
  }

  public void setPage(long page)
  {
    this.page = page;
  }

  public long getPagesize()
  {
    return pagesize;
  }

  public void setPagesize(long pagesize)
  {
    this.pagesize = pagesize;
  }

  @XmlElement(name="rep_changes")
  public RepChange[] getRepChanges()
  {
    return repChanges;
  }

  public void setRepChanges(RepChange[] repChanges)
  {
    this.repChanges = repChanges;
  }

  @Override
  public String toString()
  {
    return "RepChangeList{" +
        "total=" + total +
        ", page=" + page +
        ", pagesize=" + pagesize +
        ", repChanges=" + (repChanges == null ? null : Arrays.asList(repChanges)) +
        '}';
  }
}
