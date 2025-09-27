package com.abc.pool;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

/**
 * @Author Administrator
 * @Date 2025/9/24 22:47
 * @Version 1.0
 */
public class MessageProcessorLivelock {
    static class Message {
        private String content;
        private int retryCount = 0;

        public Message(String content) {
            this.content = content;
        }

        public void process() {
            if (retryCount < 3) {
                System.out.println("处理消息: " + content + ", 重试次数: " + retryCount);
                retryCount++;
                throw new RuntimeException("处理失败，需要重试");
            }
            System.out.println("消息处理成功: " + content);
        }
    }

    static class MessageQueue {
        private final Queue<Message> queue = new LinkedList<>();


        public void addMessage(Message message) {
            queue.offer(message);
        }

        public Message getMessage() {
            return queue.poll();
        }

        public boolean isEmpty() {
            return queue.isEmpty();
        }
    }

    static class Processor {
        private MessageQueue queue;
        private String name;
        private final Random random = new Random();

        public Processor(String name, MessageQueue queue) {
            this.name = name;
            this.queue = queue;
        }

        public void processMessages() {
            while (true) {
                Message message = queue.getMessage();
                if (message == null) {
                    break;
                }

                try {
                    message.process();
                } catch (Exception e) {
                    System.out.println(name + ": 处理失败，重新放回队列");
                    // 这里可能导致活锁：消息不断失败，不断重试
                    queue.addMessage(message);

                    // 模拟随机延迟，避免完全同步
                    try {
                        Thread.sleep(random.nextInt(100));
                    } catch (InterruptedException ex) {
                        Thread.currentThread().interrupt();
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MessageQueue queue = new MessageQueue();

        // 添加一些会失败的消息
        for (int i = 0; i < 5; i++) {
            queue.addMessage(new Message("Message-" + i));
        }

        // 创建多个处理器
        Processor p1 = new Processor("Processor-1", queue);
        Processor p2 = new Processor("Processor-2", queue);

        Thread t1 = new Thread(p1::processMessages);
        Thread t2 = new Thread(p2::processMessages);

        t1.start();
        t2.start();

        // 运行一段时间后停止
        Thread.sleep(5000);
        t1.interrupt();
        t2.interrupt();
    }
}
