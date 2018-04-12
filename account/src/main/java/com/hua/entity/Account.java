/**
  * @filename Account.java
  * @description  
  * @version 1.0
  * @author qianye.zheng
 */
package com.hua.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hua.constant.AccountConstant;
import com.hua.encryption.DecryptionEntry;
import com.hua.encryption.EncryptionV001;
import com.hua.serializer.DateSerializer;
import com.hua.serializer.DateTimeSerializer;
import com.hua.util.StringUtil;

 /**
 * @type Account
 * @description  帐户
 * @author qianye.zheng
 */
@Entity(name = "t_account")
//@Table(name = "t_account")
public class Account {

	/* 是否显示所有帐户的密码，谨慎设置 */
	private transient Boolean showAll = false;
	
	@GenericGenerator(name = "idGenerator", strategy = "native")
	@GeneratedValue(generator = "idGenerator")
	@Column(name = "id", insertable = true, 
			updatable = false,
			nullable = false, unique = true)
	@Id
	/* 对象唯一id，使用自增长 */
	private Integer id;

	@Column(name = "status", insertable = true, 
			updatable = true,
			nullable = true, unique = false)
	/* 状态: 有效-1，无效-0 */
	private Integer status = AccountConstant.STATUS_VALID;
	
	/*  */
	private transient String statusName = "";
	
	@Column(name = "remark", insertable = true, 
			updatable = true, length = 1024, 
			nullable = true, unique = false)
	/* 备注 */
	private String remark = "";
	
	/* 短备注，限制10个字符 */
	private transient String shortRemark = "";
	
	@Column(name = "createDateTime", insertable = true, 
			updatable = false,
			nullable = true, unique = false)
	/* 创建时间 */
	private Date createDateTime;
	
	@Column(name = "updateDateTime", insertable = true, 
			updatable = true,
			nullable = true, unique = false)
	/* 更新时间 */
	private Date updateDateTime;
	
	@Column(name = "username", insertable = true, 
			updatable = false, length = 128, 
			nullable = true, unique = false)
	/* 用户名(登录帐号) */
	private String username;
	
	@Column(name = "password", insertable = true, 
			updatable = true, length = 128, 
			nullable = true, unique = false)
	/* 密码 */
	private String password;
	
	/* 输出显示的密码 */
	private transient String showPassword;

	@Column(name = "level", insertable = true, 
			updatable = true, length = 2, 
			nullable = true, unique = false)
	/* 级别 */
	private String level;
	
	/* 级别名称 */
	private transient String levelName;
	
	@Column(name = "type", insertable = true, 
			updatable = true, length = 2, 
			nullable = true, unique = false)
	/* 类型 */
	private String type;
	
	/* 类型名称 */
	private transient String typeName;
	
	@Column(name = "source", insertable = true, 
			updatable = true, length = 128, 
			nullable = true, unique = false)
	/* 来源 */
	private String source;
	
	@Column(name = "usage", insertable = true, 
			updatable = true, length = 256, 
			nullable = true, unique = false)
	/* 用途 */
	private String usage;
	
	@Column(name = "relationalAccounts", insertable = true, 
			updatable = true, length = 256, 
			nullable = true, unique = false)
	/* 关联帐号 */
	private String relationalAccounts;
	
	@Column(name = "expireDate", insertable = true, 
			updatable = true,
			nullable = true, unique = false)
	/* 有效期至 */
	private Date expireDate;
	
	@Column(name = "mobilePhone", insertable = true, 
			updatable = true, length = 32, 
			nullable = true, unique = false)
	/* 手机号码 */
	private String mobilePhone;
	
	@Column(name = "officialLink", insertable = true, 
			updatable = true, length = 1024, 
			nullable = true, unique = false)
	/* 官网 */
	private String officialLink;
	
	@Column(name = "loginLink", insertable = true, 
			updatable = true, length = 1024, 
			nullable = true, unique = false)
	/* 登录入口 */
	private String loginLink;
	
	@Column(name = "location", insertable = true, 
			updatable = true, length = 256, 
			nullable = true, unique = false)
	/* 位置信息 */
	private String location;
	
	/* 版本，不同版本使用的密钥不同 规格: 0.0.1 */
	//private String version;

