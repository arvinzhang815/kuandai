package demo.service.impl;

import demo.Util.ExcelUtils;
import demo.dao.KuandaiMapper;
import demo.dto.Information;
import demo.service.KuandaiService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by: zhangbingbing
 * @date 2018/7/5
 **/
@Service
public class KuandaiServiceImpl implements KuandaiService {

    @Autowired
    public KuandaiMapper mapper;

    @Override
    public List<Information> queryByInfo(Information information) throws Exception {
        return mapper.queryInfor(information);
    }

    @Override
    public Information getInforById(String id) throws Exception {
        return mapper.getInforById(id);
    }

    @Override
    public String insert(Information infor) throws Exception {
        String result = "fail";
        int count = mapper.insert(infor);
        if(count == 1){
            result = "success!";
        }
        return result;
    }

    @Override
    public String update(Information infor) throws Exception {
        String result = "fail";
        int count = mapper.update(infor);
        if(count == 1){
            result = "success!";
        }
        return result;
    }

    @Override
    public String delete(Information infor) throws Exception {
        String result = "fail";
        int count = mapper.delete(infor);
        if(count == 1){
            result = "success!";
        }
        return result;
    }


}
