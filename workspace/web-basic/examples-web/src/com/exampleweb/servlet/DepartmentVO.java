package com.exampleweb.servlet;

//HR.Departments 테이블에 대응하는 VO 클래스
public class DepartmentVO {
	
	//테이블의 컬럼을 필드로 선언
	private int departmentId;
	private String departmentName;
	private int managerId;
	private int locationId;
	
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public int getLocationId() {
		return locationId;
	}
	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}
	
	@Override
	public String toString() { //객체의 정보를 간단한 문자열로 반환하는 메서드
		//String.format : printf에서 출력 기능만 빠진 메서드 (문자열 생산)
		String info = String.format("[%4d][%s]", departmentId, departmentName);
		return info;
	}

}








