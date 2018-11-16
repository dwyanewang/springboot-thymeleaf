**通过注解的形式使用mybatis**

1、常规的基础SQL语句可直接通过`@Select`、`@Insert`、`@Update`、`@Delete`这些注解实现。

2、一些需要通过判断来执行的SQL语句及一些暂不确定参数的SQL语句可使用`@SelectProvider`、`@InsertProvider`、`@UpdateProvider`、`@DeleteProvider`这些注解来实现。

3、获取结果集的映射关系

    /**
     * 1.用于获取结果集的映射关系
     */
    private static String getResultsStr(Class aClass) {
        StringBuilder sb = new StringBuilder();
        sb.append("@Results({\n");
        for (Field field : aClass.getDeclaredFields()) {
            String fieldName = field.getName();
            //映射关系：对象属性(驼峰)->数据库字段(下划线)
            String column = new PropertyNamingStrategy.SnakeCaseStrategy().translate(fieldName).toUpperCase();
            sb.append(String.format("@Result(property = \"%s\",column = \"%s\"),\n", fieldName, column));
        }
        sb.append("})");
        return sb.toString();
    }
  
    /**
     * 2.打印结果集的映射关系. 例如：
     *
     * @Results({
     * @Result(property = "userId", column = "USER_ID"),
     * @Result(property = "username", column = "USERNAME"),
     * @Result(property = "password", column = "PASSWORD"),
     * @Result(property = "mobileNum", column = "PHONE_NUM"),
     * })
     */
    public static void main(String[] args) {
        System.out.println(getResultsStr(User.class));
    }
    
4、在控制台中以debug的形式打印dao层中的方法，在application.properties中添加配置，可打印出相应的SQL语句

    logging.level.com.dwyanewang.dao=debug