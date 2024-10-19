package com.entity.model;

import com.entity.BokeEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 博客信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class BokeModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 博客名称
     */
    private String bokeName;


    /**
     * 博客类型
     */
    private Integer bokeTypes;


    /**
     * 博客图片
     */
    private String bokePhoto;


    /**
     * 视频
     */
    private String bokeVideo;


    /**
     * 文件
     */
    private String bokeFile;


    /**
     * 音乐
     */
    private String bokeMusic;


    /**
     * 赞
     */
    private Integer zanNumber;


    /**
     * 踩
     */
    private Integer caiNumber;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 博客内容
     */
    private Integer bokeNeirongTypes;


    /**
     * 博客详情
     */
    private String bokeContent;


    /**
     * 博客审核
     */
    private Integer bokeYesnoTypes;


    /**
     * 审核结果
     */
    private String bokeYesnoText;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：博客名称
	 */
    public String getBokeName() {
        return bokeName;
    }


    /**
	 * 设置：博客名称
	 */
    public void setBokeName(String bokeName) {
        this.bokeName = bokeName;
    }
    /**
	 * 获取：博客类型
	 */
    public Integer getBokeTypes() {
        return bokeTypes;
    }


    /**
	 * 设置：博客类型
	 */
    public void setBokeTypes(Integer bokeTypes) {
        this.bokeTypes = bokeTypes;
    }
    /**
	 * 获取：博客图片
	 */
    public String getBokePhoto() {
        return bokePhoto;
    }


    /**
	 * 设置：博客图片
	 */
    public void setBokePhoto(String bokePhoto) {
        this.bokePhoto = bokePhoto;
    }
    /**
	 * 获取：视频
	 */
    public String getBokeVideo() {
        return bokeVideo;
    }


    /**
	 * 设置：视频
	 */
    public void setBokeVideo(String bokeVideo) {
        this.bokeVideo = bokeVideo;
    }
    /**
	 * 获取：文件
	 */
    public String getBokeFile() {
        return bokeFile;
    }


    /**
	 * 设置：文件
	 */
    public void setBokeFile(String bokeFile) {
        this.bokeFile = bokeFile;
    }
    /**
	 * 获取：音乐
	 */
    public String getBokeMusic() {
        return bokeMusic;
    }


    /**
	 * 设置：音乐
	 */
    public void setBokeMusic(String bokeMusic) {
        this.bokeMusic = bokeMusic;
    }
    /**
	 * 获取：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }


    /**
	 * 设置：赞
	 */
    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 获取：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }


    /**
	 * 设置：踩
	 */
    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：博客内容
	 */
    public Integer getBokeNeirongTypes() {
        return bokeNeirongTypes;
    }


    /**
	 * 设置：博客内容
	 */
    public void setBokeNeirongTypes(Integer bokeNeirongTypes) {
        this.bokeNeirongTypes = bokeNeirongTypes;
    }
    /**
	 * 获取：博客详情
	 */
    public String getBokeContent() {
        return bokeContent;
    }


    /**
	 * 设置：博客详情
	 */
    public void setBokeContent(String bokeContent) {
        this.bokeContent = bokeContent;
    }
    /**
	 * 获取：博客审核
	 */
    public Integer getBokeYesnoTypes() {
        return bokeYesnoTypes;
    }


    /**
	 * 设置：博客审核
	 */
    public void setBokeYesnoTypes(Integer bokeYesnoTypes) {
        this.bokeYesnoTypes = bokeYesnoTypes;
    }
    /**
	 * 获取：审核结果
	 */
    public String getBokeYesnoText() {
        return bokeYesnoText;
    }


    /**
	 * 设置：审核结果
	 */
    public void setBokeYesnoText(String bokeYesnoText) {
        this.bokeYesnoText = bokeYesnoText;
    }
    /**
	 * 获取：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：发布时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
