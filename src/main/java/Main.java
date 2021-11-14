import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

public class Main {
    static OkHttpClient client = new OkHttpClient();
    public static void main(String[] args) throws IOException, ParseException {

        // "https://api.pro.coinbase.com/products/ETH-USDT/book"
        String result = run("https://api.pro.coinbase.com/products");
        System.out.println(result);
//        JSONParser parser = new JSONParser();
//        JSONObject json = (JSONObject) parser.parse(stringToParse);
        //Using the JSON simple library parse the string into a json object
        JSONParser parse = new JSONParser();
        Object obj  = parse.parse(result);

        System.out.println("data_obj = " + obj.toString());

    }


    public static String run(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}