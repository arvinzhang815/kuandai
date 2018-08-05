package demo.controller;

import demo.dto.Information;
import demo.service.KuandaiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by: zhangbingbing
 * @date 2018/7/5
 **/
@Controller
public class KuandaiController {

    @Autowired
    private KuandaiService service;

    @RequestMapping(value="/queryByInfo")
    public String getByName(@RequestBody Information infomation,
                            Model model){
        List<Information> list = new ArrayList<Information>();
        try {
            list = service.queryByInfo(infomation);
        }catch (Exception e){
            e.printStackTrace();
        }
        // 分页信息
        model.addAttribute("response", list);
        return "index";
    }
    @RequestMapping(value="/home/page")
    public ModelAndView goHome(){
        System.out.println("go to the home page!");
        ModelAndView mode = new ModelAndView();
        mode.addObject("name", "zhangsan");
        mode.setViewName("index");
        return mode;
    }

    @RequestMapping(value="/home")
    public String home(@RequestParam(value = "path",required = false) String path,
                       Model model){

        System.out.println("redirect to home page!");
        return "index";
    }
    @RequestMapping("/insert")
    public String insert(@RequestParam(value = "name",required = false) String name,
                         @RequestParam(value = "telphone",required = false) String telphone,
                         @RequestParam(value = "kuandaiNo",required = false) String kuandaiNo,
                         @RequestParam(value = "address",required = false) String address,
                         @RequestParam(value = "KDAddr",required = false) String KDAddr,
                         @RequestParam(value = "begainDate",required = false) String begainDate,
                         @RequestParam(value = "endDate",required = false) String endDate,
                         @RequestParam(value = "remark",required = false) String remark,
                         Model model){
        String result = "";
        Information infor = new Information();
        infor.setName(name);
        infor.setTelphone(telphone);
        infor.setAddress(address);
        infor.setKDAddr(KDAddr);
        infor.setBegainDate(begainDate);
        infor.setEndDate(endDate);
        infor.setRemark(remark);
        try {
            service.insert(infor);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
    @RequestMapping("/update")
    public String update(@RequestParam(value = "name",required = false) String name,
                         @RequestParam(value = "telphone",required = false) String telphone,
                         @RequestParam(value = "kuandaiNo",required = false) String kuandaiNo,
                         @RequestParam(value = "address",required = false) String address,
                         @RequestParam(value = "KDAddr",required = false) String KDAddr,
                         @RequestParam(value = "begainDate",required = false) String begainDate,
                         @RequestParam(value = "endDate",required = false) String endDate,
                         @RequestParam(value = "remark",required = false) String remark,
                         Model model){
        String result = "";
        Information infor = new Information();
        infor.setName(name);
        infor.setTelphone(telphone);
        infor.setAddress(address);
        infor.setKDAddr(KDAddr);
        infor.setBegainDate(begainDate);
        infor.setEndDate(endDate);
        infor.setRemark(remark);
        try {
            service.update(infor);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "name",required = false) String name,
                         @RequestParam(value = "telphone",required = false) String telphone,
                         @RequestParam(value = "kuandaiNo",required = false) String kuandaiNo,
                         @RequestParam(value = "address",required = false) String address,
                         @RequestParam(value = "KDAddr",required = false) String KDAddr,
                         @RequestParam(value = "begainDate",required = false) String begainDate,
                         @RequestParam(value = "endDate",required = false) String endDate,
                         @RequestParam(value = "remark",required = false) String remark,
                         Model model){
        String result = "";
        Information infor = new Information();
        infor.setName(name);
        infor.setTelphone(telphone);
        try {
            service.delete(infor);
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }

}
