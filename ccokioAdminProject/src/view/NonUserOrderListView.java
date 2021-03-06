package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.Controllers;
import domain.NonUserOrder;

public class NonUserOrderListView {

	private Scanner keyboard;

	public NonUserOrderListView() {

		this.keyboard = new Scanner(System.in);

	}

	public void nonUserOrderList(ArrayList<NonUserOrder> orders) {

		int sumPrice = 0;
		System.out.println("[주문 내역 목록 모드]");
		System.out.println("주문 번호\t비회원 전화번호\t제품 이름\t제품 가격\t수량\t합계금액");
		if (orders.size() == 0) {
			System.out.println("주문된 제품이 없습니다.");
		} else {
			for (int i = 0; i < orders.size(); i++) {
				System.out.print(orders.get(i).getNonUserOrderNumber() + "\t");
				System.out.print(orders.get(i).getNonUserTel() + "\t\t");
				System.out.print(orders.get(i).getProductName() + "\t");
				System.out.print(orders.get(i).getProductPrice() + "\t");
				System.out.print(orders.get(i).getOrderAmount() + "\t");
				System.out.println(orders.get(i).getTotalPrice());
				sumPrice = sumPrice + orders.get(i).getTotalPrice();
			}

			System.out.println("총 합계 : " + sumPrice);
		}

		Controllers.getNonUserOrderController().requestNonUserOrderMenuList();

	}

	public void nonUserOrderMenuList() {

		while (true) {
			try {
				
				System.out.print("[1. 메인메뉴 돌아가기] : ");

				int selectedMenu = keyboard.nextInt();

				switch (selectedMenu) {

				case 1:
					Controllers.getLoginController().requestCheckLogin();
					break;
				default:
					System.out.println("메뉴를 다시 선택해주세요.");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("올바른 입력을 입력해주세요.");
				Controllers.getNonUserOrderController().requestNonUserOrderMenuList();
			}
			
		}

	}

}
