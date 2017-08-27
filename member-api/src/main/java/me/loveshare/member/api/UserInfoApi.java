package me.loveshare.member.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.loveshare.bo.common.JsonResult;
import me.loveshare.dto.member.UserInfoDTO;
import me.loveshare.member.service.MemberService;
import me.loveshare.vo.common.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tony on 2017/8/1.
 */
@Api(tags = {}, description = "用户简单信息接入API")
@Slf4j
@RestController
@RequestMapping("userinfo")
public class UserInfoApi extends BaseApi {

    @Autowired
    private MemberService memberService;

    /**
     * 用户列表数据
     */
    @ApiOperation(value = "用户简单信息列表", response = UserInfoDTO.class)
    @ResponseBody
    @RequestMapping(value = "list", produces = "application/json; charset=UTF-8", method = {RequestMethod.GET, RequestMethod.POST})
    public JsonResult listC(Query query) {
        return memberService.list(query);
    }
}
