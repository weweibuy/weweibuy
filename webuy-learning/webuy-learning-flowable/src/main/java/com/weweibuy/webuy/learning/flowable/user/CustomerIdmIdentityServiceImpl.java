package com.weweibuy.webuy.learning.flowable.user;

import com.weweibuy.framework.common.core.exception.Exceptions;
import org.flowable.common.engine.impl.identity.Authentication;
import org.flowable.common.engine.impl.service.CommonEngineServiceImpl;
import org.flowable.idm.api.*;
import org.flowable.idm.engine.IdmEngineConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author durenhao
 * @date 2020/10/23 22:17
 **/
@Component
@Primary
public class CustomerIdmIdentityServiceImpl extends CommonEngineServiceImpl<IdmEngineConfiguration> implements IdmIdentityService {

    public CustomerIdmIdentityServiceImpl(IdmEngineConfiguration idmEngineConfiguration) {
        super(idmEngineConfiguration);
    }

    @Override
    public User newUser(String userId) {
        notSupportFunc();
        return null;
    }

    @Override
    public void saveUser(User user) {
        notSupportFunc();
    }

    @Override
    public void updateUserPassword(User user) {
        notSupportFunc();
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
        notSupportFunc();
    }

    @Override
    public Group newGroup(String groupId) {
        return null;
    }

    @Override
    public GroupQuery createGroupQuery() {
        return null;
    }

    @Override
    public NativeGroupQuery createNativeGroupQuery() {
        return null;
    }

    @Override
    public void saveGroup(Group group) {
        notSupportFunc();
    }

    @Override
    public void deleteGroup(String groupId) {
        notSupportFunc();
    }

    @Override
    public void createMembership(String userId, String groupId) {
        notSupportFunc();
    }

    @Override
    public void deleteMembership(String userId, String groupId) {
        notSupportFunc();
    }

    @Override
    public boolean checkPassword(String userId, String password) {
        notSupportFunc();
        return false;
    }

    @Override
    public void setAuthenticatedUserId(String authenticatedUserId) {
        Authentication.setAuthenticatedUserId(authenticatedUserId);
        notSupportFunc();
    }

    @Override
    public void setUserPicture(String userId, Picture picture) {
        notSupportFunc();
    }

    @Override
    public Picture getUserPicture(String userId) {
        return null;
    }

    @Override
    public Token newToken(String id) {
        notSupportFunc();
        return null;
    }

    @Override
    public void saveToken(Token token) {
        notSupportFunc();
    }

    @Override
    public void deleteToken(String tokenId) {
        notSupportFunc();
    }

    @Override
    public TokenQuery createTokenQuery() {
        notSupportFunc();
        return null;
    }

    @Override
    public NativeTokenQuery createNativeTokenQuery() {
        notSupportFunc();
        return null;
    }

    @Override
    public void setUserInfo(String userId, String key, String value) {
        notSupportFunc();
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
        notSupportFunc();
    }

    @Override
    public Privilege createPrivilege(String privilegeName) {
        return null;
    }

    @Override
    public void addUserPrivilegeMapping(String privilegeId, String userId) {
        notSupportFunc();
    }

    @Override
    public void deleteUserPrivilegeMapping(String privilegeId, String userId) {
        notSupportFunc();
    }

    @Override
    public void addGroupPrivilegeMapping(String privilegeId, String groupId) {

    }

    @Override
    public void deleteGroupPrivilegeMapping(String privilegeId, String groupId) {
        notSupportFunc();
    }

    @Override
    public List<PrivilegeMapping> getPrivilegeMappingsByPrivilegeId(String privilegeId) {
        return null;
    }

    @Override
    public void deletePrivilege(String privilegeId) {
        notSupportFunc();
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
