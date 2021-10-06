package my.boot;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.HashMap;

@Controller
public class MyOwnController {

    @RequestMapping("/time")
    public String time(Model model) {
        HashMap<String, String> poets = new HashMap<>();
        poets.put("Гомер","Одиссея");
        poets.put("Пушкин","Евгений Онегин");
        poets.put("Бродский","Стихи");
        model.addAttribute("data", (new Date()).toString());
        model.addAttribute("poets", poets);
        return "time"; //имя представления
    }
}
