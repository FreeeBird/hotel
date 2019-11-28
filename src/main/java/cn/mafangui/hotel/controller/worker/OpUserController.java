package cn.mafangui.hotel.controller.worker;

import cn.mafangui.hotel.entity.User;
import cn.mafangui.hotel.response.AjaxResult;
import cn.mafangui.hotel.response.MsgType;
import cn.mafangui.hotel.response.ResponseTool;
import cn.mafangui.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/op/user")
public class OpUserController {
    @Autowired
    private UserService userService;


    @RequestMapping(value = "")
    public AjaxResult getAllUser(){
        return ResponseTool.success(userService.selectAllUser());
    }

    @RequestMapping(value = "/count")
    public AjaxResult getUserCount(){
        return ResponseTool.success(userService.getUserCount());
    }

    @RequestMapping(value = "/delete/{userId}")
    public AjaxResult deleteUser(@PathVariable Integer userId){
        int re = userService.deleteUser(userId);
        if(re!=1) return ResponseTool.failed();
        return ResponseTool.success();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public AjaxResult userAdd(String username,String password,String name,String gender,String phone,String email,String address,String idcard){
        User user = new User(username,password,name,gender,phone,email,address,idcard);
        int re = userService.addUser(user);
        if(re!=1) return ResponseTool.failed();
        return ResponseTool.success();
    }

    @RequestMapping(method = RequestMethod.POST,value = "/update")
    public AjaxResult userUpdate(Integer userId, String name, String gender, String phone,
                                 String email, String address, String idcard, HttpServletRequest request){
        HttpSession session = request.getSession();
        if (!session.getAttribute("userId").equals(userId)){
            return ResponseTool.failed(MsgType.PERMISSION_DENIED);
        }
        User user = new User();
        user.setUserId(userId);
        user.setName(name);
        user.setGender(gender);
        user.setPhone(phone);
        user.setEmail(email);
        user.setAddress(address);
        user.setIdcard(idcard);
        if(userService.updateUser(user)==1)
            return ResponseTool.success("修改成功");
        return ResponseTool.success("修改失败，请检查或稍后再试");
    }


    @RequestMapping(method = RequestMethod.POST,value = "/updatePassword")
    public AjaxResult updatePassword(String username,String oldPassword,String newPassword){
        User user = userService.selectByUsernameAndPassword(username,oldPassword);
        if (user == null){
            return ResponseTool.failed("密码不对");
        }
        user.setPassword(newPassword);
        if(userService.updateUser(user)==1)
            return ResponseTool.success("修改成功");
        return ResponseTool.failed("修改失败");
    }


    @RequestMapping(value = "/{userId}")
    public AjaxResult getProfile(@PathVariable Integer userId){
        User user = userService.selectById(userId);
        user.setPassword(null);
        return ResponseTool.success(user);
    }


    @RequestMapping(value = "/username/{username}")
    public AjaxResult getByUsername(@PathVariable String username){
        User user = userService.selectByUsername(username);
        user.setPassword(null);
        return ResponseTool.success(user);
    }




}
