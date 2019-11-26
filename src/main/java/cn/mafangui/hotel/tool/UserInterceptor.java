package cn.mafangui.hotel.tool;

import cn.mafangui.hotel.response.AjaxResult;
import cn.mafangui.hotel.response.MsgType;
import cn.mafangui.hotel.response.ResponseTool;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;


public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        if(session.getAttribute("userId") != null){
            return true;
        }else {
            PrintWriter writer = response.getWriter();
            AjaxResult result = ResponseTool.failed(MsgType.PERMISSION_DENIED);
            ObjectMapper mapper = new ObjectMapper();
            writer.write(mapper.writeValueAsString(result));
            return false;
        }
    }
}
