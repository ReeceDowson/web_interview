package com.example.demo.facade.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * 类描述
 *
 * @author zhangrihui
 * @date 2019/9/13 22:41:00
 */
@Data
@AllArgsConstructor
public class UserDO implements Serializable {

    private static final long serialVersionUID = 6801398872777367695L;

    private Long id;
    private String name;
    private String passwrod;

}
