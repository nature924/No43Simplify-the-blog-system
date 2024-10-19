package com.entity.view;

import com.entity.BokeEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 博客信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("boke")
public class BokeView extends BokeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 博客类型的值
		*/
		private String bokeValue;
		/**
		* 博客内容的值
		*/
		private String bokeNeirongValue;
		/**
		* 博客审核的值
		*/
		private String bokeYesnoValue;



		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 联系方式
			*/
			private String yonghuPhone;
			/**
			* 身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public BokeView() {

	}

	public BokeView(BokeEntity bokeEntity) {
		try {
			BeanUtils.copyProperties(this, bokeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 博客类型的值
			*/
			public String getBokeValue() {
				return bokeValue;
			}
			/**
			* 设置： 博客类型的值
			*/
			public void setBokeValue(String bokeValue) {
				this.bokeValue = bokeValue;
			}
			/**
			* 获取： 博客内容的值
			*/
			public String getBokeNeirongValue() {
				return bokeNeirongValue;
			}
			/**
			* 设置： 博客内容的值
			*/
			public void setBokeNeirongValue(String bokeNeirongValue) {
				this.bokeNeirongValue = bokeNeirongValue;
			}
			/**
			* 获取： 博客审核的值
			*/
			public String getBokeYesnoValue() {
				return bokeYesnoValue;
			}
			/**
			* 设置： 博客审核的值
			*/
			public void setBokeYesnoValue(String bokeYesnoValue) {
				this.bokeYesnoValue = bokeYesnoValue;
			}
















				//级联表的get和set yonghu

					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 联系方式
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}

					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}


}
