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

package net.ioncannon.stackapps.api.request;

import net.ioncannon.stackapps.api.client.StackAppRequest;

/**
 */
public class CommentRequest extends BaseRequest
{
  public static CommentRequest start()
  {
    return new CommentRequest();
  }

  /**
sort (optional)

    * How a collection should be sorted. Various values include "active", "creation", "views", "votes".
    * one of activity (default), views, creation, or votes
    */
  public CommentRequest withSort(String sort)
  {
    stackAppRequest.addQueryPart("sort", sort);
    return this;
  }

  /** 
order (optional)

    * How the current sort should be ordered, either "asc" or "desc". Default is "desc".
    * one of desc (default), or asc
    */
  public CommentRequest withOrder(String order)
  {
    stackAppRequest.addQueryPart("order", order);
    return this;
  }

  /**
min (optional)

    * Minimum of the range to include in the response according to the current sort.
    * number
    */
  public CommentRequest withMin(Integer min)
  {
    stackAppRequest.addQueryPart("min", min);
    return this;
  }

  /**
max (optional)

    * Maximum of the range to include in the response according to the current sort.
    * number
    */
  public CommentRequest withMax(Integer max)
  {
    stackAppRequest.addQueryPart("max", max);
    return this;
  }

/**
fromdate (optional)

    * Unix timestamp of the minimum creation date on a returned item.
    * number
    */
  public CommentRequest withFromDate(Long fromDate)
  {
    stackAppRequest.addQueryPart("fromdate", fromDate);
    return this;
  }

/**
todate (optional)

    * Unix timestamp of the maximum creation date on a returned item.
    * number
    */
  public CommentRequest withToDate(Long toDate)
  {
    stackAppRequest.addQueryPart("todate", toDate);
    return this;
  }

/**
page (optional)

    * The pagination offset for the current collection. Affected by the specified pagesize.
    * number
    */
  public CommentRequest withPage(Integer page)
  {
    stackAppRequest.addQueryPart("page", page);
    return this;
  }

/**
pagesize (optional)

    * The number of collection results to display during pagination. Should be between 1 and 100 inclusive.
    * number
    */
  public CommentRequest withPageSize(Integer pageSize)
  {
    stackAppRequest.addQueryPart("pagesize", pageSize);
    return this;
  }
}
