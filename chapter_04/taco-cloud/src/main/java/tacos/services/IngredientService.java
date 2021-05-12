package tacos.services;

import org.springframework.stereotype.Service;
import tacos.domain.Ingredient;
import tacos.repository.IngredientRepository;

import java.util.List;

@Service
public class IngredientService {

    private IngredientRepository ingredientRepository;

    public IngredientService(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    public List<Ingredient> getAll(){
        return ingredientRepository.findAll();
    }
}
