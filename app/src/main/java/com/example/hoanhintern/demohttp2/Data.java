package com.example.hoanhintern.demohttp2;

public class Data {
    private String Name,Link,Url;
    private int Id;

    public Data(String name, String link, String url, int id) {
        Name = name;
        Link = link;
        Url = url;
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public String getUrl() {
        return Url;
    }

    public void setUrl(String url) {
        Url = url;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }
}
