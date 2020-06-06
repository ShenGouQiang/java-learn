package designpatterns.chanofresponsibility.servlet;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FilterChain {

    private List<Filter> filterList = new ArrayList<>();

    private int index =0;

    public void add(Filter filter){
        this.filterList.add(filter);
    }

    public void remove(Filter filter){
        this.remove(filter);
    }

    void  chain(Request request,Response response){
        if(index == filterList.size()){
            return;
        }
        filterList.get(index++).doFilter(request,response,this);
    }
}
