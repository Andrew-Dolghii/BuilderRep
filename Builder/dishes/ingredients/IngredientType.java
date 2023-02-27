package andrew.Builder.dishes.ingredients;

public enum IngredientType {
    BEAN(1, "bean"),
    BEEF(2, "beef"),
    CHICKEN(3, "chicken"),
    CUCUMBER(4, "cucumber"),
    KETCHUP(5, "ketchup"),
    POTATO(6, "potato"),
    SALAD(7, "salad"),
    TOMATO(8, "tomato"),
    OLIVES(9, "olives"),
    CHEESE(10, "cheese");

    private final String name;
    private final int id;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    IngredientType(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static IngredientType getById(int id){
        return IngredientType.values()[id-1];
    }
}
