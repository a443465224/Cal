package com.example.cal;

import java.math.BigDecimal;

public class ITools {

	/**
	 * 传入要写入的字符，和当前的数字文本，�?��输入是否规范，并且返回校验后的数字文�?
	 * @param input	当前要写入的字符
	 * @param num	输入之前的数字文�?
	 * @return		返回�?��修正后的完整文本
	 */
	public static String checkInput(String input, String num) {
		//如果已经存在小数点，并且小数点在倒数第三位，说明小数点后就已经有两位数了，就不让输入了�?
		int index = num.indexOf(".");
		if (index != -1 && index == num.length()-3) {
			return num;
		}
		if (input.equals("0")){
			//输入0时，如果金额文本，已经输入一位并且是0，就不让再输�?了�?
			if (num.length() == 1 && num.equals("0")){
				return num;
			}
		} else if (input.equals(".")){
			//输入.时，如果金额文本为空，就前面�?；如果当前文本中已经有一�?了，就不让再输入了�?
			if (num.length() == 0){
				num = "0";
			}
			if (index != -1){
				return num;
			}
		} else {
			//输入1-9�?如果当前只输入一位并且为0，就�?删除掉�?
			if (num.length() == 1 && num.equals("0")){
				num = "";
			}
		}
		return num + input;
	}
	
	/**
	 * flaot和double的加法运�?
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static BigDecimal add(Number num1, Number num2) {
		BigDecimal decimal1 = new BigDecimal(num1.toString());
		BigDecimal decimal2 = new BigDecimal(num2.toString());
		return decimal1.add(decimal2);
	}
	
	/**
	 * float和double的减法运�?
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static BigDecimal subtract(Number num1, Number num2) {
		BigDecimal decimal1 = new BigDecimal(num1.toString());
		BigDecimal decimal2 = new BigDecimal(num2.toString());
		return decimal1.subtract(decimal2);
	}
	
	/**
	 * float和double的乘法运�?
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static BigDecimal multiply(Number num1, Number num2) {
		BigDecimal decimal1 = new BigDecimal(num1.toString());
		BigDecimal decimal2 = new BigDecimal(num2.toString());
		return decimal1.multiply(decimal2);
	}
	
	/**
	 * float和double的除法运�?
	 * @param num1
	 * @param num2
	 * @return
	 */
	public static BigDecimal divide(Number num1, Number num2) {
		BigDecimal decimal1 = new BigDecimal(num1.toString());
		BigDecimal decimal2 = new BigDecimal(num2.toString());
		return decimal1.divide(decimal2, 3, BigDecimal.ROUND_HALF_UP);
	}
	
	/**
	 * float和double的除法运�?可以自定义保留位数的
	 * @param num1
	 * @param num2
	 * @param scale
	 * @return
	 */
	public static BigDecimal divide(Number num1, Number num2, int scale) {
		BigDecimal decimal1 = new BigDecimal(num1.toString());
		BigDecimal decimal2 = new BigDecimal(num2.toString());
		return decimal1.divide(decimal2, 3, BigDecimal.ROUND_HALF_UP);
	}

}
