package com.hp;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SchedulerException, InterruptedException {
        //通过SchedulerFactory创建一个调度器实例
        SchedulerFactory schedulerfactory = new StdSchedulerFactory();
        Scheduler scheduler=null;
        try{
            // 通过schedulerFactory获取一个调度器
            scheduler = schedulerfactory.getScheduler();

            // 创建JobDetail实例
            //JobDetail已经作为接口（interface）存在，通过JobBuilder创建
            // 指明jobDetail的名称，所在组的名称，以及绑定job类
            JobDetail jobDetail = JobBuilder.newJob(HelloQuartz.class).withIdentity("jobDetailName", "jobDetailGroupName").build();

            // 定义调度触发规则
            //  corn表达式  每五秒执行一次
            Trigger trigger=TriggerBuilder.newTrigger().withIdentity("SimpleTrigger", "SimpleTriggerGroup")
                    .withSchedule(CronScheduleBuilder.cronSchedule("*/5 * * * * ?"))
                    .startNow().build();

            // 把jobDetail任务和trigger触发器关联添加到任务调度中
            scheduler.scheduleJob(jobDetail, trigger);

            // 启动调度
            scheduler.start();

            Thread.sleep(20000);

            // 停止调度
            scheduler.shutdown();

        }catch(SchedulerException e){
            e.printStackTrace();
        }
    }
}
