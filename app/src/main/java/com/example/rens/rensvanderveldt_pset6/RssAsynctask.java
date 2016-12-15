package com.example.rens.rensvanderveldt_pset6;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.DocumentsContract;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by Rens on 8-12-2016.
 */

public class RssAsynctask extends AsyncTask {

    Context appContext;
    String[] regions;

    public RssAsynctask(Context c, String[] Regions){
        appContext = c;
        regions = Regions;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        Toast toast = Toast.makeText(appContext, "Zoeken naar meldingen", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected Object doInBackground(Object[] params) {
        for (Integer i = 0; i < regions.length; i++){

            String urlquery = "https://alarmeringen.nl/feeds/region/" + regions[i] + ".rss";

            try {
                URL query = new URL(urlquery);
                HttpURLConnection connection = (HttpURLConnection) query.openConnection();
                connection.setRequestMethod("GET");

                InputStream inputStream = connection.getInputStream();
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

                DocumentBuilder db = dbf.newDocumentBuilder();
                Document dom = db.parse(inputStream);

                Element domElement = dom.getDocumentElement();

                NodeList nodeList = domElement.getElementsByTagName("item");

                if (nodeList != null && nodeList.getLength() > 0){
                    for (int j = 0; j < nodeList.getLength(); j++){
                        
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }
}
