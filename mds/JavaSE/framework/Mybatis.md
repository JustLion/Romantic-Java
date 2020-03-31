### 1、 MyBatis 在 insert 插入操作时返回主键
1. MySQL
```$xslt
<insert id="insert" parameterType="com.test.User" keyProperty="userId"
useGeneratedKeys="true" >
```
2. Oracle
```$xslt
<insert id="insert" parameterType="com.test.User">
    <selectKey resultType="INTEGER" order="BEFORE" keyProperty="userId">
        SELECT SEQ_USER.NEXTVAL as userId from DUAL
    </selectKey>
    insert into user (user_id, user_name, modified, state)
    values (#{userId,jdbcType=INTEGER}, #{userName,jdbcType=VARCHAR},
    #{modified,jdbcType=TIMESTAMP}, #{state,jdbcType=INTEGER})
</insert>
```