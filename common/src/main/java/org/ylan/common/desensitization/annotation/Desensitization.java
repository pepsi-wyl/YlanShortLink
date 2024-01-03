package org.ylan.common.desensitization.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.ylan.common.desensitization.enums.DesensitizationTypeEnum;
import org.ylan.common.desensitization.serialize.DesensitizationSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 脱敏支持注解
 *
 * @author ylan
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonSerialize(using = DesensitizationSerialize.class)  // 使用自定义序列化规则
public @interface Desensitization {

    /**
     * 脱敏策略，在使用 CUSTOMIZE_RULE 的时候，startInclude 和 endExclude生效  默认 CUSTOMIZE_RULE
     */
    DesensitizationTypeEnum type() default DesensitizationTypeEnum.CUSTOMIZE_RULE;

    /**
     * 脱敏开始位置（包含） 默认 0
     */
    int startInclude() default 0;

    /**
     * 脱敏结束位置（不包含） 默认 0
     */
    int endExclude() default 0;

    /**
     * 脱敏字符 默认 *
     */
    char symbol() default '*';
}