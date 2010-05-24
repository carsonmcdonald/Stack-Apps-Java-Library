package net.ioncannon.stackapps.api.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlElement;
import java.util.Arrays;

/**
 *
 * http://api.stackoverflow.com/[version]/help/method?method=tags
 */

@XmlRootElement
public class Tags
{
  private long total;
  private long page;
  private long pagesize;
  private Tag tags[];

  public Tags()
  {
  }

  public Tags(long total, long page, long pagesize, Tag[] tags)
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
    return "Tags{" +
        "total=" + total +
        ", page=" + page +
        ", pagesize=" + pagesize +
        ", tags=" + (tags == null ? null : Arrays.asList(tags)) +
        '}';
  }

  public static class Tag
  {
    private String name;
    private long count;

    public Tag()
    {
    }

    public Tag(String name, long count)
    {
      this.name = name;
      this.count = count;
    }

    public String getName()
    {
      return name;
    }

    public void setName(String name)
    {
      this.name = name;
    }

    public long getCount()
    {
      return count;
    }

    public void setCount(long count)
    {
      this.count = count;
    }

    @Override
    public String toString()
    {
      return "Tag{" +
          "name='" + name + '\'' +
          ", count=" + count +
          '}';
    }
  }
}
