package org.ylan.model.dto.resp;

import lombok.Data;
import org.ylan.common.desensitization.annotation.Desensitization;
import org.ylan.common.desensitization.enums.DesensitizationTypeEnum;

/**
 * 用户返回参数响应 脱敏
 *
 * @author ylan
 */

@Data
public class UserRespDTO {

    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    @Desensitization(type = DesensitizationTypeEnum.MOBILE_PHONE)
    private String phone;

    /**
     * 邮箱
     */
    @Desensitization(type = DesensitizationTypeEnum.EMAIL)
    private String mail;
}