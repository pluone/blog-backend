package xyz.peilu.vblog.service.impl;

import xyz.peilu.vblog.entity.Blog;
import xyz.peilu.vblog.mapper.BlogMapper;
import xyz.peilu.vblog.service.BlogService;
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
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
