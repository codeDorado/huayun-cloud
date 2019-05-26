package cn.ddnd.huayun.web.controller;

import cn.ddnd.huayun.web.service.CloudSnapshotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("/cloud/snapshot")
public class CloudSnapshotController {

    @Autowired
    CloudSnapshotService snapshotService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("create")
    public Object create(@RequestParam("region") String region,
                        @RequestParam("id") String id,
                        @RequestParam("createType") String createType,
                        @RequestParam("name") String name,
                        @RequestParam("description") String description,
                        HttpSession session) {
        String sessionId = session.getId();
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return snapshotService.createCloudSnapshot(accessKeyId, accessKey, region, id, createType,
                name, description);
    }

    @GetMapping("delete")
    public Object delete(@RequestParam("region") String region,
                        @RequestParam("snapshotId") String snapshotId,
                        HttpSession session) {
        String sessionId = session.getId();
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return snapshotService.deleteCloudSnapshot(accessKeyId, accessKey, region, snapshotId);
    }

    @GetMapping("query")
    public Object query(@RequestParam("region") String region,
                        @Nullable @RequestParam("id") String id,
                        HttpSession session) {
        String sessionId = session.getId();
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return snapshotService.queryCloudSnapshot(accessKeyId, accessKey, region, id);
    }

    @GetMapping("apply")
    public Object apply(@RequestParam("region") String region,
                        @RequestParam("snapshotId") String snapshotId,
                        HttpSession session) {
        String sessionId = session.getId();
        Map<String, String> map = (Map) stringRedisTemplate.opsForHash().entries("user:" + sessionId);
        String accessKeyId = map.get("accessKeyId");
        String accessKey = map.get("accessKey");
        return snapshotService.applyCloudSnapshot(accessKeyId, accessKey, region, snapshotId);
    }
}