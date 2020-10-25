package com.weweibuy.webuy.learning.flowable.user;

import com.weweibuy.framework.common.core.exception.Exceptions;
import com.weweibuy.webuy.learning.flowable.support.GroupHelper;
import org.flowable.common.engine.impl.interceptor.CommandContext;
import org.flowable.idm.api.Group;
import org.flowable.idm.api.NativeGroupQuery;
import org.flowable.idm.engine.impl.GroupQueryImpl;

import java.util.List;

/**
 * @author durenhao
 * @date 2020/10/24 21:50
 **/
public class CustomGroupQuery extends GroupQueryImpl implements NativeGroupQuery {

    @Override
    public long executeCount(CommandContext commandContext) {
        return GroupHelper.countGroup(this);
    }

    @Override
    public List<Group> executeList(CommandContext commandContext) {
        return GroupHelper.queryGroup(this);
    }

    @Override
    public NativeGroupQuery sql(String selectClause) {
        throw Exceptions.business("不支持的功能");
    }

    @Override
    public NativeGroupQuery parameter(String name, Object value) {
        throw Exceptions.business("不支持的功能");
    }
}