	/**
	 * @return the username
	 */
	public final String getUsername()
	{
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public final void setUsername(String username)
	{
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public final String getPassword()
	{
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public final void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * @return the level
	 */
	public final String getLevel()
	{
		return level;
	}

	/**
	 * @param level the level to set
	 */
	public final void setLevel(String level)
	{
		this.level = level;
	}

	/**
	 * @return the type
	 */
	public final String getType()
	{
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public final void setType(String type)
	{
		this.type = type;
	}

	/**
	 * @return the source
	 */
	public final String getSource()
	{
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public final void setSource(String source)
	{
		this.source = source;
	}

	/**
	 * @return the usage
	 */
	public final String getUsage()
	{
		return usage;
	}

	/**
	 * @param usage the usage to set
	 */
	public final void setUsage(String usage)
	{
		this.usage = usage;
	}

	/**
	 * @return the relationalAccounts
	 */
	public final String getRelationalAccounts()
	{
		return relationalAccounts;
	}

	/**
	 * @param relationalAccounts the relationalAccounts to set
	 */
	public final void setRelationalAccounts(String relationalAccounts)
	{
		this.relationalAccounts = relationalAccounts;
	}

	/**
	 * @return the expireDate
	 */
	 @JsonSerialize(using = DateSerializer.class)
	public final Date getExpireDate()
	{
		return expireDate;
	}

	/**
	 * @param expireDate the expireDate to set
	 */
	public final void setExpireDate(Date expireDate)
	{
		this.expireDate = expireDate;
	}

	/**
	 * @return the mobilePhone
	 */
	public final String getMobilePhone()
	{
		return mobilePhone;
	}

	/**
	 * @param mobilePhone the mobilePhone to set
	 */
	public final void setMobilePhone(String mobilePhone)
	{
		this.mobilePhone = mobilePhone;
	}

	/**
	 * @return the officialLink
	 */
	public final String getOfficialLink()
	{
		return officialLink;
	}

	/**
	 * @param officialLink the officialLink to set
	 */
	public final void setOfficialLink(String officialLink)
	{
		this.officialLink = officialLink;
	}

	/**
	 * @return the loginLink
	 */
	public final String getLoginLink()
	{
		return loginLink;
	}

	/**
	 * @param loginLink the loginLink to set
	 */
	public final void setLoginLink(String loginLink)
	{
		this.loginLink = loginLink;
	}

	/**
	 * @return the location
	 */
	public final String getLocation()
	{
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public final void setLocation(String location)
	{
		this.location = location;
	}
	
	/**
	 * @return the id
	 */
	public final Integer getId()
	{
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public final void setId(Integer id)
	{
		this.id = id;
	}

	/**
	 * @return the status
	 */
	public final Integer getStatus()
	{
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public final void setStatus(Integer status)
	{
		this.status = status;
	}

	/**
	 * @return the remark
	 */
	public final String getRemark()
	{
		return remark;
	}

	/**
	 * @param remark the remark to set
	 */
	public final void setRemark(String remark)
	{
		this.remark = remark;
	}

	/**
	 * @return the createDateTime
	 */
	 @JsonSerialize(using = DateTimeSerializer.class)
	public final Date getCreateDateTime()
	{
		return createDateTime;
	}

	/**
	 * @param createDateTime the createDateTime to set
	 */
	public final void setCreateDateTime(Date createDateTime)
	{
		this.createDateTime = createDateTime;
	}

	/**
	 * @return the updateDateTime
	 */
	 @JsonSerialize(using = DateTimeSerializer.class)
	public final Date getUpdateDateTime()
	{
		return updateDateTime;
	}

	/**
	 * @param updateDateTime the updateDateTime to set
	 */
	public final void setUpdateDateTime(Date updateDateTime)
	{
		this.updateDateTime = updateDateTime;
	}

	/**
	 * @return the statusName
	 */
	public final String getStatusName()
	{
		if (status.equals(1))
		{
			statusName = "有效";
		} else
		{
			statusName = "无效";
		}
		
		return statusName;
	}

	/**
	 * @param statusName the statusName to set
	 */
	public final void setStatusName(String statusName)
	{
		this.statusName = statusName;
	}

	/**
	 * @return the shortRemark
	 */
	public final String getShortRemark()
	{
		if (StringUtil.isNotEmpty(remark))
		{
			if (remark.length() <= 10)
			{
				shortRemark = remark;
			} else
			{
				shortRemark = remark.substring(0, 10);
			}
		}

		return shortRemark;
	}

	/**
	 * @param shortRemark the shortRemark to set
	 */
	public final void setShortRemark(String shortRemark)
	{
		this.shortRemark = shortRemark;
	}

	/**
	 * @return the levelName
	 */
	public final String getLevelName()
	{
		switch (level)
		{
		case "1":
		{
			levelName = "普通";
			break;
		}
		case "2":
		{
			levelName = "加密";
			break;
		}
		case "3":
		{
			levelName = "绝密";
			break;
		}
		case "4":
		{
			
			break;
		}
		default:
		levelName = "";
		
		break;
		}
		return levelName;
	}

	/**
	 * @param levelName the levelName to set
	 */
	public final void setLevelName(String levelName)
	{
		this.levelName = levelName;
	}

	/**
	 * @return the typeName
	 */
	public final String getTypeName()
	{
		switch (type)
		{
		case "1":
		{
			typeName = "普通";
			break;
		}
		case "2":
		{
			typeName = "邮箱";
			break;
		}
		case "3":
		{
			typeName = "金融";
			break;
		}
		case "4":
		{
			typeName = "网络";
			break;
		}
		default:
			typeName = "";
		break;
		}
		return typeName;
	}

	/**
	 * @param typeName the typeName to set
	 */
	public final void setTypeName(String typeName)
	{
		this.typeName = typeName;
	}

	/**
	 * @return the showPassword
	 */
	public final String getShowPassword()
	{
		if ("3".equals(level) || "3".equals(type))
		{ // 绝密的或金融帐号 不输出密码
			showPassword = "******";
		} else
		{
			// 解密
			showPassword = DecryptionEntry.decryption(password, EncryptionV001.VERSION);
		}
		if (showAll)
		{
			showPassword = DecryptionEntry.decryption(password, EncryptionV001.VERSION);
		}
		
		return showPassword;
	}

	/**
	 * @param showPassword the showPassword to set
	 */
	public final void setShowPassword(String showPassword)
	{
		this.showPassword = showPassword;
	}	
	
	/**
	 * @description 
	 * @return
	 * @author qianye.zheng
	 */
	@Override
	public String toString()
	{
		return "[ID=" + id + ", username=" + username + ", pwd=" + getShowPassword() + "]";
	}
	
	
}
