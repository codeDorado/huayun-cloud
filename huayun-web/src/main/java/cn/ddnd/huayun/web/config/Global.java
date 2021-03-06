package cn.ddnd.huayun.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class Global {

    public static String exchange;
    public static String routingkey;
    public static String requestApiUrl;
    public static String accessKeyId;
    public static String accessKeySecret;
    public static String elasticsearchMonitorUrl;
    public static String monitorTitle;
    public static String monitorEmail;
    public static List region;
    public static String appCode;
//    public static Integer cloudCpu;
//    public static Integer cloudMemory;
//    public static Integer cloudDiskUsed;
//    public static Integer cloudIoRead;
//    public static Integer cloudIoWrite;
//    public static Integer cloudIopsRead;
//    public static Integer cloudIopsWrite;
//    public static Integer cloudFipIn;
//    public static Integer cloudFipOut;

    @Value("${global.rabbitmq.exchange}")
    private void setExchange(String exchange) {
        this.exchange = exchange;
    }

    @Value("${global.rabbitmq.routing-key}")
    private void setRoutingkey(String routingkey) {
        this.routingkey = routingkey;
    }

    @Value("${global.huayun.access-key-id}")
    private void setAccessKeyId(String accessKeyId) {
        Global.accessKeyId = accessKeyId;
    }

    @Value("${global.huayun.access-key-secret}")
    private void setAccessKeySecret(String accessKeySecret) {
        Global.accessKeySecret = accessKeySecret;
    }

//    @Value("${global.elasticsearch.monitor-url}")
//    private void setElasticsearchMonitorUrl(String elasticsearchMonitorUrl) {
//        Global.elasticsearchMonitorUrl = elasticsearchMonitorUrl;
//    }

    @Value("${global.monitor.title}")
    private void setMonitorTitle(String monitorTitle) {
        Global.monitorTitle = monitorTitle;
    }

    @Value("${global.monitor.email}")
    private void setMonitorEmail(String monitorEmail) {
        Global.monitorEmail = monitorEmail;
    }

    @Value("${global.huayun.region}")
    private void setRegion(List region) {
        Global.region = region;
    }

    @Value("${global.msm.app-code}")
    private void setAppCode(String appCode) {
        Global.appCode = appCode;
    }


    //    @Value("${global.cloud.cpu}")
//    private void setCloudCpu(Integer cloudCpu) {
//        Global.cloudCpu = cloudCpu;
//    }
//
//    @Value("${global.cloud.memory}")
//    private void setCloudMemory(Integer cloudMemory) {
//        Global.cloudMemory = cloudMemory;
//    }
//
//    @Value("${global.cloud.disk-used}")
//    private void setCloudDiskUsed(Integer cloudDiskUsed) {
//        Global.cloudDiskUsed = cloudDiskUsed;
//    }
//
//    @Value("${global.cloud.io-read}")
//    private void setCloudIoRead(Integer cloudIoRead) {
//        Global.cloudIoRead = cloudIoRead;
//    }
//
//    @Value("${global.cloud.io-write}")
//    private void setCloudIoWrite(Integer cloudIoWrite) {
//        Global.cloudIoWrite = cloudIoWrite;
//    }
//
//    @Value("${global.cloud.iops-read}")
//    private void setCloudIopsRead(Integer cloudIopsRead) {
//        Global.cloudIopsRead = cloudIopsRead;
//    }
//
//    @Value("${global.cloud.iops-write}")
//    private void setCloudIopsWrite(Integer cloudIopsWrite) {
//        Global.cloudIopsWrite = cloudIopsWrite;
//    }
//
//    @Value("${global.cloud.fip-in}")
//    private void setCloudFipIn(Integer cloudFipIn) {
//        Global.cloudFipIn = cloudFipIn;
//    }
//
//    @Value("${global.cloud.fip-out}")
//    private void setCloudFipOut(Integer cloudFipOut) {
//        Global.cloudFipOut = cloudFipOut;
//    }

    @Value("${global.huayun.request-api-url}")
    private void setRequesApiUrl(String url) {
        Global.requestApiUrl = url;
    }
}
