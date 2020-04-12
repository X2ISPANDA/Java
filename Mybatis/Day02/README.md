# 动态SQL

1. if语句

   ```
   <if test="username != null">
              username=#{username}
   </if>
   ```

2. if+where语句

   ```
    <where>
           <if test="username != null">
              username=#{username}
           </if>
            
           <if test="username != null">
              and sex=#{sex}
           </if>
       </where>
   ```

3. choose语句

    　有时候，我们不想用到所有的查询条件，只想选择其中的一个，查询条件有一个满足即可，使用 choose 标签可以解决此类问题，类似于 Java 的 switch 语句 

   ```
   <select id="selectUserByChoose" resultType="com.ys.po.User" parameterType="com.ys.po.User">
         select * from user
         <where>
             <choose>
                 <when test="id !='' and id != null">
                     id=#{id}
                 </when>
                 <when test="username !='' and username != null">
                     and username=#{username}
                 </when>
                 <otherwise>
                     and sex=#{sex}
                 </otherwise>
             </choose>
         </where>
     </select>
   ```

4. if+set语句

   ```
   <!-- 根据 id 更新 user 表的数据 -->
   <update id="updateUserById" parameterType="com.ys.po.User">
       update user u
           <set>
               <if test="username != null and username != ''">
                   u.username = #{username},
               </if>
               <if test="sex != null and sex != ''">
                   u.sex = #{sex}
               </if>
           </set>
        
        where id=#{id}
   </update>
   ```

5. trim语句

   - prefix：前缀
   - prefixoverride：去掉第一个and或者是or
   -  suffix：后缀
   -  suffixoverride：去掉最后一个逗号（也可以是其他的标记，就像是上面前缀中的and一样） 

   1.  用 trim 改写上面第二点的 if+where 语句 

      ```
      <select id="selectUserByUsernameAndSex" resultType="user" parameterType="com.ys.po.User">
              select * from user
              <!-- <where>
                  <if test="username != null">
                     username=#{username}
                  </if>
                   
                  <if test="username != null">
                     and sex=#{sex}
                  </if>
              </where>  -->
              <trim prefix="where" prefixOverrides="and | or">
                  <if test="username != null">
                     and username=#{username}
                  </if>
                  <if test="sex != null">
                     and sex=#{sex}
                  </if>
              </trim>
          </select>
      ```

   2.  用 trim 改写上面第三点的 if+set 语句 

      ```
      <!-- 根据 id 更新 user 表的数据 -->
          <update id="updateUserById" parameterType="com.ys.po.User">
              update user u
                  <!-- <set>
                      <if test="username != null and username != ''">
                          u.username = #{username},
                      </if>
                      <if test="sex != null and sex != ''">
                          u.sex = #{sex}
                      </if>
                  </set> -->
                  <trim prefix="set" suffixOverrides=",">
                      <if test="username != null and username != ''">
                          u.username = #{username},
                      </if>
                      <if test="sex != null and sex != ''">
                          u.sex = #{sex},
                      </if>
                  </trim>
               
               where id=#{id}
          </update>
      ```

6. SQL片段

   - 定义SQL片段

     ```
     <!-- 定义 sql 片段 -->
     <sql id="selectUserByUserNameAndSexSQL">
         <if test="username != null and username != ''">
             AND username = #{username}
         </if>
         <if test="sex != null and sex != ''">
             AND sex = #{sex}
         </if>
     </sql>
     ```

   - 引用SQL片段

     ```
     <select id="selectUserByUsernameAndSex" resultType="user" parameterType="com.ys.po.User">
         select * from user
         <trim prefix="where" prefixOverrides="and | or">
             <!-- 引用 sql 片段，如果refid 指定的不在本文件中，那么需要在前面加上 namespace -->
             <include refid="selectUserByUserNameAndSexSQL"></include>
             <!-- 在这里还可以引用其他的 sql 片段 -->
         </trim>
     </select>
     ```

7. foreach语句

   ```
   <select id="selectUserByListId" parameterType="com.ys.vo.UserVo" resultType="com.ys.po.User">
       select * from user
       <where>
           <!--
               collection:指定输入对象中的集合属性
               item:每次遍历生成的对象
               open:开始遍历时的拼接字符串
               close:结束时拼接的字符串
               separator:遍历对象之间需要拼接的字符串
               select * from user where 1=1 and (id=1 or id=2 or id=3)
             -->
           <foreach collection="ids" item="id" open="and (" close=")" separator="or">
               id=#{id}
           </foreach>
       </where>
   </select>
   ```

   