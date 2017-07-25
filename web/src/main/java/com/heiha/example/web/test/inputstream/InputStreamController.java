package com.heiha.example.web.test.inputstream;

import com.alibaba.fastjson.JSON;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Map;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/7/25 12:31<br>
 * <b>Author:</b> heiha<br>
 */
@RestController
@RequestMapping("/test/inputstream")
public class InputStreamController {
    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public void test(HttpServletRequest request) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        InputStream in = request.getInputStream();
        byte[] buf = new byte[1024];
        for (;;) {
            int len = in.read(buf);
            if (len == -1) {
                break;
            }
            if (len > 0) {
                baos.write(buf, 0, len);
            }
        }
        byte[] bytes = baos.toByteArray();
        String json = new String(bytes, 0, bytes.length, Charset.forName("UTF-8"));
        System.out.println(json);
        Map map = JSON.parseObject(json, Map.class);
        System.out.println(JSON.toJSONString(map));
    }
}
