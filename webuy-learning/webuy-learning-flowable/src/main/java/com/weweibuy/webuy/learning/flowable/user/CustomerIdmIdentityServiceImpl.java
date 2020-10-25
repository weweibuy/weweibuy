package com.weweibuy.webuy.learning.flowable.user;

import com.weweibuy.framework.common.core.exception.Exceptions;
import org.flowable.common.engine.impl.identity.Authentication;
import org.flowable.common.engine.impl.service.CommonEngineServiceImpl;
import org.flowable.idm.api.*;
import org.flowable.idm.engine.IdmEngineConfiguration;

import java.util.List;

/**
 * @author durenhao
 * @date 2020/10/23 22:17
 **/
public class CustomerIdmIdentityServiceImpl extends CommonEngineServiceImpl<IdmEngineConfiguration> implements IdmIdentityService {

    public CustomerIdmIdentityServiceImpl(IdmEngineConfiguration idmEngineConfiguration) {
        super(idmEngineConfiguration);
    }

    @Override
    public User newUser(String userId) {
        throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public void saveUser(User user) {
        throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public void updateUserPassword(User user) {
       throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public UserQuery createUserQuery() {
        return new CustomUserQuery();
    }

    @Override
    public NativeUserQuery createNativeUserQuery() {
        return new CustomUserQuery();
    }

    @Override
    public void deleteUser(String userId) {
       throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public Group newGroup(String groupId) {
       throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public GroupQuery createGroupQuery() {
        return new CustomGroupQuery();
    }

    @Override
    public NativeGroupQuery createNativeGroupQuery() {
        return null;
    }

    @Override
    public void saveGroup(Group group) {
       throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public void deleteGroup(String groupId) {
       throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public void createMembership(String userId, String groupId) {
       throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public void deleteMembership(String userId, String groupId) {
       throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public boolean checkPassword(String userId, String password) {
       throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public void setAuthenticatedUserId(String authenticatedUserId) {
        Authentication.setAuthenticatedUserId(authenticatedUserId);
       throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public void setUserPicture(String userId, Picture picture) {
       throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public Picture getUserPicture(String userId) {
        return null;
    }

    @Override
    public Token newToken(String id) {
       throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public void saveToken(Token token) {
       throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public void deleteToken(String tokenId) {
       throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public TokenQuery createTokenQuery() {
       throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public NativeTokenQuery createNativeTokenQuery() {
        throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public void setUserInfo(String userId, String key, String value) {
       throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public String getUserInfo(String userId, String key) {
        return null;
    }

    @Override
    public List<String> getUserInfoKeys(String userId) {
        return null;
    }

    @Override
    public void deleteUserInfo(String userId, String key) {
       throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public Privilege createPrivilege(String privilegeName) {
        return null;
    }

    @Override
    public void addUserPrivilegeMapping(String privilegeId, String userId) {
       throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public void deleteUserPrivilegeMapping(String privilegeId, String userId) {
       throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public void addGroupPrivilegeMapping(String privilegeId, String groupId) {

    }

    @Override
    public void deleteGroupPrivilegeMapping(String privilegeId, String groupId) {
       throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public List<PrivilegeMapping> getPrivilegeMappingsByPrivilegeId(String privilegeId) {
        return null;
    }

    @Override
    public void deletePrivilege(String privilegeId) {
       throw Exceptions.business("不支持用户操作相关功能");
    }

    @Override
    public List<User> getUsersWithPrivilege(String privilegeId) {
        return null;
    }

    @Override
    public List<Group> getGroupsWithPrivilege(String privilegeId) {
        return null;
    }

    @Override
    public PrivilegeQuery createPrivilegeQuery() {
        return null;
    }


    private void notSupportFunc() {
        throw Exceptions.business("不支持用户操作相关功能");
    }
}
