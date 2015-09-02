package ca.soccer.web;


import ca.soccer.config.Helper;
import ca.soccer.db.HibernatePlayerRepository;
import ca.soccer.db.PlayerRepository;
import ca.soccer.domain.Player;
import ca.soccer.domain.Position;
import ca.soccer.domain.Statistics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
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

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerController(PlayerRepository playerRepository) {
        this.playerRepository=playerRepository;
    }


    @RequestMapping(value="/show", method=RequestMethod.GET)
    public String showPlayer(
            Model model, HttpSession session) {
        model.addAttribute((Player) session.getAttribute("player"));
        return "playerDetails";
    }

    @RequestMapping(value="/{playerId}", method=RequestMethod.GET)
    public String player(
            @PathVariable("playerId") String playerId,
            Model model) {
        model.addAttribute(playerRepository.findOne(playerId));
        return "playerDetails";
    }

    @RequestMapping(value="/registerPlayer", method=POST)
    public String processRegistration(
            @Valid Player player, Errors errors) {
        if (errors.hasErrors()) {
            return "/registerPlayer";
        }
        if (!helper.validatePlayer(player))
            return "/registerPlayer";

        playerRepository.save(player);
        return "redirect:/players/" + player.getFirstName();
    }


    @RequestMapping(value="/registerPlayer", method=GET)
    public String showRegistrationForm() {
        return "registerPlayer";
    }

}