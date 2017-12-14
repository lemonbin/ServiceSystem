package com.baidu.waste.service.impl;

import com.baidu.waste.domain.Waste;
import com.baidu.waste.mapper.WasteMapper;
import com.baidu.waste.service.WasteService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dllo on 17/12/14.
 */
@Service
public class WasteServiceImpl implements WasteService{

    @Resource
    private WasteMapper wasteMapper;
    @Override
    public PageInfo<Waste> queryPage(Integer pageNum, Integer pageSize) {
        pageNum = pageNum == null ? 1 :pageNum;
        pageSize = pageSize == null ? 3 :pageSize;
        PageHelper.startPage(pageNum,pageSize);
        List<Waste> users = wasteMapper.findAll();
        PageInfo<Waste> pageInfo = new PageInfo<Waste>(users);
        return pageInfo;
    }

    @Override
    public boolean datadel(String del) {
        String[] split = del.split(",");
        try {
            for (int i = 0; i < split.length; i++) {
                int i1 = Integer.parseInt(split[i]);
                wasteMapper.delById(i1);
            }
        } catch (Exception e) {
            return false;
        }

        return true;
    }

    @Override
    public void delById(Integer id) {
        wasteMapper.delById(id);
    }

    @Override
    public void addWaste(Waste waste) {
        wasteMapper.addWaste(waste);
    }
}
