package org.scau.mall.web.receiver;

import java.util.Map;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * fanout路由
 * @Description: 
 * @author: zhouguangming
 * @date: 2020年7月15日 上午11:32:45
 * @version: V1.0
 * @Copyright: xrk
 */
@Component
@RabbitListener(queues = "fanout.B")
public class FanoutReceiverB {
 
    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("FanoutReceiverB消费者收到消息  : " +testMessage.toString());
    }
 
}
