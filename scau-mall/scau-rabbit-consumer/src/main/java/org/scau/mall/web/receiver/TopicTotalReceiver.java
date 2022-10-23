package org.scau.mall.web.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import java.util.Map;
 
/**
 * 接收topic路由
 * @Description: 
 * @author: zhouguangming
 * @date: 2020年7月15日 上午11:20:33
 * @version: V1.0
 * @Copyright: xrk
 */
@Component
@RabbitListener(queues = "topic.woman")
public class TopicTotalReceiver {
 
    @RabbitHandler
    public void process(Map testMessage) {
        System.out.println("TopicTotalReceiver消费者收到消息  : " + testMessage.toString());
    }
}
