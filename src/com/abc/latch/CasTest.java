package com.abc.latch;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author Administrator
 * @Date 2026/5/13 15:18
 * @Version 1.0
 */
public class CasTest implements java.io.Serializable{

    private static final Unsafe unsafe ;
    private static final long valueOffset ;
    static {
        try {
            Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
            theUnsafe.setAccessible(true);
            unsafe = (Unsafe) theUnsafe.get(null);
            valueOffset = unsafe.objectFieldOffset(CasTest.class.getDeclaredField("value"));
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    private volatile int value;

    public int getValue() {
        return value;
    }

    public static void main(String[] args) {
//        CasTest casTest = new CasTest();
//        unsafe.compareAndSwapInt(casTest,valueOffset,0,2);
//        System.out.println(casTest.getValue());

        AtomicReference<Job> jobAtomicReference = new AtomicReference<>();
        jobAtomicReference.compareAndSet(null,new Job("haha",1));
        Job job = jobAtomicReference.get();
        System.out.println(job.getName());


    }


}
