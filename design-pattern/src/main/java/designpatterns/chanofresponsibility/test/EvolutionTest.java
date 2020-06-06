package designpatterns.chanofresponsibility.test;

import designpatterns.chanofresponsibility.chain.ChainOfResponsibility;
import designpatterns.chanofresponsibility.domain.RichText;
import designpatterns.chanofresponsibility.filter.FaceFilter;
import designpatterns.chanofresponsibility.filter.ScriptFilter;
import designpatterns.chanofresponsibility.filter.WorkFilter;
import designpatterns.chanofresponsibility.interfaces.TextInterface;

/**
 * @author shengouqiang
 * @date 2020/4/10
 */
public class EvolutionTest {

    public static void main(String[] args) {
        TextInterface text = new RichText();
        text.setText("<script>Hello,:). 996, welcome to back</script>");

        ChainOfResponsibility chain = new ChainOfResponsibility();

        chain.addFilter(new FaceFilter());
        chain.addFilter(new ScriptFilter());
        chain.addFilter(new WorkFilter());

        chain.doFilter(text);

        System.out.println(text);
    }

}
