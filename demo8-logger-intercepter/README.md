#### 在使用springboot的拦截器时，有时候希望在拦截器中注入bean方便使用,但是如果直接注入会发现无法注入而报空指针异常
解决方案有两种：

    1、在注册拦截器时，将拦截器注入为bean
    @Configuration
    public class LoggerConfigure implements WebMvcConfigurer {
        @Bean
        public LoggerInterceptor loggerInterceptor(){
            return new LoggerInterceptor();
        }
        @Override
        public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(loggerInterceptor()).addPathPatterns("/**");
        }
    }
    
    2、通过HttpServletRequest请求对象的上下文（ServetCotext）获取Spring管理的Bean
    /**
      * 根据传入的类型获取spring管理的对应dao
      * @param request 请求对象
      * @return LoggerDao
      */
    private LoggerDao getDAO(HttpServletRequest request){
       BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
       return factory.getBean(LoggerDao.class);
    }