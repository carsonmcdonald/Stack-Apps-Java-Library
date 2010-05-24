package net.ioncannon.stackapps.api.model;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/**
 */

@XmlRootElement
public class RevisionList
{
  private Revision revisions[];

  public RevisionList()
  {
  }

  public RevisionList(Revision[] revisions)
  {
    this.revisions = revisions;
  }

  public Revision[] getRevisions()
  {
    return revisions;
  }

  public void setRevisions(Revision[] revisions)
  {
    this.revisions = revisions;
  }

  @Override
  public String toString()
  {
    return "RevisionList{" +
        "revisions=" + (revisions == null ? null : Arrays.asList(revisions)) +
        '}';
  }

}
