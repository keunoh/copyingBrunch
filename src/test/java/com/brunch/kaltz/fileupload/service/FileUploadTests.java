package com.brunch.kaltz.fileupload.service;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.file.Paths;
import java.util.stream.Stream;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
class FileUploadTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private StorageService storageService;

    @Test
    public void shouldListAllFiles() throws Exception {
        /**
         * 여기서 storageService.loadAll()을 호출한다.
         * first.txt, second.txt 리턴을 보장한다.
         */
        given(this.storageService.loadAll())
                .willReturn(Stream.of(Paths.get("first.txt"), Paths.get("second.txt")));

        /**
         * /fileUpload URL 실행한다.
         * 1) status 200 리턴을 예상한다.
         * 2) 두개의 리소스 (http://localhost/files/first.txt, http://localhost/files/second.txt)가 존재함을 예상한다.
         */
        this.mvc.perform(get("/fileUpload"))
                .andExpect(status().isOk())
        // first.txt 와 second.txt 가 대입이 안 되는 거 같음
                .andExpect(model().attribute("files",
                        Matchers.contains("http://localhost/files/first.txt",
                                        "http://localhost/files/second.txt")));
    }
}