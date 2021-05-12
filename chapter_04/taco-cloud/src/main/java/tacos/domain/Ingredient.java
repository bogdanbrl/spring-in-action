package tacos.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "ingredients")
public class Ingredient {

    @Id
    private String id;

    private String name;

    @Enumerated(EnumType.STRING)
    private Type Type;

    public Ingredient(String id, String name, Ingredient.Type type) {
        this.id = id;
        this.name = name;
        Type = type;
    }

    public Ingredient() {

    }

    public enum Type {
        WRAP,
        PROTEIN,
        VEGGIES,
        CHEESE,
        SAUCE
    }

}


