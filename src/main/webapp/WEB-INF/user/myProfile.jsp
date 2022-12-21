<%@page contentType="text/html; charset=utf-8"%>

	<table style="background-color: YellowGreen">
		<tr height="40">
			<td width="150" align="center" bgcolor="E6ECDE">사용자 ID</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				${user.id}</td>
		</tr>
		<tr height="40">
			<td width="150" align="center" bgcolor="E6ECDE">비밀번호</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				${user.password}</td>
		</tr>
		<tr height="40">
			<td width="150" align="center" bgcolor="E6ECDE">이름</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				${user.name}</td>
		</tr>
		<tr height="40">
			<td width="150" align="center" bgcolor="E6ECDE">닉네임</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				${user.nickname}</td>
		</tr>
		<tr height="40">
			<td width="150" align="center" bgcolor="E6ECDE">생년월일</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				${user.birth}</td>
		</tr>
		<tr height="40">
			<td width="150" align="center" bgcolor="E6ECDE">이메일 주소</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				${user.email}</td>
		</tr>
		<tr height="40">
			<td width="150" align="center" bgcolor="E6ECDE">전화번호</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				${user.phoneNumber}</td>
		</tr>
		<tr height="40">
			<td width="150" align="center" bgcolor="E6ECDE">주소</td>
			<td width="250" bgcolor="ffffff" style="padding-left: 10">
				${user.address}</td>
	</table>
