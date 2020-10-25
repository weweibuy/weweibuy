package com.weweibuy.webuy.learning.flowable.user;

import com.weweibuy.framework.common.core.exception.Exceptions;
import com.weweibuy.webuy.learning.flowable.support.UserHelper;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.idm.api.NativeUserQuery;
import org.flowable.idm.api.User;
import org.flowable.idm.engine.impl.UserQueryImpl;

import java.util.List;

/**
 * @author durenhao
 * @date 2020/10/23 22:50
 **/
public class CustomUserQuery extends UserQueryImpl implements NativeUserQuery {

    @Override
    public long executeCount(CommandContext commandContext) {
        return UserHelper.countUser(this);
    }

    @Override
    public List<User> executeList(CommandContext commandContext) {
        return UserHelper.queryUser(this);
    }


    @Override
    public NativeUserQuery sql(String s) {
        throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public NativeUserQuery parameter(String s, Object o) {
        throw Exceptions.business("不支持用户操作相关功能");
    }

    private void notSupportFunc() {
        throw Exceptions.business("不支持用户操作相关功能");
    }

}
