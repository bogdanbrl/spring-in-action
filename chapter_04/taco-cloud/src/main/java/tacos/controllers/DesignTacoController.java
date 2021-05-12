package tacos.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import tacos.domain.Ingredient;
import tacos.domain.Ingredient.Type;
import tacos.domain.Order;
import tacos.domain.Taco;
import tacos.services.IngredientService;
import tacos.services.OrderService;
import tacos.services.TacoService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {

    private IngredientService ingredientService;
    private TacoService tacoService;
    private OrderService orderService;

    public DesignTacoController(IngredientService ingredientService, TacoService tacoService, OrderService orderService) {
        this.ingredientService = ingredientService;
        this.tacoService = tacoService;
        this.orderService = orderService;
    }

    @ModelAttribute(name = "order")
    public Order order(){
        return new Order();
    }

    @ModelAttribute(name = "taco")
    public Taco taco(){
        return new Taco();
    }

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientService.getAll().forEach(i -> ingredients.add(i));

        Type[] types = Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(ingredients, type));
        }
        return "design";
    }

    @PostMapping
    public String processDesign(@Valid Taco taco, Errors errors, @ModelAttribute Order order) {
        if (errors.hasErrors()) {
            return "design";
        }

        tacoService.add(taco);
        order.getTacos().add(taco);

        log.info("Processing design: " + taco);
        return "redirect:/orders/current";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
