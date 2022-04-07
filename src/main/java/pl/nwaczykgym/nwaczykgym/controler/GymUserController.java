package pl.nwaczykgym.nwaczykgym.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.nwaczykgym.nwaczykgym.model.GymUser;

@RestController
public class GymUserController {



    @PostMapping(path = "/user/create")
    public void createGymUser(@RequestBody() GymUser gymUser){



    }

}
