package ca.soccer.test;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import ca.soccer.config.Factory;
import ca.soccer.data.TrainerRepository;
import ca.soccer.domain.Trainer;
import ca.soccer.web.TrainerController;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class TrainerControllerTest {
    Factory factory=new Factory();


  /*  @Test
    public void testTrainer() throws Exception {
        Trainer expectedTrainer = factory.generateRandomTrainer();
        TrainerRepository mockRepository = mock(TrainerRepository.class);
        when(mockRepository.findOne(expectedTrainer.getFirstName())).thenReturn(expectedTrainer);
        TrainerController controller = new TrainerController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/trainers/"+expectedTrainer.getFirstName()))
                .andExpect(view().name("trainer"))
                .andExpect(model().attributeExists("trainer"))
                .andExpect(model().attribute("trainer", expectedTrainer));
    }


    @Test
    public void testShowTrainer() throws Exception {
        Trainer expectedTrainer = factory.generateRandomTrainer();
        TrainerRepository mockRepository = mock(TrainerRepository.class);
        when(mockRepository.findOne(expectedTrainer.getFirstName())).thenReturn(expectedTrainer);
        TrainerController controller = new TrainerController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/trainerDetails/show?trainer_id="+expectedTrainer.getFirstName()))
                .andExpect(view().name("trainer"))
                .andExpect(model().attributeExists("trainer"))
                .andExpect(model().attribute("trainer", expectedTrainer));
    }*/

}
