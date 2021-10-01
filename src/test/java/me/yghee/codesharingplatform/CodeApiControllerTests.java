package me.yghee.codesharingplatform;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CodeApiController.class)
class CodeApiControllerTests {

    @Autowired
    MockMvc mvc;

    @Test
    public void detailWithNotExisted() throws Exception {
        mvc.perform(get("/api/code/1"))
            .andExpect(status().isBadRequest());
    }

    @Test
    public void createCode() throws Exception {
        mvc.perform(post("/api/code/new")
            .contentType(MediaType.APPLICATION_JSON)
            .content("\"code\": \"public static void ...\""))
                .andExpect(status().isOk())
                .andExpect(content().string("{ \"id\" : \"1\" }"));

    }

    @Test
    public void list() throws Exception {
        Codes codes = Codes.getInstance();
        for (int i = 0; i < 10; i++) {
            codes.add(new Code(("code" +  (i + 1)), "2021-10-01 20:00:00"));
        }

        mvc.perform(get("/api/code/latest")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"code\":\"code10\"")))
        .andExpect(content().string(containsString("\"date\":\"2021-10-01 20:00:00\"")));
    }

}