package kr.ming9.boot.web;

import kr.ming9.boot.config.auth.SecurityConfig;
import kr.ming9.boot.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class,
        excludeFilters = {  // WebMvcTest는 @ControllerAdvice, @Controller를 읽음( @Repository, @Service는 대상이 아님) 스캔 대상에서 SecurityConfig 제거
                @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        }
)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;        // 이 클래스를 통해 GET, POST 등에 대한 API 테스트를 할 수 있음

    @WithMockUser(roles="USER")
    @Test
    public void hello가_리턴된다() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello"))          // get요청
                .andExpect(status().isOk())           // http Header Status 검증
                .andExpect(content().string(hello));  // 결과를 검증

    }

    @WithMockUser(roles="USER")
    @Test
    public void HelloDtoTest() throws Exception{
        String name = "abcd";
        int amount = 11;

        mvc.perform(get("/hello/dto").param("name", name).param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));

    }
}
