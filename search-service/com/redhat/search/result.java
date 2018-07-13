package com.redhat.search;


public class Result{


    private String results;

    public Result(){

    }

    public Result(String results){
        this.results = results;

    }

    public String getResult() {
        return results;
    }

    public void setResult(String results) {
        this.results = results;
    }

    public string toString(){
        return String.format("Results[results='%s']", results);
    }
}