package com.heiha.example.sql.po;

import java.util.Date;

public class TbSample extends BaseEntity {
    /**
     * TODO
     * 没有显式声明构造方法导致了，POST等需要对象转换的请求失败 <br>
     * 这是什么原因导致的？
     */
    public TbSample() {}

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_sample.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_sample.create_user_id
     *
     * @mbg.generated
     */
    private String createUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_sample.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_sample.update_user_id
     *
     * @mbg.generated
     */
    private String updateUserId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_sample.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column tb_sample.version
     *
     * @mbg.generated
     */
    private Byte version;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tb_sample
     *
     * @mbg.generated
     */
    public TbSample(Long id, String createUserId, Date createTime, String updateUserId, Date updateTime, Byte version) {
        this.id = id;
        this.createUserId = createUserId;
        this.createTime = createTime;
        this.updateUserId = updateUserId;
        this.updateTime = updateTime;
        this.version = version;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_sample.id
     *
     * @return the value of tb_sample.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_sample.create_user_id
     *
     * @return the value of tb_sample.create_user_id
     *
     * @mbg.generated
     */
    public String getCreateUserId() {
        return createUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_sample.create_time
     *
     * @return the value of tb_sample.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_sample.update_user_id
     *
     * @return the value of tb_sample.update_user_id
     *
     * @mbg.generated
     */
    public String getUpdateUserId() {
        return updateUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_sample.update_time
     *
     * @return the value of tb_sample.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column tb_sample.version
     *
     * @return the value of tb_sample.version
     *
     * @mbg.generated
     */
    public Byte getVersion() {
        return version;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public void setVersion(Byte version) {
        this.version = version;
    }
}