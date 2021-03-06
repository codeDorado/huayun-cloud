package cn.ddnd.huayun.log.request.Execute;

import cn.ddnd.huayun.log.config.Global;
import cn.ddnd.huayun.log.message.CloudDiskMessageHandleImpl;
import cn.ddnd.huayun.log.message.MessageHandle;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: huayun
 * @description: 磁盘IO读取日志
 * @author: Xue 8
 * @create: 2019-05-23 17:25
 **/
public class ExecuteRequestIoRead extends ExecuteRequest{

    @Override
    public void execute() {
//        map.put("Action", "InstanceIoReadMonitor");
//        map.put("Id", "i-zz6rj39kty724");
//        map.put("StartTime", startDateTime);
//        map.put("EndTime", endDateTime);
        if (Global.cloudIdList == null || Global.cloudIdList.size() == 0)
            return;
        for (String str : Global.cloudIdList) {
            String[] strArr = str.split(";");
            map.put("Region", strArr[1]);
            map.put("Action", "InstanceIoReadMonitor");
            map.put("Id", strArr[0]);
            map.put("StartTime", startDateTime);
            map.put("EndTime", endDateTime);
            Map map1 = new HashMap(map);

            Request request = okHttpRequest.getRequestUrl(map1);
            try {
                Response response = okHttpClient.newCall(request).execute();
                MessageHandle handle = new CloudDiskMessageHandleImpl();
                Map map = handle.handle(response.body().string(), "io_read", String.valueOf(map1.get("Id")));
                if (map == null || map.size() == 0)
                    return;
                rabbitmqService.publish(map);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
