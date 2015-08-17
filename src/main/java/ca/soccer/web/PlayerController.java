package ca.soccer.web;


import ca.soccer.config.Helper;
import ca.soccer.domain.Player;
import ca.soccer.domain.Position;
import ca.soccer.domain.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.math.BigDecimal;

import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.GET;


@Controller
@RequestMapping("/players")
public class PlayerController {
    @Autowired
    Helper helper;

    @RequestMapping(value="/show", method=RequestMethod.GET)
    public String showPlayer(
            Model model, HttpSession session) {
        model.addAttribute( (Player) session.getAttribute("player") );
        return "playerDetails";
    }

    @RequestMapping(value="/registerPlayer", method=POST)
    public String processRegistration(
            @RequestParam(value="position", defaultValue="Goalkeeper") Position position,
            @RequestParam(value="salary", defaultValue="0") BigDecimal salary,
            @RequestParam(value="goals", defaultValue="0") int goals,
            @RequestParam(value="bookings", defaultValue="0") int bookings,
            @Valid Player player, Errors errors,
            HttpSession session
            ) {
        Statistics statistics=new Statistics(goals,bookings);
        player.setStatistics(statistics);
        player.setPosition(position);
        player.setAnnualSalary(salary);
        if (errors.hasErrors()) {
            return "/registerPlayer";
        }

        if (!helper.validatePlayer(player))
            return "/registerPlayer";

        session.setAttribute("player", player);

        return "redirect:/players/show/";
    }


    @RequestMapping(value="/registerPlayer", method=GET)
    public String showRegistrationForm() {
        return "registerPlayer";
    }
}