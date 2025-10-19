package me.hmhb.test.service.impl;

import me.hmhb.test.entity.User;
import me.hmhb.test.mapper.UserMapper;
import me.hmhb.test.service.MyService;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MyServiceImpl implements MyService {

    @Autowired
    UserMapper userMapper;

    User user1 = new User()
            .setName("张三")
            .setSex("男")
            .setAge(18);
    User user2 = new User()
            .setName("李四")
            .setSex("女")
            .setAge(19);

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void service1() throws Exception {
        userMapper.insertUser(user1);
        MyService myService = (MyService) AopContext.currentProxy();
        myService.service2();
        throw new RuntimeException("手动抛出异常");
    }

    @Transactional(propagation = Propagation.NESTED)
    @Override
    public void service2() {
        userMapper.insertUser(user2);
    }
}
