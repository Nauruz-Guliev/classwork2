package ru.kpfu.itis.gnt;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Properties;


public class FileHandler {
    private static final String PATH_TO_SAVE_INTO = "src/ru/kpfu/itis/gnt/downloads";

    private static final String IMAGE_FILE_FORMAT = ".png";
    private static final String PROPERTIES_FORMAT = ".properties";


    public static void saveImage(String imageUrl, String imageName) throws IOException {
        imageUrl = imageUrl.replaceAll("\\\\", "");
        URL url = new URL(imageUrl);
        URLConnection urlConnection = url.openConnection();
        System.out.println(url);
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(PATH_TO_SAVE_INTO +"/" + imageName + IMAGE_FILE_FORMAT));
             BufferedInputStream in = new BufferedInputStream(urlConnection.getInputStream())) {
            byte[] buffer = new byte[1024];
            int bytesRead = -1;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }


    public static void saveIngredients(String cocktailName, ArrayList<String> ingredients, ArrayList<String> ingredientDescriptions) throws IOException {
        /*
        Properties prop = new Properties();
        String pathToFileProperties = PATH_TO_SAVE_INTO + "/" +cocktailName + PROPERTIES_FORMAT;
        File newFile = new File(pathToFileProperties);
        if (!newFile.exists()){
            newFile.createNewFile();
        }
        try (InputStream in = new FileInputStream(pathToFileProperties)) {
            prop.load(in);
        }
        for(int i = 0; i<Math.min(ingredients.size(), ingredientDescriptions.size()); i++){
            prop.setProperty(ingredients.get(i), ingredientDescriptions.get(i));
            try ( OutputStream out = new FileOutputStream(pathToFileProperties)){
                prop.store(out, null);
            }
        }
         */
        StringBuilder result = new StringBuilder();
        String pathToFileProperties = PATH_TO_SAVE_INTO + "/" +cocktailName + PROPERTIES_FORMAT;
        for(int i = 0; i<Math.min(ingredients.size(), ingredientDescriptions.size()); i++){
            result.append(ingredients.get(i)).append("=").append(ingredientDescriptions.get(i)).append("\n");
        }
        try (BufferedWriter out = new BufferedWriter(new FileWriter(pathToFileProperties))) {
            out.write(result.toString());
        }
    }
}
