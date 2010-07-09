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

import javax.xml.bind.annotation.XmlElement;

/**
 */
public class APISiteStyling
{
  private String linkColor;
  private String tagForegroundColor;
  private String tagBackgroundColor;

  public APISiteStyling()
  {
  }

  public APISiteStyling(String linkColor, String tagForegroundColor, String tagBackgroundColor)
  {
    this.linkColor = linkColor;
    this.tagForegroundColor = tagForegroundColor;
    this.tagBackgroundColor = tagBackgroundColor;
  }

  @XmlElement(name="link_color")
  public String getLinkColor()
  {
    return linkColor;
  }

  public void setLinkColor(String linkColor)
  {
    this.linkColor = linkColor;
  }

  @XmlElement(name="tag_foreground_color")
  public String getTagForegroundColor()
  {
    return tagForegroundColor;
  }

  public void setTagForegroundColor(String tagForegroundColor)
  {
    this.tagForegroundColor = tagForegroundColor;
  }

  @XmlElement(name="tag_background_color")
  public String getTagBackgroundColor()
  {
    return tagBackgroundColor;
  }

  public void setTagBackgroundColor(String tagBackgroundColor)
  {
    this.tagBackgroundColor = tagBackgroundColor;
  }

  @Override
  public String toString()
  {
    return "APISiteStyling{" +
        "linkColor='" + linkColor + '\'' +
        ", tagForegroundColor='" + tagForegroundColor + '\'' +
        ", tagBackgroundColor='" + tagBackgroundColor + '\'' +
        '}';
  }
}
