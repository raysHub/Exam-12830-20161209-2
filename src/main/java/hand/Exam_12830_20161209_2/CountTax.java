package hand.Exam_12830_20161209_2;

import java.util.Scanner;

public class CountTax {

	public static float countTax(float salary) {
		float tax = 0;
		if (salary < 3500) {
			return 0;
		}
		// 工资减去起征点（还要五险一金是0就不减了）
		int m = Math.round(salary - 3500);
		// 征税级数
		int grade;
		// 判断所在等级
		if (m <= 1500) {
			grade = 1;
		} else if (m > 1500 && m <= 4500) {
			grade = 2;
		} else if (m > 4500 && m <= 9000) {
			grade = 3;
		} else if (m > 9000 && m <= 35000) {
			grade = 4;
		} else if (m > 35000 && m <= 55000) {
			grade = 5;
		} else if (m > 55000 && m <= 80000) {
			grade = 6;
		} else {
			grade = 7;
		}
		// 根据等级计算所得税
		switch (grade) {
		case 1:
			tax = m * 0.03f;
			break;
		case 2:
			tax = (m-1500) * 0.1f+45;
			break;
		case 3:
			tax = (m-8000) * 0.2f + 345;
			break;
		case 4:
			tax = (m-12500) * 0.25f + 545;
			break;
		case 5:
			tax = (m-38500) * 0.3f + 6170;
			break;
		case 6:
			tax = (m-58500) * 0.35f + 11120;
			break;
		case 7:
			tax = (m-83500) * 0.45f + 18645;
			break;

		default:
			break;
		}
		// 返回保留两位小数的所得税
		return (float) (Math.round(tax * 100)) / 100;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("请输入工资：");
		float salary = scan.nextFloat();
		scan.close();
		System.out.println("所需要缴纳的税费为：" + countTax(salary) + "元");
	}

}
