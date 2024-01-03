package org.ylan.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

import static org.ylan.common.constant.MybatisFiledConstant.*;

/**
 * MyBatis-Plus 原数据自动填充类
 *
 * @author ylan
 */

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        strictInsertFill(metaObject, CREATE_TIME, Date::new, Date.class);
        strictInsertFill(metaObject, UPDATE_TIME, Date::new, Date.class);
        strictInsertFill(metaObject, DEL_FLAG, () -> 0, Integer.class);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        strictInsertFill(metaObject, UPDATE_TIME, Date::new, Date.class);
    }

}