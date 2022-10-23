package org.scau.mall.web.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.util.Map;

/**
 * fanout路由
 * @Description: 
 * @author: zhouguangming
 * @date: 2020年7月15日 上午11:32:45
 * @version: V1.0
 * @Copyright: xrk
 */
@Component
@RabbitListener(queues = "fanout.A")
public class FanoutReceiverA {
 
    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("FanoutReceiverA消费者收到消息  : " +testMessage.toString());
    }
 
}
