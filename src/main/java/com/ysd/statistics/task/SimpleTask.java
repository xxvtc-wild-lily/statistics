package com.ysd.statistics.task;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.ysd.statistics.entity.PublicPlace;
import com.ysd.statistics.entity.Statistics;
import com.ysd.statistics.repository.StatisticsRepostitory;

@Component
@EnableScheduling
public class SimpleTask {
	
	@Autowired
	private StatisticsRepostitory statisticsRepository;
	
	@Resource
	private SimpleDateFormat dateFormat;
	
	
	@Scheduled(cron = "* 30 23 * * ? ")
	public void reportCurrentTimeCron() {
		Calendar cal=Calendar.getInstance();
		String year = cal.get(Calendar.YEAR)+"";
		String month = cal.get(Calendar.MONTH)+1+"";
		String day = cal.get(Calendar.DATE)+"";
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
		// 当前时间
		String date = dateFormat.format(cal.getTime());
		// 当前时间毫秒数
		long current=System.currentTimeMillis();
		// 今天零点零分零秒的毫秒数
        long zero=current/(1000*3600*24)*(1000*3600*24)-TimeZone.getDefault().getRawOffset();
        // 今天23点30分的毫秒数
        long twelve=zero+24*60*60*1000-60*30*1000;
        
        Timestamp zeroT = new Timestamp(zero);
        Timestamp twelveT = new Timestamp(twelve);
        String zeroS = zeroT.toString();
        zeroS = zeroS.substring(0, zeroS.length() - 2);
        String twelveS = twelveT.toString();
        twelveS = twelveS.substring(0, twelveS.length() - 2);
        List<Map<String, Object>> list = statisticsRepository.selectTodayUserInfo(zeroS, twelveS);
        
        for (int i = 0;i < list.size();i++) {
        	statisticsRepository.insertStatistics(Integer.parseInt(list.get(i).get("sta_public_palce_id")+""), Integer.parseInt(list.get(i).get("sta_people_nums")+""), year, month, day);
        }
        
	}
	
}
