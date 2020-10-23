package com.weweibuy.webuy.learning.flowable.user;

import com.weweibuy.framework.common.core.exception.Exceptions;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.idm.api.NativeUserQuery;
import org.flowable.idm.api.User;
import org.flowable.idm.engine.impl.UserQueryImpl;

import java.util.Collections;
import java.util.List;

/**
 * @author durenhao
 * @date 2020/10/23 22:50
 **/
public class CustomUserQuery extends UserQueryImpl implements NativeUserQuery {


    @Override
    public long executeCount(CommandContext commandContext) {
        return 1L;
    }

    @Override
    public List<User> executeList(CommandContext commandContext) {
        return Collections.emptyList();
    }


    @Override
    public NativeUserQuery sql(String s) {
        notSupportFunc();
        return null;
    }

    @Override
    public NativeUserQuery parameter(String s, Object o) {
        notSupportFunc();
        return null;
    }

    private void notSupportFunc() {
        throw Exceptions.business("不支持用户操作相关功能");
    }

}
