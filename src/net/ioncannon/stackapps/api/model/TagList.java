package net.ioncannon.stackapps.api.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/**
 *
 * http://api.stackoverflow.com/[version]/help/method?method=tags
 */

@XmlRootElement
public class TagList extends StackAppResponse
{
  private long total;
  private long page;
  private long pagesize;
  private Tag tags[];

  public TagList()
  {
  }

  public TagList(long total, long page, long pagesize, Tag[] tags)
  {
    this.total = total;
    this.page = page;
    this.pagesize = pagesize;
    this.tags = tags;
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

  public Tag[] getTags()
  {
    return tags;
  }

  public void setTags(Tag[] tags)
  {
    this.tags = tags;
  }

  @Override
  public String toString()
  {
    return "TagList{" +
        "total=" + total +
        ", page=" + page +
        ", pagesize=" + pagesize +
        ", tags=" + (tags == null ? null : Arrays.asList(tags)) +
        '}';
  }
}
