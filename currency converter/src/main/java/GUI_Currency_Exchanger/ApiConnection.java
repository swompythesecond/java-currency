package GUI_Currency_Exchanger;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiConnection {
    public static double CNY = 0;
    public static double EUR = 0;
    public static double JPY = 0;
    public static double AUD = 0;
    public static double USD = 0;

    public ApiConnection() throws IOException {
        URL url = new URL("https://openexchangerates.org/api/latest.json?app_id=aeaf4078ed1e4e83a96d03c630958082&base=USD");


        HttpURLConnection connection = (HttpURLConnection) url.openConnection();


        connection.setRequestProperty("accept", "application/json");

        JsonElement root = JsonParser.parseReader(new InputStreamReader((InputStream) connection.getContent()));
        JsonObject jsonObject = root.getAsJsonObject();
        try {
            CNY = jsonObject.get("rates").getAsJsonObject().get("CNY").getAsDouble();
            EUR = jsonObject.get("rates").getAsJsonObject().get("EUR").getAsDouble();
            JPY = jsonObject.get("rates").getAsJsonObject().get("JPY").getAsDouble();
            AUD = jsonObject.get("rates").getAsJsonObject().get("AUD").getAsDouble();
            USD = jsonObject.get("rates").getAsJsonObject().get("USD").getAsDouble();



        } catch (Exception exception) {
            System.out.println("Error while fetching");
        }
    }






}
