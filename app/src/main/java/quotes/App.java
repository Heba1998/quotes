/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;


import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class App {

// lab9

    public static void main(String[] args) throws IOException {
        ShowapiQuotes("http://api.forismatic.com/api/1.0/?method=getQuote&format=json&lang=en");
    }

    public static List ShowQuote(String path) throws FileNotFoundException {
        Gson gson = new Gson();
        FileReader fileReader = null;
        if (fileReader == null){
            fileReader = new FileReader(path);
        }else {
            System.out.println("No Quotes");
        }

        Type quoteType = new TypeToken<List<Quotes>>(){}.getType();
        List<Quotes> RandomQuotes = gson.fromJson(fileReader, quoteType);
        int random = (int)(Math.random() * RandomQuotes.size());
        System.out.println(RandomQuotes.get(random).toString());

        return RandomQuotes;
    }

    public static String ShowapiQuotes(String url) throws IOException {

        try {
        StringBuilder createdLine = new StringBuilder();
        HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();

        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);

        int responseCode = connection.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {

            InputStreamReader inputStreamReader = new InputStreamReader(connection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String data = bufferedReader.readLine();
            createdLine = new StringBuilder(data);
            System.out.println(data);
            createdLine.append(data);
            bufferedReader.close();
            FileWriter fileToWrite = new FileWriter("NewQuotes.json");
            fileToWrite.write(createdLine.toString());
            fileToWrite.close();
        } else {
            ShowQuote("app/src/main/resources/recentquotes.json");
        }} catch (IOException e) {
            ShowQuote("app/src/main/resources/recentquotes.json");
        }
        return url;

    }

}