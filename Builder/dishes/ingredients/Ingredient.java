package andrew.Builder.dishes.ingredients;

import java.time.LocalDateTime;
import java.util.Objects;

public class Ingredient {

    private final IngredientType type;
    private final String supplier;
    private final LocalDateTime productionDate;
    private final LocalDateTime bestBeforeDate;

    public Ingredient(IngredientType type, String supplier, LocalDateTime productionDate, LocalDateTime bestBeforeDate) {
        this.type = type;
        this.supplier = supplier;
        this.productionDate = productionDate;
        this.bestBeforeDate = bestBeforeDate;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "type=" + type +
                ", supplier='" + supplier + '\'' +
                ", productionDate=" + productionDate +
                ", bestBeforeDate=" + bestBeforeDate +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() !=  o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return type == that.type && supplier.equals(that.supplier) && productionDate.equals(that.productionDate)
                && bestBeforeDate.equals(that.bestBeforeDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, supplier, productionDate, bestBeforeDate);
    }

    public IngredientType getType() {
        return type;
    }

    public String getSupplier() {
        return supplier;
    }

    public LocalDateTime getProductionDate() {
        return productionDate;
    }

    public LocalDateTime getBestBeforeDate() {
        return bestBeforeDate;
    }
}
