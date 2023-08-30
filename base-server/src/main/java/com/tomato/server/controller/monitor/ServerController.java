package com.tomato.server.controller.monitor;

import com.tomato.common.response.BaseResponse;
import com.tomato.server.model.Server;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 服务器监控
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/monitor/server")
public class ServerController {
    //    @PreAuthorize("@ss.hasPermi('monitor:server:list')")
    @GetMapping()
    public BaseResponse getInfo() throws Exception {
        Server server = new Server();
        server.copyTo();
        return BaseResponse.success(server);
    }
}
