
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 博客信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/boke")
public class BokeController {
    private static final Logger logger = LoggerFactory.getLogger(BokeController.class);

    @Autowired
    private BokeService bokeService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = bokeService.queryPage(params);

        //字典表数据转换
        List<BokeView> list =(List<BokeView>)page.getList();
        for(BokeView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BokeEntity boke = bokeService.selectById(id);
        if(boke !=null){
            //entity转view
            BokeView view = new BokeView();
            BeanUtils.copyProperties( boke , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(boke.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody BokeEntity boke, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,boke:{}",this.getClass().getName(),boke.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            boke.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<BokeEntity> queryWrapper = new EntityWrapper<BokeEntity>()
            .eq("boke_name", boke.getBokeName())
            .eq("boke_types", boke.getBokeTypes())
            .eq("boke_video", boke.getBokeVideo())
            .eq("boke_music", boke.getBokeMusic())
            .eq("zan_number", boke.getZanNumber())
            .eq("cai_number", boke.getCaiNumber())
            .eq("yonghu_id", boke.getYonghuId())
            .eq("boke_neirong_types", boke.getBokeNeirongTypes())
            .eq("boke_yesno_types", boke.getBokeYesnoTypes())
            .eq("boke_yesno_text", boke.getBokeYesnoText())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BokeEntity bokeEntity = bokeService.selectOne(queryWrapper);
        if(bokeEntity==null){
            boke.setBokeYesnoTypes(1);
            boke.setInsertTime(new Date());
            boke.setCreateTime(new Date());
            bokeService.insert(boke);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody BokeEntity boke, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,boke:{}",this.getClass().getName(),boke.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            boke.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<BokeEntity> queryWrapper = new EntityWrapper<BokeEntity>()
            .notIn("id",boke.getId())
            .andNew()
            .eq("boke_name", boke.getBokeName())
            .eq("boke_types", boke.getBokeTypes())
            .eq("boke_video", boke.getBokeVideo())
            .eq("boke_music", boke.getBokeMusic())
            .eq("zan_number", boke.getZanNumber())
            .eq("cai_number", boke.getCaiNumber())
            .eq("yonghu_id", boke.getYonghuId())
            .eq("boke_neirong_types", boke.getBokeNeirongTypes())
            .eq("boke_yesno_types", boke.getBokeYesnoTypes())
            .eq("boke_yesno_text", boke.getBokeYesnoText())
            .eq("insert_time", boke.getInsertTime())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BokeEntity bokeEntity = bokeService.selectOne(queryWrapper);
        if("".equals(boke.getBokePhoto()) || "null".equals(boke.getBokePhoto())){
                boke.setBokePhoto(null);
        }
        if("".equals(boke.getBokeVideo()) || "null".equals(boke.getBokeVideo())){
                boke.setBokeVideo(null);
        }
        if("".equals(boke.getBokeFile()) || "null".equals(boke.getBokeFile())){
                boke.setBokeFile(null);
        }
        if(bokeEntity==null){
            bokeService.updateById(boke);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        bokeService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<BokeEntity> bokeList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            BokeEntity bokeEntity = new BokeEntity();
//                            bokeEntity.setBokeName(data.get(0));                    //博客名称 要改的
//                            bokeEntity.setBokeTypes(Integer.valueOf(data.get(0)));   //博客类型 要改的
//                            bokeEntity.setBokePhoto("");//详情和图片
//                            bokeEntity.setBokeVideo(data.get(0));                    //视频 要改的
//                            bokeEntity.setBokeFile(data.get(0));                    //文件 要改的
//                            bokeEntity.setBokeMusic(data.get(0));                    //音乐 要改的
//                            bokeEntity.setZanNumber(Integer.valueOf(data.get(0)));   //赞 要改的
//                            bokeEntity.setCaiNumber(Integer.valueOf(data.get(0)));   //踩 要改的
//                            bokeEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            bokeEntity.setBokeNeirongTypes(Integer.valueOf(data.get(0)));   //博客内容 要改的
//                            bokeEntity.setBokeContent("");//详情和图片
//                            bokeEntity.setBokeYesnoTypes(Integer.valueOf(data.get(0)));   //博客审核 要改的
//                            bokeEntity.setBokeYesnoText(data.get(0));                    //审核结果 要改的
//                            bokeEntity.setInsertTime(date);//时间
//                            bokeEntity.setCreateTime(date);//时间
                            bokeList.add(bokeEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        bokeService.insertBatch(bokeList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = bokeService.queryPage(params);

        //字典表数据转换
        List<BokeView> list =(List<BokeView>)page.getList();
        for(BokeView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        BokeEntity boke = bokeService.selectById(id);
            if(boke !=null){


                //entity转view
                BokeView view = new BokeView();
                BeanUtils.copyProperties( boke , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(boke.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody BokeEntity boke, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,boke:{}",this.getClass().getName(),boke.toString());
        Wrapper<BokeEntity> queryWrapper = new EntityWrapper<BokeEntity>()
            .eq("boke_name", boke.getBokeName())
            .eq("boke_types", boke.getBokeTypes())
            .eq("boke_video", boke.getBokeVideo())
            .eq("boke_music", boke.getBokeMusic())
            .eq("zan_number", boke.getZanNumber())
            .eq("cai_number", boke.getCaiNumber())
            .eq("yonghu_id", boke.getYonghuId())
            .eq("boke_neirong_types", boke.getBokeNeirongTypes())
            .eq("boke_yesno_types", boke.getBokeYesnoTypes())
            .eq("boke_yesno_text", boke.getBokeYesnoText())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        BokeEntity bokeEntity = bokeService.selectOne(queryWrapper);
        if(bokeEntity==null){
            boke.setBokeYesnoTypes(1);
            boke.setInsertTime(new Date());
            boke.setCreateTime(new Date());
        bokeService.insert(boke);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
