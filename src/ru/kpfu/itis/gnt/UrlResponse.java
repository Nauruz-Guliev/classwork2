package ru.kpfu.itis.gnt;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;

public class UrlResponse {
    public static String getHttpResponse(URL url) throws InterruptedException {
        StringBuilder responseBody = new StringBuilder();
        try (BufferedInputStream in = new BufferedInputStream(url.openStream())) {
            int b;
            while ((b = in.read()) != -1) {
                responseBody.append((char) b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Thread.sleep(1000);
        return responseBody.toString();
    }
}
