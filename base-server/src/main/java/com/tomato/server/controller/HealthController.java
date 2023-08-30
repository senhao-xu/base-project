package com.tomato.server.controller;

import com.tomato.common.response.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author senhao-xu
 * @Date: 2021/12/10 18:10
 */
@Slf4j
@Api("健康检查")
@RestController
@RequestMapping("/HealthController")
@RequiredArgsConstructor
public class HealthController {

    @ApiOperation(value = "健康检查")
    @GetMapping("/health")
    public BaseResponse health(){
        return BaseResponse.success();
    }
}
