package com.medsys.nis.maintain.bean; /**
 * Created by Super on 2020/9/7.
 */

import lombok.Data;

import java.util.Date;

/**
 * @description: 通知详情表
 * @author: ZhouW
 * @time: 2020/9/7 22:15
 */
@Data
public class NoteList {
    //通知id
    private String noId;
    //通知标题
    private String noTitle;
    //发布时间
    private Date noTime;
    //创建时间
    private Date operTime;
    //通知状态
    private String noState;
}
