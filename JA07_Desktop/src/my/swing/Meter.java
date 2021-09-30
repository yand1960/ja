package my.swing;

import javax.ws.rs.client.ClientBuilder;

public class Meter {

    private String base_url = "http://yand.dyndns.org/Gaspipeline/pressure/get/";

    public String get(Integer n) {
       String url = base_url + n;
       String result =  ClientBuilder.newClient()
               .target(url)
               .request()
               .get(String.class);
       return result;
    }

}
