package com.baidu.waste.service;

import com.baidu.waste.domain.Waste;
import com.github.pagehelper.PageInfo;

/**
 * Created by dllo on 17/12/14.
 */
public interface WasteService {
    PageInfo<Waste> queryPage(Integer pageNum, Integer pageSize);

    boolean datadel(String del);

    void delById(Integer id);

    void addWaste(Waste waste);
}
