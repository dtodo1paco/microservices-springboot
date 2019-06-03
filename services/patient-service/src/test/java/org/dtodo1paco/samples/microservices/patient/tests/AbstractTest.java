/**
 * 
 */
package org.dtodo1paco.samples.microservices.patient.tests;
import java.io.IOException;
import java.util.Arrays;

import org.dtodo1paco.samples.microservices.patient.DemoApplication;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author pac
 *
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@WebAppConfiguration
@Transactional
public abstract class AbstractTest {
   protected MockMvc mvc;
   @Autowired
   WebApplicationContext webApplicationContext;
   private HttpMessageConverter mappingJackson2HttpMessageConverter;


   protected void setUp() {
      mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
   }
   protected String mapToJson(Object obj) throws JsonProcessingException {
      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.writeValueAsString(obj);
   }
   protected <T> T mapFromJson(String json, Class<T> clazz)
      throws JsonParseException, JsonMappingException, IOException {
      ObjectMapper objectMapper = new ObjectMapper();
      return objectMapper.readValue(json, clazz);
   }

   @Autowired
   void setConverters(HttpMessageConverter<?>[] converters) {
       this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
               .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter).findAny().get();
       Assert.assertNotNull("the JSON message converter must not be null", this.mappingJackson2HttpMessageConverter);
   }
   @SuppressWarnings("unchecked")
   protected String json(Object o) throws IOException {
       MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
       this.mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
       return mockHttpOutputMessage.getBodyAsString();
   }
   
}