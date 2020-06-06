package designpatterns.chanofresponsibility.servlet;

/**
 * @author shengouqiang
 * @date 2020/4/10
 */
public class FaceFilter implements Filter {
    @Override
    public void doFilter(Request request,Response response,FilterChain chain) {
        request.setRequestStr(request.getRequestStr().replaceAll(":\\)","^_^"));
        chain.chain(request,response);
        response.setResponseStr(response.getResponseStr()+" --Face ");
    }
}
