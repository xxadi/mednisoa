package com.medsys.nis.maintain.bean; /**
 * Created by Super on 2020/9/7.
 */

import lombok.Data;

import java.util.Date;

/**
 * @description: 组管理
 * @author: ZhouW
 * @time: 2020/9/7 22:01
 */
@Data
public class GroupManager {
    //组号
    private String groupId;
    //组名称
    private String groupGname;
    //组员姓名
    private String groupName;
    //组员编码
    private String groupNameCpde;
    //创建时间
    private Date createTime;
    //是否可用
    private String activity;
}
