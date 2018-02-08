package com.hp.controller.timeTask;

/**
 * Created by hp on 2018/1/30.
 */
//供spring task使用注解方式使用任务
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component("taskJob")
public class job2 {
	@Scheduled(cron = "0 0 10 * * ?")
	public void say(){
		System.out.println("job2");
	}
}
