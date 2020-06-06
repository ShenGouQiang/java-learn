package designpatterns.chanofresponsibility.chain;

import designpatterns.chanofresponsibility.interfaces.TextInterface;
import designpatterns.chanofresponsibility.interfaces.WebFilter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shengouqiang
 * @date 2020/4/8
 */
public class ChainOfResponsibility implements  WebFilter{

    private List<WebFilter>  filterLisrt = new ArrayList<>();

    public boolean addFilter(WebFilter filter){
        filterLisrt.add(filter);
        return true;
    }

    public boolean removeFilter(WebFilter filter){
        filterLisrt.remove(filter);
        return true;
    }

    @Override
    public boolean doFilter(TextInterface text) {
        for(WebFilter filter : filterLisrt){
            if(!filter.doFilter(text)){
                return false;
            }
        }
        return true;
    }
}
