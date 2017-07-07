package com.heiha.example.web;

import com.heiha.example.aop.annotation.AdditionalResponseHeader;
import com.heiha.example.aop.annotation.NoWebCache;
import com.heiha.example.mongo.po.Demo;
import com.heiha.example.mongo.po.WuXingType;
import com.heiha.example.mongo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.*;

/**
 * <br>
 * <b>Project:</b> spring-boot-demo<br>
 * <b>Date:</b> 2017/6/16 13:49<br>
 * <b>Author:</b> heiha<br>
 */
@RestController
@RequestMapping("/demo")
public class DemoController {
    @Autowired
    private DemoService demoService;

    /**
     * Used to test if Controller handle requests asynchronous <br>
     * Result: yes, and while this method sleeping, another thread will deal with a new coming request
     *
     * @param seconds
     * @return
     */
    @AdditionalResponseHeader
    @RequestMapping(path = "/test/sleep", method = RequestMethod.GET)
    public String demo(Integer seconds) {
        try {
            // 测试Controller处理Http请求是否异步
            // 测试结果，异步执行，此处sleep，新的请求会由新的线程处理
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Sleep (second): " + seconds;
    }

    /**
     * For some reasons, {@link NoWebCache} is not in effect. <br>
     * see {@link com.heiha.example.aop.aspect.NoWebCacheAspect} to find more detail.
     *
     * @return
     */
    @NoWebCache
    @RequestMapping(path = "/test/getString", method = RequestMethod.GET)
    public String toDemo() {
        return "demo";
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public List<Demo> getById(@PathVariable("id") String id) {
        return demoService.getById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Demo save(@RequestBody Demo demo) {
        return demoService.save(demo);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Demo update(@RequestBody Demo demo) {
        return demoService.update(demo);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public void removeById(@PathVariable("id") String id) {
        demoService.removeById(id);
    }

    @RequestMapping(path = "/getDemo", method = RequestMethod.GET)
    public Demo getDemo() {
        Demo demo = new Demo();
        demo.setId("fd11111");
        demo.setName("namea");
        demo.setWuXingType(WuXingType.HUO);
        demo.setNote("test");
        return demo;
    }

    @RequestMapping(path = "/call", method = RequestMethod.GET)
    public  List<String> testCallable() throws InterruptedException, ExecutionException {
        List<Callable<String>> callableList = new ArrayList<>(100);
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        for (int i = 1; i< 50; i++) {
            final String iStr = String.valueOf(i);
            Callable<String> callable = new Callable<String>() {
                @Override
                public String call() throws Exception {
                    try {
                        Thread.sleep(Integer.valueOf(iStr) * 1000);
                    } catch (Exception e) {
                        System.out.println("quit");
                        throw new Exception("quit");
                    }
                    System.out.println("In callable: " + iStr);
                    if (iStr.equals("49")) {
                        throw new Exception("49 exception");
                    }
                    return iStr;
                }
            };
            callableList.add(callable);
        }
        List<String> result = new ArrayList<>();
        List<Future<String>> futures = executorService.invokeAll(callableList, 10, TimeUnit.SECONDS);
        for (Future future : futures) {
            if (future.isDone() && !future.isCancelled()) {
                result.add((String)future.get());
            }
        }
        return result;
    }
}
