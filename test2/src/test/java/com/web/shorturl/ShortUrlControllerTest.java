package com.web.shorturl;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.http.MediaType;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({
    @ContextConfiguration("file:src/main/webapp/WEB-INF/spring/**/root-context.xml"),
    @ContextConfiguration(" file:src/main/webapp/WEB-INF/spring/appServlet/**/servlet-context.xml")
})
public class ShortUrlControllerTest {

	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup(){
		mockMvc = MockMvcBuilders.webAppContextSetup(this.context).build();
	}
	
    @Test
    public void home() throws Exception {
    	mockMvc.perform(get("/").accept(MediaType.TEXT_HTML))
			    	.andDo(print())
			    	.andExpect(status().isOk())
			    	.andReturn();   	
    }
    
    @Test
    public void createShortUrl() throws Exception {
    	mockMvc.perform(post("/shorturl/generate").param("url", "http://naver.com").accept(MediaType.TEXT_HTML))
			    	.andDo(print())
			    	.andExpect(status().isOk())
			    	.andReturn();
    }        
         
    @Test
    public void sendShortUrl() throws Exception {
    	mockMvc.perform(get("/GlNwozHF").accept(MediaType.TEXT_HTML))
			    	.andDo(print())
			    	.andExpect(status().isOk())
			    	.andReturn();
    }    
    

}
