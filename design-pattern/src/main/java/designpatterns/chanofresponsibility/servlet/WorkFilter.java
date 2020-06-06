package designpatterns.chanofresponsibility.servlet;

import designpatterns.chanofresponsibility.interfaces.TextInterface;
import designpatterns.chanofresponsibility.interfaces.WebFilter;

/**
 * @author shengouqiang
 * @date 2020/4/10
 */
public class WorkFilter implements Filter {
    @Override
    public void doFilter(Request request,Response response,FilterChain chain) {
        request.setRequestStr(request.getRequestStr().replaceAll("996","965"));
        chain.chain(request,response);
        response.setResponseStr(response.getResponseStr()+" --Work ");
    }
}
