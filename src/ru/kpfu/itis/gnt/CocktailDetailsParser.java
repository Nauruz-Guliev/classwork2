package ru.kpfu.itis.gnt;

import java.util.ArrayList;

public class CocktailDetailsParser {
    private final String responseBody;
    private final static String IMAGE_URL_REGEX = "(strDrinkThumb[:\"]+)([-\\:\\/\\\\.,a-zA-Z\\s0-9]+)";
    private final static String COCKTAIL_NAME_REGEX = "(strDrink[\":]+)([a-zA-Z]+)";
    private final static String COCKTAIL_ID = "(idDrink[\":]+)([0-9a-zA-Z\\s]+)";
    public CocktailDetailsParser(String responseBody){
        this.responseBody = responseBody;
    }
    public ArrayList<String> getImageUrl(){
        return RegexOccurrences.getResult(IMAGE_URL_REGEX, responseBody);
    }
    public ArrayList<String> getCocktailName() {
        return RegexOccurrences.getResult(COCKTAIL_NAME_REGEX, responseBody);
    }
    public ArrayList<String> getCocktailId(){
        return RegexOccurrences.getResult(COCKTAIL_ID, responseBody);
    }
}
