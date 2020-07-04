package Utils;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import PMS.factory.EmloyeeServiceFactory;
import PMS.vo.Employee;

/**
 * �������Ա����Ϣ��"ְ�����", "����", "���֤��", "����", "�Ա�", "��������", "ѧ��", "����", "ְ��",
 * "סַ","�ֻ�����", "�����ʼ�","�༭ʱ��", "��ע"��
 * 
 * @author X-rapido
 */
public class RandomValue {
	public static int id = 1;
	public static String base = "abcdefghijklmnopqrstuvwxyz0123456789";
	private static String firstName = "��Ǯ��������֣��������������������������ʩ�ſײ��ϻ���κ�ս���л������ˮ��������˸��ɷ�����³Τ������ﻨ������Ԭ��ۺ��ʷ�Ʒ����Ѧ�׺����������ޱϺ�����������ʱ��Ƥ���뿵����Ԫ������ƽ�ƺ�������Ҧ��տ����ë����ױ���갼Ʒ��ɴ�̸��é���ܼ�������ף������������ϯ����ǿ��·¦Σ��ͯ�չ�÷ʢ�ֵ�����������Ĳ��﷮���������֧�¾̹�¬Ī�������Ѹɽ�Ӧ�������ڵ��������������ʯ�޼�ť�������ϻ���½��������춻���κ�ӷ����ഢ���������ɾ��θ����ڽ��͹�����ɽ�ȳ������ȫۭ�����������������ﱩ�����������������ղ����Ҷ��˾��۬�輻��ӡ�ް׻���̨�Ӷ����̼���׿�����ɳ����������ܲ�˫��ݷ����̷�����̼������Ƚ��۪Ӻȴ�ɣ���ţ��ͨ�����༽ۣ����ũ�±�ׯ�̲����ֳ�Ľ����ϰ�°���������������θ����߾Ӻⲽ�����������Ŀܹ�»�ڶ�Ź�����εԽ��¡ʦ�������˹��������������Ǽ��Ŀ�����ɳؿ������ᳲ�������󽭺�����Ȩ�ָ��滸����ٹ˾���Ϲ�ŷ���ĺ�������˶��������ʸ�ξ�ٹ����̨��ұ���������������̫����������������ԯ�������������Ľ����������˾ͽ˾������˾���붽�ӳ�����ľ����������������ṫ���ذμй��׸����������ַ���۳Ϳ�նθɰ��ﶫ�����ź��ӹ麣����΢����˧�ÿ�������������������������Ĳ��٦�����Ϲ�ī�������갮��١�����Ը��ټ�����";
	private static String girl = "���Ӣ���������Ⱦ���������֥��Ƽ�����ҷ���ʴ��������÷���������滷ѩ�ٰ���ϼ����ݺ�����𷲼Ѽ�������������Ҷ�������������ɺɯ������ٻ�������ӱ¶������������Ǻɵ���ü������ޱݼ���Է�ܰ�������԰��ӽ�������ع���ѱ�ˬ������ϣ����Ʈ�����������������������ܿ�ƺ������˿ɼ���Ӱ��֦˼�� ";
	private static String boy = "ΰ�����㿡��ǿ��ƽ�����Ļ�������������־��������ɽ�ʲ���������Ԫȫ��ʤѧ��ŷ���������ɱ�˳���ӽ��β��ɿ��ǹ���ﰲ����ï�����м�ͱ벩���Ⱦ�����׳��˼Ⱥ���İ�����ܹ����ƺ���������ԣ���ܽ���������ǫ�����֮�ֺ��ʲ����������������ά�������������󳿳�ʿ�Խ��������׵���ʱ̩ʢ��衾��ڲ�����ŷ纽��";
	private static String[] road = "�������,������·,ʮ÷�ֽ�,����·,��̶��,���㳡,��ɽ��,��ɽ��·,��ɽ������,��ɳ��·,�Ժ�㳡,����·,�񺽽�,������·,��ͤ������,���Ź㳡,���Ǵ���,����·,��ڽ�,�д�·,�����㳡,����·,������,���·,�ӳǴ���,���ǹ㳡,������,����·,���ǽ�,����·,�����㳡,�г�·,���Ǵ���,˳��·,���ǽ�,ɽ�ǹ㳡,���ǽ�,����·,̩�ǽ�,����·,��������,����·,������,����·,˶����,��������,������,�ả·,˫Ԫ����,ϧ����ֵ�,��ׯ�ֵ�,����ҵ԰,��ɽ��,̫ƽ·,������,Ϋ�ع㳡,��ɽ����,����·,������,֥�·,���ݹ㳡,������·,�������,����һ·,����������,�ۺ����㳡,����֧��,�ۺ�һ·,����֧��,����·,ƽ�ȹ㳡,��ˮ·,��������,�ൺ·,������,�����㳡,۰�ǽ�,���·,������,����·,�ӱ�����,�Ƶ�·,������,ݷ��·,���Ͻ�,�����㳡,���ս�,����·,��̩����,����·,ɽ���㳡,��ˮ·,�ʳǽ�,��ɽ·,�ķ���,ƽԭ�㳡,��ˮ����,�㽭·,������,�ٿ�·,���Ϲ㳡,̩��·,�����,��ɽϿ֧·,����Ͽһ����,̨��γһ�㳡,̨��γ�Ľ�,̨��γ��·,����Ͽ����,����Ͽ��·,̨��γ���㳡,̨��γ��·,����Ͽ����,��ͭϿ·,̨������,����Ͽ�㳡,����Ͽ��,�ŵ���·,�ŵ�һ��,̨����·,̨��һ����,۩����·,�ŵ�����,����Ͽ·,���ض���,����һ�㳡,̨���Ľ�,����Ͽ·,����֧����,��ɽϿ·,۩�Ǳ��㳡,����Ͽ·,����Ͽ��,̨����·,�ŵ��Ľ�,ʯ��㳡,��Ͽ����,�Ĵ�·,���Ž�,����·,�ϴ�㳡,����·,������,����·,��Ұ����,�����㳡,��̨��,����·,���ս�,����·,��Ұ�㳡,�۳�·,���ϴ���,����·,������,���ع㳡,��ؽ�,��ɽ·,��ˮ��,����·,�������,�ŵ�·,������,����·,��ƽ��,��ׯ�㳡,���ݽ�,����·,�Ϻ�����,����·,�ĵǹ㳡,�ź�ɽ֧·,�Ӱ�һ��,�ź�ɽ·,�˰�֧��,��ɽ֧�㳡,�쵺֧����,���߶�·,����һ��,�����·,���һ�㳡,����ɽ·,��ɽ֧��,�����·,���ض�����,����һ�㳡,��ڶ���,����·,���ڽ�,��ɽ·,��ɽ�㳡,Ҵ��·,��ɽ����,�쵺·,���ݽ�,��ѧ�㳡,������,���·,������,����·,�ŵ����,��ɽ·,���ݽ�,��ɽ·,������,���չ㳡,������,����·,�������,�붫·,��ɽ�㳡,��ɽ·,Ĳƽ��,�Ӱ���·,�Ӽ���,�Ͼ��㳡,����������,������·,���ڽ�,ɽ��·,���˹㳡,֥Ȫ·,�����н�,����·,���������,¡�¹㳡,���ݽ�,����·,̫ƽ��һ��,������֧·,̫ƽ�Ƕ��㳡,��̨��һ·,̫ƽ��������,����·һ·,���ݽֶ���,����һ֧�㳡,̫ƽ������,̫ƽ����·,��̨������,̫ƽ����·,����������,������·,����֧��,���Ŷ�·,�����Ľ�,��Ңһ�㳡,����֧��,�����·,���˶�����,�κ���·,��̨һ�㳡,��տ��·,��������,��տ֧·,տɽ���,̩�����㳡,տɽ�Ĵ���,������·,�����Ľ�,�Ϻ�֧·,�������㳡,������·,տɽ����,�����´���,���ϴ���,����һ�㳡,�麣����,������·,���ʺ���,տɽ��·,�������㳡,̩�ݶ�·,����һ����,��̨��·,΢ɽ����,��ͥ���㳡,�麣֧��,������·,�κ�����,̩����·,����д���,������·,��տ����,����һ·,�����ؽ�,����ع㳡,�����Ľ�,��տһ·,����һ����,������,�����߹㳡,̩��һ·,̩������,��Ң��·,���һ��,�������㳡,����һ����,����֧·,տɽһ��,������·,����󵺺��ȹع㳡,��Ң��·,����֧��,��տ��·,��ң������,���žŹ㳡,̩�����,�κ�һ·,���Ű˽�,���ݱ�·,�麣һ�㳡,������·,�ٻ��ش���,�����·,�Ͼ��ؽ�,��ʤ�ع㳡,��ңһ��,��տ��·,��ӹ�ؽ�,ɽ����·,۶��������,��տ·,���ݽ�,����·,������,����㳡,������,̨��·,���˴���,����·,����㳡,�κ�·,�����,����·,�򽭽�,ʯ���㳡,���˴���,����·,���ڽ�,����·,���ֹ㳡,����,̨���,��̨·,�������,���۹㳡,������,����·,�ƻ���,�ٳ�·,���Ź㳡,���·,��������,̨��·,���ҽ�,�����㳡,���½�,��Ȫ·,��ˮ��,����·,�û�����,����·,̩�ݽ�,̫��·,������,̩�˹㳡,����,����·,��ͨ����,캵�·,��Ȫ�㳡,����·,Ȫ�ݽ�,�綫·,���,ȵɽ�㳡,��������,����·,�����,����·,��ƽ�㳡,��տ·,��͡��,տɽ·,���ݴ���,���ع㳡,��ͷ��,����·,�ƺ���,����·,��¡�㳡,�ع�·,��������,�°�·,�ɾӽ�,�����㳡,������,����·,�麣��,�Ϻ�·,���δ���,��ƽ·,�γǽ�,����·,�²���,����㳡,�г�����,���綫·,�г�������,�Ϻ�֧·,���֧�㳡,������·,�г�γ��,������·,����֧��,����֧�㳡,С��һ����,�г�һ·,С�۶���,��ƽ·,�㶫�㳡,�½�·,��ƽ��,��ͨ·,С����,�����㳡,���ƽ�,��ƽ·,�����,����·,���ȹ㳡,ƽ��·,�Ľ����,����·,������,���ع㳡,��˳��,����·,����,��ī·,�ۻ�����,�ۻ�·,���ս�,�ռ�·,������,����㳡,���Ľ�,����·,���ش���,�Ϻ�·,��ɽ�㳡,�䶨·,�����,����·,�����,��ǹ㳡,�ĳǴ���,����·,�׿ڽ�,����·,���ݹ㳡,����·,��Զ��,����·,����ͷ,����㳡,��ǽ�,����·,������,����·,�����,����·,�γ������,���γһ·,��ˮɽ֧��,���γһ�㳡,���γ����,���γ��·,���γ�Ľ�,���γ��·,��馶�����,����֧·,����Ľ�,�ռ�֧·,�������,��̨֧�㳡,�������,���һ·,��ˮɽ����,̩ɽ֧·,���һ�㳡,�����·,����֧��,��۶�·,����֧��,��ƽ�㳡,��Է����,��ɽ·,�����,����·,�۽��㳡,�Ͻ�·,������,����·,��̨����,��̨�㳡,������,����·,�����,����·,��ǹ㳡,�̺�·,�ȺӴ���,����·,�е½�,�ʹ��㳡,�ɱ���,����·,�涼��,�ɽ�·,��ͤ����,����·,��̨��,��ͷ·,��馽�,��ɽ�㳡,���ݽ�,��̨·,�˰�����,��ƽ·,�����㳡,����·,������,����·,�ຣ��,̩ɽ�㳡,�ܴ����,��ƽ·,̨�����߽�,̨������·,̨�����߹㳡,̨������·,�����,���Ŷ�·,ܽ��ɽ��,�Ӱ����㳡,����һ��,̨����·,̨��һ��,̨����·,����֧�㳡,���ɹ�·,̨���ߴ���,̨����·,����֧��,̨���˹㳡,̨������,��ƽ֧·,���ڶ���,�ຣ֧·,����֧����,���ж�·,����һ��,������·,���ƽ�,���ع㳡,�����,����·,��ɴ���,ܽ��·,���ǹ㳡,����·,��ƽ��,ƽ��·,���˽�,�ֿڹ㳡,��Ǵ���,����·,��ʢ��,����·,�����㳡,��ɽ·,��ͽ�,����·,�ÿڴ���,��ɽ�㳡,������,����·,˳�˽�,����·,�����㳡,�˺�·,���ڴ���,Ӫ��·,���ؽ�,��ׯ�㳡,��ʢ��,����·,������,����·,��ϴ���,ɣ��·,մ����,ɽ��·,������,�Ͽڹ㳡,���˽�,ͨ��·,���´���,���·,�ٹ�㳡,����·,���ֽ�,����·,�Ͼ�ˮ��,̨տ�㳡,�������,�շ�·,̫ƽɽ,��ɽ·,��Ϫ�㳡,̫��·"
			.split(",");
	private static final String[] email_suffix = "@gmail.com,@yahoo.com,@msn.com,@hotmail.com,@aol.com,@ask.com,@live.com,@qq.com,@0355.net,@163.com,@163.net,@263.net,@3721.net,@yeah.net,@googlemail.com,@126.com,@sina.com,@sohu.com,@yahoo.com.cn"
			.split(",");

