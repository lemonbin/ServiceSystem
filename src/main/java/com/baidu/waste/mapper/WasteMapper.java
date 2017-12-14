package com.baidu.waste.mapper;

import com.baidu.waste.domain.Waste;

import java.util.List;

/**
 * Created by dllo on 17/12/14.
 */
public interface WasteMapper {
    List<Waste> findAll();

    void delById(int i1);

    void addWaste(Waste waste);
}
