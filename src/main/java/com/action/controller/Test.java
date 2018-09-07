package com.action.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
public class Test {
    @RequestMapping("/upload")
    @ResponseBody
    public String downlaod(HttpServletRequest request, String description, @RequestParam("file") MultipartFile file) throws IOException {
        System.out.print(description);
        if (!file.isEmpty()) {
            String path = "D:\\javatry\\SpringMVC\\src\\main\\webapp\\image\\001";
            String filename = file.getOriginalFilename();
            File filepath = new File(path, filename);
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            file.transferTo(new File(path + File.separator + filename));
            return "success";
        } else
            return "error";
    }
}


