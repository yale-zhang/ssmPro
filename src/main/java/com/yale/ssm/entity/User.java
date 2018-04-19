package com.yale.ssm.entity;

import com.yale.ssm.validator.UserAddView;
import com.yale.ssm.validator.UserModifyView;
import com.yale.ssm.validator.annotation.ListNotHasNull;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.List;

public class User {
    @NotNull(message = "userI不能为空")
    private long userId;

    //@NotEmpty(message = "用户名不能为空")
    @NotNull(groups = {UserAddView.class, UserModifyView.class},message ="添加、修改用户时名字不能为空")//,
            //payload = ValidateErrorLevel.Info.class)
    @ListNotHasNull.List({
            @ListNotHasNull(groups = {UserAddView.class}, message = "添加上Name不能为空"),
            @ListNotHasNull(groups = {UserModifyView.class}, message = "修改时Name不能为空")})
    private String userName;

    @Min(value = 18, groups = {UserAddView.class}, message = "姓名不能低于18岁")
    @Max(value = 30, groups = {UserModifyView.class}, message = "姓名不能超过30岁")
    private int age;

    //验证手机号码
    @Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\\\d{8}$")
    private long userPhone;

    @NotNull(groups = {UserAddView.class}, message = "添加用户时地址不能为空")
    private String address;

    private Date createTime;

    private int score;

    @ListNotHasNull(message = "List中不能含有null的元素")
    @Valid
    private List<Order> orders;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public long getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(long userPhone) {
        this.userPhone = userPhone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userPhone=" + userPhone + ", createTime=" + createTime + ", score=" + score
                + "]";
    }

}
