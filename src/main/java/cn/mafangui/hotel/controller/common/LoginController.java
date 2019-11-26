package cn.mafangui.hotel.controller.common;

import cn.mafangui.hotel.entity.User;
import cn.mafangui.hotel.entity.Worker;
import cn.mafangui.hotel.response.AjaxResult;
import cn.mafangui.hotel.response.ResponseTool;
import cn.mafangui.hotel.service.UserService;
import cn.mafangui.hotel.service.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private WorkerService workerService;

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public AjaxResult userLogin(String username, String password,
                                        HttpServletRequest request) {
        if(StringUtils.isEmpty(username)){
            return ResponseTool.failed("用户名不能为空");
        }else if(StringUtils.isEmpty(password)) {
            return ResponseTool.failed("密码不能为空");
        }
        User user = userService.selectByUsernameAndPassword(username,password);
        if(user==null){
            return ResponseTool.failed("用户名或密码不正确");
        }
        HttpSession session = request.getSession();
        session.setAttribute("userId",user.getUserId());
        session.setAttribute("username",user.getUsername());
        HashMap map = new HashMap<>();
        map.put("sessionId",session.getId());
        map.put("userId",user.getUserId());
        return ResponseTool.success(map);
    }

    @RequestMapping(value = "/admin",method = RequestMethod.POST)
    public AjaxResult workerLogin(String username, String password,
                                HttpServletRequest request){
        if(StringUtils.isEmpty(username)){
            return ResponseTool.failed("用户名不能为空");
        }else if(StringUtils.isEmpty(password)) {
            return ResponseTool.failed("密码不能为空");
        }
        Worker worker = workerService.login(username,password);
        if(worker==null){
            return ResponseTool.failed("用户名或密码不正确");
        }
        HttpSession session = request.getSession();
        session.setAttribute("userId",worker.getWorkerId());
        session.setAttribute("role",worker.getRole());
        HashMap<String, String> map = new HashMap<>();
        map.put("sessionId",session.getId());
        map.put("role",worker.getRole());
        return ResponseTool.success(map);
    }

}
