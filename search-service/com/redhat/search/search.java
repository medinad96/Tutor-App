package com.redhat.search;

public class Search{

    private string keywords;

    public Search(){

    }

    public Search(String keywords){
        this.keywords = keywords;
    }

    public string getKeywords() {
        return keywords;
    }

    public void setKeywords(string keywords) {
        this.keywords = keywords;
    }

    public string toString(){
        return String.format("Search[keywords='%s']", keywords);
    }

}