package me.yghee.codesharingplatform;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CodeControllerTests {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    void detailWithNotExisted() {
        String body = restTemplate.getForObject("/code/1", String.class);

        assertThat(body).contains("Create");
    }
}