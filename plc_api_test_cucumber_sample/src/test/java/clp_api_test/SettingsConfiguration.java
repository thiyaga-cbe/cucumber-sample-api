/**
 * 
 */
package plc_api_test;

import java.lang.reflect.Field;

import org.springframework.context.annotation.Configuration;

/**
 * @author madhuri.namana
 *
 */
@Configuration
public class SettingsConfiguration {
	
	public String SessionIDCheck_1 = "false";
	public String PublicKey_1 = "C:\\PPES\\plc_api_test\\src\\test\\resource\\keys\\Client_1\\PublicKey.xml";
	public String PrivateKey_1 = "C:\\PPES\\plc_api_test\\src\\test\\resource\\keys\\Client_1\\PrivateKey.xml";
	public static String GeneralError = "General Exception";
	public String IsEmailtobeSent_1 = "true";
	
	//Email Configurations
	public String FromEmail_1 = "p.anandraj@gmail.com";
	public String SMTPHost_1 = "email-smtp.us-west-2.amazonaws.com";
	public String SMTPPort_1 = "587";
	public String SMTPUserName_1 = "AKIAJC4H3FA44AYSP4SQ";
	public String SMTPPassword_1 = "AgSNV+d4lPc5GnJrR/pfzVqDU39AQa1e38R9bAEpi4ap";
	
	
	Field[] fields = this.getClass().getFields();
	

	public String getValue(String key, String clientID){
		String actualKey = key + clientID;
		String value = null;
		try {
			Field field = this.getClass().getField(actualKey);
			value = (String)field.get(this);
		}  catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return value;
	}		
		
}
