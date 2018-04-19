package validator;

import com.yale.ssm.web.UserController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@EnableWebMvc
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath*:spring/spring-service.xml"})
public class ValidatorTest extends AbstractTestNGSpringContextTests{
    @Autowired
    private WebApplicationContext webcontext;
    @Autowired
    private UserController userController;

    private MockMvc mockMvc;

    @BeforeMethod
    public void prepareMockmvc(){
        this.mockMvc = webAppContextSetup(webcontext).build();
    }

    @Test
    public void TestUserContoller() throws Exception{
        //Integer offset,Integer limit
        this.mockMvc.perform(get("/user/list").param("offset","0")
                .param("limit","50"))
                .andDo(print())
                .andExpect(status().isOk());
    }
}
