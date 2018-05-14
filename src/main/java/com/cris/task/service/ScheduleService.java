package com.cris.task.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @ClassName ScheduleService
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
@Service
public class ScheduleService {

    /**
    * @Author zc-cris
    * @Description second,minute,hour,day of month,month,day of week
     *              * * * * * MON-FRI （表示周一到周五的每一秒都执行这个定时任务）
     *              【0 0/5 14,18 * * ?】:每天的14点和18点，整点开始每隔5分钟执行一次
     *              【0 15 10 ? * 1-6】: 每个月的周一到周六的10点15分执行一次
     *              【0 0 2 ? * 6L】:每个月的最后一个周六的2点执行一次
     *              【0 0 2 LW * ?】:每个月的最后一个工作日的2点执行一次
     *              【0 0 2-4 ? * 1#1】: 每个月的第一个周一的2点至4点每个整点执行一次
    * @Param []
    * @return void
    **/
    //@Scheduled(cron = "0 * * * * MON-FRI")  // 周一到周五每分钟执行一次
    //@Scheduled(cron = "0,1,2,3,4 * * * * MON-FRI") // 周一到周五每分钟的每0,1,2,3,4 秒执行一次
    //@Scheduled(cron = "0-4 * * * * MON-FRI")    // 同上
    //@Scheduled(cron = "0/4 * * * * MON-FRI")    // 周一到周五每4秒执行一次
    public void scheduledTask(){
        System.out.println("定时任务执行中...");
    }

}
