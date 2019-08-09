package com.ocean.mapper;

import com.ocean.identity.domain.UserIdentityInDto;
import com.ocean.identity.domain.UserIdentityOutDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IdentityMapper {

    List<UserIdentityOutDto> findIdentityList(UserIdentityInDto userIdentityInDto);


    Integer auditUserIdentity(@Param("state") Integer state,@Param("id")Long id,@Param("remark")String remark);

    UserIdentityOutDto findByUserId(Long userId);

}
