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

public class DownloadTaskVideo extends AsyncTask<String, Void,String> {


    private Load load;

    public DownloadTaskVideo(Load load) {
        this.load = load;
    }

    @Override
    protected String doInBackground(String... strings) {
        Document document = null;
        String path="";

        try {
            document = (Document) Jsoup.connect(strings[0]).get();
            if (document != null) {

                Elements sub = document.select("div.responsive-player");
                Log.e("Size", sub.size() + "");
                for (Element element : sub) {
                    Element a = element.getElementsByTag("iframe").first();
                    Log.e("path",a.attr("src"));
                    path=a.attr("src");
                }
            }

        } catch (IOException e) {
            load.Failure();
            e.printStackTrace();
        }
        return path;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if (s==null){
            load.FailureVideo();
        }else {
            load.SuccessLoadingVideo(s);
        }
    }
}
