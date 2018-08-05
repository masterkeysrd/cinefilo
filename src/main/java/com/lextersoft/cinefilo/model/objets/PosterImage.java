package com.lextersoft.cinefilo.model.objets;

public class PosterImage {
    private String name;
    private String url;
    private float size;

    public PosterImage(String name, String url, float size) {
        this.name = name;
        this.url = url;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }
}
