package com.xiaomi.example.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.xiaomi.example.pojo.User;
import com.xiaomi.example.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by mi on 2017/3/9.
 */

@Controller
@RequestMapping("/")
public class HomeController {
    private Logger logger = Logger.getLogger("CONTROLLER-LOGGER");

    @Resource
    private UserService userService;

    @RequestMapping(value = "/", method = GET)
    public String home(HttpServletRequest request, HttpServletResponse response) {
//        response.setContentType("text/html;charset=UTF-8");
        return "../index";
    }

    @RequestMapping(value = "/login",method = POST)
    @ResponseBody
    public JSONObject login(HttpSession session, @RequestBody JSONObject json){

        String username = json.getString("username");
        String password = json.getString("password");
        logger.info("[CONTROLLER]:" + username + " 正在登录");
        if(userService.login(username, password)){
            session.setAttribute("username", username);
            json.put("[CONTROLLER]:" + "result", "OK");
            logger.info(username + " login success");
        } else {
            json.put("result", "NO");
            logger.info("[CONTROLLER]:" + username + " login failed");
        }
        return json;
    }

    @RequestMapping(value = "/register", method = GET)
    public ModelAndView register(HttpServletRequest request){
        logger.info("[CONTROLLER]: jump to register");
        ModelAndView mav = new ModelAndView();
        mav.setViewName("register");
        return mav;
    }

    @RequestMapping(value = "/register", method = POST)
    public String registerUser(HttpServletRequest request, HttpServletResponse response){
        User user = new User();
        logger.info(JSON.toJSONString(request.getParameterNames()));
        user.setUserName(request.getParameter("username"));
        user.setEmail(request.getParameter("email"));
        user.setGender(request.getParameter("gender"));
        user.setPassword(request.getParameter("password"));
        logger.info("[CONTROLLER]:用户注册信息:" + JSON.toJSONString(user));
        if(userService.register(user)){
            logger.info("[CONTROLLER]:用户注册成功!");
            return "success";
        } else {
            logger.info("[CONTROLLER]:用户注册失败!");
            return "register";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/getUserByName", method = GET)
    public JSONObject getUserByName(HttpSession session, @RequestBody JSONObject data) {
        String userName = data.getString("userName");
        logger.info("[CONTROLLER]:get user by name:" + userName);
        if(userService.getUserByName(userName) != null) {
            data.put("result", "YES");
        } else {
            data.put("result", "NO");
        }
        return data;
    }

    @ResponseBody
    @RequestMapping(value="/getUserList", method = GET, produces = "text/plain;charset=UTF-8")
    public String getUserList(HttpServletRequest request){
        int page = Integer.valueOf(request.getParameter("page"));
        logger.info("正在请求的时第" + page + "页");
        List listUser = userService.getUserListPaging(page, 2L);
        Gson gson = new Gson();
        String userListInfo = gson.toJson(listUser);
        logger.info("get user list:" + userListInfo);
        return userListInfo;
    }

}
