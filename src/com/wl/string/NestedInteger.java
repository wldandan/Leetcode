package com.wl.string;

import java.util.ArrayList;
import java.util.List;

public class NestedInteger {

    private Integer value;
    private List<NestedInteger> lists = new ArrayList<>();

    public NestedInteger(){}

    public NestedInteger(int value){
        this.value = value;
    }

    public void add(NestedInteger ni){
        lists.add(ni);
    }

    public void setInteger(int value){
        this.value = value;
    }

    public Integer getInteger() {
        return this.value;
    }

    public boolean isInteger(){
        return this.value instanceof Integer;
    }

    public List<NestedInteger> getList(){
        return lists;
    }
  }