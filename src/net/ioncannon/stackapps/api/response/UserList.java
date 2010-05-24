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
