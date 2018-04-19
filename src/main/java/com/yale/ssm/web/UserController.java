package com.yale.ssm.web;

import com.yale.ssm.Service.IUserService;
import com.yale.ssm.entity.User;
import com.yale.ssm.validator.UserAddView;
import com.yale.ssm.validator.UserModifyView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.groups.Default;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IUserService userService;

    /*启用UserAddView 这个验证规则
      此处@Validated(UserAddView.class)表示使用UserAddView这套校验规则，若使用@Valid 则表示使用默认校验规则，
      若两个规则同时加上去，则只有第一套起作用
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public void addUser(@RequestBody @Validated({UserAddView.class, Default.class}) User user){

    }
    /**
     * 修改Person对象
     * 此处启用PersonModifyView 这个验证规则
     */
    @RequestMapping(value = "/modify", method = RequestMethod.PUT)
    public void modifyUser(@RequestBody @Validated(value = {UserModifyView.class}) User user) {

    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public String list(Model model,Integer offset,Integer limit){
        LOG.info("invoke----------/user/list");
        offset = offset == null ? 0 : offset;//默认便宜0
        limit = limit == null ? 50 : limit;//默认展示50条
        List<User> userList = userService.getUserList(offset, limit);
        model.addAttribute("userList",userList);
        return "userlist";
    }

}
