package designpatterns.chanofresponsibility.filter;

import designpatterns.chanofresponsibility.interfaces.TextInterface;
import designpatterns.chanofresponsibility.interfaces.WebFilter;

/**
 * @author shengouqiang
 * @date 2020/4/10
 */
public class FaceFilter implements WebFilter {
    @Override
    public boolean doFilter(TextInterface text) {
        text.setText(text.getText().replaceAll(":\\)","^_^"));
        return true;
    }
}
