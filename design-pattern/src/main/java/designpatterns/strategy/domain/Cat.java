package designpatterns.strategy.domain;

import lombok.AllArgsConstructor;
        import lombok.Data;
        import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cat {
    private String name;
    private Double weight;
    private Integer age;
    private Sex sex;
}
