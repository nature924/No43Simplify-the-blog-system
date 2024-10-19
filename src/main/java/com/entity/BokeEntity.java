package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 博客信息
 *
 * @author 
 * @email
 */
@TableName("boke")
public class BokeEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public BokeEntity() {

	}

	public BokeEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 博客名称
     */
    @TableField(value = "boke_name")

    private String bokeName;


    /**
     * 博客类型
     */
    @TableField(value = "boke_types")

    private Integer bokeTypes;


    /**
     * 博客图片
     */
    @TableField(value = "boke_photo")

    private String bokePhoto;


    /**
     * 视频
     */
    @TableField(value = "boke_video")

    private String bokeVideo;


    /**
     * 文件
     */
    @TableField(value = "boke_file")

    private String bokeFile;


    /**
     * 音乐
     */
    @TableField(value = "boke_music")

    private String bokeMusic;


    /**
     * 赞
     */
    @TableField(value = "zan_number")

    private Integer zanNumber;


    /**
     * 踩
     */
    @TableField(value = "cai_number")

    private Integer caiNumber;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 博客内容
     */
    @TableField(value = "boke_neirong_types")

    private Integer bokeNeirongTypes;


    /**
     * 博客详情
     */
    @TableField(value = "boke_content")

    private String bokeContent;


    /**
     * 博客审核
     */
    @TableField(value = "boke_yesno_types")

    private Integer bokeYesnoTypes;


    /**
     * 审核结果
     */
    @TableField(value = "boke_yesno_text")

    private String bokeYesnoText;


    /**
     * 发布时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：博客名称
	 */
    public String getBokeName() {
        return bokeName;
    }
    /**
	 * 获取：博客名称
	 */

    public void setBokeName(String bokeName) {
        this.bokeName = bokeName;
    }
    /**
	 * 设置：博客类型
	 */
    public Integer getBokeTypes() {
        return bokeTypes;
    }
    /**
	 * 获取：博客类型
	 */

    public void setBokeTypes(Integer bokeTypes) {
        this.bokeTypes = bokeTypes;
    }
    /**
	 * 设置：博客图片
	 */
    public String getBokePhoto() {
        return bokePhoto;
    }
    /**
	 * 获取：博客图片
	 */

    public void setBokePhoto(String bokePhoto) {
        this.bokePhoto = bokePhoto;
    }
    /**
	 * 设置：视频
	 */
    public String getBokeVideo() {
        return bokeVideo;
    }
    /**
	 * 获取：视频
	 */

    public void setBokeVideo(String bokeVideo) {
        this.bokeVideo = bokeVideo;
    }
    /**
	 * 设置：文件
	 */
    public String getBokeFile() {
        return bokeFile;
    }
    /**
	 * 获取：文件
	 */

    public void setBokeFile(String bokeFile) {
        this.bokeFile = bokeFile;
    }
    /**
	 * 设置：音乐
	 */
    public String getBokeMusic() {
        return bokeMusic;
    }
    /**
	 * 获取：音乐
	 */

    public void setBokeMusic(String bokeMusic) {
        this.bokeMusic = bokeMusic;
    }
    /**
	 * 设置：赞
	 */
    public Integer getZanNumber() {
        return zanNumber;
    }
    /**
	 * 获取：赞
	 */

    public void setZanNumber(Integer zanNumber) {
        this.zanNumber = zanNumber;
    }
    /**
	 * 设置：踩
	 */
    public Integer getCaiNumber() {
        return caiNumber;
    }
    /**
	 * 获取：踩
	 */

    public void setCaiNumber(Integer caiNumber) {
        this.caiNumber = caiNumber;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }
    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：博客内容
	 */
    public Integer getBokeNeirongTypes() {
        return bokeNeirongTypes;
    }
    /**
	 * 获取：博客内容
	 */

    public void setBokeNeirongTypes(Integer bokeNeirongTypes) {
        this.bokeNeirongTypes = bokeNeirongTypes;
    }
    /**
	 * 设置：博客详情
	 */
    public String getBokeContent() {
        return bokeContent;
    }
    /**
	 * 获取：博客详情
	 */

    public void setBokeContent(String bokeContent) {
        this.bokeContent = bokeContent;
    }
    /**
	 * 设置：博客审核
	 */
    public Integer getBokeYesnoTypes() {
        return bokeYesnoTypes;
    }
    /**
	 * 获取：博客审核
	 */

    public void setBokeYesnoTypes(Integer bokeYesnoTypes) {
        this.bokeYesnoTypes = bokeYesnoTypes;
    }
    /**
	 * 设置：审核结果
	 */
    public String getBokeYesnoText() {
        return bokeYesnoText;
    }
    /**
	 * 获取：审核结果
	 */

    public void setBokeYesnoText(String bokeYesnoText) {
        this.bokeYesnoText = bokeYesnoText;
    }
    /**
	 * 设置：发布时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：发布时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Boke{" +
            "id=" + id +
            ", bokeName=" + bokeName +
            ", bokeTypes=" + bokeTypes +
            ", bokePhoto=" + bokePhoto +
            ", bokeVideo=" + bokeVideo +
            ", bokeFile=" + bokeFile +
            ", bokeMusic=" + bokeMusic +
            ", zanNumber=" + zanNumber +
            ", caiNumber=" + caiNumber +
            ", yonghuId=" + yonghuId +
            ", bokeNeirongTypes=" + bokeNeirongTypes +
            ", bokeContent=" + bokeContent +
            ", bokeYesnoTypes=" + bokeYesnoTypes +
            ", bokeYesnoText=" + bokeYesnoText +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
