package work;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @Author Administrator
 * @Date 2022/8/14 12:00
 * @Version 1.0
 */
public class MakerTest {

    public static void main(String[] args) {
        final ProdcutionChannel channel = new ProdcutionChannel(5);
        AtomicInteger productNo = new AtomicInteger();
        IntStream.range(1,8).forEach(i->{
            new Thread(()->{
                while (true){
                    channel.offerProduction(new Production(productNo.getAndIncrement()));
                    try {
                        TimeUnit.SECONDS.sleep(ThreadLocalRandom.current().nextInt(10));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });
    }
}
