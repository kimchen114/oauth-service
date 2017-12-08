package com.example.oauth2.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.oauth2.domain.SysUser;
import com.example.oauth2.domain.SysUserCriteria;
import com.example.oauth2.mapper.SysUserMapper;

@Service
public class SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;
	
	
	
	public SysUser getByUsername(String username){
		SysUserCriteria example = new SysUserCriteria();
		example.createCriteria().andUsernameEqualTo(username).andStatusEqualTo(0);
		List<SysUser> list=sysUserMapper.selectByExample(example);
		return list.get(0);
	}
	
	public SysUser getById(Integer userId){
		return sysUserMapper.selectByPrimaryKey(userId);
	}
	
	
	public int update(SysUser sysUser){
		return sysUserMapper.updateByPrimaryKeySelective(sysUser);
	}
	
	
	
	
	
}
