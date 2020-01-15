//package com.yudao;
//
//import com.yudao.controller.dto.TaskDTO;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.client.RestTemplate;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.*;
//
////@Component
//public class MyTestRunner implements ApplicationRunner {
//
//    private static final Logger LOG = LoggerFactory.getLogger(MyTestRunner.class);
//
//
//    @Override
//    public void run(ApplicationArguments applicationArguments) throws Exception {
//        RestTemplate template = new RestTemplate();
//
//
//        // 使用一个字符串集合来存储文本中的路径 ，也可用String []数组
//        List<String> list = new ArrayList<String>();
//        FileInputStream fis = new FileInputStream("/Users/grojer/Downloads/1.txt");
//        // 防止路径乱码   如果utf-8 乱码  改GBK     eclipse里创建的txt  用UTF-8，在电脑上自己创建的txt  用GBK
//        InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
//        BufferedReader br = new BufferedReader(isr);
//        String line = "";
//        while ((line = br.readLine()) != null) {
//            // 如果 t x t文件里的路径 不包含---字符串       这里是对里面的内容进行一个筛选
//            if (line.lastIndexOf("---") < 0) {
//                list.add(line);
//            }
//        }
//        br.close();
//        isr.close();
//        fis.close();
//
//        int i = 2;
//
//        for (Iterator<String> iterator = list.iterator(); iterator.hasNext(); ) {
//            String next = iterator.next();
//
//            String[] temp = next.split(" ");
//
//            TaskDTO t = new TaskDTO();
//
//            t.setTaskName("ks000" + i);
//            t.setTvmodel(1);
//            t.setTaskType("快手套餐");
//            t.setAppType((byte) 3);
//
//            Map map = new HashMap();
//
//            map.put("thumbUpCount",6);
//            map.put("commentCount",6);
//            map.put("addFansCount",6);
//            map.put("playCount",6);
//            map.put("shareCount",6);
//            map.put("userId",temp[1]);
//            map.put("productId",temp[0]);
//
//            t.setOtherData(map);
//            ResponseEntity<TaskDTO> result;
//            result = template.postForEntity("http://47.52.116.3:8004/gaia/task/insertTask", t, TaskDTO.class);
//            TaskDTO dd = result.getBody();
//
//            System.out.print(dd);
//
//            Thread.sleep(3000);
//
//            i = i + 1;
//        }
//
//
//    }
//
//
//}
