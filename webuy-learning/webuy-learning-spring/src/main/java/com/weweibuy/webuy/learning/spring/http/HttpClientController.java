package com.weweibuy.webuy.learning.spring.http;

import com.weweibuy.webuy.learning.spring.client.HelloClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author durenhao
 * @date 2019/12/28 11:41
 **/
@RestController
public class HttpClientController {

    private final HttpClient httpClient;

    private final HelloClient helloClient;

    public HttpClientController(HttpClient httpClient, HelloClient helloClient) {
        this.httpClient = httpClient;
        this.helloClient = helloClient;
    }

    @GetMapping("/http/test")
    public String http() throws IOException {
        HttpGet httpGet = new HttpGet("http://localhost:9000/hello");
        HttpResponse response = httpClient.execute(httpGet);
        InputStream content = response.getEntity().getContent();
        byte[] bytes = new byte[1024];
        int len = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while ((len = content.read(bytes)) != -1) {
            stringBuilder.append(new String(bytes, 0, len));
        }
        return stringBuilder.toString();
    }

    @GetMapping("/http/client")
    public Object httpFeignClient()  {
        return helloClient.hello();
    }

}
