package lock;


import org.openjdk.jol.info.ClassLayout;
import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class Lock {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Lock l = new Lock();
        Integer h = l.hashCode();
//        System.out.println(Integer.toHexString(h));
        System.out.println(ClassLayout.parseInstance(l).toPrintable());

        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.gc();
        System.out.println(ClassLayout.parseInstance(l).toPrintable());


//        countHash(l);
    }

    public static void countHash(Object object) throws NoSuchFieldException, IllegalAccessException {
        Field field = Unsafe.class.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe)field.get(null);
        long hashCode = 0;
        for(long index = 4; index > 0; index--) {
            hashCode |= (unsafe.getByte(object, index) & 0xFF) << ((index - 1) * 8);
        }
        String code = Long.toHexString(hashCode);
        System.out.println("0x"+code);
    }

}