	private static final String[] department = "������Դ���ţ���Ӫ���ţ���Ϣ�������ţ������ţ����ۺ��г����ţ��ͻ������ţ��ɹ����ţ������ţ��о��ͷ�չ����".split("��");

	private static final String[] nation = "�ɹ��塢���塢���塢���塢ά����塢���塢׳�塢�����塢���塢�����塢���塢�����塢�������塢���塢�����塢���塢 ���Ӷ��塢�����塢��ɽ�塢�����塢�¶������塢�����塢�����塢��塢���塢���塢�����塢�����塢Ǽ�塢ˮ�塢���塢���塢�����塢�����塢ë���塢�����塢�����塢�������塢�����塢�����塢�����塢�°��塢����˹�塢���¿��塢���塢ŭ�塢���α���塢ԣ���塢�����塢���״��塢�����塢��ŵ�塢����塢�Ű��塢�������塢����"
			.split("��");

	private static final String[] degree = "�ޣ�Сѧ��������ѧ���߼���ѧ��ר�ƣ����ƣ�˶ʿ�о�������ʿ�о���".split("��");

	private static final String[] title = "�������м������߼������߼�".split("��");;

	public static int getNum(int start, int end) {
		return (int) (Math.random() * (end - start + 1) + start);
	}

	public static String getDepartments() {
		return String.join("-", department);
	}

