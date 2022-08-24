package completablefuture.test02;

import com.thread.future.MedalInfo;
import com.thread.future.UserInfo;
import com.thread.service.MedalService;
import com.thread.service.UserInfoService;
import junit.framework.TestCase;

import java.util.concurrent.*;

/**
 * 链接：https://juejin.cn/post/6970558076642394142
 * @author dongchao
 * @date 2022/8/23 17:54
 */
public class Demo01 extends TestCase {

    public static final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static final ExecutorService executor = Executors.newCachedThreadPool();

    /**
     * 如果我们不使用Future进行并行异步调用，而是在主线程串行进行的话，耗时大约为300+500+300 = 1100 ms。
     * 可以发现，future+线程池异步配合，提高了程序的执行效率。
     * 但是Future对于结果的获取，不是很友好，只能通过阻塞或者轮询的方式得到任务的结果。
     *
     * Future.get() 就是阻塞调用，在线程获取结果之前get方法会一直阻塞。
     * Future提供了一个isDone方法，可以在程序中轮询这个方法查询执行结果。
     *
     * 阻塞的方式和异步编程的设计理念相违背，而轮询的方式会耗费无谓的CPU资源。
     * 因此，JDK8设计出CompletableFuture。CompletableFuture提供了一种观察者模式类似的机制，可以让任务执行完成后通知监听的一方。
     *
     */
    // 一个例子回顾Future
    public void test01() throws InterruptedException, ExecutionException {
        UserInfoService userInfoService = new UserInfoService();
        MedalService medalService = new MedalService();
        long userId = 666L;
        long startTime = System.currentTimeMillis();

        //调用用户服务获取用户基本信息
        FutureTask<UserInfo> userInfoFutureTask = new FutureTask<>(new Callable<UserInfo>() {
            @Override
            public UserInfo call() throws Exception {
                return userInfoService.getUserInfo(userId);
            }
        });
        executorService.submit(userInfoFutureTask);

        Thread.sleep(300);//模拟主线程其它操作耗时

        FutureTask<MedalInfo> medalInfoFutureTask = new FutureTask<>(new Callable<MedalInfo>() {
            @Override
            public MedalInfo call() throws Exception {
                return medalService.getMedalInfo(userId);
            }
        });
        executorService.submit(medalInfoFutureTask);

        UserInfo userInfo = userInfoFutureTask.get();//获取个人信息结果
        MedalInfo medalInfo = medalInfoFutureTask.get();//获取勋章信息结果

        System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");
    }

    /**
     * 可以发现，使用CompletableFuture，代码简洁了很多。CompletableFuture的supplyAsync方法，
     * 提供了异步执行的功能，线程池也不用单独创建了。
     * 实际上，它CompletableFuture使用了默认线程池是ForkJoinPool.commonPool。
     */
    // 一个例子走进CompletableFuture
    public void test02() throws InterruptedException, ExecutionException, TimeoutException {
        UserInfoService userInfoService = new UserInfoService();
        MedalService medalService = new MedalService();
        long userId =666L;
        long startTime = System.currentTimeMillis();

        //调用用户服务获取用户基本信息
        CompletableFuture<UserInfo> completableUserInfoFuture = CompletableFuture.supplyAsync(() -> userInfoService.getUserInfo(userId));

        Thread.sleep(300); //模拟主线程其它操作耗时

        CompletableFuture<MedalInfo> completableMedalInfoFuture = CompletableFuture.supplyAsync(() -> medalService.getMedalInfo(userId));

        UserInfo userInfo = completableUserInfoFuture.get(2,TimeUnit.SECONDS);//获取个人信息结果
        MedalInfo medalInfo = completableMedalInfoFuture.get();//获取勋章信息结果
        System.out.println("总共用时" + (System.currentTimeMillis() - startTime) + "ms");

    }

    // 创建异步任务
    // supplyAsync执行CompletableFuture任务，支持返回值
    // runAsync执行CompletableFuture任务，没有返回值。
    public void test03() {
        //runAsync的使用
        CompletableFuture<Void> runFuture = CompletableFuture.runAsync(() -> System.out.println("run,关注公众号:捡田螺的小男孩"), executor);
        //supplyAsync的使用
        CompletableFuture<String> supplyFuture = CompletableFuture.supplyAsync(() -> {
            System.out.print("supply,关注公众号:捡田螺的小男孩");
            return "捡田螺的小男孩"; }, executor);
        //runAsync的future没有返回值，输出null
        System.out.println(runFuture.join());
        //supplyAsync的future，有返回值
        System.out.println(supplyFuture.join());
        executor.shutdown(); // 线程池需要关闭
    }

