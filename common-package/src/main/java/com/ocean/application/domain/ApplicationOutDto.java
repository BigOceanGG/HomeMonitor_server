package com.ocean.application.domain;

import lombok.Data;

import java.util.Date;

@Data
public class ApplicationOutDto {
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
    private Date   createTime;

    private int    userId;
    private int    userType;
    private String callbackAddress;
    private String remark;
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
