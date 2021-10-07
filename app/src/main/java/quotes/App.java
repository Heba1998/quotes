/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package quotes;


import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.List;

public class App {


    public static void main(String[] args) throws FileNotFoundException {
        String path = "app/src/main/resources/recentquotes.json";
        ShowQuote(path);
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

}