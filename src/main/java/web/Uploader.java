package web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mars on 23.09.2016.
 */
@Controller
public class Uploader {

    private static final String path = "D:/Programing/shop/Foxsshop/src/main/webapp";
    private static final String root = "/img";

    @RequestMapping("/load")
    @ResponseBody
    public List<String> list() {
        File files = new File(path + root);
        File[] filesList = files.listFiles();
        List<String> strings = new ArrayList<>();
        for (File f : filesList) {
            strings.add(root + "/" + f.getName());
        }
        return strings;
    }

}
