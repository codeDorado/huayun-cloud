package cn.ddnd.huayun.web.request.Execute;

import java.util.Map;

public class ExecuteRequestRouter extends ExecuteRequest{

    /**
     * 路由器相关操作
     * @param parameter
     * @return
     */
    @Override
    public Object execute(Map parameter) {
        map.putAll(parameter);
        return doExecute();
    }

}
