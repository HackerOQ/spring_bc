/*
package com.muishao.common.base;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sunyard.common.dto.PagingDTO;
import com.sunyard.common.param.PagingParam;

import java.util.List;

*/
/**
 * @author Efy Shu
 * @ClassName BaseService
 * @Description Service基础类
 * @date 2017年11月17日 上午11:21:00
 *//*

public class BaseService {
    */
/**
     * 分页参数前置处理逻辑
     *
     * @param param
     * @param <T>
     *//*

    public <T extends PagingParam> void prePageParam(T param) {
        PageHelper.startPage(param.getPage(), param.getRows());
        if (param.getSord() != null && !"".equals(param.getSord())) {
            PageHelper.orderBy(param.getSidx() + " " + param.getSord());
        }
    }

    */
/**
     * 导出-分页参数前置处理逻辑
     *
     * @param param
     * @param <T>
     *//*

    public <T extends PagingParam> void exportPrePageParam(T param) {
        PageHelper.startPage(1, Integer.MAX_VALUE - 1);
        if (param.getSord() != null && !"".equals(param.getSord())) {
            PageHelper.orderBy(param.getSidx() + " " + param.getSord());
        }
    }

    */
/**
     * 分页结果前置处理逻辑
     *
     * @param result
     * @param <T>
     * @return
     *//*

    public <T> PagingDTO<T> prePageResult(List<T> result) {
        Page<T> page = (Page<T>) result;
        PagingDTO<T> pagingDTO = new PagingDTO<>();
        pagingDTO.setPage(page.getPageNum());
        pagingDTO.setTotal(page.getPages());
        pagingDTO.setRecords(page.getTotal());
        pagingDTO.setRows(page.getResult());
        return pagingDTO;
    }
}
*/
