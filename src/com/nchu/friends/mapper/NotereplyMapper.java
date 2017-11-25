package com.nchu.friends.mapper;

import com.nchu.friends.po.Notereply;
import com.nchu.friends.po.NotereplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NotereplyMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notereply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	long countByExample(NotereplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notereply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int deleteByExample(NotereplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notereply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int deleteByPrimaryKey(Integer replyid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notereply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int insert(Notereply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notereply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int insertSelective(Notereply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notereply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	List<Notereply> selectByExample(NotereplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notereply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	Notereply selectByPrimaryKey(Integer replyid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notereply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int updateByExampleSelective(@Param("record") Notereply record, @Param("example") NotereplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notereply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int updateByExample(@Param("record") Notereply record, @Param("example") NotereplyExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notereply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int updateByPrimaryKeySelective(Notereply record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table notereply
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int updateByPrimaryKey(Notereply record);
}