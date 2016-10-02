package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URISyntaxException;

/**
 * Created by Mars on 23.09.2016.
 */
@Controller
public class FileManager {

    private static final String HOST = "D:/Programing/shop/Foxsshop/src/main/webapp";
    private static final String PATH = "/img";

    @RequestMapping("/files")
    public String redirect(@RequestParam(required = false) String action,
                           @RequestParam(required = false) String to,
                           @RequestParam(required = false) String from,
                           Model model, WebRequest webRequest) {
        //String HOST = webRequest.getContextPath();
        StringBuilder currentDir = new StringBuilder(PATH);
        if (null == action) action = "";
        if (null == to) to = "";

        if (action.equals("goto")) {
            currentDir.replace(0, currentDir.length(), from);
            currentDir.append("/").append(to);
        }
        if (action.equals("up")) {
            if (!from.equals(PATH)) {
                currentDir.replace(0, currentDir.length(), from);
                int i = currentDir.lastIndexOf("/");
                currentDir.delete(i, currentDir.length());
            }
        }


        File files = new File(HOST + currentDir);
        File[] filesList = files.listFiles();
        model.addAttribute("files", filesList);
        model.addAttribute("currentDir", currentDir.toString());
        model.addAttribute("rootDir", PATH);
        model.addAttribute("www", webRequest.toString());
        return "filemanager";
    }

    /*@RequestMapping(value = "/download", method = RequestMethod.GET)
    public void download(@RequestParam(required = false) String name,
                         HttpServletResponse response) throws IOException {

        File file = new File(HOST + name);
        InputStream is = new FileInputStream(file);

        // MIME type of the file
        response.setContentType("application/octet-stream");
        // Response header
        response.setHeader("Content-Disposition", "attachment; filename=\""
                + file.getName() + "\"");
        // Read from the file and write into the response
        OutputStream os = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer)) != -1) {
            os.write(buffer, 0, len);
        }
        os.flush();
        os.close();
        is.close();
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file) {

        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                String name = file.getOriginalFilename();
                String rootPath = HOST + PATH;
                File dir = new File(rootPath);

                if (!dir.exists()) {
                    dir.mkdirs();
                }

                File uploadedFile = new File(dir.getAbsolutePath() + File.separator + name);

                BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(uploadedFile));
                stream.write(bytes);
                stream.flush();
                stream.close();

            } catch (Exception e) {

            }
        }
        return "redirect:/files";
    }*/

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(@RequestParam(required = false) String name,
                         @RequestParam(required = false) String path) {
        File file = new File(path + name);
        if (file.exists()) file.delete();
        return "redirect:/files";
    }
}
