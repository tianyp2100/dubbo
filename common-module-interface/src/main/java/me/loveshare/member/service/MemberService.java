package me.loveshare.member.service;

import me.loveshare.bo.common.JsonResult;
import me.loveshare.vo.common.Query;

/**
 * Created by Tony on 2017/8/25.
 */
public interface MemberService {

    /**
     * 获取列表
     */

    JsonResult list(Query query);
}
