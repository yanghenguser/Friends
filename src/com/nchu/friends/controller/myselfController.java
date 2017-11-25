package com.nchu.friends.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nchu.friends.mapper.HomenoteMapper;
import com.nchu.friends.mapper.MsgreplyMapper;
import com.nchu.friends.mapper.UserinfoMapper;
import com.nchu.friends.mapper.UsermsgMapper;
import com.nchu.friends.my.po.MyUserMsg;
import com.nchu.friends.my.po.status;
import com.nchu.friends.po.Homenote;
import com.nchu.friends.po.HomenoteExample;
import com.nchu.friends.po.Msgreply;
import com.nchu.friends.po.MsgreplyExample;
import com.nchu.friends.po.Userinfo;
import com.nchu.friends.po.UserinfoExample;
import com.nchu.friends.po.Usermsg;
import com.nchu.friends.po.UsermsgExample;
import com.nchu.friends.utility.Encrypt;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.xml.internal.bind.v2.runtime.reflect.TransducedAccessor;


@Controller
public class myselfController {
	
	@Autowired
	UserinfoMapper userinfoMapper;
	
	@Autowired
	HomenoteMapper homenoteMapper;
	
	@Autowired
	UsermsgMapper usermsgMapper;

	@Autowired
	MsgreplyMapper msgreplyMapper ;
	
	@RequestMapping("/myself")
	public String myself()
	{
		
		return "myself" ;
	}	
		
	
	/*基本信息*/
	@RequestMapping("/baseinfo")
	@ResponseBody
	public List<Userinfo> baseinfo(String name){
		UserinfoExample userinfoExample = new UserinfoExample() ;
		UserinfoExample.Criteria criteria=userinfoExample.createCriteria();
		criteria.andUsernameEqualTo(name);
		List<Userinfo> userinfo = userinfoMapper.selectByExample(userinfoExample) ;
		

		
		return userinfo ;
		
	}
	
	/*发表的帖子*/
	@RequestMapping("/mymsg")
	@ResponseBody
	public List<Usermsg> mymsg(String name){
		UserinfoExample userinfoExample = new UserinfoExample() ;
		UserinfoExample.Criteria userCriteria=userinfoExample.createCriteria();
		userCriteria.andUsernameEqualTo(name);
		List<Userinfo> userinfo = userinfoMapper.selectByExample(userinfoExample) ;
		
		Integer id = userinfo.get(0).getUserid();
		
		UsermsgExample usermsgExample = new UsermsgExample() ;
		UsermsgExample.Criteria msgCriteria = usermsgExample.createCriteria();
		msgCriteria.andUseridEqualTo(id) ;
		List<Usermsg> usermsgs = usermsgMapper.selectByExampleWithBLOBs(usermsgExample);
		
		
		
		return usermsgs ;
		
	}
	
	
	/*评论过的帖子*/
	@RequestMapping("/commentedmsg")
	@ResponseBody
	public List<Usermsg> commentedmsg(String name){
		UserinfoExample userinfoExample = new UserinfoExample() ;
		UserinfoExample.Criteria userCriteria=userinfoExample.createCriteria();
		userCriteria.andUsernameEqualTo(name);
		List<Userinfo> userinfo = userinfoMapper.selectByExample(userinfoExample) ;
		
		Integer userid = userinfo.get(0).getUserid();
		
		MsgreplyExample msgreplyExample = new MsgreplyExample() ;
		MsgreplyExample.Criteria msgreplyCriteria=msgreplyExample.createCriteria();
		msgreplyCriteria.andUseridEqualTo(userid);
		List<Msgreply> msgreplys = msgreplyMapper.selectByExampleWithBLOBs(msgreplyExample);
		
		List<Usermsg> usermsgs = new LinkedList<>() ;
		for(int i =0 ;i<msgreplys.size();i++)
		{
			int msgid = msgreplys.get(i).getMsgid() ;
			UsermsgExample usermsgExample = new UsermsgExample() ;
			UsermsgExample.Criteria msgCriteria = usermsgExample.createCriteria();
			msgCriteria.andUseridEqualTo(userid) ;
			Usermsg usermsg = usermsgMapper.selectByPrimaryKey(msgid) ;
			
			usermsgs.add(usermsg) ;
		}
		
		return usermsgs ;
		
	}
	
	
	/*赞过的帖子*/
	@RequestMapping("/likedmsg")
	@ResponseBody
	public List<Usermsg> likedmsg(String name){
		UserinfoExample userinfoExample = new UserinfoExample() ;
		UserinfoExample.Criteria userCriteria=userinfoExample.createCriteria();
		userCriteria.andUsernameEqualTo(name);
		List<Userinfo> userinfo = userinfoMapper.selectByExample(userinfoExample) ;
		
		Integer userid = userinfo.get(0).getUserid();
		
		MsgreplyExample msgreplyExample = new MsgreplyExample() ;
		MsgreplyExample.Criteria msgreplyCriteria=msgreplyExample.createCriteria();
		msgreplyCriteria.andUseridEqualTo(userid);
		List<Msgreply> msgreplys = msgreplyMapper.selectByExampleWithBLOBs(msgreplyExample);
		
		List<Usermsg> usermsgs = new LinkedList<>() ;
		for(int i =0 ;i<msgreplys.size();i++)
		{
			int msgid = msgreplys.get(i).getMsgid() ;
			UsermsgExample usermsgExample = new UsermsgExample() ;
			UsermsgExample.Criteria msgCriteria = usermsgExample.createCriteria();
			msgCriteria.andUseridEqualTo(userid) ;
			Usermsg usermsg = usermsgMapper.selectByPrimaryKey(msgid) ;
			
			usermsgs.add(usermsg) ;
		}
		
		return usermsgs ;
		
	}
	
}
