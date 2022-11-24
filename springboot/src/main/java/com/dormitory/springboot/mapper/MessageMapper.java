package com.dormitory.springboot.mapper;

import com.dormitory.springboot.entity.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface MessageMapper {
    /**
     * 进行分页查询
     */

    //获取总条数
    public Integer totalCount(@Param("a_aid") String a_aid, @Param("s_sid") String s_sid, @Param("m_time") Date m_time);
    //获取消息列表
    public List<Message> getMessageList(@Param("a_aid") String a_aid, @Param("s_sid") String s_sid, @Param("m_time") Date m_time,
                                        @Param("currentPage")Integer currentPage, @Param("pageSize")Integer pageSize);

    public int addMessage(Message message);//添加消息
    public int deleteMessage(@Param("a_aid")String a_aid, @Param("s_sid")String s_sid, @Param("m_time")Date m_time);//删除消息
    public int updateMessage(Message message);//修改消息

    public List<Message> findMessageByTime(@Param("a_aid")String a_aid, @Param("s_sid")String s_sid,
                                           @Param("stime")Date stime, @Param("etime") Date etime);//查询某个时间段的消息
    public List<Message> getAll();

}
