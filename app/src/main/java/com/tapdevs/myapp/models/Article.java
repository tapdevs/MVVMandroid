package com.tapdevs.myapp.models;

/**
 * Created by  Jan Shair on 31/01/2017.
 */

public class Article {

    /**
    "author": "https://www.facebook.com/bbcnews",
            "title": "Amber Rudd: Trump travel ban could help IS",
            "description": "The home secretary warns that the president's travel restrictions are a \"propaganda opportunity\".",
            "url": "http://www.bbc.co.uk/news/uk-38814346",
            "urlToImage": "http://ichef-1.bbci.co.uk/news/1024/cpsprodpb/17263/production/_93891849_mediaitem93891847.jpg",
            "publishedAt": "2017-01-31T21:43:47Z"

    **/

    private String author, title, description, url, urlToImage, publishedAt;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }
}
