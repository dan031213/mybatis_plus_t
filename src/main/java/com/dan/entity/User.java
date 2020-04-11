package com.dan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author lizhenyang
 * @desc
 * @create 2020-04-11 12:02
 */

@Data
@TableName("t_user")
public class User {
    @TableId(type = IdType.ASSIGN_UUID)
    private String userId;
    private String userName;
    private String userPassword;
    private String userAddress;
    private String userTel;
    private String userEmail;
    @Version
    private Integer version;
}
