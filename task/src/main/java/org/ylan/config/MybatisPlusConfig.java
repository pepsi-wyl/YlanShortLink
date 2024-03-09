package org.ylan.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author ylan
 *
 * MP 配置类
 */

@Configuration
@MapperScan("org.ylan.mapper")
@EnableTransactionManagement
public class MybatisPlusConfig {

}