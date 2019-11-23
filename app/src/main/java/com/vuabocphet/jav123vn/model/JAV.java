package com.vuabocphet.jav123vn.model;

public class JAV {
    public String title;
    public String links;
    public String urlimg;
    public String view;

    public JAV(String title, String links, String urlimg, String view) {
        this.title = title;
        this.links = links;
        this.urlimg = urlimg;
        this.view = view;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLinks() {
        return links;
    }

    public void setLinks(String links) {
        this.links = links;
    }

    public String getUrlimg() {
        return urlimg;
    }

    public void setUrlimg(String urlimg) {
        this.urlimg = urlimg;
    }

    public String getView() {
        return view;
    }

    public void setView(String view) {
        this.view = view;
    }
}
