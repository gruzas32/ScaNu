package entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Recipes {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "recipe_id")
    private int recipeId;
   @Basic
    @Column(name = "recipe_name")
    private String recipeName;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "eggs")
    private boolean eggs;
    @Basic
    @Column(name = "milk")
    private boolean milk;
    @Basic
    @Column(name = "cheese")
    private boolean cheese;
    @Basic
    @Column(name = "sausage")
    private boolean sausage;
    @Basic
    @Column(name = "cucumber")
    private boolean cucumber;
    @Basic
    @Column(name = "tomato")
    private boolean tomato;
    @Basic
    @Column(name = "cream")
    private boolean cream;
    @Basic
    @Column(name = "sugar")
    private boolean sugar;
    @Basic
    @Column(name = "water")
    private boolean water;
    @Basic
    @Column(name = "flour")
    private boolean flour;
    @Basic
    @Column(name = "saliami")
    private boolean saliami;
    @Basic
    @Column(name = "macaroni")
    private boolean macaroni;
    @Basic
    @Column(name = "tomatosauce")
    private boolean tomatosauce;
    @Basic
    @Column(name = "spaghetti")
    private boolean spaghetti;
    @Basic
    @Column(name = "calendar")
    private boolean calendar;
    @Basic
    @Column(name = "cabbage")
    private boolean cabbage;
    @Basic
    @Column(name = "onion")
    private boolean onion;
    @Basic
    @Column(name = "carrot")
    private boolean carrot;
    @Basic
    @Column(name = "radish")
    private boolean radish;
    @Basic
    @Column(name = "potatoes")
    private boolean potatoes;
    @Basic
    @Column(name = "breakfast")
    private boolean breakfast;
    @Basic
    @Column(name = "snack")
    private boolean snack;
    @Basic
    @Column(name = "christmas")
    private boolean christmas;
    @Basic
    @Column(name = "evening")
    private boolean evening;
    @Basic
    @Column(name = "newyear")
    private boolean newyear;
    @Basic
    @Column(name = "bbq")
    private boolean bbq;
    @Basic
    @Column(name = "dinner")
    private boolean dinner;
    @Basic
    @Column(name = "nightfood")
    private boolean nightfood;
    @Basic
    @Column(name = "mayo")
    private boolean mayo;

    public Recipes(int recipeId, String recipeName, String description, boolean eggs, boolean milk, boolean cheese, boolean sausage, boolean cucumber, boolean tomato, boolean cream, boolean sugar, boolean water, boolean flour, boolean saliami, boolean macaroni, boolean tomatosauce, boolean spaghetti, boolean calendar, boolean cabbage, boolean onion, boolean carrot, boolean radish, boolean potatoes, boolean breakfast, boolean snack, boolean christmas, boolean evening, boolean newyear, boolean bbq, boolean dinner, boolean nightfood, boolean mayo) {
        this.recipeId = recipeId;
        this.recipeName = recipeName;
        this.description = description;
        this.eggs = eggs;
        this.milk = milk;
        this.cheese = cheese;
        this.sausage = sausage;
        this.cucumber = cucumber;
        this.tomato = tomato;
        this.cream = cream;
        this.sugar = sugar;
        this.water = water;
        this.flour = flour;
        this.saliami = saliami;
        this.macaroni = macaroni;
        this.tomatosauce = tomatosauce;
        this.spaghetti = spaghetti;
        this.calendar = calendar;
        this.cabbage = cabbage;
        this.onion = onion;
        this.carrot = carrot;
        this.radish = radish;
        this.potatoes = potatoes;
        this.breakfast = breakfast;
        this.snack = snack;
        this.christmas = christmas;
        this.evening = evening;
        this.newyear = newyear;
        this.bbq = bbq;
        this.dinner = dinner;
        this.nightfood = nightfood;
        this.mayo = mayo;
    }

    public Recipes() {

    }

    public boolean isMayo() {
        return mayo;
    }

    public void setMayo(boolean mayo) {
        this.mayo = mayo;
    }

    public int getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isEggs() {
        return eggs;
    }

    public void setEggs(boolean eggs) {
        this.eggs = eggs;
    }

    public boolean isMilk() {
        return milk;
    }

    public void setMilk(boolean milk) {
        this.milk = milk;
    }

    public boolean isCheese() {
        return cheese;
    }

    public void setCheese(boolean cheese) {
        this.cheese = cheese;
    }

    public boolean isSausage() {
        return sausage;
    }

    public void setSausage(boolean sausage) {
        this.sausage = sausage;
    }

    public boolean isCucumber() {
        return cucumber;
    }

    public void setCucumber(boolean cucumber) {
        this.cucumber = cucumber;
    }

    public boolean isTomato() {
        return tomato;
    }

    public void setTomato(boolean tomato) {
        this.tomato = tomato;
    }

    public boolean isCream() {
        return cream;
    }

    public void setCream(boolean cream) {
        this.cream = cream;
    }

    public boolean isSugar() {
        return sugar;
    }

    public void setSugar(boolean sugar) {
        this.sugar = sugar;
    }

    public boolean isWater() {
        return water;
    }

    public void setWater(boolean water) {
        this.water = water;
    }

    public boolean isFlour() {
        return flour;
    }

    public void setFlour(boolean flour) {
        this.flour = flour;
    }

    public boolean isSaliami() {
        return saliami;
    }

    public void setSaliami(boolean saliami) {
        this.saliami = saliami;
    }

    public boolean isMacaroni() {
        return macaroni;
    }

    public void setMacaroni(boolean macaroni) {
        this.macaroni = macaroni;
    }

    public boolean isTomatosauce() {
        return tomatosauce;
    }

    public void setTomatosauce(boolean tomatosauce) {
        this.tomatosauce = tomatosauce;
    }

    public boolean isSpaghetti() {
        return spaghetti;
    }

    public void setSpaghetti(boolean spaghetti) {
        this.spaghetti = spaghetti;
    }

    public boolean isCalendar() {
        return calendar;
    }

    public void setCalendar(boolean calendar) {
        this.calendar = calendar;
    }

    public boolean isCabbage() {
        return cabbage;
    }

    public void setCabbage(boolean cabbage) {
        this.cabbage = cabbage;
    }

    public boolean isOnion() {
        return onion;
    }

    public void setOnion(boolean onion) {
        this.onion = onion;
    }

    public boolean isCarrot() {
        return carrot;
    }

    public void setCarrot(boolean carrot) {
        this.carrot = carrot;
    }

    public boolean isRadish() {
        return radish;
    }

    public void setRadish(boolean radish) {
        this.radish = radish;
    }

    public boolean isPotatoes() {
        return potatoes;
    }

    public void setPotatoes(boolean potatoes) {
        this.potatoes = potatoes;
    }

    public boolean isBreakfast() {
        return breakfast;
    }

    public void setBreakfast(boolean breakfast) {
        this.breakfast = breakfast;
    }

    public boolean isSnack() {
        return snack;
    }

    public void setSnack(boolean snack) {
        this.snack = snack;
    }

    public boolean isChristmas() {
        return christmas;
    }

    public void setChristmas(boolean christmas) {
        this.christmas = christmas;
    }

    public boolean isEvening() {
        return evening;
    }

    public void setEvening(boolean evening) {
        this.evening = evening;
    }

    public boolean isNewyear() {
        return newyear;
    }

    public void setNewyear(boolean newyear) {
        this.newyear = newyear;
    }

    public boolean isBbq() {
        return bbq;
    }

    public void setBbq(boolean bbq) {
        this.bbq = bbq;
    }

    public boolean isDinner() {
        return dinner;
    }

    public void setDinner(boolean dinner) {
        this.dinner = dinner;
    }

    public boolean isNightfood() {
        return nightfood;
    }

    public void setNightfood(boolean nightfood) {
        this.nightfood = nightfood;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipes products = (Recipes) o;
        return recipeId == products.recipeId && Objects.equals(recipeName, products.recipeName) && Objects.equals(description, products.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, recipeName, description);
    }
}
