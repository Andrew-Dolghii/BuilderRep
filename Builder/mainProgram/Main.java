package andrew.Builder.mainProgram;

import andrew.Builder.dishes.builders.OrderBuilder;
import andrew.Builder.dishes.builders.PizzaBuilder;
import andrew.Builder.dishes.dessert.Cake;
import andrew.Builder.dishes.drinks.FruitFresh;
import andrew.Builder.dishes.first_dish.Bouillon;
import andrew.Builder.dishes.first_dish.Soup;
import andrew.Builder.dishes.ingredients.Ingredient;
import andrew.Builder.dishes.ingredients.IngredientType;
import andrew.Builder.dishes.second_dish.Macaroni;
import andrew.Builder.dishes.second_dish.Pizza;
import andrew.Builder.dishes.snacks.CheeseSticks;
import andrew.Builder.dishes.types.FirstDish;
import andrew.Builder.dishes.types.Snack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Order order = new OrderBuilder()
                .addSnack(new CheeseSticks())
                .addDessert(new Cake())
                .build();

        Order order1 = new OrderBuilder()
                .addFirstDish(new Soup())
                .addSecondDish(new Macaroni())
                .addDrink(new FruitFresh())
                .build();

        OrderBuilder orderBuilder = new OrderBuilder();
        Snack snack = new CheeseSticks();
        orderBuilder.addSnack(snack);

        FirstDish firstDish = new Bouillon();
        orderBuilder.addFirstDish(firstDish);

        Order order2 = orderBuilder.build();

        String str = "abc";
        StringBuilder stringBuilder = new StringBuilder();
        String newStr = stringBuilder.toString();

        Pizza pizza = makePizza();
        System.out.println(pizza);
    }

    public static Pizza makePizza(){
        PizzaBuilder pizzaBuilder = new PizzaBuilder();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Hello");
        System.out.println("Choose the base of the pizza: 1 - thin, 2 - normal, 3 - thick, 4 - covered");

        String doughBase;
        try{
            String answer = reader.readLine();
            switch(answer){
                case "1":
                    doughBase = "thin";
                    break;
                case "3":
                    doughBase = "thick";
                    break;
                case "4":
                    doughBase = "covered";
                    break;
                default:
                    doughBase = "normal";
                    break;
            }
            pizzaBuilder.setDoughBase(doughBase);
        } catch(IOException e){
            System.out.println("In choosing the base of the pizza, an error occurred");
        }

        try{
            System.out.println("Add ingredients: \n"
                + Arrays.stream(IngredientType.values())
                    .map(ingredientType -> ingredientType.getId() + " - " + ingredientType.getName())
                    .collect(Collectors.joining(", ")));
            System.out.println("Enter \"enough\" for finalization of ingredient selection");
            String answer;
            while(!(answer = reader.readLine()).equals("enough")){
                Ingredient ingredient = new Ingredient(
                        IngredientType.getById(Integer.parseInt(answer)),
                        "our supplier",
                        LocalDateTime.now(),
                        LocalDateTime.MAX);
                pizzaBuilder.addIngredient(ingredient);
            }
        } catch(IOException e){
            System.out.println("In adding the ingredients, an error occurred");
        }
        return pizzaBuilder.build();
    }
}
