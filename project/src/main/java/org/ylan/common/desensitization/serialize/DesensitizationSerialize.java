package org.ylan.common.desensitization.serialize;

import cn.hutool.core.util.DesensitizedUtil;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.ylan.common.desensitization.annotation.Desensitization;
import org.ylan.common.desensitization.enums.DesensitizationTypeEnum;

import java.io.IOException;
import java.util.Objects;

/**
 * 自定义序列化类
 *
 * @author ylan
 */

@NoArgsConstructor
@AllArgsConstructor
// 继承 JsonSerializer，实现ContextualSerializer接口，并重写两个方法
public class DesensitizationSerialize extends JsonSerializer<String> implements ContextualSerializer {

    /**
     * 脱敏类型
     */
    private DesensitizationTypeEnum type;

    /**
     * 脱敏开始位置（包含）
     */
    private Integer startInclude;

    /**
     * 脱敏结束位置（不包含）
     */
    private Integer endExclude;

    /**
     * 脱敏字符
     */
    private char symbol;

    /**
     * 配置属性
     * 身份证前N位不脱敏
     */
    private final Integer ID_CARD_NUM_FRONT = 6;

    /**
     * 配置属性
     * 身份证后N位不脱敏
     */
    private final Integer ID_CARD_NUM_END = 4;

    /**
     * 配置属性
     * 地址后N位脱敏
     */
    private final Integer ADDRESS_SENSITIVE_SIZE = 8;

    /**
     * serialize规则
     * @param str
     * @param jsonGenerator
     * @param serializerProvider
     * @throws IOException
     */
    @Override
    public void serialize(String str, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        switch (type) {
            // 自定义类型脱敏 [startInclude,endExclude)
            case CUSTOMIZE_RULE:
                jsonGenerator.writeString(this.hide(str, startInclude, endExclude, symbol));
                break;
            // 用户id脱敏
            case USER_ID:
                jsonGenerator.writeString(String.valueOf(DesensitizedUtil.userId()));
                break;
            // 中文姓名脱敏
            case CHINESE_NAME:
                jsonGenerator.writeString(DesensitizedUtil.chineseName(String.valueOf(str)));
                break;
            // 身份证脱敏
            case ID_CARD:
                jsonGenerator.writeString(DesensitizedUtil.idCardNum(String.valueOf(str), ID_CARD_NUM_FRONT, ID_CARD_NUM_END));
                break;
            // 固定电话脱敏
            case FIXED_PHONE:
                jsonGenerator.writeString(DesensitizedUtil.fixedPhone(String.valueOf(str)));
                break;
            // 手机号脱敏 前三后四不掩码，其他全部用*进行掩码
            case MOBILE_PHONE:
                jsonGenerator.writeString(DesensitizedUtil.mobilePhone(String.valueOf(str)));
                break;
            // 地址脱敏 脱敏后N位
            case ADDRESS:
                jsonGenerator.writeString(DesensitizedUtil.address(String.valueOf(str), ADDRESS_SENSITIVE_SIZE));
                break;
            // 邮箱脱敏
            case EMAIL:
                jsonGenerator.writeString(DesensitizedUtil.email(String.valueOf(str)));
                break;
            // 密码脱敏
            case PASSWORD:
                jsonGenerator.writeString(DesensitizedUtil.password(String.valueOf(str)));
                break;
            // 中国大陆车牌脱敏
            case CAR_LICENSE:
                jsonGenerator.writeString(DesensitizedUtil.carLicense(String.valueOf(str)));
                break;
            // 银行卡脱敏
            case BANK_CARD:
                jsonGenerator.writeString(DesensitizedUtil.bankCard(String.valueOf(str)));
                break;
            default:
        }
    }

    /**
     * 判断脱敏注解是否存在，并按需脱敏
     * @param serializerProvider
     * @param beanProperty
     * @return
     * @throws JsonMappingException
     */
    @Override
    public JsonSerializer<?> createContextual(SerializerProvider serializerProvider, BeanProperty beanProperty) throws JsonMappingException {
        // 判断数据是否为存在
        if (beanProperty != null) {
            // 判断数据类型是否为String类型
            if (Objects.equals(beanProperty.getType().getRawClass(), String.class)) {
                // 获取脱敏自定义的注解
                Desensitization desensitization = beanProperty.getAnnotation(Desensitization.class);
                // 为null
                if (desensitization == null) {
                    desensitization = beanProperty.getContextAnnotation(Desensitization.class);
                }
                // 不为null
                if (desensitization != null) {
                    // 创建定义的序列化类的实例并且返回，入参为注解定义的type，开始位置，结束位置，脱敏字符
                    return new DesensitizationSerialize(
                            desensitization.type(),
                            desensitization.startInclude(),
                            desensitization.endExclude(),
                            desensitization.symbol()
                    );
                }
            }
            return serializerProvider.findValueSerializer(beanProperty.getType(), beanProperty);
        }
        return serializerProvider.findNullValueSerializer(null);
    }

    /**
     * 对字符串进行脱敏操作
     * @param str            原始字符串
     * @param startInclude   左侧需要保留几位明文字段
     * @param endExclude     右侧需要保留几位明文字段
     * @param symbol         用于遮罩的字符串, 如'*'
     * @return
     */
    private static String hide(CharSequence str, int startInclude, int endExclude, char symbol) {
        if (isEmpty(str)) {
            return str(str);
        } else {
            String originalStr = str(str);
            int[] strCodePoints = originalStr.codePoints().toArray();
            int strLength = strCodePoints.length;
            if (startInclude > strLength) {
                return originalStr;
            } else {
                if (endExclude > strLength) {
                    endExclude = strLength;
                }

                if (startInclude > endExclude) {
                    return originalStr;
                } else {
                    StringBuilder stringBuilder = new StringBuilder();

                    for(int i = 0; i < strLength; ++i) {
                        if (i >= startInclude && i < endExclude) {
                            stringBuilder.append(symbol);
                        } else {
                            stringBuilder.append(new String(strCodePoints, i, 1));
                        }
                    }

                    return stringBuilder.toString();
                }
            }
        }
    }

    private static String str(CharSequence str) {
        return null == str ? null : str.toString();
    }

    private static boolean isEmpty(CharSequence str) {
        return str == null || str.length() == 0;
    }
}