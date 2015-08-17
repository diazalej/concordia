package ca.soccer.test;

import ca.soccer.config.Factory;

import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

public class PlayerControllerTests {

    Factory factory=new Factory();
    
  /*
    @Test
    public void testPlayer() throws Exception {
        Player expectedPlayer = factory.generateRandomPlayer();
        PlayerRepository mockRepository = mock(PlayerRepository.class);
        when(mockRepository.findOne(expectedPlayer.getFirstName())).thenReturn(expectedPlayer);
        PlayerController controller = new PlayerController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/players/"+expectedPlayer.getFirstName()))
                .andExpect(view().name("player"))
                .andExpect(model().attributeExists("player"))
                .andExpect(model().attribute("player", expectedPlayer));
    }


    //http://localhost:8080/show?player_id=Reyder%20Risco
    @Test
    public void testShowPlayer() throws Exception {
        Player expectedPlayer = factory.generateRandomPlayer();
        PlayerRepository mockRepository = mock(PlayerRepository.class);
        when(mockRepository.findOne(expectedPlayer.getFirstName())).thenReturn(expectedPlayer);
        PlayerController controller = new PlayerController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();
        mockMvc.perform(get("/players/show?player_id="+expectedPlayer.getFirstName()))
                .andExpect(view().name("player"))
                .andExpect(model().attributeExists("player"))
                .andExpect(model().attribute("player", expectedPlayer));
    }*/

}
