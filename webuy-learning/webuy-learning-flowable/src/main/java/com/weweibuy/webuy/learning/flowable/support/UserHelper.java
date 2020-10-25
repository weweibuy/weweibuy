package com.weweibuy.webuy.learning.flowable.support;

import com.weweibuy.framework.common.core.exception.Exceptions;
import com.weweibuy.framework.common.core.model.dto.CommonDataResponse;
import com.weweibuy.upms.api.user.dto.request.UserQueryReqDTO;
import com.weweibuy.upms.api.user.dto.response.UserRespDTO;
import com.weweibuy.webuy.learning.flowable.client.UserClient;
import lombok.RequiredArgsConstructor;
import org.flowable.idm.api.User;
import org.flowable.idm.engine.impl.UserQueryImpl;
import org.flowable.idm.engine.impl.persistence.entity.UserEntityImpl;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author durenhao
 * @date 2020/10/25 11:42
 **/
@Component
@RequiredArgsConstructor
public class UserHelper {

    private final UserClient client;

    private static UserClient userClient;

    @PostConstruct
    public void init() {
        userClient = client;
    }

    public static List<User> queryUser(UserQueryImpl userQuery) {
        return Optional.ofNullable(userClient.queryUser(userQueryToReqDto(userQuery)))
                .map(CommonDataResponse::getData)
                .map(list -> list.stream().map(UserHelper::userRespDTOToUser).collect(Collectors.toList()))
                .orElseThrow(() -> Exceptions.unknown());
    }


    public static Long countUser(UserQueryImpl userQuery) {
        return Optional.ofNullable(userClient.countUser(userQueryToReqDto(userQuery)))
                .map(CommonDataResponse::getData)
                .orElseThrow(() -> Exceptions.unknown());
    }


    private static UserQueryReqDTO userQueryToReqDto(UserQueryImpl userQuery) {
        UserQueryReqDTO userQueryReqDTO = new UserQueryReqDTO();
        userQueryReqDTO.setName(userQuery.getFirstName());
        userQueryReqDTO.setUsername(userQuery.getId());
        Optional.ofNullable(userQuery.getIds())
                .map(list -> list.toArray(new String[10]))
                .ifPresent(userQueryReqDTO::setUsernameList);
        userQueryReqDTO.setGroupKey(userQuery.getGroupId());
        Optional.ofNullable(userQuery.getGroupIds())
                .map(list -> list.toArray(new String[10]))
                .ifPresent(userQueryReqDTO::setGroupKeyList);

        userQueryReqDTO.setEmail(userQuery.getEmail());
        return userQueryReqDTO;
    }

    private static User userRespDTOToUser(UserRespDTO dto) {
        UserEntityImpl userEntity = new UserEntityImpl();
        userEntity.setDisplayName(dto.getName());
        userEntity.setId(dto.getUsername());
        userEntity.setEmail(dto.getUsername());
        userEntity.setFirstName(dto.getUsername());
        userEntity.setLastName(dto.getUsername());
        return userEntity;
    }
}
