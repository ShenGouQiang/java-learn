package designpatterns.strategy.domain;

import lombok.Getter;

@Getter
public enum Sex {

    /**
     * 雄性
     */
    MALE("1","雄性"),
    /**
     * 雌性
     */
    FEMALE("2","雌性");

    private String code;

    private String desc;

    Sex(String code,String desc){
        this.code=code;
        this.desc=desc;
    }
}
