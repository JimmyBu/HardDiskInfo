package org.RAM.SpringBoot.Controller;

import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DecimalFormat;
import java.util.Map;

@Controller
public class RamController {

    @RequestMapping("/RAM")
    private static String memory(Map<String, Object> map) throws SigarException {
    Sigar sigar = new Sigar();
    Mem mem = sigar.getMem();
    // 内存总量
        System.out.println("内存总量:    " + mem.getTotal() / 1024L + "K av");
    // 当前内存使用量
        System.out.println("当前内存使用量:    " + mem.getUsed() / 1024L + "K used");
    // 当前内存剩余量
        System.out.println("当前内存剩余量:    " + mem.getFree() / 1024L + "K free");
    Swap swap = sigar.getSwap();
    // 交换区总量
        System.out.println("交换区总量:    " + swap.getTotal() / 1024L + "K av");
    // 当前交换区使用量
        System.out.println("当前交换区使用量:    " + swap.getUsed() / 1024L + "K used");
    // 当前交换区剩余量
        System.out.println("当前交换区剩余量:    " + swap.getFree() / 1024L + "K free");

        map.put("ram", mem.getTotal() / 1024L + "K InTotal\n");
        map.put("ram2", mem.getUsed() / 1024L + "K used\n");
        map.put("ram3",  mem.getFree() / 1024L + "K free\n");
        map.put("ram4",  swap.getTotal() / 1024L + "K InTotal\n");
        map.put("ram5",  swap.getUsed() / 1024L + "K used\n");
        map.put("ram6",  swap.getFree() / 1024L + "K free\n");
        map.put("ram7", DECIMALFORMAT.format(((double)mem.getUsed()/(double)mem.getTotal())*100)+"%");
        map.put("ram8", DECIMALFORMAT.format(((double)mem.getFree()/(double)mem.getTotal())*100)+"%");

        return "Ram";
    }
    private static DecimalFormat DECIMALFORMAT = new DecimalFormat("#.##");
}