	public static String getDegrees() {
		return String.join("-", degree);
	}

	public static String getTitles() {
		return String.join("-", title);
	}

	/**
	 * �������Email
	 * 
	 * @param lMin
	 *            ��С����
	 * @param lMax
	 *            ��󳤶�
	 * @return
	 */
	public static String getEmail(int lMin, int lMax) {
		int length = getNum(lMin, lMax);
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < length; i++) {
			int number = (int) (Math.random() * base.length());
			sb.append(base.charAt(number));
		}
		sb.append(email_suffix[(int) (Math.random() * email_suffix.length)]);
		return sb.toString();
	}

	/**
	 * ��������ֻ�����
	 */
	private static String[] telFirst = "134,135,136,137,138,139,150,151,152,157,158,159,130,131,132,155,156,133,153"
			.split(",");

	private static String getTel() {
		int index = getNum(0, telFirst.length - 1);
		String first = telFirst[index];
		String second = String.valueOf(getNum(1, 888) + 10000).substring(1);
		String thrid = String.valueOf(getNum(1, 9100) + 10000).substring(1);
		return first + second + thrid;
	}

	/**
	 * ���������������
	 */
	private static String name_sex = "";

	private static String getChineseName() {
		int index = getNum(0, firstName.length() - 1);
		String first = firstName.substring(index, index + 1);
		int sex = getNum(0, 1);
		String str = boy;
		int length = boy.length();
		if (sex == 0) {
			str = girl;
			length = girl.length();
			name_sex = "Ů";
		} else {
			name_sex = "��";
		}
		index = getNum(0, length - 1);
		String second = str.substring(index, index + 1);
		int hasThird = getNum(0, 1);
		String third = "";
		if (hasThird == 1) {
			index = getNum(0, length - 1);
			third = str.substring(index, index + 1);
		}
		return first + second + third;
	}

	/**
	 * ������ɵ�ַ
	 * 
	 * @return
	 */
	private static String getRoad() {
		int index = getNum(0, road.length - 1);
		String first = road[index];
		String second = String.valueOf(getNum(11, 150)) + "��";
		String third = "-" + getNum(1, 20) + "-" + getNum(1, 10);
		return first + second + third;
	}

	/**
	 * ������ɲ���
	 * 
	 * @return
	 */
	private static String getDepartment() {
		int index = getNum(0, department.length - 1);
		String depart = department[index];
		return depart;
	}

	/**
	 * �����������
	 * 
	 * @return
	 */
	private static String getNation() {
		int index = getNum(0, nation.length - 1);
		String nat = nation[index];
		return nat;
	}

	/**
	 * �������ѧ��
	 * 
	 * @return
	 */
	private static String getDegree() {
		int index = getNum(0, degree.length - 1);
		String degr = degree[index];
		return degr;
	}

	/**
	 * �������ְλ
	 * 
	 * @return
	 */
	private static String getTitle() {
		int index = getNum(0, title.length - 1);
		String tit = title[index];
		return tit;
	}

	/**
	 * �������֤�Ż�ȡ����
	 *
	 * @param idCard
	 *            ���֤��
	 * @return ����
	 */
	public static int getAgeByIdCard(String idCard) {
		int iAge = 0;
		Calendar cal = Calendar.getInstance();
		String year = idCard.substring(6, 10);
		int iCurrYear = cal.get(Calendar.YEAR);
		iAge = iCurrYear - Integer.valueOf(year);
		return iAge;
	}

	/**
	 * �������֤��Ż�ȡ����
	 *
	 * @param idCard
	 *            ���֤��
	 * @return ����(yyyyMMdd)
	 */
	public static String getBirthByIdCard(String idCard) {
		return idCard.substring(6, 14);
	}

	/**
	 * �������֤�Ż�ȡ������
	 *
	 * @param idCard
	 *            ���֤��
	 * @return ����(yyyy)
	 */
	public static Short getYearByIdCard(String idCard) {
		return Short.valueOf(idCard.substring(6, 10));
	}

	/**
	 * �������֤��Ż�ȡ������
	 *
	 * @param idCard
	 *            ���֤��
	 * @return ����(MM)
	 */
	public static Short getMonthByIdCard(String idCard) {
		return Short.valueOf(idCard.substring(10, 12));
	}

	/**
	 * �������֤�Ż�ȡ������
	 *
	 * @param idCard
	 *            ���֤��
	 * @return ����(dd)
	 */
	public static Short getDateByIdCard(String idCard) {
		return Short.valueOf(idCard.substring(12, 14));
	}

	/**
	 * �������֤�Ż�ȡ�Ա�
	 *
	 * @param idCard
	 *            ���֤��
	 * @return �Ա�(M-�У�F-Ů��N-δ֪)
	 */
	public static String getGenderByIdCard(String idCard) {
		String sGender = "δ֪";

		String sCardNum = idCard.substring(16, 17);
		if (Integer.parseInt(sCardNum) % 2 != 0) {
			sGender = "��";// 1
		} else {
			sGender = "Ů";// 2
		}
		// System.out.println(idCard);
		// System.out.println(sCardNum);
		return sGender;
	}

	/**
	 * ���ݲ�������Զ�����Ա�����
	 * 
	 * @param depart
	 * @return
	 */
	public static String getID(String depart) {
		StringBuffer ID = new StringBuffer();
		String[] s = RandomValue.getDepartments().split("-");
		for (int i = 0; i < s.length; i++) {
			//System.out.println(s[i]);
			if (depart.equals(s[i])) {
				ID.append("0" + (i + 1));
				SimpleDateFormat df1 = new SimpleDateFormat("yyMMdd");// �������ڸ�ʽ
				String numDate = df1.format(new Date());
				String line = null;
				int id;
				try {
					line = FileControl.readFile();
					//System.out.println(":" + line);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				String[] str = line.split("-");
				ID.append(numDate);
				if (str[0].equals(numDate)) {// �ļ��еı�����ںͽ��������һ��
					id = Integer.valueOf(str[1]);
				} else {// �ļ��еı�����ڲ�һ�£���1����
					id = 1;
				}
				ID.append(String.format("%04d", id));
				//System.out.println(ID);
				break;
			}
		}
		return ID.toString();
	}
	/**
	 * ��ȡԱ����Ϣ
	 * @return
	 */
	public static String getData() {
		String idcard = new IdCardGenerator().generate();
		if (idcard.length() == 18) {
			String sex = getGenderByIdCard(idcard);
			int age = getAgeByIdCard(idcard);
			Short nian = getYearByIdCard(idcard);
			Short yue = getMonthByIdCard(idcard);
			Short ri = getDateByIdCard(idcard);
			String sr = getBirthByIdCard(idcard);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// �������ڸ�ʽ
			String depart = getDepartment();
			String ID = getID(depart);

			/*System.out.println(ID + "��" + getChineseName() + "��" + idcard + "��" + getNation() + "��" + sex + "��" + sr
					+ "��" + getDegree() + "��" + depart + "��" + getTitle() + "��" + getRoad() + "��" + getTel() + "��"
					+ getEmail(6, 9) + "��" + df.format(new Date())+"");*/
			return ID + "��" + getChineseName() + "��" + idcard + "��" + getNation() + "��" + sex + "��" + sr + "��"
					+ getDegree() + "��" + depart + "��" + getTitle() + "��" + getRoad() + "��" + getTel() + "��"
					+ getEmail(6, 9) + "��" + df.format(new Date()) +"��"+ "��";
		}
		return null;
	}

	public static void main(String[] args) throws SQLException {
		String str = null;
		long begin = System.currentTimeMillis();
		for (int i = 0; i < 2000; i++) {
			str = getData();
			// System.out.println(str);
			if (str == null || str.length() == 0) {
				i--;
				continue;
			}
			String[] s = str.split("��");
			Employee em = new Employee();
			em.setEmployeeID(s[0]);
			em.setName(s[1]);
			em.setCardNumber(s[2]);
			em.setNation(s[3]);
			em.setSex(s[4]);
			em.setBirthday(s[5]);
			em.setSchoolRecord(s[6]);
			em.setDepartment(s[7]);
			em.setPositionName(s[8]);
			em.setRoad(s[9]);
			em.setTellphone(s[10]);
			em.setEmail(s[11]);
			em.setEditTime(s[12]);
			em.setInfo(s[13]);
			try {
				EmloyeeServiceFactory.getIEmpServiceInstance().insert(em);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		long end2 = System.currentTimeMillis();
		System.out.println("��������ʱ��Ϊ��" + (end2 - begin));

	}
}
