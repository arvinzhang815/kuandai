package demo.dao;

import demo.dto.Information;
import java.util.List;

/**
 * @author Created by: zhangbingbing
 * @date 2018/8/3
 **/
public interface KuandaiMapper {
    int insert(Information infor);
    int update(Information infor);
    int delete(Information infor);
    List<Information> queryInfor(Information infor);
    Information getInforById(String id);
    long countInfor(Information information);

}
