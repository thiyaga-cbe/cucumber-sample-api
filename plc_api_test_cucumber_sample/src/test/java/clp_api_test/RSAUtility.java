package plc_api_test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

import javax.crypto.Cipher;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

/**
 * @author bharath.parameshwara
 *
 */
public class RSAUtility {
    
	private static SettingsConfiguration settingsConfiguration;

	public static String RSADecrypt(String strToBeDecrypted, String clientId) {
		try {
			byte[] enqText = Base64.decodeBase64(strToBeDecrypted);
			PrivateKey decryptKey = readPrivateKey(clientId);

			Cipher localRsa = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			localRsa.init(Cipher.DECRYPT_MODE, decryptKey);
			byte[] tempText = localRsa.doFinal(enqText);
			String decryptedText = new String(tempText, "UTF-8");
			return decryptedText;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public static String RSAEncrypt(String strToBeEncrypted, String clientId) {
		try {
			byte[] enqText = strToBeEncrypted.getBytes("UTF-8");
			PublicKey encryptKey = readPublicKey(clientId);

			Cipher localRsa = Cipher.getInstance("RSA/ECB/PKCS1Padding");
			localRsa.init(Cipher.ENCRYPT_MODE, encryptKey);
			byte[] tempText = localRsa.doFinal(enqText);
			String encryptedText = Base64.encodeBase64String(tempText);
			return encryptedText;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	private static PublicKey readPublicKey(String clientId) {
		String Modulus;
		String Exponent;
		PublicKey publicKey;
		try {
			File file = new File("C:\\PPES\\plc_api_test\\src\\test\\resource\\keys\\Client_1\\PublicKey.xml");
			InputStream fileStream=new FileInputStream(file);
			
			// File keyFile = new
			// File(RSAUtility.class.getResource(settingsConfiguration.getValue("PublicKey_",clientId)).toURI());

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(fileStream);
			document.getDocumentElement().normalize();

			Node temp = document.getFirstChild();

			Element eElement = (Element) temp;
			Modulus = eElement.getElementsByTagName("Modulus").item(0).getTextContent();
			Exponent = eElement.getElementsByTagName("Exponent").item(0).getTextContent();

			BigInteger modules = new BigInteger(1, Base64.decodeBase64(Modulus));
			BigInteger exponent = new BigInteger(1, Base64.decodeBase64(Exponent));

			RSAPublicKeySpec pubSpec = new RSAPublicKeySpec(modules, exponent);

			KeyFactory factory = KeyFactory.getInstance("RSA");

			publicKey = factory.generatePublic(pubSpec);

			return publicKey;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;

		}
	}

	private static PrivateKey readPrivateKey(String clientId) {
		SettingsConfiguration settingsConfiguration = new SettingsConfiguration();

		String Modulus;
		String publicExponent;
		String firstPrime;
		String secondPrime;
		String firstExponent;
		String secondExponent;
		String coefficient;
		String privateExponent;
		PrivateKey privateKey;
		try {
//			InputStream fileStream = RSAUtility.class
//					.getResourceAsStream(settingsConfiguration.getValue("PrivateKey_", clientId));
			
			File file = new File("C:\\PPES\\plc_api_test\\src\\test\\resource\\keys\\Client_1\\PrivateKey.xml");
			InputStream fileStream=new FileInputStream(file);
			// File keyFile = new
			// File(RSAUtility.class.getResource(settingsConfiguration.getValue("PrivateKey_",clientId)).toURI());

			KeyFactory factory = KeyFactory.getInstance("RSA");

			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(fileStream);
			document.getDocumentElement().normalize();

			Node temp = document.getFirstChild();

			Element eElement = (Element) temp;
			Modulus = eElement.getElementsByTagName("Modulus").item(0).getTextContent();
			publicExponent = eElement.getElementsByTagName("Exponent").item(0).getTextContent();
			firstPrime = eElement.getElementsByTagName("P").item(0).getTextContent();
			secondPrime = eElement.getElementsByTagName("Q").item(0).getTextContent();
			firstExponent = eElement.getElementsByTagName("DP").item(0).getTextContent();
			secondExponent = eElement.getElementsByTagName("DQ").item(0).getTextContent();
			coefficient = eElement.getElementsByTagName("InverseQ").item(0).getTextContent();
			privateExponent = eElement.getElementsByTagName("D").item(0).getTextContent();

			BigInteger modules = new BigInteger(1, Base64.decodeBase64(Modulus));
			BigInteger exponent = new BigInteger(1, Base64.decodeBase64(publicExponent));
			BigInteger P = new BigInteger(1, Base64.decodeBase64(firstPrime));
			BigInteger Q = new BigInteger(1, Base64.decodeBase64(secondPrime));
			BigInteger DP = new BigInteger(1, Base64.decodeBase64(firstExponent));
			BigInteger DQ = new BigInteger(1, Base64.decodeBase64(secondExponent));
			BigInteger InvQ = new BigInteger(1, Base64.decodeBase64(coefficient));
			BigInteger d = new BigInteger(1, Base64.decodeBase64(privateExponent));

			RSAPrivateKeySpec priSpec = new RSAPrivateCrtKeySpec(modules, exponent, d, P, Q, DP, DQ, InvQ);

			privateKey = factory.generatePrivate(priSpec);

			return privateKey;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public String getValue(String key, String clientID) {
		String actualKey = key + clientID;
		String value = null;
		try {
			Field field = this.getClass().getField(actualKey);
			value = (String) field.get(this);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return value;
	}

}
