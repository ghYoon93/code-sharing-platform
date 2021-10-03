package me.yghee.codesharingplatform;

import me.yghee.codesharingplatform.controller.CodeApiController;
import me.yghee.codesharingplatform.domain.Code;
import me.yghee.codesharingplatform.domain.CodeNotFoundException;
import me.yghee.codesharingplatform.service.CodeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CodeApiController.class)
class CodeApiControllerTests {

    @Autowired
    MockMvc mvc;

    @MockBean
    private CodeService codeService;

    @Test
    public void detailWithNotExisted() throws Exception {
        given(codeService.getCode(1)).willThrow(new CodeNotFoundException(1));
        mvc.perform(get("/api/code/1"))
            .andExpect(status().isNotFound())
            .andExpect(content().string("{}"));
    }

    @Test
    public void createCode() throws Exception {

        given(codeService.postCode(any())).willReturn(1);

        mvc.perform(post("/api/code/new")
            .contentType(MediaType.APPLICATION_JSON)
            .content("\"code\": \"public static void ...\""))
                .andExpect(status().isOk())
                .andExpect(content().string("{ \"id\" : \"1\" }"));

        verify(codeService).postCode(any());

    }

    @Test
    public void latestList() throws Exception {
        Deque<Code> latests = new ArrayDeque<>();
        for (int i = 0; i < 10; i++) {
            latests.addFirst(new Code(("code" +  (i + 1)), "2021-10-01 20:00:00"));
        }

        given(codeService.getLatest()).willReturn(latests);

        mvc.perform(get("/api/code/latest")
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("\"code\":\"code10\"")))
        .andExpect(content().string(containsString("\"date\":\"2021-10-01 20:00:00\"")));
    }

}