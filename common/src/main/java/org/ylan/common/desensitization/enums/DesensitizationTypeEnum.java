package org.ylan.common.desensitization.enums;

/**
 * 脱敏策略枚举
 *
 * @author ylan
 */

public enum DesensitizationTypeEnum {

    //自定义
    CUSTOMIZE_RULE,

    // 用户id
    USER_ID,

    // 中文姓名
    CHINESE_NAME,

    // 身份证
    ID_CARD,

    // 固定电话
    FIXED_PHONE,

    // 手机号
    MOBILE_PHONE,

    // 地址
    ADDRESS,

    // 电子邮件
    EMAIL,

    // 密码
    PASSWORD,

    // 中国大陆车牌，包含普通车辆、新能源车辆
    CAR_LICENSE,

    // 银行卡
    BANK_CARD
}