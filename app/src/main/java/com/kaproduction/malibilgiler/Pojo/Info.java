package com.kaproduction.malibilgiler.Pojo;

/**
 * Created by reis on 29/10/16.
 */

public class Info {

    String parent;//ust baslik
    String child;//alt baslik
    String url;//eger internetten pdf yi okuyorsak adresi
    int icon;

    public Info(String parent, String child, int icon) {
        this.parent = parent;
        this.child = child;
        this.icon = icon;
    }

    public Info(String parent, int icon) {
        this.parent = parent;
        this.icon = icon;

    }

    public Info(String parent, int icon, String url) {
        this.parent = parent;
        this.icon = icon;
        this.url = url;
    }


    public String getParent() {
        return parent;
    }

    public String getChild() {
        return child;
    }

    public String getUrl() {
        return url;
    }

    public int getIcon() {
        return icon;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public void setChild(String child) {
        this.child = child;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
