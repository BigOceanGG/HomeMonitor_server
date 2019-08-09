package com.ocean.common.domain;

import com.ocean.utils.EnumUtils;
import com.ocean.utils.ResponseUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseController {
    @Autowired
    public ResponseUtils responseUtils;
    @Autowired
    public EnumUtils enumUtils;

}
