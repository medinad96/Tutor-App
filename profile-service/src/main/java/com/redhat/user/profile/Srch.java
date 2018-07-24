package com.redhat.user.profile;

import org.infinispan.protostream.annotations.ProtoField;

public class Srch {
    @ProtoField(number = 22)
    public String keywords;

    public Srch(){

    }

    public Srch(String keywords){
        this.keywords = keywords;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String toString(){
        return String.format("Srch[keywords='%s']", keywords);
    }

}
