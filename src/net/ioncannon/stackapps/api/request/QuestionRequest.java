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
public class QuestionRequest extends QuestionBaseRequest<QuestionRequest>
{
  public static QuestionRequest start()
  {
    return new QuestionRequest();
  }


/**
tagged (optional)

    * List of tags questions must have
    * string
    */
  public QuestionRequest withTagged(String tagged)
  {
    stackAppRequest.addQueryPart("tagged", tagged);
    return this;
  }

/**
body (optional)

    * When "true", a post's body will be included in the response. Default is "false".
    * boolean
    */
  public QuestionRequest withBody(Boolean body)
  {
    stackAppRequest.addQueryPart("body", body);
    return this;
  }

/**
comments (optional)

    * When "true", any comments on a post will be included in the response. Default is "false".
    * boolean
    */
  public QuestionRequest withComments(Boolean comments)
  {
    stackAppRequest.addQueryPart("comments", comments);
    return this;
  }
}
