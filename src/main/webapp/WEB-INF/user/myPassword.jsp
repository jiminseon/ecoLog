<%@page contentType="text/html; charset=utf-8" %>

	<form name="form" method="POST" action="<c:url value='/user/profile' />">
	
		<table style="background-color: beige; width: 100%; height: 100%" align="center">
			<tr height=100% align="center">
				<td width=100% align="center" bgcolor=beige><h3>비밀번호 확인</h3>
				<h5>마이페이지 접근을 위해 비밀번호를 입력해주세요</h5></td>
			</tr>
			<tr height=100% align="center">
				<td width="100%" bgcolor="beige" style="padding-left: 10">
				<input type="password" style="width: 240" name="password"></td>
				<td align=left><input type="button" value="확인"
					onClick="javascript:if(checkPW()==true) form.submit();" > &nbsp;</td>
			</tr>
		</table>
	</form>
