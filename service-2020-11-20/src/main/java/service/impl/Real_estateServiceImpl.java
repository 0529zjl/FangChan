package service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kgc.dao.Real_estateMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Real_estate;
import pojo.Real_estateExample;
import service.Real_estateService;

import java.util.Date;
import java.util.List;

/**
 * @author shkstart
 * @create 2020-11-20 15:01
 */
@Service
public class Real_estateServiceImpl implements Real_estateService {
    @Autowired
    Real_estateMapper real_estateMapper;

    @Override
    public List<Real_estate> selectByExample(Real_estateExample example) {
        return real_estateMapper.selectByExample(example);
    }

    @Override
    public PageInfo<Real_estate> selectReal(Real_estateExample example, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        PageHelper.orderBy("buildTime");
        List<Real_estate> real_estates = real_estateMapper.selectByExample(example);
        for (Real_estate real_estate : real_estates) {
            Date date=real_estate.getBuildtime();
            java.sql.Date date1=new java.sql.Date(date.getTime());
            real_estate.setBuildtime(date1);
        }
        PageInfo<Real_estate> pageInfo = new PageInfo<>(real_estates);
        return pageInfo;
    }
}
