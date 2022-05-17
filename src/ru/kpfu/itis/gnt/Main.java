package ru.kpfu.itis.gnt;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

public class Main {
    private static Scanner sc;
    private static String nameOfCocktail;
    private static String responseBodyCocktail;
    private static String responseBodyIngredient;
    private static CocktailDetailsParser parserDetail;
    private static CocktailIngredientParser parserIngredient;
    private static String cocktailName;
    private static String cocktailId;

    public static void main(String[] args) {
        userInteractor();
    }
    public static void userInteractor() {
        try {
            System.out.print("Type in the name of your cocktail: ");
            sc = new Scanner(System.in);
            nameOfCocktail = sc.nextLine();
            responseBodyCocktail = UrlResponse.getHttpResponse(CocktailUrls.getCocktailNameUrl(nameOfCocktail));
            parserDetail = new CocktailDetailsParser(responseBodyCocktail);
            cocktailId = parserDetail.getCocktailId().get(0);
            cocktailName = parserDetail.getCocktailName().get(0);
            responseBodyIngredient = UrlResponse.getHttpResponse(CocktailUrls.getCocktailIngredientsUrl(cocktailId));
            parserIngredient = new CocktailIngredientParser(responseBodyIngredient);
            FileHandler.saveImage(parserDetail.getImageUrl().get(0), cocktailName);
            FileHandler.saveIngredients(nameOfCocktail, parserIngredient.getIngredientName(), parserIngredient.getIngredientABV());
            System.out.println(nameOfCocktail + " has been saved successfully!");

        }catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        } catch (IndexOutOfBoundsException e){
            System.out.println("such a cocktail has not been found");
        }
    }
}
