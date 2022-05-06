package zb.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("zb.mall.core.dao")
public class MybatisPlusConfig {

}
