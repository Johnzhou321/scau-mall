package org.scau.mall.web.receiver;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
/**
 * 监听全匹配路由队列
 * @Description: 配置多台监控同一直连队列，轮询方式消费信息
 * @author: zhouguangming
 * @date: 2020年7月15日 上午11:04:32
 * @version: V1.0
 * @Copyright: xrk
 */
@Component
@RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
public class DirectReceiver {
 
    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
    }
 
}
