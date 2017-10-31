package yang.mybatis.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import yang.mybatis.dao.UserDaoImp;
import yang.mybatis.domain.User;

import java.io.File;
import java.io.IOException;

/**
 * Created by root on 2017/8/18 0018.
 */
@Controller
@RequestMapping(value = "/myAction")
public class MyAction {

    @Autowired
    UserDaoImp userDaoImp;

    @RequestMapping(value = "/test")
    public String  test01() throws Exception {
        System.out.print("测试成功");
        /*ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(User);*/
        return "/index.jsp";
    }

    @RequestMapping(value = "/test02")
    public String  test02(ModelMap model) throws Exception {
        System.out.print("测试成功");
        User user=userDaoImp.findUserById(1);
        model.put("user",user);
        return "/test01/index.jsp";
    }
    /**
     * 文件上传
     * @param model
     * @param file
     * @return
     */
    @RequestMapping(value = "/fileUpload")
    public String fileUpload(ModelMap model, MultipartFile file) {
        String saveFileDirPath = "D:/upload/";
        String saveFileName=file.getOriginalFilename();
        File newFile = new File(saveFileDirPath+saveFileName);
        try {
            //将文件上传到服务器
            file.transferTo(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        model.put("success", "文件上传成功,请求成功");
        return "/index.jsp";
    }

}
