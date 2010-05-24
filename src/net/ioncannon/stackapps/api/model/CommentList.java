package net.ioncannon.stackapps.api.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/**
 */

@XmlRootElement
public class CommentList extends StackAppResponse 
{
  private long total;
  private long page;
  private long pagesize;
  private Comment comments[];

  public CommentList()
  {
  }

  public CommentList(long total, long page, long pagesize, Comment[] comments)
  {
    this.total = total;
    this.page = page;
    this.pagesize = pagesize;
    this.comments = comments;
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

  public Comment[] getComments()
  {
    return comments;
  }

  public void setComments(Comment[] comments)
  {
    this.comments = comments;
  }

  @Override
  public String toString()
  {
    return "CommentList{" +
        "total=" + total +
        ", page=" + page +
        ", pagesize=" + pagesize +
        ", comments=" + (comments == null ? null : Arrays.asList(comments)) +
        '}';
  }
}
