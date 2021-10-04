package me.yghee.codesharingplatform;

import me.yghee.codesharingplatform.domain.CodeNotFoundException;
import me.yghee.codesharingplatform.service.CodeService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CodeControllerTests {

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    CodeService codeService;

    @Test
    void detailWithNotExisted() {
        given(codeService.getCode(1L)).willThrow(new CodeNotFoundException(1L));
        String body = restTemplate.getForObject("/code/1", String.class);

        assertThat(body).contains("{}");
    }
}