<%@page import="org.apache.ibatis.io.ResolverUtil.Test"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link href="/resources/css/login/signUp.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="/resources/js/signup.js"></script>
   <main id="main">
      <div id="middle-box">
         <h1 class="d-none">메인</h1>
         <section id="title-box">
            <h1 id="title">
               <span id="text-red">M</span><span>o</span><span id="text-green">M</span><span
                  id="text-blue">o</span>
            </h1>
   
         </section>
         
            <div id="signupForm">
               <form action="signup" method="post">
               <div id="formContent">
                  <div>
                     <label>아이디</label><br>
                     <input type="text" id="loginId" name="loginId"/>
                     <div id="idConfirm"></div><div id="idchk"></div>
                  </div>
                  <div>
                     <label>비밀번호</label><br>
                     <input type="password" id="pwd" name="pwd"/>
                     <div id="pwdConfirm"></div>
                  </div>
               
                  <div>
                     <label>비밀번호 확인</label><br>
                     <input type="password" id="checkPwd" name="checkPassword"/>
                     <div id="pwdchk"></div>
                  </div>

                  <div>
                     <label>이름</label><br>
                     <input type="text" name="name"/>
                  </div>

                  <div id="selectDiv">
                     <div>
                        <label>성별</label><br>
                        <select name="gender">
                           <option value="남성" selected="select">남성</option>
                           <option value="여성">여성</option>
                        </select>
                     </div>
                     
                     <div>
                        <label>생년월일</label><br> <select class="year" name="year">
                  <%
                     for (int i = 0; i < 70; i++) {
                  %>
                  <%int year=(i + 1950);%>
                  <option value="<%=year%>"><%=year%></option>
                  <%
                     }
                  %>

               </select> <select class="month" name="month">
                  <%
                     for (int i = 0; i < 12; i++) {
                  %>
                  <%int month=(i + 1);%>
                  <option value="<%=month%>"><%=month%></option>
                  <%
                     }
                  %>
               </select> <select class="day" name="day">
                  <%
                     for (int i = 0; i < 31; i++) {
                  %>
                  <%int day=(i + 1);%>
                 
                  <option value="<%=day%>"><%=(i + 1)%></option>
                  <%
                     }
                  %>
               </select>
                     </div>
                  </div>

                  <div>
                     <label>전화번호</label> <br> 
                     <input id="phone" type="text" name="phone"><br>
                        <span id="phone-confirm"></span>
                  </div>
                  
                  <div>
                     <label>이메일</label> <br> 
                     <label><input id="inputEmail" type="text" name="email">@ 
                     <select id="emailOption" name="emailaddress">
                        <option value="naver.com">naver.com
                        <option value="daum.net">daum.net
                        <option value="gmail.com">gmail.com
                     </select></label>
                  </div>
                  <input type="hidden" name="roleId" value="Role_Customer">
               </div>
               <div id="signUpButton">
                  <a href="login/signupConfirm"><input type="submit" name="signup" value="가입하기"></a>
                  <a href="login"><input type="button" name="cancel" value="취소"></a>
               </div>
               </form>
            </div>
         
      </div>
   </main>
