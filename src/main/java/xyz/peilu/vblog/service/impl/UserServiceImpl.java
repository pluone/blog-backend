package xyz.peilu.vblog.service.impl;

import xyz.peilu.vblog.entity.User;
import xyz.peilu.vblog.mapper.UserMapper;
import xyz.peilu.vblog.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author peilu
 * @since 2020-08-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
