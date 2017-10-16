package com.jaffob.craigswatch;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jack on 10/15/2017.
 */

public class CWHTTPGet {

    private HttpURLConnection urlConnection;
    private InputStream inStream;
    private boolean errorOccurred;

    public CWHTTPGet(String url)
    {
        errorOccurred = false;
        urlConnection = null;
        inStream = null;

        try {
            URL urlObj = new URL(url);
            urlConnection = (HttpURLConnection) urlObj.openConnection();
            inStream = new BufferedInputStream(urlConnection.getInputStream());
        } catch (Exception e)
        {
            errorOccurred = true;
        }
    }

    public void close()
    {
        urlConnection.disconnect();
    }

    public InputStream getInputStream()
    {
        return inStream;
    }

    public HttpURLConnection getUrlConnection()
    {
        return urlConnection;
    }

    public boolean hadError()
    {
        return errorOccurred;
    }
}
