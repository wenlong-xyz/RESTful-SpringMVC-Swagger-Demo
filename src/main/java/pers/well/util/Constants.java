package pers.well.util;

public class Constants {
	public static final int ACTIVE_HOURS = 72;
	public static final String COMPANY_ID_DEAFULT = "00000000001";

	public static final int CARD_ID_LENGTH = 11;
	public static final float CARD_BALANCE = 1000;
	public static final float CARD_DEPOSIT = 5000;
	
	public enum AccountState{
		CHECKING((byte)0),ACCESS((byte)1),INCALIDATION((byte)2);
		
		private byte value;
		private AccountState(byte value){
			this.value = value;
		}
		public byte getValue(){
			return value;
		}
	}
	
	public enum CarState{
		FREE((byte)0),ORDERING((byte)1),USEING((byte)2),REPAIRING((byte)3);
		
		private byte value;
		private CarState(byte value){
			this.value = value;
		}
		public byte getValue(){
			return value;
		}
	}
	
	public enum OrderState{
		ORDERING((byte)0),GOING((byte)1),FINISHED((byte)2),ALL((byte)3);
		
		private byte value;
		private OrderState(byte value){
			this.value = value;
		}
		public byte getValue(){
			return value;
		}
	}
	
	
	//文件相关
	public static final String catchDir = "tmp/";
	public static final String faceDir = "user/private/face/";
	public static final String licenseDir = "user/private/license/";
	public static final String facePre = "face-";
	public static final String licensePre = "license-";
}
