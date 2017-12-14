package com.baidu.waste.controller;

import com.baidu.base.utils.AjaxResult;
import com.baidu.waste.domain.Waste;
import com.baidu.waste.service.WasteService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;


/**
 * Created by dllo on 17/12/14.
 */
@Controller
@RequestMapping("/waste")
public class WasteController {

    @Resource
    private WasteService wasteService;


    @RequestMapping("/article-add")
    public String article_add() {
        return "article/article-add";
    }

    @RequestMapping("/article-list")
    public String article_list() {
        return "article/article-list";
    }
    /**
     * 分页+普通查询
     */
    @ResponseBody
    @RequestMapping("/findWasteAll")
    public PageInfo<Waste> pageAll(@RequestParam("pageNum") Integer pageNum, @RequestParam("pageSize") Integer pageSize) {
        PageInfo<Waste> pageInfo = wasteService.queryPage(pageNum, pageSize);
        return pageInfo;
    }

    /**
     * 批量删除
     */
    @ResponseBody
    @RequestMapping("/deleteWastes")
    public boolean del(@RequestParam("del") String del) {
        return wasteService.datadel(del);
    }

    @ResponseBody
    @RequestMapping("/addWaste")
    public void del(Waste waste) {
        waste.setColtime(new Timestamp(new Date().getTime()));
        waste.setClassstatus(1);
        waste.setOrderstatus(1);
        wasteService.addWaste(waste);
    }

    /**
     * 删除用户
     */
    @ResponseBody
    @RequestMapping("/deleteWaste")
    public AjaxResult deleteUser(Integer id) {
        AjaxResult ajaxResult = new AjaxResult();
        wasteService.delById(id);
        return ajaxResult;
    }
}
