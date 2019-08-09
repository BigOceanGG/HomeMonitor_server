package com.ocean.common.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BaseDto {

    @ApiModelProperty(value = "提示语中英文区分 中文zh-cn  英文en")
    private String typeCode;
    @ApiModelProperty(value = "页码")
    private Integer page;
    @ApiModelProperty(value = "一页条数")
    private Integer pageSize;
//    @ApiModelProperty(value = "按列升降排序")
//    private String orderBy;

}
