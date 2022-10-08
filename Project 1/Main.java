package Bank_Wallet;

import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;


// Transaction class - transaction done by family members
class Transactions{
	int amount;
	String done_by;
	String time;
	String comment;
	Transactions(int a,String d,String t,String c){
		amount=a;
		done_by=d;
		time=t;
		comment=c;
	}
}

// Request class - request raise by other family members 
class Request{
	String Raise_by;  //Family member who raise this request
	String Raise_for;  // Family member who raise this request for
	String comment;  // any comment for request
	boolean done;  // this request is already done or not
	int check;   // int value to check which type of request is this
	boolean reject;  // this request is rejected or not
	Request(String r1,String r2,String c,boolean b,int ch,boolean r){
		Raise_by=r1;
		Raise_for=r2;
		comment=c;
		done=b;
		check=ch;
		reject=r;
	}
	
	/***
	 * Check
	 * 1. permission_count
	 * 2. for today's permission
	 */
}

// Dad class that do such things - explained using Methods
class Dad{
	String name;
	static Scanner input=new Scanner(System.in);
	Dad(String name){
		this.name=name;
	}
	// This method add money from Bank1 to wallet
	static void add_money_from_bank1() {
		if(Main.bank1_balance>=0) { 
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		    String formattedDate = myDateObj.format(myFormatObj);
			System.out.println("How much money you want to add from Bank1?");
			int x=input.nextInt();
			if(x>=0) {
				if(x<=Main.bank1_balance) {
					Main.wallet+=x;
					System.out.println("Successfully,Money is added to Wallet");
					Main.transaction.add(new Transactions(x,"Dad",formattedDate,"Added to wallet from Bank1"));
					return;
				}else {
					System.out.println("Sorry, you cann't exceed more than your Bank1 balance in your wallet");
					return;
				}
			}else {
				System.out.println("Please add valid amount");
				return;
			}
		}else {
			System.out.println("Your Bank1 balance is empty!!");
			return;
		}
	}
	// Dad can add money from Bank 2
	static void add_money_from_bank2() {
		if(blockedD==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		if(Main.bank2_balance>=0) {
			// Below 3 lines checking for TimeStamp of Transaction
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		    String formattedDate = myDateObj.format(myFormatObj);
			System.out.println("How much money you want to add from Bank2?");
			int x=input.nextInt();
			if(x>=0) {
				if(x<=Main.bank2_balance) {
					Main.wallet+=x;
					System.out.println("Successfully,Money is added to Wallet");
					Main.transaction.add(new Transactions(x,"Dad",formattedDate,"Added to Wallet from Bank2"));
				}else {
					System.out.println("Sorry, you cann't exceed more than your Bank2 balance in your wallet");
				}
			}else {
				System.out.println("Please add valid amount");
			}
		}else {
			System.out.println("Your Bank2 balance is empty!!");
		}
	}
	// Dad can withdraw money from wallet
	static void withdraw_money() {
		System.out.println("How much money you want to withdraw?");
		int withdraw=input.nextInt();
		if(withdraw<0) {
			System.out.println("Please Enter Valid amount");
		}else {
			if(withdraw<=Main.wallet) {
				Main.wallet=Main.wallet-withdraw;
				System.out.println("Withdraw Successfully!!");
				System.out.printf("Now Wallet Balance is\n",Main.wallet);
				LocalDateTime myDateObj = LocalDateTime.now();
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			    String formattedDate = myDateObj.format(myFormatObj);
			    Main.transaction.add(new Transactions(withdraw,"Dad",formattedDate,"Withdraw money from wallet"));
			}else {
				System.out.println("Please Enter Valid amount");
			}
		}
	}
	// Dad can see all transactions
	static void view_all_transactions() {
		int len=Main.transaction.size();
		if(len==0) {
			System.out.println("Sorry, No Entry found in Account Statement");
		}else {
			System.out.println("=============  ALL TRANSACTIONS =============");
			for (int i=0;i<len;i++)
			{
				System.out.printf("****  Transaction %d ***\n",i+1);
				System.out.println("Amount is: "+Main.transaction.get(i).amount);
				System.out.println("Payment Done By: "+Main.transaction.get(i).done_by);
				System.out.println("Time Stamp of transaction: "+Main.transaction.get(i).time);
				System.out.println("Any Comment: "+Main.transaction.get(i).comment);
			}
		}
	}
	// Dad can see all request raised by other family members
	static void see_all_requests() {
		int len=Main.request.size();
		if(len==0) {
			System.out.println("There are no requests pending!!");
		}else {
			System.out.println("======  ALL PENDING REQUESTS FOR DAD =====");
			//int c=0;
			for (int i=0;i<len;i++)
			{
				Request r1=Main.request.get(i);
				if(r1.Raise_for=="Dad" && r1.done==false && r1.reject==false) {
					System.out.printf("*** Pending Request ***\n");
					System.out.println("Request Raise By: "+r1.Raise_by);
					System.out.println("Any Comment on Request: "+r1.comment);
					System.out.println("Want to take action against this request?\n if yes then Enter 1 else 2");
					int temp=input.nextInt();
					if(temp==1) {
						if(r1.check==1) {  //for permission_count
							r1.done=true;
							if(r1.Raise_by=="child1") {
								child1.permission_count1++;
							}else if(r1.Raise_by=="child2") {
								child2.permission_count2++;
							}else if(r1.Raise_by=="child3") {
								child3.permission_count3++;
							}else if(r1.Raise_by=="child4") {
								child4.permission_count4++;
							}else if(r1.Raise_by=="child5") {
								child5.permission_count5++;
							}else if(r1.Raise_by=="child6") {
								child6.permission_count6++;
							}else if(r1.Raise_by=="child7") {
								child7.permission_count7++;
							}else if(r1.Raise_by=="child8") {
								child8.permission_count8++;
							}
							System.out.println("Successfully, Now this request is completed");
						}else {
							System.out.println("What you want to do?\n 1. Accept the Request\n2. Reject the Request");
							int temp1=input.nextInt();
							if(temp1==1) {
								r1.done=true;
								System.out.println("Successfully, Now this request is completed");
							}else if(temp1==2) {
								r1.reject=true;
								System.out.println("Request is rejected successfully");
							}else {
								System.out.println("Please enter valid number");
							}
						}
					}else {
						System.out.println("Okay");
					}
				}
				
			}
		}
	}
	// Dad can see motifications
	static void view_all_notifications() {
		if (Main.wallet<=100){
			System.out.println("Attention!! Wallet Balance is less than 100$");
		}else {
			System.out.println("There are no Notifications");
		}
	}
	// Dad can block any family member
	static void Block_Member() {
		System.out.println("Whom you want to block From this Wallet System?");
		System.out.println("1. Child1\n2. Child2\n3. Child3\n4. Child4\n5. Child5\n6. Child 6\n7. Child 7\n8. Child 8\n9. Mom");
		int temp1=input.nextInt();
		if(temp1==1) {
			child1.blocked1=true;
		}else if(temp1==2) {
			child2.blocked2=true;
		}else if(temp1==3) {
			child3.blocked3=true;
		}else if(temp1==4) {
			child4.blocked4=true;
		}else if(temp1==5) {
			child5.blocked5=true;
		}else if(temp1==6) {
			child6.blocked6=true;
		}else if(temp1==7) {
			child7.blocked7=true;
		}else if(temp1==8) {
			child8.blocked8=true;
		}else if(temp1==9) {
			Mom.blockedM=true;
		}else {
			System.out.println("Please Enter Valid Number");
		}
	}
	// Dad can unblock any family member
	static void UnBlock_Member() {
		System.out.println("Whom you want to unblock From this Wallet System?");
		System.out.println("1. Child1\n2. Child2\n3. Child3\n4. Child4\n5. Child5\n6. Child 6\n7. Child 7\n8. Child 8\n9. Mom");
		int temp1=input.nextInt();
		if(temp1==1) {
			child1.blocked1=false;
		}else if(temp1==2) {
			child2.blocked2=false;
		}else if(temp1==3) {
			child3.blocked3=false;
		}else if(temp1==4) {
			child4.blocked4=false;
		}else if(temp1==5) {
			child5.blocked5=false;
		}else if(temp1==6) {
			child6.blocked6=false;
		}else if(temp1==7) {
			child7.blocked7=false;
		}else if(temp1==8) {
			child8.blocked8=false;
		}else if(temp1==9) {
			Mom.blockedM=false;
		}else {
			System.out.println("Please Enter Valid Number");
		}
	}
}

// Mom class
class Mom{
	static Scanner input=new Scanner(System.in);
	public static boolean blockedM=false;
	String name;
	Mom(String name){
		this.name=name;
	}
	static void add_money_from_bank1() {
		if(blockedM==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		if(Main.bank1_balance>=0) {
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		    String formattedDate = myDateObj.format(myFormatObj);
			System.out.println("How much money you want to add from Bank1?");
			int x=input.nextInt();
			if(x>=0) {
				if(x<=Main.bank1_balance) {
					Main.wallet+=x;
					System.out.println("Successfully,Money is added to Wallet");
					Main.transaction.add(new Transactions(x,"Mom",formattedDate,"Added to wallet from Bank1"));
					
				}else {
					System.out.println("Sorry, you cann't exceed more than your Bank1 balance in your wallet");
				}
			}else {
				System.out.println("Please add valid amount");
			}
		}else {
			System.out.println("Your Bank1 balance is empty!!");
		}
	}
	static void add_money_from_bank2() {
		if(blockedM==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		if(Main.bank2_balance>=0) {
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		    String formattedDate = myDateObj.format(myFormatObj);
			System.out.println("How much money you want to add from Bank2?");
			int x=input.nextInt();
			if(x>=0) {
				if(x<=Main.bank2_balance) {
					Main.wallet+=x;
					System.out.println("Successfully,Money is added to Wallet");
					Main.transaction.add(new Transactions(x,"Mom",formattedDate,"Added to wallet from Bank1"));
				}else {
					System.out.println("Sorry, you cann't exceed more than your Bank2 balance in your wallet");
				}
			}else {
				System.out.println("Please add valid amount");
			}
		}else {
			System.out.println("Your Bank2 balance is empty!!");
		}
	}
	static void withdraw_money() {
		if(blockedM==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		System.out.println("How much money you want to withdraw?");
		int withdraw=input.nextInt();
		if(withdraw<0) {
			System.out.println("Please Enter Valid amount");
		}else {
			if(withdraw<=Main.wallet) {
				Main.wallet=Main.wallet-withdraw;
				System.out.println("Withdraw Successfully!!");
				System.out.printf("Now Wallet Balance is\n",Main.wallet);
				LocalDateTime myDateObj = LocalDateTime.now();
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			    String formattedDate = myDateObj.format(myFormatObj);
			    Main.transaction.add(new Transactions(withdraw,"Mom",formattedDate,"Withdraw money from wallet"));
			}else {
				System.out.println("Please Enter Valid amount");
			}
		}
	}
	static void view_all_transactions() {
		if(blockedM==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		int len=Main.transaction.size();
		if(len==0) {
			System.out.println("Sorry, No Entry found in Account Statement");
		}else {
			System.out.println("=============  ALL TRANSACTIONS =============");
			for (int i=0;i<len;i++)
			{
				System.out.printf("****  Transaction %d ***\n",i+1);
				System.out.println("Amount is: "+Main.transaction.get(i).amount);
				System.out.println("Payment Done By: "+Main.transaction.get(i).done_by);
				System.out.println("Time Stamp of transaction: "+Main.transaction.get(i).time);
				System.out.println("Any Comment: "+Main.transaction.get(i).comment);
			}
		}
	}
	static void see_all_requests() {
		if(blockedM==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		int len=Main.request.size();
		if(len==0) {
			System.out.println("There are no requests pending!!");
		}else {
			System.out.println("======  ALL PENDING REQUESTS FOR MOM =====");
			for (int i=0;i<len;i++)
			{
				Request r1=Main.request.get(i);
				if(r1.Raise_for=="Mom" && r1.done==false && r1.reject==false) {
					System.out.printf("*** Pending Request  ***\n");
					System.out.println("Request Raise By: "+r1.Raise_by);
					System.out.println("Any Comment on Request: "+r1.comment);
					System.out.println("Want to take action against this request?\n if yes then Enter 1 else 2");
					int temp=input.nextInt();
					if(temp==1) {
						if(r1.check==1) {  //for permission_count
							r1.done=true;
							if(r1.Raise_by=="child1") {
								child1.permission_count1++;
							}else if(r1.Raise_by=="child2") {
								child2.permission_count2++;
							}else if(r1.Raise_by=="child3") {
								child3.permission_count3++;
							}else if(r1.Raise_by=="child4") {
								child4.permission_count4++;
							}else if(r1.Raise_by=="child5") {
								child5.permission_count5++;
							}else if(r1.Raise_by=="child6") {
								child6.permission_count6++;
							}else if(r1.Raise_by=="child7") {
								child7.permission_count7++;
							}else if(r1.Raise_by=="child8") {
								child8.permission_count8++;
							}
							System.out.println("Successfully, Now this request is completed");
						}
					}else {
						System.out.println("What you want to do?\n 1. Accept the Request\n2. Reject the Request\n3. Transfer the Request to Dad");
						int temp1=input.nextInt();
						if(temp1==1) {
							r1.done=true;
							System.out.println("Successfully, Now this request is completed");
						}else if(temp1==2) {
							r1.reject=true;
							System.out.println("Request is rejected successfully");
						}else {
							Main.request.add(new Request(r1.Raise_by,"Dad","Transfer by Mom",false,2,false));
							System.out.println("Your Request is successfully transfer to Dad");
						}
					}
				}
				
			}
		}
	}
	static void view_all_notifications() {
		if(blockedM==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		if (Main.wallet<=100){
			System.out.println("Attention!! Wallet Balance is less than 100$");
		}else {
			System.out.println("There are no Notifications");
		}
	}
}

// child1 class that can do 2 things - withdrawn money, ask permission to access wallet
class child1
{
	static String name1;
	public static boolean blocked1=false;
	static Scanner input=new Scanner(System.in);
	public static int permission_count1=0;
	public static int today_pay1=0;
	child1(String n,int p){
		name1=n;
		permission_count1=p;
	}
	static void pay_money_from_wallet(){
		if(blocked1==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		if(permission_count1>=2) {
			System.out.println("How much money you want to withdraw from wallet?");
			int temp1=input.nextInt();
			if(temp1+today_pay1<=50) {
				Main.wallet-=temp1;
				System.out.println("You are successfully withdrawn money");
				LocalDateTime myDateObj = LocalDateTime.now();
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			    String formattedDate = myDateObj.format(myFormatObj);
				Main.transaction.add(new Transactions(temp1,"child1",formattedDate,"Amount is debited from Wallet"));
			}else {
				System.out.println("Sorry, you cann't exceed today's pay money by 50");
				System.out.println("Want to ask permission from Mom?");
				System.out.println("if yes, then enter 1 else 2");
				int ask=input.nextInt();
				if(ask==1) {
					//ask from Mom for payment permission
					Main.request.add(new Request("child1","Mom","Request for greater than 50$ for today's",false,2,false));
					System.out.println("Request sent to Mom for payment permission");
				}else {
					System.out.println("Please Enter Valid Number");
				}
			}
		}else {
			System.out.println("You cann't withdrawn money, because your today permission count<2");
			System.out.println("Want to ask permission from Dad or Mom?");
			System.out.println("if yes, then enter 1 else 2");
			int ask=input.nextInt();
			if(ask==1) {
				//ask from Mom for permission_count
				Main.request.add(new Request("child1","Mom","Request for today permission to access wallet",false,1,false));
				Main.request.add(new Request("child1","Dad","Request for today permission to access wallet",false,1,false));
				System.out.println("Permission for today wallet access permission is gone to Dad or Mom");
			}else {
				System.out.println("Please Enter Valid Number");
			}
		}
	}
	static void Ask_permission_for_permissionCount() {
		if(blocked1==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		if(permission_count1>=2) {
			System.out.println("You don't need today's permission for accessing the wallet");
		}else {
			Main.request.add(new Request("child1","Mom","Request for today permission to access wallet",false,1,false));
			Main.request.add(new Request("child1","Dad","Request for today permission to access wallet",false,1,false));
			System.out.println("Permission for today wallet access permission is gone to Dad and Mom");
		}
	}
}

class child2
{
	static String name2;
	public static boolean blocked2=false;
	static Scanner input=new Scanner(System.in);
	public static int permission_count2=0;
	public static int today_pay2=0;
	child2(String n,int p){
		name2=n;
		permission_count2=p;
	}
	static void pay_money_from_wallet(){
		if(blocked2==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		if(permission_count2>=2) {
			System.out.println("How much money you want to withdraw from wallet?");
			int temp1=input.nextInt();
			if(temp1+today_pay2<=50) {
				Main.wallet-=temp1;
				System.out.println("You are successfully withdrawn money");
				LocalDateTime myDateObj = LocalDateTime.now();
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			    String formattedDate = myDateObj.format(myFormatObj);
				Main.transaction.add(new Transactions(temp1,"child2",formattedDate,"Amount is debited from Wallet"));
			}else {
				System.out.println("Sorry, you cann't exceed today's pay money by 50");
				System.out.println("Want to ask permission from Mom?");
				System.out.println("if yes, then enter 1 else 2");
				int ask=input.nextInt();
				if(ask==1) {
					//ask from Mom for payment permission
					Main.request.add(new Request("child2","Mom","Request for greater than 50$ for today's",false,2,false));
					System.out.println("Request sent to Mom for payment permission");
				}else {
					System.out.println("Please Enter Valid Number");
				}
			}
		}else {
			System.out.println("You cann't withdrawn money, because your today permission count<2");
			System.out.println("Want to ask permission from Dad or Mom?");
			System.out.println("if yes, then enter 1 else 2");
			int ask=input.nextInt();
			if(ask==1) {
				//ask from Mom for permission_count
				Main.request.add(new Request("child2","Mom","Request for today permission to access wallet",false,1,false));
				Main.request.add(new Request("child2","Dad","Request for today permission to access wallet",false,1,false));
				System.out.println("Permission for today wallet access permission is gone to Dad or Mom");
			}else {
				System.out.println("Please Enter Valid Number");
			}
		}
	}
	static void Ask_permission_for_permissionCount() {
		if(blocked2==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		if(permission_count2>=2) {
			System.out.println("You don't need today's permission for accessing the wallet");
		}else {
			Main.request.add(new Request("child2","Mom","Request for today permission to access wallet",false,1,false));
			Main.request.add(new Request("child2","Dad","Request for today permission to access wallet",false,1,false));
			System.out.println("Permission for today wallet access permission is gone to Dad and Mom");
		}
	}
}

class child3
{
	static String name3;
	public static boolean blocked3=false;
	static Scanner input=new Scanner(System.in);
	public static int permission_count3=0;
	public static int today_pay3=0;
	child3(String n,int p){
		name3=n;
		permission_count3=p;
	}
	static void pay_money_from_wallet(){
		if(blocked3==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		if(permission_count3>=2) {
			System.out.println("How much money you want to withdraw from wallet?");
			int temp1=input.nextInt();
			if(temp1+today_pay3<=50) {
				Main.wallet-=temp1;
				System.out.println("You are successfully withdrawn money");
				LocalDateTime myDateObj = LocalDateTime.now();
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			    String formattedDate = myDateObj.format(myFormatObj);
				Main.transaction.add(new Transactions(temp1,"child3",formattedDate,"Amount is debited from Wallet"));
			}else {
				System.out.println("Sorry, you cann't exceed today's pay money by 50");
				System.out.println("Want to ask permission from Mom?");
				System.out.println("if yes, then enter 1 else 2");
				int ask=input.nextInt();
				if(ask==1) {
					//ask from Mom for payment permission
					Main.request.add(new Request("child3","Mom","Request for greater than 50$ for today's",false,2,false));
					System.out.println("Request sent to Mom for payment permission");
				}else {
					System.out.println("Please Enter Valid Number");
				}
			}
		}else {
			System.out.println("You cann't withdrawn money, because your today permission count<2");
			System.out.println("Want to ask permission from Dad or Mom?");
			System.out.println("if yes, then enter 1 else 2");
			int ask=input.nextInt();
			if(ask==1) {
				//ask from Mom for permission_count
				Main.request.add(new Request("child3","Mom","Request for today permission to access wallet",false,1,false));
				Main.request.add(new Request("child3","Dad","Request for today permission to access wallet",false,1,false));
				System.out.println("Permission for today wallet access permission is gone to Dad or Mom");
			}else {
				System.out.println("Please Enter Valid Number");
			}
		}
	}
	static void Ask_permission_for_permissionCount() {
		if(blocked3==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		if(permission_count3>=2) {
			System.out.println("You don't need today's permission for accessing the wallet");
		}else {
			Main.request.add(new Request("child3","Mom","Request for today permission to access wallet",false,1,false));
			Main.request.add(new Request("child3","Dad","Request for today permission to access wallet",false,1,false));
			System.out.println("Permission for today wallet access permission is gone to Dad and Mom");
		}
	}
}


class child4
{
	static String name4;
	public static boolean blocked4=false;
	static Scanner input=new Scanner(System.in);
	public static int permission_count4=0;
	public static int today_pay4=0;
	child4(String n,int p){
		name4=n;
		permission_count4=p;
	}
	static void pay_money_from_wallet(){
		if(blocked4==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		if(permission_count4>=2) {
			System.out.println("How much money you want to withdraw from wallet?");
			int temp1=input.nextInt();
			if(temp1+today_pay4<=50) {
				Main.wallet-=temp1;
				System.out.println("You are successfully withdrawn money");
				LocalDateTime myDateObj = LocalDateTime.now();
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			    String formattedDate = myDateObj.format(myFormatObj);
				Main.transaction.add(new Transactions(temp1,"child4",formattedDate,"Amount is debited from Wallet"));
			}else {
				System.out.println("Sorry, you cann't exceed today's pay money by 50");
				System.out.println("Want to ask permission from Mom?");
				System.out.println("if yes, then enter 1 else 2");
				int ask=input.nextInt();
				if(ask==1) {
					//ask from Mom for payment permission
					Main.request.add(new Request("child4","Mom","Request for greater than 50$ for today's",false,2,false));
					System.out.println("Request sent to Mom for payment permission");
				}else {
					System.out.println("Please Enter Valid Number");
				}
			}
		}else {
			System.out.println("You cann't withdrawn money, because your today permission count<2");
			System.out.println("Want to ask permission from Dad or Mom?");
			System.out.println("if yes, then enter 1 else 2");
			int ask=input.nextInt();
			if(ask==1) {
				//ask from Mom for permission_count
				Main.request.add(new Request("child4","Mom","Request for today permission to access wallet",false,1,false));
				Main.request.add(new Request("child4","Dad","Request for today permission to access wallet",false,1,false));
				System.out.println("Permission for today wallet access permission is gone to Dad or Mom");
			}else {
				System.out.println("Please Enter Valid Number");
			}
		}
	}
	static void Ask_permission_for_permissionCount() {
		if(blocked4==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		if(permission_count4>=2) {
			System.out.println("You don't need today's permission for accessing the wallet");
		}else {
			Main.request.add(new Request("child4","Mom","Request for today permission to access wallet",false,1,false));
			Main.request.add(new Request("child4","Dad","Request for today permission to access wallet",false,1,false));
			System.out.println("Permission for today wallet access permission is gone to Dad and Mom");
		}
	}
}


class child5
{
	static String name5;
	public static boolean blocked5=false;
	static Scanner input=new Scanner(System.in);
	public static int permission_count5=0;
	public static int today_pay5=0;
	child5(String n,int p){
		name5=n;
		permission_count5=p;
	}
	static void pay_money_from_wallet(){
		if(blocked5==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		if(permission_count5>=2) {
			System.out.println("How much money you want to withdraw from wallet?");
			int temp1=input.nextInt();
			if(temp1+today_pay5<=50) {
				Main.wallet-=temp1;
				System.out.println("You are successfully withdrawn money");
				LocalDateTime myDateObj = LocalDateTime.now();
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			    String formattedDate = myDateObj.format(myFormatObj);
				Main.transaction.add(new Transactions(temp1,"child5",formattedDate,"Amount is debited from Wallet"));
			}else {
				System.out.println("Sorry, you cann't exceed today's pay money by 50");
				System.out.println("Want to ask permission from Mom?");
				System.out.println("if yes, then enter 1 else 2");
				int ask=input.nextInt();
				if(ask==1) {
					//ask from Mom for payment permission
					Main.request.add(new Request("child5","Mom","Request for greater than 50$ for today's",false,2,false));
					System.out.println("Request sent to Mom for payment permission");
				}else {
					System.out.println("Please Enter Valid Number");
				}
			}
		}else {
			System.out.println("You cann't withdrawn money, because your today permission count<2");
			System.out.println("Want to ask permission from Dad or Mom?");
			System.out.println("if yes, then enter 1 else 2");
			int ask=input.nextInt();
			if(ask==1) {
				//ask from Mom for permission_count
				Main.request.add(new Request("child5","Mom","Request for today permission to access wallet",false,1,false));
				Main.request.add(new Request("child5","Dad","Request for today permission to access wallet",false,1,false));
				System.out.println("Permission for today wallet access permission is gone to Dad or Mom");
			}else {
				System.out.println("Please Enter Valid Number");
			}
		}
	}
	static void Ask_permission_for_permissionCount() {
		if(blocked5==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		if(permission_count5>=2) {
			System.out.println("You don't need today's permission for accessing the wallet");
		}else {
			Main.request.add(new Request("child5","Mom","Request for today permission to access wallet",false,1,false));
			Main.request.add(new Request("child5","Dad","Request for today permission to access wallet",false,1,false));
			System.out.println("Permission for today wallet access permission is gone to Dad and Mom");
		}
	}
}

class child6
{
	static String name6;
	public static boolean blocked6=false;
	static Scanner input=new Scanner(System.in);
	public static int permission_count6=0;
	public static int today_pay6=0;
	child6(String n,int p){
		name6=n;
		permission_count6=p;
	}
	static void pay_money_from_wallet(){
		if(blocked6==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		if(permission_count6>=2) {
			System.out.println("How much money you want to withdraw from wallet?");
			int temp1=input.nextInt();
			if(temp1+today_pay6<=50) {
				Main.wallet-=temp1;
				System.out.println("You are successfully withdrawn money");
				LocalDateTime myDateObj = LocalDateTime.now();
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			    String formattedDate = myDateObj.format(myFormatObj);
				Main.transaction.add(new Transactions(temp1,"child6",formattedDate,"Amount is debited from Wallet"));
			}else {
				System.out.println("Sorry, you cann't exceed today's pay money by 50");
				System.out.println("Want to ask permission from Mom?");
				System.out.println("if yes, then enter 1 else 2");
				int ask=input.nextInt();
				if(ask==1) {
					//ask from Mom for payment permission
					Main.request.add(new Request("child6","Mom","Request for greater than 50$ for today's",false,2,false));
					System.out.println("Request sent to Mom for payment permission");
				}else {
					System.out.println("Please Enter Valid Number");
				}
			}
		}else {
			System.out.println("You cann't withdrawn money, because your today permission count<2");
			System.out.println("Want to ask permission from Dad or Mom?");
			System.out.println("if yes, then enter 1 else 2");
			int ask=input.nextInt();
			if(ask==1) {
				//ask from Mom for permission_count
				Main.request.add(new Request("child6","Mom","Request for today permission to access wallet",false,1,false));
				Main.request.add(new Request("child6","Dad","Request for today permission to access wallet",false,1,false));
				System.out.println("Permission for today wallet access permission is gone to Dad or Mom");
			}else {
				System.out.println("Please Enter Valid Number");
			}
		}
	}
	static void Ask_permission_for_permissionCount() {
		if(blocked6==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		if(permission_count6>=2) {
			System.out.println("You don't need today's permission for accessing the wallet");
		}else {
			Main.request.add(new Request("child6","Mom","Request for today permission to access wallet",false,1,false));
			Main.request.add(new Request("child6","Dad","Request for today permission to access wallet",false,1,false));
			System.out.println("Permission for today wallet access permission is gone to Dad and Mom");
		}
	}
}

class child7
{
	static String name7;
	public static boolean blocked7=false;
	static Scanner input=new Scanner(System.in);
	public static int permission_count7=0;
	public static int today_pay7=0;
	child7(String n,int p){
		name7=n;
		permission_count7=p;
	}
	static void pay_money_from_wallet(){
		if(blocked7==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		if(permission_count7>=2) {
			System.out.println("How much money you want to withdraw from wallet?");
			int temp1=input.nextInt();
			if(temp1+today_pay7<=50) {
				Main.wallet-=temp1;
				System.out.println("You are successfully withdrawn money");
				LocalDateTime myDateObj = LocalDateTime.now();
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			    String formattedDate = myDateObj.format(myFormatObj);
				Main.transaction.add(new Transactions(temp1,"child7",formattedDate,"Amount is debited from Wallet"));
			}else {
				System.out.println("Sorry, you cann't exceed today's pay money by 50");
				System.out.println("Want to ask permission from Mom?");
				System.out.println("if yes, then enter 1 else 2");
				int ask=input.nextInt();
				if(ask==1) {
					//ask from Mom for payment permission
					Main.request.add(new Request("child7","Mom","Request for greater than 50$ for today's",false,2,false));
					System.out.println("Request sent to Mom for payment permission");
				}else {
					System.out.println("Please Enter Valid Number");
				}
			}
		}else {
			System.out.println("You cann't withdrawn money, because your today permission count<2");
			System.out.println("Want to ask permission from Dad or Mom?");
			System.out.println("if yes, then enter 1 else 2");
			int ask=input.nextInt();
			if(ask==1) {
				//ask from Mom for permission_count
				Main.request.add(new Request("child7","Mom","Request for today permission to access wallet",false,1,false));
				Main.request.add(new Request("child7","Dad","Request for today permission to access wallet",false,1,false));
				System.out.println("Permission for today wallet access permission is gone to Dad or Mom");
			}else {
				System.out.println("Please Enter Valid Number");
			}
		}
	}
	static void Ask_permission_for_permissionCount() {
		if(blocked7==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		if(permission_count7>=2) {
			System.out.println("You don't need today's permission for accessing the wallet");
		}else {
			Main.request.add(new Request("child7","Mom","Request for today permission to access wallet",false,1,false));
			Main.request.add(new Request("child7","Dad","Request for today permission to access wallet",false,1,false));
			System.out.println("Permission for today wallet access permission is gone to Dad and Mom");
		}
	}
}

class child8
{
	static String name8;
	public static boolean blocked8=false;
	static Scanner input=new Scanner(System.in);
	public static int permission_count8=0;
	public static int today_pay8=0;
	child8(String n,int p){
		name8=n;
		permission_count8=p;
	}
	static void pay_money_from_wallet(){
		if(blocked8==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		if(permission_count8>=2) {
			System.out.println("How much money you want to withdraw from wallet?");
			int temp1=input.nextInt();
			if(temp1+today_pay8<=50) {
				Main.wallet-=temp1;
				System.out.println("You are successfully withdrawn money");
				LocalDateTime myDateObj = LocalDateTime.now();
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
			    String formattedDate = myDateObj.format(myFormatObj);
				Main.transaction.add(new Transactions(temp1,"child8",formattedDate,"Amount is debited from Wallet"));
			}else {
				System.out.println("Sorry, you cann't exceed today's pay money by 50");
				System.out.println("Want to ask permission from Mom?");
				System.out.println("if yes, then enter 1 else 2");
				int ask=input.nextInt();
				if(ask==1) {
					//ask from Mom for payment permission
					Main.request.add(new Request("child8","Mom","Request for greater than 50$ for today's",false,2,false));
					System.out.println("Request sent to Mom for payment permission");
				}else {
					System.out.println("Please Enter Valid Number");
				}
			}
		}else {
			System.out.println("You cann't withdrawn money, because your today permission count<2");
			System.out.println("Want to ask permission from Dad or Mom?");
			System.out.println("if yes, then enter 1 else 2");
			int ask=input.nextInt();
			if(ask==1) {
				//ask from Mom for permission_count
				Main.request.add(new Request("child8","Mom","Request for today permission to access wallet",false,1,false));
				Main.request.add(new Request("child8","Dad","Request for today permission to access wallet",false,1,false));
				System.out.println("Permission for today wallet access permission is gone to Dad or Mom");
			}else {
				System.out.println("Please Enter Valid Number");
			}
		}
	}
	static void Ask_permission_for_permissionCount() {
		if(blocked8==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		if(permission_count8>=2) {
			System.out.println("You don't need today's permission for accessing the wallet");
		}else {
			Main.request.add(new Request("child8","Mom","Request for today permission to access wallet",false,1,false));
			Main.request.add(new Request("child8","Dad","Request for today permission to access wallet",false,1,false));
			System.out.println("Permission for today wallet access permission is gone to Dad and Mom");
		}
	}
}

public class Main {
	public static int bank1_balance=500;  //Bank1 Mom
	public static int bank2_balance=400;  // Bank2 Dad
	public static int wallet=500;  // wallet balance
	public static ArrayList<Transactions> transaction=new ArrayList<>();  //transaction arraylist - that stores all transactions
	public static ArrayList<Request> request=new ArrayList<>();  // request arraylist - that stores all requests
	
	public static void check_balance() {
		System.out.println("Hi!!");
		System.out.println("Bank1 Balance is: "+Main.bank1_balance);
		System.out.println("Bank2 Balance is: "+Main.bank2_balance);
		System.out.println("Wallet Balance is: "+Main.wallet);
	}
	
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		// TODO Auto-generated method stub
		System.out.println("Welcome to DIGITAL WALLET SYSTEM");
		System.out.println("---------------------------------");
		System.out.println();
		Dad dad=new Dad("Dad");
		Mom mom=new Mom("Mom");
		child1 ch1=new child1("child1",0);
		child1 ch2=new child1("child2",0);
		child1 ch3=new child1("child3",0);
		child1 ch4=new child1("child4",0);
		child1 ch5=new child1("child5",0);
		child1 ch6=new child1("child6",0);
		child1 ch7=new child1("child7",0);
		child1 ch8=new child1("child8",0);
		// showing main menu
		System.out.println("Who you are?\n1. Child1\n2. Child2\n3. Child3\n4. Child4\n5. Child5\n6. Child 6\n7. Child 7\n8. Child 8\n9. Mom\n10. Dad\n11. Exit");
		int temp1=input.nextInt();
		do {
			if(temp1==1) {
				System.out.println("What do you want to do?");
				System.out.println("1. Withdraw Money From Wallet\n2. Exit");
				int temp2=input.nextInt();
				if(temp2==1) {
					child1.pay_money_from_wallet();
				}
			}else if(temp1==2) {
				System.out.println("What do you want to do?");
				System.out.println("1. Withdraw Money From Wallet\n2. Exit");
				int temp2=input.nextInt();
				if(temp2==1) {
					child2.pay_money_from_wallet();
				}
			}else if(temp1==3) {
				System.out.println("What do you want to do?");
				System.out.println("1. Withdraw Money From Wallet\n2. Exit");
				int temp2=input.nextInt();
				if(temp2==1) {
					child3.pay_money_from_wallet();
				}
			}else if(temp1==4) {
				System.out.println("What do you want to do?");
				System.out.println("1. Withdraw Money From Wallet\n2. Exit");
				int temp2=input.nextInt();
				if(temp2==1) {
					child4.pay_money_from_wallet();
				}
			}else if(temp1==5) {
				System.out.println("What do you want to do?");
				System.out.println("1. Withdraw Money From Wallet\n2. Exit");
				int temp2=input.nextInt();
				if(temp2==1) {
					child5.pay_money_from_wallet();
				}
			}else if(temp1==6) {
				System.out.println("What do you want to do?");
				System.out.println("1. Withdraw Money From Wallet\n2. Exit");
				int temp2=input.nextInt();
				if(temp2==1) {
					child6.pay_money_from_wallet();
				}
			}else if(temp1==7) {
				System.out.println("What do you want to do?");
				System.out.println("1. Withdraw Money From Wallet\n2. Exit");
				int temp2=input.nextInt();
				if(temp2==1) {
					child7.pay_money_from_wallet();
				}
			}else if(temp1==8) {
				System.out.println("What do you want to do?");
				System.out.println("1. Withdraw Money From Wallet\n2. Exit");
				int temp2=input.nextInt();
				if(temp2==1) {
					child8.pay_money_from_wallet();
				}
			}else if(temp1==9) {  //write for Mom 
				System.out.println("What do you want to do?");
				System.out.println("1. Want to add money from Bank1 to Wallet?\n"
						+ "2. Want to add money from Bank2 to Wallet?\n"
						+ "3. Witdraw Money\n"
						+ "4. View All Transactions\n"
						+ "5. See All Requests\n"
						+ "6. View All Notifications\n"
						+ "7. See Balance in Bank1, Bank2 and Wallet\n"
						+ "8. Exit");
				int temp2=input.nextInt();
				while(temp2>=1 && temp2<8) {
					if(temp2==1) {
						Mom.add_money_from_bank1();
					}else if(temp2==2) {
						Mom.add_money_from_bank2();
					}else if(temp2==3) {
						Mom.withdraw_money();
					}else if(temp2==4) {
						Mom.view_all_transactions();
					}else if(temp2==5) {
						Mom.see_all_requests();
					}else if(temp2==6) {
						Mom.view_all_notifications();
					}else if(temp2==7) {
						Main.check_balance();
					}else {
						break;
					}
					System.out.println("1. Want to add money from Bank1 to Wallet?\n"
							+ "2. Want to add money from Bank2 to Wallet?\n"
							+ "3. Witdraw Money\n"
							+ "4. View All Transactions\n"
							+ "5. See All Requests\n"
							+ "6. View All Notifications\n"
							+ "7. See Balance in Bank1, Bank2 and Wallet\n"
							+ "8. Exit");
					temp2=input.nextInt();
				}
			}else if(temp1==10) {  //write for Dad
				System.out.println("What do you want to do?");
				System.out.println("1. Want to add money from Bank1 to Wallet?\n"
						+ "2. Want to add money from Bank2 to Wallet?\n"
						+ "3. Witdraw Money\n"
						+ "4. View All Transactions\n"
						+ "5. See All Requests\n"
						+ "6. View All Notifications\n"
						+ "7. Want to Block any Family Member\n"
						+ "8. Want to UnBlock any family Member\n"
						+ "9. See Balance in Bank1, Bank2 and Wallet\n"
						+ "10. Exit");
				int temp2=input.nextInt();
				do {
					if(temp2==1) {
						Dad.add_money_from_bank1();
					}else if(temp2==2) {
						Dad.add_money_from_bank2();
					}else if(temp2==3) {
						Dad.withdraw_money();
					}else if(temp2==4) {
						Dad.view_all_transactions();
					}else if(temp2==5) {
						Dad.see_all_requests();
					}else if(temp2==6) {
						Dad.view_all_notifications();
					}else if(temp2==7){
						Dad.Block_Member();
					}else if(temp2==8) {
						Dad.UnBlock_Member();
					}else if(temp2==9) {
						Main.check_balance();
					}else {
						break;
					}
					System.out.println("1. Want to add money from Bank1 to Wallet?\n"
							+ "2. Want to add money from Bank2 to Wallet?\n"
							+ "3. Witdraw Money\n"
							+ "4. View All Transactions\n"
							+ "5. See All Requests\n"
							+ "6. View All Notifications\n"
							+ "7. Want to Block any Family Member\n"
							+ "8. Want to UnBlock any family Member\n"
							+ "9. See Balance in Bank1, Bank2 and Wallet\n"
							+ "10. Exit");
					temp2=input.nextInt();
				}while(temp2>=1);
			}else {
				System.out.println("!!! You are successfully logout !!!!");
				break;
			}
			System.out.println("Who you are?\n1. Child1\n2. Child2\n3. Child3\n4. Child4\n5. Child5\n6. Child 6\n7. Child 7\n8. Child 8\n9. Mom\n10. Dad\n11. Exit");
			temp1=input.nextInt();
		}while(temp1>0);
		System.out.println("!!! You are successfully logout !!!!");
		System.out.println("Thanks for using our Digital Wallet System");
	}

}
