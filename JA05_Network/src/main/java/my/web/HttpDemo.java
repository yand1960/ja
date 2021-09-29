package my.web;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.ws.rs.Consumes;
import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpDemo {
    public static void main1(String[] args) throws IOException {
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


    public static void main(String[] args) throws IOException {
//    У ЦБР есть служба, возвращающая курсы валют
//    https://www.cbr-xml-daily.ru/daily_json.js
//    Используйте ее для получения курса USD

        String url = "https://www.cbr-xml-daily.ru/daily_json.js";

        Client client = ClientBuilder.newClient();
        CBRData data = ClientBuilder.newClient()
                .register(CbrCorrectionFilter.class) //ЦБР передает неверный заголовок. Приходится подсказывать
                .target(url)
                .request()
                .get(CBRData.class);
        System.out.println(data.getValute().get("USD").getValue());
    }
}

class CBRData {
    private String date;
    private String previousDate;
    private String previousURL;
    private String timestamp;
    private HashMap<String,Rate> valute;

    @JsonProperty("PreviousDate") //из-за неадекватной капитализации приходится указывать название свойства
    public String getPreviousDate() {
        return previousDate;
    }

    public void setPreviousDate(String previousDate) {
        this.previousDate = previousDate;
    }

    @JsonProperty("PreviousURL")
    public String getPreviousURL() {
        return previousURL;
    }

    public void setPreviousURL(String previousURL) {
        this.previousURL = previousURL;
    }

    @JsonProperty("Timestamp")
    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @JsonProperty("Date")
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("Valute")
    public HashMap<String, Rate> getValute() {
        return valute;
    }

    public void setValute(HashMap<String, Rate> valute) {
        this.valute = valute;
    }
}

class Rate {
    private String id;
    private String numCode;
    private String charCode;
    private int nominal;
    private String name;
    private Double value;
    private Double previous;

    @JsonProperty("NumCode")
    public String getNumCode() {
        return numCode;
    }

    public void setNumCode(String numCode) {
        this.numCode = numCode;
    }

    @JsonProperty("CharCode")
    public String getCharCode() {
        return charCode;
    }

    public void setCharCode(String charCode) {
        this.charCode = charCode;
    }

    @JsonProperty("Nominal")
    public int getNominal() {
        return nominal;
    }

    public void setNominal(int nominal) {
        this.nominal = nominal;
    }

    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("Value")
    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @JsonProperty("Previous")
    public Double getPrevious() {
        return previous;
    }

    public void setPrevious(Double previous) {
        this.previous = previous;
    }

    @JsonProperty("ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

