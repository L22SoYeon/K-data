package fithy.project.dto;

public class User {
	private String userCode;
	private String userId;
	private String userPw;
	private String userName;
	private String userGender;
	private String userAge;
	private String userPhoneNum;
	private String userAddress;
	private String userFavoriteKind;

	// DB에 insert 해주기 위해 만든 생성자 -----------------
	public User(String userCode, String userId, String userPw, String userName, String userGender, String userAge,
			String userPhoneNum, String userAddress, String userFavoriteKind) {
		super();
		this.userCode = userCode;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.userGender = userGender;
		this.userAge = userAge;
		this.userPhoneNum = userPhoneNum;
		this.userAddress = userAddress;
		this.userFavoriteKind = userFavoriteKind;
	}

	// session 영역을 위해 만든 생성자 -------------------
	public User(String userCode, String userId, String userName) {
		super();
		this.userCode = userCode;
		this.userId = userId;
		this.userName = userName;
	}

	// 간략한 회원 정보를 저장하기 위해 만든 생성자 --------
	public User(String userCode, String userId, String userName, String userPhoneNum, String userAddress) {
		super();
		this.userCode = userCode;
		this.userId = userId;
		this.userName = userName;
		this.userPhoneNum = userPhoneNum;
		this.userAddress = userAddress;
	}

	// 로그인 비교 생성자 ----------------------------------
	public User(String userId, String userPw) {
		super();
		this.userId = userId;
		this.userPw = userPw;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	public String getUserAge() {
		return userAge;
	}

	public void setUserAge(String userAge) {
		this.userAge = userAge;
	}

	public String getUserPhoneNum() {
		return userPhoneNum;
	}

	public void setUserPhoneNum(String userPhoneNum) {
		this.userPhoneNum = userPhoneNum;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserFavoriteKind() {
		return userFavoriteKind;
	}

	public void setUserFavoriteKind(String userFavoriteKind) {
		this.userFavoriteKind = userFavoriteKind;
	}

}
