package service;

import com.github.pagehelper.PageInfo;
import pojo.Real_estate;
import pojo.Real_estateExample;

import java.util.List;

/**
 * @author shkstart
 * @create 2020-11-20 15:01
 */
public interface Real_estateService {
    List<Real_estate> selectByExample(Real_estateExample example);

    PageInfo<Real_estate> selectReal(Real_estateExample example,Integer pageNum,Integer PageSize);
}
