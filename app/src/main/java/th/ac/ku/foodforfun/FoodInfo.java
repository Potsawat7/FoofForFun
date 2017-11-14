package th.ac.ku.foodforfun;

/**
 * Created by Admin on 11/12/2017.
 */

public class FoodInfo {
    private String name, category, recipe , steps;
    private String image;

    public FoodInfo(String name, String category, String recipe, String steps, String image) {
        this.name = name;
        this.category = category;
        this.recipe = recipe;
        this.steps = steps;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
