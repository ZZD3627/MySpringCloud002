package com.zzd.rabbitmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Description: Topic话题模式总数监听器
 * @BelongsProject: DreamChardonnay
 * @BelongsPackage: com.cyj.dream.file.listener
 * @Author: ChenYongJia
 * @CreateTime: 2021-10-19
 * @Email: chen87647213@163.com
 * @Version: 1.0
 */
@Slf4j
@Component
@RabbitListener(queues = "topic.woman")
public class TopicTotalReceiver {

    @RabbitHandler
    public void process(Map testMessage) {
        log.info("TopicTotalReceiver消费者收到消息  : " + testMessage.toString());
    }

}

