package my.web;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpDemo {
    public static void main(String[] args) throws IOException {
        String address = "http://cbr.ru";
        URL url = new URL(address);
        HttpURLConnection cn = (HttpURLConnection) url.openConnection();

        BufferedReader reader = new BufferedReader(
                 new InputStreamReader((InputStream) cn.getContent())
                );
        String result = "";
        while(reader.ready()) {
            result += reader.readLine() + "\n";
        }

//        int position = result.indexOf("USD");
//        result = result.substring(position,position + 100);
//        String pattern = "mono-num\">";
//        int position1 = result.indexOf(pattern) + pattern.length();
//        int position2 = result.indexOf("₽");
//        result = result.substring(position1, position2);
//        System.out.println(result);

        String pattern = "USD[\\S\\s]+?mono-num\">(\\S+)";
        Matcher matcher = Pattern.compile(pattern).matcher(result);
        matcher.find();
        System.out.println(matcher.group(1));
    }
}
