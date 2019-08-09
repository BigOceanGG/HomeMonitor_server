package com.ocean.application.domain;

import lombok.Data;

@Data
public class ApplicationInDto {
    private String typeCode = "zh-cn";

    private Integer pageNum = 1;
    private Integer pageSize = 10;

    private String id;
    private String applicationName;
    private int    applicationType;
    private String applicationLogo;
    private String applicationSummary;
    private String applicationWebsite;
    private int    authorizationType;

    private String applicationId;
    private String applicationKey;
    private int    enabled;

    private String startTime;
    private String endTime;

    private int    userId;
    private String remark;
    private int    userType;
    private String callbackAddress;
    private String approver;

    private String companyName;
    private String contactPhone;
    private String contactEmail;
    private String businessLicenceNo;
    private String businessLicencePic;

    private String linkMan;
    private String certNo;
    private String certFrontPic;
    private String certBackPic;
}
