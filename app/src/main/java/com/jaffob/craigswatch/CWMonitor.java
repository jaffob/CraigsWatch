package com.jaffob.craigswatch;

import java.util.ArrayList;

/**
 * Created by Jack on 10/15/2017.
 */

public class CWMonitor {

    /* Flags. */
    public static final int MONITOR_SEARCH_NEW = 1;
    public static final int MONITOR_SEARCH_REMOVED = 2;

    /* Global list of all monitors. */
    public static ArrayList<CWMonitor> monitors = new ArrayList<>();

    /* Search parameters. Call buildURLS() when these change. */
    public String query;
    public ArrayList<String> categories;
    public int priceMin, priceMax;

    /* Internal data. */
    private ArrayList<String> urls;
    private ArrayList<String> listings;

    public CWMonitor()
    {
        query = "";
        categories = new ArrayList<>();
        priceMin = -1;
        priceMax = -1;
    }

    /**
     * Given the current search parameters, populates a list of URLS
     * to be searched by this monitor.
     */
    public void buildURLs()
    {
        urls.clear();

        // String together the GET parameters that get appended to every URL.
        String suffix = "?query=" + getSanitizedString(query);
        if (priceMin >= 0)
            suffix +=  "&min_price=" + priceMin;
        if (priceMax >= 0)
            suffix +=  "&max_price=" + priceMin;

        // Create a URL for every category we want to search.
        for (String cat : categories)
        {
            urls.add("https://sfbay.craigslist.org/search/" + cat + suffix);
        }
    }

    /**
     * Searches every stored URL for new listings, updating the current listings
     * array with the results.
     * @return Bit flags of whether there are new listings or removed listings.
     */
    public int searchForListings()
    {
        int result = 0;

        for (String url : urls)
        {
            CWHTTPGet request = new CWHTTPGet(url);

            if (!request.hadError())
            {

            }
        }
    }

    public String getSanitizedString(String str)
    {
        return str;
    }
}
