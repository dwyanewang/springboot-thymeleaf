package com.dwyanewang.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dwyanewang.dao.LoggerDao;
import com.dwyanewang.entity.TLoggerInfos;
import com.dwyanewang.util.LoggerUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggerInterceptor implements HandlerInterceptor {

    @Autowired
    private LoggerDao loggerDao;

    //请求开始时间标识
    private static final String LOGGER_SENT_TIME = "_sent_time";
    //请求日志实体标识
    private static final String LOGGER_ENTITY = "_entity";


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        TLoggerInfos loggerInfos = new TLoggerInfos();
        String sessionId = request.getRequestedSessionId();
        String url = request.getRequestURI();
        String paramData = JSON.toJSONString(request.getParameterMap(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue);
        loggerInfos.setAliClientIp(LoggerUtils.getCliectIp(request));
        loggerInfos.setAliMethod(request.getMethod());
        loggerInfos.setAliType(LoggerUtils.getRequestType(request));
        loggerInfos.setAliParamData(paramData);
        loggerInfos.setAliUri(url);
        loggerInfos.setAliSessionId(sessionId);
        request.setAttribute(LOGGER_SENT_TIME, System.currentTimeMillis());
        request.setAttribute(LOGGER_ENTITY, loggerInfos);
        System.out.println("处理前" + loggerInfos);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        int status = response.getStatus();
        long currenTime = System.currentTimeMillis();
        long time = Long.valueOf(request.getAttribute(LOGGER_SENT_TIME).toString());
        TLoggerInfos loggerInfos = (TLoggerInfos) request.getAttribute(LOGGER_ENTITY);
        loggerInfos.setAliTimeConsuming(Integer.valueOf((currenTime - time) + ""));
        loggerInfos.setAliReturmTime(currenTime + "");
        loggerInfos.setAliHttpStatusCode(status + "");
        loggerInfos.setAliReturnData(JSON.toJSONString(request.getAttribute(LoggerUtils.LOGGER_RETURN),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue
                ));
        System.out.println("处理完成" + loggerInfos);
//        LoggerDao loggerDao = getDAO(request);
        loggerDao.insert(loggerInfos);
    }

    /**
     * 根据传入的类型获取spring管理的对应dao
     * @param request 请求对象
     * @return LoggerDao
     */
    private LoggerDao getDAO(HttpServletRequest request)
    {
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(LoggerDao.class);
    }
}
