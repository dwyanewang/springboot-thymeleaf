package com.dwyanewang.dao;

import com.dwyanewang.entity.TLoggerInfos;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface LoggerDao {
    @Insert("insert \n" +
            "    into\n" +
            "        t_logger_infos\n" +
            "        (ali_client_ip,ali_uri,ali_type,ali_method,ali_param_data,ali_session_id,ali_returm_time,ali_return_data, ali_http_status_code,  ali_time_consuming) \n" +
            "    values\n" +
            "        (#{aliClientIp}, #{aliUri},#{aliType},#{aliMethod}, #{aliParamData},#{aliSessionId},#{aliReturmTime}, #{aliReturnData}, #{aliHttpStatusCode}, #{aliTimeConsuming}  )")
    void insert(TLoggerInfos loggerInfos);

}
