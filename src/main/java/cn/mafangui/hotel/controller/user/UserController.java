package cn.mafangui.hotel.controller.user;

import cn.mafangui.hotel.entity.User;
import cn.mafangui.hotel.response.AjaxResult;
import cn.mafangui.hotel.response.MsgType;
import cn.mafangui.hotel.response.ResponseUtil;
import cn.mafangui.hotel.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;



    /**
     * 用户添加
     * @param username
     * @param password
     * @param name
     * @param gender
     * @param phone
     * @param email
     * @param address
     * @param idcard
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/add")
    public int userAdd(String username,String password,String name,String gender,String phone,String email,String address,String idcard){
        User user = new User(username,password,name,gender,phone,email,address,idcard);
        return userService.addUser(user);
    }


    /**
     * 更新用户信息
     * @param userId
     * @param name
     * @param gender
     * @param phone
     * @param email
     * @param address
     * @param idcard
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/update")
    public AjaxResult userUpdate(int userId, String name, String gender, String phone,
                                 String email, String address, String idcard, HttpServletRequest request){
        HttpSession session = request.getSession();
        if (!session.getAttribute("userId").equals(userId)){
            return ResponseUtil.failed(MsgType.PERMISSION_DENIED);
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
            return ResponseUtil.success("修改成功");
        return ResponseUtil.success("修改失败，请检查或稍后再试");
    }

    /**
     * 更改密码
     * @param username
     * @param oldPassword
     * @param newPassword
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/updatePassword")
    public AjaxResult updatePassword(String username,String oldPassword,String newPassword){
        User user = userService.selectByUsernameAndPassword(username,oldPassword);
        if (user == null){
            return ResponseUtil.failed("密码不对");
        }
        user.setPassword(newPassword);
        if(userService.updateUser(user)==1)
            return ResponseUtil.success("修改成功");
        return ResponseUtil.failed("修改失败");
    }

    /**
     *  获取个人资料
     * @param request
     * @return
     */
    @RequestMapping(value = "/profile")
    public AjaxResult getProfile(HttpServletRequest request){
        String username = (String) request.getSession().getAttribute("username");
        User user = userService.selectByUsername(username);
        if(user==null) return ResponseUtil.failed("未知错误");
        user.setPassword(null);
        StringBuilder sb = new StringBuilder(user.getIdcard());
        sb.replace(5,12,"********");
        user.setIdcard(sb.toString());
        return ResponseUtil.success(user);
    }


    /**
     * 根据username查找用户
     * @param username
     * @return
     */
    @RequestMapping(value = "/withUsername")
    public AjaxResult getByUsername(String username, HttpServletRequest request){
        if(!request.getSession().getAttribute("username").equals(username)){
            return ResponseUtil.failed(MsgType.PERMISSION_DENIED);
        }
        User user = userService.selectByUsername(username);
        user.setPassword(null);
        return ResponseUtil.success(user);
    }

    /**
     * 注销
     * @param request
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public AjaxResult logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("userId");
        session.removeAttribute("username");
        return ResponseUtil.success("注销成功");
    }


}
