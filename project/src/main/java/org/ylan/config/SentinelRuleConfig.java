package org.ylan.config;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static org.ylan.common.constant.SentinelConstant.RUTE_CREATE_SHORT_lINK;

/**
 * 初始化Sentinel限流配置
 *
 * @author ylan
 */

@Component
public class SentinelRuleConfig implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        List<FlowRule> rules = new ArrayList<>();

        // 创建短链接接口限流规则
        FlowRule createShortLink = new FlowRule();
        createShortLink.setResource(RUTE_CREATE_SHORT_lINK);
        createShortLink.setGrade(RuleConstant.FLOW_GRADE_QPS);  // QPS
        createShortLink.setCount(1);                            // 定义阈值
        rules.add(createShortLink);

        // 限流管理器
        FlowRuleManager.loadRules(rules);
    }
}