package tacos.bootstrap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import tacos.domain.Ingredient;
import tacos.repository.IngredientRepository;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private IngredientRepository ingredientRepository;

    @Override
    public void run(String... args) throws Exception {
 //       loadData();
    }

    private void loadData() {
        Ingredient ingredient1 = new Ingredient("FLTO", "Flour Tortilla", Ingredient.Type.WRAP);
        Ingredient ingredient2 = new Ingredient("COTO", "Corn Tortilla", Ingredient.Type.WRAP);
        Ingredient ingredient3 = new Ingredient("GRBF", "Ground Beef", Ingredient.Type.PROTEIN);
        Ingredient ingredient4 = new Ingredient("CARN", "Carnitas", Ingredient.Type.PROTEIN);
        Ingredient ingredient5 = new Ingredient("TMTO", "Diced Tomatoes", Ingredient.Type.VEGGIES);
        Ingredient ingredient6 = new Ingredient("LETC", "Lettuce", Ingredient.Type.VEGGIES);
        Ingredient ingredient7 = new Ingredient("CHED", "Cheddar", Ingredient.Type.CHEESE);
        Ingredient ingredient8 = new Ingredient("JACK", "Monterrey Jack", Ingredient.Type.CHEESE);
        Ingredient ingredient9 = new Ingredient("SLSA", "Salsa", Ingredient.Type.SAUCE);
        Ingredient ingredient10 = new Ingredient("SRCR", "Sour Cream", Ingredient.Type.SAUCE);

        ingredientRepository.save(ingredient1);
        ingredientRepository.save(ingredient2);
        ingredientRepository.save(ingredient3);
        ingredientRepository.save(ingredient4);
        ingredientRepository.save(ingredient5);
        ingredientRepository.save(ingredient6);
        ingredientRepository.save(ingredient7);
        ingredientRepository.save(ingredient8);
        ingredientRepository.save(ingredient9);
        ingredientRepository.save(ingredient10);
    }
}
