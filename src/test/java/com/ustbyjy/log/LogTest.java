package com.ustbyjy.log;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class LogTest {
    private static Logger logger = LoggerFactory.getLogger(LogTest.class);

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS");

    public static void main(String[] args) {
        Map<String, LogSegment> logSegmentMap = new HashMap<>();
        String fileName = "D:\\QMDownload\\csproxy.log.2018-05-05";
        BufferedReader bufferedReader = null;
        String line;
        int lineNum = 1;
        LogSegment logSegment;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            while (StringUtils.isNotBlank(line = bufferedReader.readLine())) {
                if (line.contains("path=/huawei/give_awards")) {
                    String dateStr = line.substring(0, 24);
                    Date startTime = simpleDateFormat.parse(dateStr);
                    int indexOfRequestId = line.lastIndexOf("requestId=") + 10;
                    String requestId = line.substring(indexOfRequestId, indexOfRequestId + 32);

                    logSegment = new LogSegment();
                    logSegment.setRequestId(requestId)
                            .setStartNum(lineNum)
                            .setStartTime(startTime);

                    logSegmentMap.put(requestId, logSegment);
                } else if (line.contains("HuaWei.giveAwards@give awards")) {
                    String dateStr = line.substring(0, 24);
                    Date endTime = simpleDateFormat.parse(dateStr);
                    int indexOfRequestId = line.lastIndexOf("serial_no=") + 10;
                    String requestId = line.substring(indexOfRequestId, indexOfRequestId + 32);

                    logSegment = logSegmentMap.get(requestId);
                    logSegment.setEndNum(lineNum)
                            .setCostInMillisecond(endTime.getTime() - logSegment.getStartTime().getTime())
                            .setMessage(line);
                }
                lineNum++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        List<LogSegment> logSegmentList = new ArrayList<>(logSegmentMap.values());
        Collections.sort(logSegmentList);

        for (LogSegment segment : logSegmentList) {
            logger.info(segment.toString());
        }
    }
}
