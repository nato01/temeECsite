<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<header>
	<div id="headerTitle">
		Radish
	</div>
	<div id="headerMenu">
		<ul>
			<s:form action="SearchItemAction">
				<s:if test='#session.mCategoryDTOList!=null && #session.mCategoryDTOList.size()>0'>
					<li><s:select name="categoryId" list="#session.mCategoryDTOList" listValue="categoryName" listKey="categoryId" class="category" id="categoryId"/></li>
				</s:if>
				<li><s:textfield name="keyword" class="txtKeywords" placeholder="検索ワード" /></li>
				<li><s:submit value="商品検索" class="submitBtn" /></li>
			</s:form>
			<s:if test="#session.logined==1">
				<s:form action="LogoutAction">
					<li><s:submit value="ログアウト" class="submitBtn"/></li>
				</s:form>
			</s:if>
			<s:else>
				<s:form  action="GoLoginAction">
					<li><s:submit value="ログイン" class="submitBtn"/></li>
				</s:form>
			</s:else>
			<s:form action="CartAction">
				<li><s:submit value="カート" class="submitBtn"/></li>
			</s:form>
			<s:if test="#session.logined==1">
				<s:form action="MyPageAction">
					<li><s:submit value="マイページ" class="submitBtn"/></li>
				</s:form>
			</s:if>
		</ul>
	</div>

</header>