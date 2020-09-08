package com.medsys.nis.common.util; /**
 * Created by Super on 2020/8/20.
 */

import java.util.UUID;

/**
 * @description:
 * @author: ZhouW
 * @time: 2020/8/20 15:23
 */
public class UUIDUtils {
    public static String getUUID32(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
