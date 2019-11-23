package com.vuabocphet.jav123vn.tanks;

import android.os.AsyncTask;
import android.util.Log;

import com.vuabocphet.jav123vn.listen.Load;
import com.vuabocphet.jav123vn.model.JAV;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DownloadTask extends AsyncTask<String, Void, List<JAV>> {


    private Load load;

    public DownloadTask(Load load) {
        this.load = load;
    }


    @Override
    protected List<JAV> doInBackground(String... strings) {
        Document document = null;
        List<JAV> javs = new ArrayList<>();
        javs.clear();
        try {
            document = (Document) Jsoup.connect(strings[0]).get();
            if (document != null) {

                Elements sub = document.select("div#primary.content-area > main#main.site-main> div > article");
                Log.e("Size", sub.size() + "");
                for (Element element : sub) {
                    Element a = element.getElementsByTag("a").first();
                    Element img = a.getElementsByTag("img").first();
                    Element view = a.getElementsByTag("span").first();
                    String links = a.attr("href");
                    String titles = a.attr("title");
                    String imgurl = img.attr("src");
                    String views = view.text();
                    Log.e("links:", a.attr("href"));
                    Log.e("titles:", a.attr("title"));
                    Log.e("img:", img.attr("srcset"));
                    Log.e("span:", view.text());
                    if (links != null && titles != null && imgurl != null && views!=null) {
                        JAV jav = new JAV(titles, links, imgurl,views);
                        javs.add(jav);
                    }

                }
            }

        } catch (IOException e) {
            load.Failure();
            e.printStackTrace();
        }

        return javs;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(List<JAV> javList) {
        super.onPostExecute(javList);
        if (javList == null) {
            load.Failure();
        } else {
            load.Success(javList);
        }
    }
}
