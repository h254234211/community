package com.community.mapper;

import com.community.dto.QuestionQueryDTO;
import com.community.model.Question;
import com.community.model.QuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

public interface QuestionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbg.generated Mon Jan 20 19:54:21 CST 2020
     */
    long countByExample(QuestionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbg.generated Mon Jan 20 19:54:21 CST 2020
     */
    int deleteByExample(QuestionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbg.generated Mon Jan 20 19:54:21 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbg.generated Mon Jan 20 19:54:21 CST 2020
     */
    int insert(Question record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbg.generated Mon Jan 20 19:54:21 CST 2020
     */
    int insertSelective(Question record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbg.generated Mon Jan 20 19:54:21 CST 2020
     */
    List<Question> selectByExampleWithBLOBsWithRowbounds(QuestionExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbg.generated Mon Jan 20 19:54:21 CST 2020
     */
    List<Question> selectByExampleWithBLOBs(QuestionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbg.generated Mon Jan 20 19:54:21 CST 2020
     */
    List<Question> selectByExampleWithRowbounds(QuestionExample example, RowBounds rowBounds);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbg.generated Mon Jan 20 19:54:21 CST 2020
     */
    List<Question> selectByExample(QuestionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbg.generated Mon Jan 20 19:54:21 CST 2020
     */
    Question selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbg.generated Mon Jan 20 19:54:21 CST 2020
     */
    int updateByExampleSelective(@Param("record") Question record, @Param("example") QuestionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbg.generated Mon Jan 20 19:54:21 CST 2020
     */
    int updateByExampleWithBLOBs(@Param("record") Question record, @Param("example") QuestionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbg.generated Mon Jan 20 19:54:21 CST 2020
     */
    int updateByExample(@Param("record") Question record, @Param("example") QuestionExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbg.generated Mon Jan 20 19:54:21 CST 2020
     */
    int updateByPrimaryKeySelective(Question record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbg.generated Mon Jan 20 19:54:21 CST 2020
     */
    int updateByPrimaryKeyWithBLOBs(Question record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table question
     *
     * @mbg.generated Mon Jan 20 19:54:21 CST 2020
     */
    int updateByPrimaryKey(Question record);

    /*
     * 阅读数+1
     * */
    int incView(Question record);

    /*
     * 评论数+1
     * */
    int incComment(Question record);

    /*
    *  通过tag获取问题列表
    * */
    List<Question> selectRelated(Question question);

    /*
     *  搜索功能 获取查找到的问题的个数
     * */
    Integer countBySearch(QuestionQueryDTO questionQueryDTO);

    /*
     *  搜索功能 获取查找到的问题
     * */
    List<Question> selectBySearch(QuestionQueryDTO questionQueryDTO);
}