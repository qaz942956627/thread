package com.lu.thread;

import com.lu.thread.config.LazyMan;
import com.lu.thread.config.Person;
import com.lu.thread.config.ThreadPool;
import com.lu.thread.entity.MutableInteger;
import com.lu.thread.entity.Teacher;
import com.lu.thread.service.LazyOutput;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;

@SpringBootTest
class ThreadApplicationTests {

   /* @Autowired
    private TbOrderService tbOrderService;
    @Autowired
    private IdWorker idWorker;
    *//*@Autowired
    private AsyncService asyncService;*//*

    @Test
    void contextLoads() {
    }

    private static int count = 0;
    @Autowired
    private ThreadPoolTaskExecutor threadPool;

    @Test()
    void test() {

        CountDownLatch cdl = new CountDownLatch(10);
        try {
            long start = System.currentTimeMillis();
            for (int i = 0; i < 10; i++) {
                int temp = i;
                threadPool.execute(() -> {
                    try {
                        System.out.println(Thread.currentThread().getName() + "  -> " + temp);
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        count++;
                        cdl.countDown();
                    }
                });
            }

            cdl.await();
            long end = System.currentTimeMillis();
            System.out.println("插入完毕用时:" + (end - start) + "毫秒:" + count);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 线程池用完，程序结束，关闭线程池
            threadPool.shutdown();
        }

        TbOrder order = this.tbOrderService.findOneById(1048108312895295488L);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            long id = idWorker.nextId();
            order.setOrderId(id);
            this.tbOrderService.save(order);
        }
        long end = System.currentTimeMillis();
        System.out.println("插入完毕用时:" + (end - start) + "毫秒");
    }

    @Test
    void test1() {
        TbOrder order = this.tbOrderService.findOneById(1048108312895295488L);
        long id = idWorker.nextId();
        order.setOrderId(id);
        TbOrder save = this.tbOrderService.save(order);
        System.out.println(order);
    }

    *//*@Test
    void test2() {
        Long id = asyncService.executeAsync();
        System.out.println(id);
    }*//*

    @Autowired
    private LazyOutput lazyOutput;

    @Test
    void test3() throws InterruptedException {
        ThreadPoolTaskExecutor threadPool = ThreadPool.getInstances();
        CountDownLatch cdl = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            int tmp = i;
            threadPool.execute(() -> {
                try {
                    lazyOutput.output(tmp);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cdl.countDown();
            });
        }
        cdl.await();
        System.out.println("程序结束");
    }

    @Test
    void test4() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            lazyOutput.output(i);
        }
    }*/

    @Test
    void lambdaTest() throws ExecutionException, InterruptedException {
        Supplier<Integer> integerCallable = () -> 1024;
        Integer integer = integerCallable.get();
        System.out.println(integer);


        Consumer<Integer> consumer = (i) -> System.out.println(i);
        consumer.accept(111);

        IntFunction<Integer> integerIntFunction = (int i) -> i;

        Integer apply = integerIntFunction.apply(123);
        System.out.println(apply);

        Supplier<Boolean> booleanCallable = () -> true;

        IntFunction<Boolean> booleanIntFunction = (int i) -> true;

        Predicate<Integer> predicate = (i) -> {
            if (i < 0) {
                return true;
            }
            return false;
        };

        boolean test = predicate.test(1);

        UnaryOperator<Integer> operator = (integer1 -> {
           return integer1;
        });
        IntBinaryOperator intBinaryOperator = (int i, int j) -> {
            return i + j;
        };

        Callable<String> callable = () -> "callable执行";
        FutureTask<String> futureTask = new FutureTask<>(callable);
        new Thread(futureTask).start();
        String s = futureTask.get();
        System.out.println(s);



    }

    @Test
    void test5() {
        List<Integer> list = Arrays.asList(11, 2, 3, 4, 5);
        Integer integer1 = list.stream().min(Integer::compare).get();

        Integer reduce = list.stream().reduce(100, (x, y) -> x + y);
        System.out.println(reduce);
    }



    @Test
    void test67() {
        String s = "sdfasdfa;";
        StringBuffer stringBuffer = new StringBuffer(s);
        System.out.println(stringBuffer.substring(0, stringBuffer.length() - 1));


    }

    @Test
    void test8() throws InterruptedException {
        MutableInteger mutableInteger = new MutableInteger();
        ThreadPoolTaskExecutor executor = ThreadPool.getInstances();

        executor.execute(() -> {
            try {
                mutableInteger.setValue(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executor.execute(() -> {
            System.out.println(mutableInteger.getValue());
        });

        TimeUnit.SECONDS.sleep(10);




    }

    @Qualifier("wang")
    @Autowired
    private Teacher teacher;
    @Test
    void testBean2() {

        System.out.println(teacher);
    }

    @Test
    void testBean() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Person.class);
        context.refresh();
        Teacher teacher = (Teacher) context.getBean("teacher1");
        System.out.println(teacher);
    }


    @Autowired
    private LazyOutput lazyOutput;

    @Test
    void testBean3() {
        lazyOutput.souTeacher();
    }

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;


    @Test
    void threadTest() throws InterruptedException {
        CountDownLatch cdl = new CountDownLatch(200);
        for (int i = 0; i < 200; i++) {
            int tmp = i;
            threadPoolTaskExecutor.execute(() -> {
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"---正在执行"+tmp);
                cdl.countDown();
            });
        }
        cdl.await();
        System.out.println(Thread.currentThread().getName()+"执行完毕");
    }

    @Test
    void mapTest() {
        //System.getProperties().list(System.out);
        //System.out.println(Runtime.getRuntime());
        int a = 1;
        int b = 2;
        a = b;
        a = 3;
        System.out.println(a);
        System.out.println(b);

        Integer a1 = new Integer(1);
        Integer a2 = new Integer(2);
        a1 = a2;
        a1 = new Integer(3);
        System.out.println(a1);
        System.out.println(a2);

        Teacher t = new Teacher();
        Teacher t2 = new Teacher();

        t = t2;
        t.setName("wang");
        System.out.println(t);
        System.out.println(t2);
    }

    @Test
    void throwTest() {
        int i = 100;
        for (int i1 = 1; i1 < 1000; i1++) {
            System.out.println(i1);
            if (i1 % 100 == 0) {
                throw new RuntimeException();
            }
        }

    }

    @Test
    void singleSynTest() throws InterruptedException {
        threadPoolTaskExecutor.execute(() -> {
            for (int i = 0; i < 2; i++) {
                try {
                    LazyMan instance = LazyMan.getInstance();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        });

        TimeUnit.SECONDS.sleep(4);
    }

    @Test
    void queueTest() {
        Map<String, String> map = new HashMap<>();
        map.put("1", "一");
        map.put("2", "二");
        map.put("3", "三");
        map.put("4", "四");
        map.forEach((key,value)->{
            System.out.println(key);
            System.out.println(value);
            System.out.println("--------------");
        });
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        Iterator<Integer> iterator = queue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        for (Integer integer : queue) {

        }
        Integer element = queue.element();
        queue.offer(11);
        List<Integer> list = (List<Integer>) queue;
        list.get(1);
        System.out.println(queue);
        queue.forEach((i) -> System.out.println(i));
        System.out.println(queue);

        Integer peek = queue.peek();
        Integer poll = queue.poll();
        Integer remove = queue.remove();

    }

    @Test
    void path() {
        System.out.println(System.getProperty("user.dir"));
    }
}
