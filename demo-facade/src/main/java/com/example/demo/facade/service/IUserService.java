package com.example.demo.facade.service;

import com.example.demo.facade.model.UserDO;

import java.util.List;

/**
 * 类描述
 *
 * @author zhangrihui
 * @date 2019/9/13 22:43:00
 */
public interface IUserService {

    /**
     * 通过id查询用户
     * @param id
     * @return T
     * @日期：2018年6月17日
     */
    public UserDO findById(Long id);

    /**
     * 查询用户列表
     * @return List<T>
     * @日期：2018年6月17日
     */
    public List<UserDO> listUser();

}
