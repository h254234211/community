package com.community.dto;

/*  为什么要创建dto包
*   数据传输对象（DTO)(Data Transfer Object)，是一种设计模式之间传输数据的软件应用系统。
*   数据传输目标往往是数据访问对象从数据库中检索数据。
*   数据传输对象与数据交互对象或数据访问对象之间的差异是一个以不具有任何行为除了存储和检索的数据（访问和存取器）。
* */

import lombok.Data;

@Data
public class AccessTokenDto {
    private String client_id;
    private String client_secret;
    private String code;
    private String redirect_uri;
    private String state;
}
