package com.nchu.friends.mapper;

import com.nchu.friends.po.Msgreply;
import com.nchu.friends.po.MsgreplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MsgreplyMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	long countByExample(MsgreplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int deleteByExample(MsgreplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int deleteByPrimaryKey(Integer replyid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int insert(Msgreply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int insertSelective(Msgreply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	List<Msgreply> selectByExampleWithBLOBs(MsgreplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	List<Msgreply> selectByExample(MsgreplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	Msgreply selectByPrimaryKey(Integer replyid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int updateByExampleSelective(@Param("record") Msgreply record, @Param("example") MsgreplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int updateByExampleWithBLOBs(@Param("record") Msgreply record, @Param("example") MsgreplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int updateByExample(@Param("record") Msgreply record, @Param("example") MsgreplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int updateByPrimaryKeySelective(Msgreply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int updateByPrimaryKeyWithBLOBs(Msgreply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table msgreply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int updateByPrimaryKey(Msgreply record);
}