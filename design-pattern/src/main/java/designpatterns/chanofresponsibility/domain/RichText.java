package designpatterns.chanofresponsibility.domain;

import designpatterns.chanofresponsibility.interfaces.TextInterface;
import lombok.ToString;

/**
 * @author shengouqiang
 * @date 2020/4/8
 */
@ToString
public class RichText implements TextInterface {

    private String textContent;

    @Override
    public String getText() {
        return textContent;
    }

    @Override
    public void setText(String txt) {
        this.textContent = txt;
    }
}
