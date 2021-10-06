package my.boot;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;

@Controller
@Scope("prototype")
public class MyOwnController {

    @Autowired
    CounterBean counter;

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

    @RequestMapping("/counter")
    @ResponseBody
    public String counter(Model model) {
        return "" + counter.incAndGet();
    }

}