    // 任务异步回调
    // 1. thenRun/thenRunAsync
    // CompletableFuture的thenRun方法，通俗点讲就是，做完第一个任务后，再做第二个任务。
    // 某个任务执行完成后，执行回调方法；但是前后两个任务没有参数传递，第二个任务也没有返回值
    // thenRun 和thenRunAsync有什么区别呢？
    // 如果你执行第一个任务的时候，传入了一个自定义线程池：
    //
    // 调用thenRun方法执行第二个任务时，则第二个任务和第一个任务是共用同一个线程池。
    // 调用thenRunAsync执行第二个任务时，则第一个任务使用的是你自己传入的线程池，第二个任务使用的是ForkJoin线程池
    public void test04() throws ExecutionException, InterruptedException {
        CompletableFuture<String> orgFuture = CompletableFuture.supplyAsync(
                ()->{
                    System.out.println("先执行第一个CompletableFuture方法任务");
                    return "捡田螺的小男孩";
                }
        );

        CompletableFuture thenRunFuture = orgFuture.thenRun(() -> {
            System.out.println("接着执行第二个任务");
        });

        System.out.println(thenRunFuture.get());
    }

    // 2.thenAccept/thenAcceptAsync
    // CompletableFuture的thenAccept方法表示，第一个任务执行完成后，执行第二个回调方法任务，
    // 会将该任务的执行结果，作为入参，传递到回调方法中，但是回调方法是没有返回值的。
    public void test05() throws ExecutionException, InterruptedException {
        CompletableFuture<String> orgFuture = CompletableFuture.supplyAsync(
                ()->{
                    System.out.println("原始CompletableFuture方法任务");
                    return "捡田螺的小男孩";
                }
        );

        CompletableFuture thenAcceptFuture = orgFuture.thenAccept((a) -> {
            if ("捡田螺的小男孩".equals(a)) {
                System.out.println("关注了");
            }

            System.out.println("先考虑考虑");
        });

        System.out.println(thenAcceptFuture.get());
    }

    // 3. thenApply/thenApplyAsync
    // CompletableFuture的thenApply方法表示，第一个任务执行完成后，执行第二个回调方法任务，
    // 会将该任务的执行结果，作为入参，传递到回调方法中，并且回调方法是有返回值的。
    public void test06() throws ExecutionException, InterruptedException {
        CompletableFuture<String> orgFuture = CompletableFuture.supplyAsync(
                ()->{
                    System.out.println("原始CompletableFuture方法任务");
                    return "捡田螺的小男孩";
                }
        );

        CompletableFuture<String> thenApplyFuture = orgFuture.thenApply((a) -> {
            if ("捡田螺的小男孩".equals(a)) {
                return "关注了";
            }

            return "先考虑考虑";
        });

        System.out.println(thenApplyFuture.get());
    }

    // 4. exceptionally
    // CompletableFuture的exceptionally方法表示，某个任务执行异常时，
    // 执行的回调方法;并且有抛出异常作为参数，传递到回调方法。
    public void test07() throws ExecutionException, InterruptedException {
        CompletableFuture<String> orgFuture = CompletableFuture.supplyAsync(
                ()->{
                    System.out.println("当前线程名称：" + Thread.currentThread().getName());
                    throw new RuntimeException();
                }
        );

        CompletableFuture<String> exceptionFuture = orgFuture.exceptionally((e) -> {
            e.printStackTrace();
            return "你的程序异常啦";
        });

        System.out.println(exceptionFuture.get());
    }

