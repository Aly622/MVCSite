package com.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by Oliver.Liu on 3/6/2016.
 * 定时任务执行JavaBean可以不实现Job接口的execute方法
 */
public class MySchedule implements Job {

    public void printSomething(){
        //内容就是打印一句话
        System.out.println("this is andy schedule");
    }
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

    }
}
