package com.example.imsbackend.mapper.struct;

import com.example.imsbackend.domain.dto.InsertUserDTO;
import com.example.imsbackend.domain.dto.UpdateUserDTO;
import com.example.imsbackend.domain.entity.User;
import com.example.imsbackend.domain.vo.AuthUserInfoVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * @author Silvery
 * @since 2023/11/2 19:46
 */
@Mapper
public interface BeanCopyUtil {

    BeanCopyUtil INSTANCE = Mappers.getMapper(BeanCopyUtil.class);

    AuthUserInfoVO toAuthUserInfo(User user);

    User toUser(InsertUserDTO insertUserDTO);

    User toUser(UpdateUserDTO updateUserDTO);
}
