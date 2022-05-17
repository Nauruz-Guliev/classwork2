package ru.kpfu.itis.gnt;

import java.net.MalformedURLException;
import java.net.URL;

public class CocktailUrls {
    private final static String COCKTAIL_NAME_URL = "https://thecocktaildb.com/api/json/v1/1/search.php?s=";
    private final static String COCKTAIL_INGREDIENTS_URL = "https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i=";
    public static URL getCocktailNameUrl(String name) throws MalformedURLException {
        return new URL(COCKTAIL_NAME_URL+ name);
    }
    public static URL getCocktailIngredientsUrl(String name) throws MalformedURLException {
        return new URL(COCKTAIL_INGREDIENTS_URL + name);
    }

}
