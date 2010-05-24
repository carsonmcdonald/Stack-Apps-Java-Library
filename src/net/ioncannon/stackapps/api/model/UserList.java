package net.ioncannon.stackapps.api.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/**
 *
 * http://api.stackoverflow.com/0.8/help/method?method=users
 * http://api.stackoverflow.com/0.8/help/method?method=users/{id}
 *
 */

@XmlRootElement
public class UserList extends StackAppResponse
{
  private long total;
  private long page;
  private long pagesize;
  private User users[];

  public UserList()
  {
  }

  public UserList(long total, long page, long pagesize, User[] users)
  {
    this.total = total;
    this.page = page;
    this.pagesize = pagesize;
    this.users = users;
  }

  public User[] getUsers()
  {
    return users;
  }

  public void setUsers(User[] users)
  {
    this.users = users;
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

  @Override
  public String toString()
  {
    return "UserList{" +
        "total=" + total +
        ", page=" + page +
        ", pagesize=" + pagesize +
        ", users=" + (users == null ? null : Arrays.asList(users)) +
        '}';
  }
}
