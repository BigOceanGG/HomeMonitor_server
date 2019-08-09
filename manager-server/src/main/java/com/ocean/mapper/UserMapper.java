package com.ocean.mapper;

import com.ocean.identity.domain.UserInDto;
import com.ocean.identity.domain.UserOutDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by shining on 2018/9/25.
 */
public interface UserMapper {

    /**
     * 查询用户列表并关联输出绑定的认证信息
     * @param userInDto
     * @return
     */
    public List<UserOutDto> findUserList(UserInDto userInDto);


    Integer updateUserEnabled(@Param("id") Long id, @Param("enabled") Integer enabled);

    Integer updateUserApproveStatus(@Param("userId") Long userId, @Param("approveStatus") Integer approveStatus);
}
