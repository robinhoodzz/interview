package com.designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/4/23.
 */
public class ObjectStructure {

    private List<Element> elements = new ArrayList<Element>();

    public void attach(Element element){
        elements.add(element);
    }

    public void detach(Element element){
        elements.remove(element);
    }

    public void accept(Visitor visitor){
        for(int i=0; i<elements.size(); i++){
            elements.get(i).accept(visitor);
        }
    }

}
