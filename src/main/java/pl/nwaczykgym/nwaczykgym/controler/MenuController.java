package pl.nwaczykgym.nwaczykgym.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @GetMapping(path = "/menu")
    public String menu(){
        return "Eins zwei polizei";
    }
}
