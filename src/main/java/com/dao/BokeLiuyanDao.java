package com.dao;

import com.entity.BokeLiuyanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.BokeLiuyanView;

/**
 * 博客评论 Dao 接口
 *
 * @author 
 */
public interface BokeLiuyanDao extends BaseMapper<BokeLiuyanEntity> {

   List<BokeLiuyanView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
