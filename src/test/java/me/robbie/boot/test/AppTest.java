package me.robbie.boot.test;

import me.robbie.boot.test.action.SimpleAction;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 * <一句话功能简述>
 * <功能详细描述>
 *
 * @auth:闻西
 * @see: [相关类/方法]
 * @since [产品/模块版本]
 */
@RunWith(SpringJUnit4ClassRunner.class)
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
