package com.nchu.friends.mapper;

import com.nchu.friends.po.Homenote;
import com.nchu.friends.po.HomenoteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface HomenoteMapper {

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table homenote
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	long countByExample(HomenoteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table homenote
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int deleteByExample(HomenoteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table homenote
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int deleteByPrimaryKey(Integer noteid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table homenote
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int insert(Homenote record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table homenote
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int insertSelective(Homenote record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table homenote
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	List<Homenote> selectByExampleWithBLOBs(HomenoteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table homenote
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	List<Homenote> selectByExample(HomenoteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table homenote
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	Homenote selectByPrimaryKey(Integer noteid);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table homenote
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int updateByExampleSelective(@Param("record") Homenote record, @Param("example") HomenoteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table homenote
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int updateByExampleWithBLOBs(@Param("record") Homenote record, @Param("example") HomenoteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table homenote
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int updateByExample(@Param("record") Homenote record, @Param("example") HomenoteExample example);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table homenote
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int updateByPrimaryKeySelective(Homenote record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table homenote
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int updateByPrimaryKeyWithBLOBs(Homenote record);

	/**
	 * This method was generated by MyBatis Generator. This method corresponds to the database table homenote
	 * @mbg.generated  Sat Apr 22 01:20:07 CST 2017
	 */
	int updateByPrimaryKey(Homenote record);
}