    // 5. whenComplete方法
    // CompletableFuture的whenComplete方法表示，某个任务执行完成后，执行的回调方法，无返回值；
    // 并且whenComplete方法返回的CompletableFuture的result是上个任务的结果。
    public void test08() throws ExecutionException, InterruptedException {
        CompletableFuture<String> orgFuture = CompletableFuture.supplyAsync(
                ()->{
                    System.out.println("当前线程名称：" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "捡田螺的小男孩";
                }
        );

        CompletableFuture<String> rstFuture = orgFuture.whenComplete((a, throwable) -> {
            System.out.println("当前线程名称：" + Thread.currentThread().getName());
            System.out.println("上个任务执行完啦，还把" + a + "传过来");
            if ("捡田螺的小男孩".equals(a)) {
                System.out.println("666");
            }
            System.out.println("233333");
        });

        System.out.println(rstFuture.get());
    }

    // 6. handle方法
    // CompletableFuture的handle方法表示，某个任务执行完成后，执行回调方法，并且是有返回值的;
    // 并且handle方法返回的CompletableFuture的result是回调方法执行的结果。
    public void test09() throws ExecutionException, InterruptedException {
        CompletableFuture<String> orgFuture = CompletableFuture.supplyAsync(
                ()->{
                    System.out.println("当前线程名称：" + Thread.currentThread().getName());
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "捡田螺的小男孩";
                }
        );

        CompletableFuture<String> rstFuture = orgFuture.handle((a, throwable) -> {

            System.out.println("上个任务执行完啦，还把" + a + "传过来");
            if ("捡田螺的小男孩".equals(a)) {
                System.out.println("666");
                return "关注了";
            }
            System.out.println("233333");
            return null;
        });

        System.out.println(rstFuture.get());
    }

    // 多个任务组合处理
    // AND组合关系
    // thenCombine / thenAcceptBoth / runAfterBoth都表示：将两个CompletableFuture组合起来，只有这两个都正常执行完了，才会执行某个任务。
    // 区别在于：
    // thenCombine：会将两个任务的执行结果作为方法入参，传递到指定方法中，且有返回值
    // thenAcceptBoth: 会将两个任务的执行结果作为方法入参，传递到指定方法中，且无返回值
    // runAfterBoth 不会把执行结果当做方法入参，且没有返回值。
    public void test10() {
        CompletableFuture<String> first = CompletableFuture.completedFuture("第一个异步任务");
        ExecutorService executor = Executors.newFixedThreadPool(10);
        CompletableFuture<String> future = CompletableFuture
                //第二个异步任务
                .supplyAsync(() -> "第二个异步任务", executor)
                // (w, s) -> System.out.println(s) 是第三个任务
                .thenCombineAsync(first, (s, w) -> {
                    System.out.println(w);
                    System.out.println(s);
                    return "两个异步任务的组合";
                }, executor);
        System.out.println(future.join());
        executor.shutdown();
    }

    // OR 组合的关系
    // applyToEither / acceptEither / runAfterEither 都表示：将两个CompletableFuture组合起来，只要其中一个执行完了,就会执行某个任务。
    // 区别在于：
    // applyToEither：会将已经执行完成的任务，作为方法入参，传递到指定方法中，且有返回值
    // acceptEither: 会将已经执行完成的任务，作为方法入参，传递到指定方法中，且无返回值
    // runAfterEither： 不会把执行结果当做方法入参，且没有返回值。
    public void test11() {
        //第一个异步任务，休眠2秒，保证它执行晚点
        CompletableFuture<String> first = CompletableFuture.supplyAsync(()->{
            try{

                Thread.sleep(2000L);
                System.out.println("执行完第一个异步任务");}
            catch (Exception e){
                return "第一个任务异常";
            }
            return "第一个异步任务";
        });
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<Void> future = CompletableFuture
                //第二个异步任务
                .supplyAsync(() -> {
                            System.out.println("执行完第二个任务");
                            return "第二个任务";}
                        , executor)
                //第三个任务
                .acceptEitherAsync(first, System.out::println, executor);

        executor.shutdown();
    }

    // AllOf
    // 所有任务都执行完成后，才执行 allOf返回的CompletableFuture。如果任意一个任务异常，
    // allOf的CompletableFuture，执行get方法，会抛出异常
    public void test12() {
        CompletableFuture<Void> a = CompletableFuture.runAsync(()->{
            System.out.println("我执行完了");
        });
        CompletableFuture<Void> b = CompletableFuture.runAsync(() -> {
            System.out.println("我也执行完了");
        });
        CompletableFuture<Void> allOfFuture = CompletableFuture.allOf(a, b).whenComplete((m,k)->{
            System.out.println("finish");
        });
    }

    // AnyOf
    // 任意一个任务执行完，就执行anyOf返回的CompletableFuture。如果执行的任务异常，
    // anyOf的CompletableFuture，执行get方法，会抛出异常
    public void test13() {
        CompletableFuture<Void> a = CompletableFuture.runAsync(()->{
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我执行完了");
        });
        CompletableFuture<Void> b = CompletableFuture.runAsync(() -> {
            System.out.println("我也执行完了");
        });
        CompletableFuture<Object> anyOfFuture = CompletableFuture.anyOf(a, b).whenComplete((m,k)->{
            System.out.println("finish");
//            return "捡田螺的小男孩";
        });
        anyOfFuture.join();
    }

    // thenCompose
    // thenCompose方法会在某个任务执行完成后，将该任务的执行结果,作为方法入参,去执行指定的方法。该方法会返回一个新的CompletableFuture实例
    //
    // 如果该CompletableFuture实例的result不为null，则返回一个基于该result新的CompletableFuture实例；
    // 如果该CompletableFuture实例为null，然后就执行这个新任务
    public void test14() {
        CompletableFuture<String> f = CompletableFuture.completedFuture("第一个任务");
        //第二个异步任务
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<String> future = CompletableFuture
                .supplyAsync(() -> "第二个任务", executor)
                .thenComposeAsync(data -> {
                    System.out.println(data); return f; //使用第一个任务作为返回
                }, executor);
        System.out.println(future.join());
        executor.shutdown();
    }



}
