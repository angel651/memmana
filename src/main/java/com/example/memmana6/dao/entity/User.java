package com.example.memmana6.dao.entity;
import lombok.Data;
import org.springframework.stereotype.Repository;

@Repository
@Data  //需要先安装Lombok插件，然后开启自动注解处理（Enable annotation processing）功能，以便省去属性的getter/settter/toString()等
public class User {  //模型层里的实体
    private String username;  //类属性
    private String password = "";  //设置空串以保证按主键值删除会员时不报对象属性值异常
    private String realname;
    private String mobile;
    private Integer age;

    /*public void setUsername(String username) {  //setXXX方法
        this.username = username;
    }

    public String getUsername() {  //getXXX方法
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getRealname() {
        return realname;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getAge() {
        return age;
    }*/

    @Override
    public String toString() {
        return "User [username=" + username + ", password=" + password
                + ", realname=" + realname + ", mobile=" + mobile
                + ", age=" + age + "]";
    }
}
