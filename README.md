Stack Apps Java API Wrapper
===========================

## DESCRIPTION

This is a simple Java wrapper on top of the [Stack Apps API](http://stackapps.com/).

## FEATURES

Supports all the API functionality as of version 0.8.

## REQUIREMENTS

This wrapper requires the [Java Jersey](https://jersey.dev.java.net/) JAX-RS reference implementation. The jars can be found in the lib directory, once JSR-311 is incorporated into the JDK they should no longer be needed.

## EXAMPLE USE

	/**
	 * The following will print out the current stats for the 
	 * stackoverflow.com site.
	 */
	public class Example
	{
	  public static void main(String[] args)
	  {
	    Stats stats = StackAppClient.getStats();
	    System.err.println(stats);
	  }
	}

Please note that the above example does not include a key, without a key the API limits are very low.

## LICENSE

Copyright (c) 2010 Carson McDonald

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.

