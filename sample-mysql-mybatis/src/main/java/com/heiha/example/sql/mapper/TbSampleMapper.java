package com.heiha.example.sql.mapper;

import com.heiha.example.sql.po.TbSample;
import com.heiha.example.sql.po.TbSampleExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

public interface TbSampleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sample
     *
     * @mbg.generated
     */
    long countByExample(TbSampleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sample
     *
     * @mbg.generated
     */
    int deleteByExample(TbSampleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sample
     *
     * @mbg.generated
     */
    @Delete({
        "delete from tb_sample",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sample
     *
     * @mbg.generated
     */
    @Insert({
        "insert into tb_sample (create_user_id, create_time, ",
        "update_user_id, update_time, ",
        "version)",
        "values (#{createUserId,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateUserId,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{version,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Long.class)
    int insert(TbSample record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sample
     *
     * @mbg.generated
     */
    int insertSelective(TbSample record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sample
     *
     * @mbg.generated
     */
    List<TbSample> selectByExample(TbSampleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sample
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, create_user_id, create_time, update_user_id, update_time, version",
        "from tb_sample",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @ResultMap("com.heiha.example.sql.mapper.TbSampleMapper.BaseResultMap")
    TbSample selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sample
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TbSample record, @Param("example") TbSampleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sample
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TbSample record, @Param("example") TbSampleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sample
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(TbSample record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sample
     *
     * @mbg.generated
     */
    @Update({
        "update tb_sample",
        "set create_user_id = #{createUserId,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_user_id = #{updateUserId,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "version = #{version,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(TbSample record);
}