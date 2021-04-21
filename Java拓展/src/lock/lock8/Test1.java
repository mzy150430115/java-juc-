package lock.lock8;

/**
 * 8锁就是关于锁的八个问题
 * 1.
 * 2.SendSms延迟4秒，两个线程先打印发短信还是打电话？
 *  synchronized锁的对象是方法的调用者。两个方法拿到的是同一个锁，谁先拿到谁执行
 * 3.增加了一个普通方法后，先执行带锁的发短信还是普通的hello？
 *  普通方法先执行，因为不受锁的影响
 * 4.现在有两个phone对象，先发短信还是先打电话？ 发短信
 * 5.增加两个静态的同步方法，只有一个对象，先打印还是先发短信？
 *   发短信。因为加了static以后synchronized锁的是class 模板
 * 6.两个对象！增加两个静态的同步方法，先打印还是先发短信？
 *   发短信，因为加了static 两个class的类模板只有一个，锁的是class
 * 7.普通锁方法+静态的同步锁方法，一个对象，先打电话还是发短信
 *   打电话 因为打电话的那个方法锁的是调用者 普通方法，而打电话锁的是类模板class
 * 8.两个对象，其他和7一样。先打电话还是发短信？
 *   还是先发短信 和7的一样。
 */
public class Test1 {
    public static void main(String[] args) {
        Phone phone1 = new Phone();
        Phone phone2 = new Phone();
        new Thread(()->{
            phone1.sendSms();
        },"A").start();

        new Thread(()->{
            phone1.call();
        },"B").start();
    }
}

class Phone{
    public synchronized void sendSms(){
        System.out.println("发短信");
    }
    public synchronized void call(){
        System.out.println("打电话");
    }
}
