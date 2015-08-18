package ca.soccer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import ca.soccer.config.Helper;
import ca.soccer.domain.Trainer;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/trainers")
public class TrainerController {
    @Autowired
    Helper helper;

    @RequestMapping(value="/show", method=RequestMethod.GET)
    public String showTrainer(Model model,  HttpSession session) {
        model.addAttribute((Trainer) session.getAttribute("trainer"));
        return "trainerDetails";
    }

    @RequestMapping(value="/registerTrainer", method=POST)
    public String processRegistration(
            @RequestParam(value="salary", defaultValue="0") BigDecimal salary,
            @Valid Trainer trainer, Errors errors,
            HttpSession session) {
        trainer.setAnnualSalary(salary);
        if (errors.hasErrors()) {
            return "/registertrainer";
        }

        if (!helper.validateTrainer(trainer))
            return "/registerTrainer";

        session.setAttribute("trainer", trainer);
        return "redirect:/trainers/show" ;
    }


    @RequestMapping(value="/registerTrainer", method=GET)
    public String showRegistrationForm() {
        return "registerTrainer";
    }

}

