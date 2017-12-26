package me.robbie.boot.test;

import me.robbie.boot.test.action.SimpleAction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * @RunWith(SpringRunner.class) 等价于
 * @RunWith(SpringJUnit4ClassRunner.class)
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Run.class)
@WebAppConfiguration
public class AppTest {

    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(new SimpleAction()).build();
    }

    @Test
    public void testIndex() throws Exception{
        ResultActions actions =

                mvc.perform(MockMvcRequestBuilders.get("/")
                .accept(MediaType.TEXT_PLAIN));
                //.andExpect(MockMvcResultMatchers.status().isOk())
                //.andExpect(MockMvcResultMatchers.content().string("Hello World!"));

        System.out.println(actions.andReturn().getResponse().getContentAsString());
    }
}
