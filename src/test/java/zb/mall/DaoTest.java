package zb.mall;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import zb.mall.core.dao.MallUserDao;
import zb.mall.core.entity.vo.MallUser;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DaoTest {
    @Autowired
    MallUserDao mallUserDao;

    @Test
    public void test(){
        List<MallUser> mallUsers = mallUserDao.selectList(null);
        System.out.println(mallUsers);
    }
}
