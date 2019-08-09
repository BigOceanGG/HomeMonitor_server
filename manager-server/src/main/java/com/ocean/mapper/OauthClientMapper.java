package com.ocean.mapper;

import com.ocean.application.domain.ApplicationInDto;

public interface OauthClientMapper {

    boolean insertOauthClient(ApplicationInDto applicationInDto);

    boolean updateOauthClient(ApplicationInDto applicationInDto);
}
