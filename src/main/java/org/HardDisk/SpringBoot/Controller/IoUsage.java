package org.HardDisk.SpringBoot.Controller;

import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.System.out;


@Controller
public class IoUsage {
    @ResponseBody
    @RequestMapping("/hd")

    public class AcquireDiskIO {
        public String CMD = "iostat -d -x 1 2";
        public JSONArray getDiskIORate(String info) {
            String diskName = null;
            double rkb = 0.0;
            double wkb = 0.0;
            JSONObject json = new JSONObject();
            JSONArray jsonArray = new JSONArray();
            String[] data = info.split("\n");
            for (int i = 7; i < data.length; i++) {
                String[] numdata = data[i].split(" +");
                diskName = numdata[0];//磁盘名称
                rkb = Double.parseDouble(numdata[5]);//磁盘读数据速率
                wkb = Double.parseDouble(numdata[6]);//磁盘写数据速率
                json.put("diskName", diskName);
                json.put("rkb", rkb);
                json.put("wkb", wkb);
                jsonArray.add(json);
            }
            return jsonArray;//返回json数组
        }

    }

}
