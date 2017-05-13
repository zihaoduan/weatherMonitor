package mainSystem;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;
import org.python.util.PythonInterpreter;
public class JunitTest {

	@Test
	public void test() {
		StringBuilder stb=null;
		BufferedReader br_citylist=null;
		String decode=null;
		int count=0;
		try {
			String city="����";
			String urlencode=URLEncoder.encode(city,"utf-8");
			String url="http://apicloud.mob.com/environment/query?key=1d42eae83af38&city="+urlencode;
//			String url2="https://github.com/";
			URL url1=new URL(url);
			HttpURLConnection connection=(HttpURLConnection) url1.openConnection();
			connection.setReadTimeout(1000 * 60);// ���ó�ʱʱ��Ϊ60��
			connection.setDoInput(true);// ��ȡ����
			connection.setRequestMethod("GET");// ��������ʽΪGET��ʽ
			if (connection.getResponseCode() == 200) {// ������200��ʾ����ɹ�
				br_citylist = new BufferedReader(
						new InputStreamReader(
								connection.getInputStream()));
			} else {
				// �������Լ�����������ʧ�ܵĴ���
				throw new Exception("��������ʧ�ܣ���������룺"
						+ connection.getResponseCode());

			}
			char[] buff = new char[1024];
//			byte[] buff=new byte[10240];
			stb = new StringBuilder();
			while ((count = br_citylist.read(buff)) != -1) {
				decode = new String(buff, 0, count);
				stb.append(decode);
			}
			br_citylist.close();
			System.out.println(stb.toString());
			connection.disconnect();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	@Test
	public void test1() {
		BufferedInputStream bi_citylist=null;
		BufferedOutputStream bo=null;
		int count=0;
		try {
			String url2="https://github.com/";
			URL url1=new URL(url2);
			HttpURLConnection connection=(HttpURLConnection) url1.openConnection();
			connection.setReadTimeout(1000 * 60);// ���ó�ʱʱ��Ϊ60��
			connection.setDoInput(true);// ��ȡ����
			connection.setRequestMethod("GET");// ��������ʽΪGET��ʽ
			if (connection.getResponseCode() == 200) {// ������200��ʾ����ɹ�
				bi_citylist =new BufferedInputStream(connection.getInputStream());
				bo=new BufferedOutputStream(new FileOutputStream(new File("C:\\Users\\ac\\Desktop\\github.html")));
			} else {
				// �������Լ�����������ʧ�ܵĴ���
				throw new Exception("��������ʧ�ܣ���������룺"
						+ connection.getResponseCode());

			}
			byte[] buff=new byte[10240];
			while ((count = bi_citylist.read(buff)) != -1) {
				bo.write(buff, 0, count);
			}
			bo.close();
			bi_citylist.close();
			connection.disconnect();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2(){
		Process proc;
		try {
			proc = Runtime.getRuntime().exec("cmd.exe /c start python F:\\eclipse�����ļ�\\mlWeather\\pm25predict\\bp1.py");
			proc.waitFor();
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}  
	}
	
	@Test
	public void test3(){
		FileOutputStream fo=null;
		try {
			fo=new FileOutputStream("C:\\Users\\ac\\Desktop\\exportdata.txt");
			for (int i = 0; i <100; i++) {
				StringBuffer sb = new StringBuffer();
				sb.append(10);
				sb.append(" ");
				sb.append(10);
				sb.append(" ");
				sb.append(10);
				sb.append(" ");
				sb.append(10);
				sb.append("\r\n");
				sb.append(10);
				sb.append(" ");
				sb.append(10);
				sb.append(" ");
				sb.append(10);
				sb.append(" ");
				sb.append(10);
				sb.append("\r\n");
				sb.append(10);
				sb.append(" ");
				sb.append(10);
				sb.append(" ");
				sb.append(10);
				sb.append(" ");
				sb.append(10);
				sb.append("\r\n");
				fo.write(sb.toString().getBytes(), 0,
						sb.toString().getBytes().length);
			}
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			try {
				fo.close();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
		}
		
	}
}