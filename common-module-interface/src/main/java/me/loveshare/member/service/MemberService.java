package me.loveshare.member.service;

import java.util.List;

/**
 * Created by Tony on 2017/8/25.
 */
public class MemberService {

    /**
     * 批量新建
     *
     * @param records 批量新建数据
     * @return 按“records”参数数据的顺序返回插入数据库主键
     */
    List<Integer> saveBatch(List<UserInfo> records);
}
