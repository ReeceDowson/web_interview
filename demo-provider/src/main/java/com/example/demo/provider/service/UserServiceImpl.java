package com.example.demo.provider.service;

import com.alibaba.dubbo.config.annotation.Service;
import com.example.demo.facade.model.UserDO;
import com.example.demo.facade.service.IUserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 类描述
 *
 * @author zhangrihui
 * @date 2019/9/13 22:45:00
 */
@Service(interfaceClass = IUserService.class)
@Component
public class UserServiceImpl implements IUserService {

    @SuppressWarnings("serial")
    private List<UserDO> users = new ArrayList<UserDO>(){{
        add(new UserDO(1L,"熊大", "123"));
        add(new UserDO(2L,"熊二", "234"));
        add(new UserDO(3L,"熊三", "456"));
    }};

    /**
     * <p>覆盖方法：findById</p>
     * <p>描述：通过id查询用户</p>
     * @param id
     * @return
     */
    @Override
    public UserDO findById(Long id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().get();
    }

    /**
     * <p>覆盖方法：listUser</p>
     * <p>描述：查询用户列表</p>
     * @return
     */
    @Override
    public List<UserDO> listUser() {
        return users;
    }
}
