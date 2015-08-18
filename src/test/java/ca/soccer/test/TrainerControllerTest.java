package ca.soccer.test;

import ca.soccer.web.PlayerController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;
import ca.soccer.config.Factory;
import ca.soccer.domain.Trainer;
import ca.soccer.web.TrainerController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class TrainerControllerTest {

    MockMvc mockMvc;

    @Before
    public void setup() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setExposeContextBeansAsAttributes(true);

        mockMvc = MockMvcBuilders.standaloneSetup(new TrainerController())
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    public void testRegisterTrainerPage() throws Exception {
        mockMvc.perform(get("/trainers/registerTrainer"))
                .andExpect(view().name("registerTrainer"));
    }

}
