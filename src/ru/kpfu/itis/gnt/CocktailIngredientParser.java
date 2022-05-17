package ru.kpfu.itis.gnt;

import java.util.ArrayList;

public class CocktailIngredientParser {
    private final static String INGREDIENT_REGEX = "(strIngredient[0-9\":]+)([a-zA-Z\\s]+)";
    private final static String INGREDIENT_AMOUNT_REGEX = "(strMeasure[0-9\":]+)([a-zA-Z\\s]+)";
    private String responseBody;
    public CocktailIngredientParser(String responseBody){
        this.responseBody = responseBody;
    }
    public ArrayList<String> getIngredientName(){
        return RegexOccurrences.getResult(INGREDIENT_REGEX, responseBody);
    }
    public ArrayList<String> getIngredientABV(){
        return RegexOccurrences.getResult(INGREDIENT_AMOUNT_REGEX, responseBody);
    }
}
