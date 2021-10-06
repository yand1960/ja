package my.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ProductController {

    @RequestMapping("/time")
    public String time() {
        return (new Date()).toString();
    }

}
