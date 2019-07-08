package com.pojo;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User{
    private String username; //用户名
    private String password; //密码
    private String email;   //邮箱
}
