package net.ioncannon.stackapps.api.model;

/**
 */
public class Tag
{
  private String name;
  private long count;
  private long userId;

  public Tag()
  {
  }

  public Tag(String name, long count, long userId)
  {
    this.name = name;
    this.count = count;
    this.userId = userId;
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

  public long getUserId()
  {
    return userId;
  }

  public void setUserId(long userId)
  {
    this.userId = userId;
  }

  @Override
  public String toString()
  {
    return "Tag{" +
        "name='" + name + '\'' +
        ", count=" + count +
        ", userId=" + userId +
        '}';
  }
}
