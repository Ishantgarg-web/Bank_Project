package shyam_wallet;

import java.util.*;


import java.time.*;
import java.time.format.DateTimeFormatter;


class Alltransactions{
	int amount;
	String done_by;
	String time;
	String comment;
	Alltransactions(int a,String d,String t,String ch){
		amount=a;
		done_by=d;
		time=t;
		comment=ch;
	}
}
class Allrequest{
	int Raise_by;  
	int Raise_for; 
	String comment; 
	boolean done;
	int check; 
	boolean reject;
	Allrequest(int r1,int r2,String c,boolean d,int ch,boolean rej){
		Raise_by=r1;
		Raise_for=r2;
		comment=c;
		done=d;
		check=ch;
		reject=rej;
	}
}


class parents{  // Dad and Mom
	String name;
	int id;
	boolean block=false;
	Scanner input=new Scanner(System.in);
	public void take_money_from_wallet() {
		System.out.println("How much amount you want to Debit?");
		int withdraw=input.nextInt();
		if(withdraw<0) {
			System.out.println("Amount should be greater than zero");
		}else {
			if(withdraw<=Main.wallet) {
				Main.wallet=Main.wallet-withdraw;
				System.out.println("Money is debitet!!");
				System.out.println("updated Wallet Balance is: "+Main.wallet);
				LocalDateTime myDateObj = LocalDateTime.now();
				DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm");
			    String formattedDate = myDateObj.format(myFormatObj);
			    if(Main.transaction.containsKey(id)) {
					ArrayList<Alltransactions> al1=Main.transaction.get(this.id);
					al1.add(new Alltransactions(withdraw,name,formattedDate,"Amount is debited from wallet"));
					Main.transaction.put(id,al1);
				}else {
					ArrayList<Alltransactions> al1=new ArrayList<>();
					al1.add(new Alltransactions(withdraw,name,formattedDate,"Amount is debited from Wallet"));
					Main.transaction.put(id,al1);
				}
			}else {
				System.out.println("Not Enough Balance");
			}
		}
	}
	public void Wallet_transactions() {
		int len=Main.transaction.size();
		if(len==0) {
			System.out.println("Zeroes Entry");
		}else {
			System.out.println("=============  ALL TRANSACTIONS =============");
			int c=1;
			for (Map.Entry<Integer, ArrayList<Alltransactions>> entry:Main.transaction.entrySet())
			{
				int payment_done_by=entry.getKey();
				ArrayList<Alltransactions> al1=Main.transaction.get(payment_done_by);
				for (int i=0;i<al1.size();i++)
				{
					System.out.println("Transaction number "+c);
					Alltransactions t=al1.get(i);
					System.out.println("Person ID: "+payment_done_by);
					System.out.println("Amount is: "+t.amount);
					System.out.println("Transaction completed by: "+t.done_by);
					System.out.println("Date and Time of transaction: "+t.time);
					System.out.println("Comment on transaction: "+t.comment);
					c++;
				}
			}
		}
	}
	public void Notifications() {
		if (Main.wallet<=100){
			System.out.println("Attention!! Balance of wallet is less than 100$");
		}else {
			System.out.println("There are no new Notifications");
		}
	}
}

class Dad extends parents{
	Dad(String n,int i){
		name=n;
		id=i;
	}
	public void add_money_from_bank() {
		if(Main.Dad_bank>=0) {
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		    String formattedDate = myDateObj.format(myFormatObj);
			System.out.println("How much money you want to add from Bank?");
			int x=input.nextInt();
			if(x>=0) {
				if(x<=Main.Dad_bank) {
					Main.wallet+=x;
					Main.Dad_bank-=x;
					System.out.println("Successfully,Money is added to Wallet");
					if(Main.transaction.containsKey(10)) {
						ArrayList<Alltransactions> al1=Main.transaction.get(10);
						al1.add(new Alltransactions(x,"Dad",formattedDate,"Amount is debited from wallet"));
						Main.transaction.put(10,al1);
					}else {
						ArrayList<Alltransactions> al1=new ArrayList<>();
						al1.add(new Alltransactions(x,"Dad",formattedDate,"Amount is debited from Wallet"));
						Main.transaction.put(10,al1);
					}
					
				}else {
					System.out.println("Sorry, you cann't exceed more than your Bank balance in your wallet");
				}
			}else {
				System.out.println("Please add valid amount");
			}
		}else {
			System.out.println("Your Bank balance is empty!!");
		}
	}
	public void see_all_requests() { // for DAD
		int len=Main.request.size();
		if(len==0) {
			System.out.println("There are no requests pending!!");
		}else {
			System.out.println("======  ALL PENDING REQUESTS FOR DAD =====");
			if(Main.request.containsKey(10)) {
				ArrayList<Allrequest> al1=new ArrayList<>();
				for (int j=0;j<al1.size();j++) {
					Allrequest r1=al1.get(j);
					if(r1.Raise_for==10 && r1.done==false && r1.reject==false) {
						System.out.printf("*** Pending Request  ***\n");
						System.out.println("Request Raise By: "+r1.Raise_by);
						System.out.println("Any Comment on Request: "+r1.comment);
						System.out.println("What you want to do?\n1. Accept the Request\n2. Reject the Request\n3. Exit");
						int temp=input.nextInt();
						if(temp==1) {
							r1.done=true;
							child1 ch1=new child1("child1",1);
							child2 ch2=new child2("child2",2);
							child3 ch3=new child3("child3",3);
							child4 ch4=new child4("child4",4);
							child5 ch5=new child5("child5",5);
							child6 ch6=new child6("child6",6);
							child7 ch7=new child7("child7",7);
							child8 ch8=new child8("child8",8);
							if(r1.check==1) {
								if(r1.Raise_by==1) {
									ch1.pCount++;
								}else if(r1.Raise_by==2) {
									ch2.pCount++;
								}else if(r1.Raise_by==3) {
									ch3.pCount++;
								}else if(r1.Raise_by==4) {
									ch4.pCount++;
								}else if(r1.Raise_by==5) {
									ch5.pCount++;
								}else if(r1.Raise_by==6) {
									ch6.pCount++;
								}else if(r1.Raise_by==7) {
									ch7.pCount++;
								}else if(r1.Raise_by==8) {
									ch8.pCount++;
								}
							}else {
								if(r1.Raise_by==1) {
									ch1.can_pay_more_than_50=true;
								}else if(r1.Raise_by==2) {
									ch2.can_pay_more_than_50=true;
								}else if(r1.Raise_by==3) {
									ch3.can_pay_more_than_50=true;
								}else if(r1.Raise_by==4) {
									ch4.can_pay_more_than_50=true;
								}else if(r1.Raise_by==5) {
									ch5.can_pay_more_than_50=true;
								}else if(r1.Raise_by==6) {
									ch6.can_pay_more_than_50=true;
								}else if(r1.Raise_by==7) {
									ch7.can_pay_more_than_50=true;
								}else if(r1.Raise_by==8) {
									ch8.can_pay_more_than_50=true;
								}
							}
							System.out.println("Successfully, Now this request is completed");
						}else if(temp==2) {
							r1.reject=true;
							System.out.println("Request is rejected successfully");
						}
					}
				}
			}else {
				System.out.println("There are no Requests Pending!!");
			}
		}
	}
	public void block_memeber() {
		System.out.println("For which family member you want to block?\n"
				+ "Please Enter ID.");
		int temp=input.nextInt();
		child1 ch1=new child1("child1",1);
		child2 ch2=new child2("child2",2);
		child3 ch3=new child3("child3",3);
		child4 ch4=new child4("child4",4);
		child5 ch5=new child5("child5",5);
		child6 ch6=new child6("child6",6);
		child7 ch7=new child7("child7",7);
		child8 ch8=new child8("child8",8);
		if(temp==1) {
			ch1.blockc=true;
		}else if(temp==2) {
			ch2.blockc=true;
		}else if(temp==3) {
			ch3.blockc=true;
		}else if(temp==4) {
			ch4.blockc=true;
		}else if(temp==5) {
			ch5.blockc=true;
		}else if(temp==6) {
			ch6.blockc=true;
		}else if(temp==7) {
			ch7.blockc=true;
		}else if(temp==8) {
			ch8.blockc=true;
		}else {
			return;
		}
	}
	public void unblock_member() {
		System.out.println("For which family member you want to unblock?\n"
				+ "Please Enter ID.");
		int temp=input.nextInt();
		child1 ch1=new child1("child1",1);
		child2 ch2=new child2("child2",2);
		child3 ch3=new child3("child3",3);
		child4 ch4=new child4("child4",4);
		child5 ch5=new child5("child5",5);
		child6 ch6=new child6("child6",6);
		child7 ch7=new child7("child7",7);
		child8 ch8=new child8("child8",8);
		if(temp==1) {
			ch1.blockc=false;
		}else if(temp==2) {
			ch2.blockc=false;
		}else if(temp==3) {
			ch3.blockc=false;
		}else if(temp==4) {
			ch4.blockc=false;
		}else if(temp==5) {
			ch5.blockc=false;
		}else if(temp==6) {
			ch6.blockc=false;
		}else if(temp==7) {
			ch7.blockc=false;
		}else if(temp==8) {
			ch8.blockc=false;
		}else {
			return;
		}
	}
}

class Mom extends parents{
	Mom(String n,int i){
		name=n;
		id=i;
	}
	public void add_money_from_bank() {
		if(Main.Mom_bank>=0) {
			LocalDateTime myDateObj = LocalDateTime.now();
			DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		    String formattedDate = myDateObj.format(myFormatObj);
			System.out.println("How much money you want to add from Bank?");
			int x=input.nextInt();
			if(x>=0) {
				if(x<=Main.Mom_bank) {
					Main.wallet+=x;
					Main.Mom_bank-=x;
					System.out.println("Successfully,Money is added to Wallet");
					if(Main.transaction.containsKey(9)) {
						ArrayList<Alltransactions> al1=Main.transaction.get(9);
						al1.add(new Alltransactions(x,"Mom",formattedDate,"Amount is debited from wallet"));
						Main.transaction.put(9,al1);
					}else {
						ArrayList<Alltransactions> al1=new ArrayList<>();
						al1.add(new Alltransactions(x,"Mom",formattedDate,"Amount is debited from Wallet"));
						Main.transaction.put(9,al1);
					}
					
				}else {
					System.out.println("Sorry, you cann't exceed more than your Bank balance in your wallet");
				}
			}else {
				System.out.println("Please add valid amount");
			}
		}else {
			System.out.println("Your Bank balance is empty!!");
		}
	}
	public void see_all_requests() {  // for MOM
		int len=Main.request.size();
		if(len==0) {
			System.out.println("There are no requests pending!!");
		}else {
			if(Main.request.containsKey(9)) {
				System.out.println("======  ALL PENDING REQUESTS FOR MOM =====");
				ArrayList<Allrequest> al1=Main.request.get(9);
				for (int j=0;j<al1.size();j++) {
					Allrequest r1=al1.get(j);
					if(r1.Raise_for==9 && r1.done==false && r1.reject==false) {
						System.out.printf("*** Pending Request  ***\n");
						System.out.println("Request Raise By: "+r1.Raise_by);
						System.out.println("Any Comment on Request: "+r1.comment);
						System.out.println("What you want to do?\n 1. Accept the Request\n2. Reject the Request\n3. Transfer the request to Dad\n4. Exit");
						int temp=input.nextInt();
						if(temp==1) {
							r1.done=true;
							child1 ch1=new child1("child1",1);
							child2 ch2=new child2("child2",2);
							child3 ch3=new child3("child3",3);
							child4 ch4=new child4("child4",4);
							child5 ch5=new child5("child5",5);
							child6 ch6=new child6("child6",6);
							child7 ch7=new child7("child7",7);
							child8 ch8=new child8("child8",8);
							if(r1.check==1) {
								if(r1.Raise_by==1) {
									ch1.pCount++;
								}else if(r1.Raise_by==2) {
									ch2.pCount++;
								}else if(r1.Raise_by==3) {
									ch3.pCount++;
								}else if(r1.Raise_by==4) {
									ch4.pCount++;
								}else if(r1.Raise_by==5) {
									ch5.pCount++;
								}else if(r1.Raise_by==6) {
									ch6.pCount++;
								}else if(r1.Raise_by==7) {
									ch7.pCount++;
								}else if(r1.Raise_by==8) {
									ch8.pCount++;
								}
							}else {
								if(r1.Raise_by==1) {
									ch1.can_pay_more_than_50=true;
								}else if(r1.Raise_by==2) {
									ch2.can_pay_more_than_50=true;
								}else if(r1.Raise_by==3) {
									ch3.can_pay_more_than_50=true;
								}else if(r1.Raise_by==4) {
									ch4.can_pay_more_than_50=true;
								}else if(r1.Raise_by==5) {
									ch5.can_pay_more_than_50=true;
								}else if(r1.Raise_by==6) {
									ch6.can_pay_more_than_50=true;
								}else if(r1.Raise_by==7) {
									ch7.can_pay_more_than_50=true;
								}else if(r1.Raise_by==8) {
									ch8.can_pay_more_than_50=true;
								}
							}
							System.out.println("Successfully, Now this request is completed");
						}else if(temp==2) {
							r1.reject=true;
							System.out.println("Request is rejected successfully");
						}else if(temp==3) {
							r1.done=true;
							if(Main.request.containsKey(10)) {
								ArrayList<Allrequest> al2=Main.request.get(10);
								al2.add(new Allrequest(r1.Raise_by,10,r1.comment,false,r1.check,false));
								Main.request.put(10, al2);
							}else {
								ArrayList<Allrequest> al2=new ArrayList<>();
								al2.add(new Allrequest(r1.Raise_by,10,r1.comment,false,r1.check,false));
								Main.request.put(10, al2);
							}
							System.out.println("Request is transferred Successfully!!");
						}
					}
				}
			}else {
				System.out.println("There are no requests pending!!");
			}
		}
	}
}


// Children class
class childrens{
	String name;
	int id;
	int pCount=0;
	int tPay=0;
	boolean one_time_pay=false;
	boolean two_time_pay=false;
	boolean blockc=false;
	boolean can_pay_more_than_50=false;
	Scanner input=new Scanner(System.in);
	
	public void Debit_from_wallet() {
		if(blockc==true) {
			System.out.println("sorry you are blocked by Dad");
			return;
		}
		
		System.out.println("How much you want to withdraw?");
		int x=input.nextInt();
		Scanner textscan=new Scanner(System.in);
		System.out.println("Enter shop name for which you want to withdraw");
		String shop_name=textscan.nextLine();
		if(x>0) {
			System.out.println("current pcount is: "+this.pCount);
			if(x<=Main.wallet) {
				if(pCount==0) {
					System.out.println("Sorry!, you need a permission to access wallet");
					System.out.println("Want to raise Request?\n1. Yes\n2. No\n");
					int temp1=input.nextInt();
					if(temp1==1) {
						if(Main.request.containsKey(9)) {
							ArrayList<Allrequest> al1=Main.request.get(9);
							al1.add(new Allrequest(id,9,"Child want to access wallet",false,1,false));
							Main.request.put(9, al1);
						}else {
							ArrayList<Allrequest> al1=new ArrayList<>();
							al1.add(new Allrequest(id,9,"Child want to access wallet",false,1,false));
							Main.request.put(9, al1);
						}
						System.out.println("Request Raised Successfully!!");
					}
				}else if(pCount==1 && one_time_pay==false) {
					if(x+tPay<=50) {
						LocalDateTime myDateObj = LocalDateTime.now();
						DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
					    String formattedDate = myDateObj.format(myFormatObj);
						Main.wallet-=x;
						tPay+=x;
						one_time_pay=true;
						String temp2="Money is withdrawn for shop name: "+shop_name;
						
						if(Main.transaction.containsKey(id)) {
							ArrayList<Alltransactions> al1=Main.transaction.get(id);
							al1.add(new Alltransactions(x,name,formattedDate,"Money is debit by children from wallet"));
							Main.transaction.put(id, al1);
						}else {
							ArrayList<Alltransactions> al1=new ArrayList<>();
							al1.add(new Alltransactions(x,name,formattedDate,"Money is debit by children from wallet"));
							Main.transaction.put(id, al1);
						}
						System.out.println("Your transaction is successfull");
					}else {
						if(can_pay_more_than_50==true) {
							LocalDateTime myDateObj = LocalDateTime.now();
							DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
						    String formattedDate = myDateObj.format(myFormatObj);
							Main.wallet-=x;
							tPay+=x;
							one_time_pay=true;
							can_pay_more_than_50=false;
							String temp2="Money is withdrawn for shop name: "+shop_name;
							
							if(Main.transaction.containsKey(id)) {
								ArrayList<Alltransactions> al1=Main.transaction.get(id);
								al1.add(new Alltransactions(x,name,formattedDate,"Money is debit by children from wallet and "+temp2));
								Main.transaction.put(id, al1);
							}else {
								ArrayList<Alltransactions> al1=new ArrayList<>();
								al1.add(new Alltransactions(x,name,formattedDate,"Money is debit by children from wallet and "+temp2));
								Main.transaction.put(id, al1);
							}
							
							System.out.println("Your transaction is successfull");
						}else {
							System.out.println("Sorry! You don't have permission to withdrawn money more than 50$");
							System.out.println("Want to raise Request?\n1. Yes\n2. No\n");
							int temp1=input.nextInt();
							if(temp1==1) {
								if(Main.request.containsKey(9)) {
									ArrayList<Allrequest> al1=Main.request.get(9);
									al1.add(new Allrequest(id,9,"Child try to debit money more than 50$",false,2,false));
									Main.request.put(9, al1);
								}else {
									ArrayList<Allrequest> al1=new ArrayList<>();
									al1.add(new Allrequest(id,9,"Child try to debit money more than 50$",false,2,false));
									Main.request.put(9, al1);
								}
								System.out.println("Request Raised Successfully!!");
							}
						}
					}
				}else if(pCount==1 && one_time_pay==true) {
					System.out.println("Sorry!, you need a permission to access wallet");
					System.out.println("Want to raise Request?\n1. Yes\n2. No\n");
					int temp1=input.nextInt();
					if(temp1==1) {
						if(Main.request.containsKey(9)) {
							ArrayList<Allrequest> al1=Main.request.get(9);
							al1.add(new Allrequest(id,9,"Child want to access wallet",false,1,false));
							Main.request.put(9, al1);
						}else {
							ArrayList<Allrequest> al1=new ArrayList<>();
							al1.add(new Allrequest(id,9,"Child want to access wallet",false,1,false));
							Main.request.put(9, al1);
						}
						System.out.println("Request Raised Successfully!!");
					}
				}else if(pCount==2 && two_time_pay==false) {
					if(x+tPay<=50) {
						LocalDateTime myDateObj = LocalDateTime.now();
						DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
					    String formattedDate = myDateObj.format(myFormatObj);
						Main.wallet-=x;
						tPay+=x;
						two_time_pay=true;
						String temp2="Money is withdrawn for shop name: "+shop_name;
						if(Main.transaction.containsKey(id)) {
							ArrayList<Alltransactions> al1=Main.transaction.get(id);
							al1.add(new Alltransactions(x,name,formattedDate,"Money is debit by children from wallet and "+temp2));
							Main.transaction.put(id, al1);
						}else {
							ArrayList<Alltransactions> al1=new ArrayList<>();
							al1.add(new Alltransactions(x,name,formattedDate,"Money is debit by children from wallet and "+temp2));
							Main.transaction.put(id, al1);
						}
						System.out.println("Your transaction is successfull");
					}else {
						if(can_pay_more_than_50==true) {
							LocalDateTime myDateObj = LocalDateTime.now();
							DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
						    String formattedDate = myDateObj.format(myFormatObj);
							Main.wallet-=x;
							tPay+=x;
							two_time_pay=true;
							can_pay_more_than_50=false;
							String temp2="Money is withdrawn for shop name: "+shop_name;
							if(Main.transaction.containsKey(id)) {
								ArrayList<Alltransactions> al1=Main.transaction.get(id);
								al1.add(new Alltransactions(x,name,formattedDate,"Money is debit by children from wallet and "+temp2));
								Main.transaction.put(id, al1);
							}else {
								ArrayList<Alltransactions> al1=new ArrayList<>();
								al1.add(new Alltransactions(x,name,formattedDate,"Money is debit by children from wallet and "+temp2));
								Main.transaction.put(id, al1);
							}
							System.out.println("Your transaction is successfull");
						}else {
							System.out.println("Sorry! You don't have permission to withdrawn money more than 50$");
							System.out.println("Want to raise Request?\n1. Yes\n2. No\n");
							int temp1=input.nextInt();
							if(temp1==1) {
								if(Main.request.containsKey(9)) {
									ArrayList<Allrequest> al1=Main.request.get(9);
									al1.add(new Allrequest(id,9,"Child try to debit money more than 50$",false,2,false));
									Main.request.put(9, al1);
								}else {
									ArrayList<Allrequest> al1=new ArrayList<>();
									al1.add(new Allrequest(id,9,"Child try to debit money more than 50$",false,2,false));
									Main.request.put(9, al1);
								}
								System.out.println("Request Raised Successfully!!");
							}
						}
					}
				}else if(pCount==2 && two_time_pay==true) {
					if(x+tPay<=50) {
						LocalDateTime myDateObj = LocalDateTime.now();
						DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
					    String formattedDate = myDateObj.format(myFormatObj);
						Main.wallet-=x;
						tPay+=x;
						two_time_pay=true;
						String temp2="Money is withdrawn for shop name: "+shop_name;
						if(Main.transaction.containsKey(id)) {
							ArrayList<Alltransactions> al1=Main.transaction.get(id);
							al1.add(new Alltransactions(x,name,formattedDate,"Money is debit by children from wallet and "+temp2));
							Main.transaction.put(id, al1);
						}else {
							ArrayList<Alltransactions> al1=new ArrayList<>();
							al1.add(new Alltransactions(x,name,formattedDate,"Money is debit by children from wallet and "+temp2));
							Main.transaction.put(id, al1);
						}
						System.out.println("Your transaction is successfull");
					}else {
						if(can_pay_more_than_50==true) {
							LocalDateTime myDateObj = LocalDateTime.now();
							DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
						    String formattedDate = myDateObj.format(myFormatObj);
							Main.wallet-=x;
							tPay+=x;
							two_time_pay=true;
							can_pay_more_than_50=false;
							String temp2="Money is withdrawn for shop name: "+shop_name;
							if(Main.transaction.containsKey(id)) {
								ArrayList<Alltransactions> al1=Main.transaction.get(id);
								al1.add(new Alltransactions(x,name,formattedDate,"Money is debit by children from wallet and "+temp2));
								Main.transaction.put(id, al1);
							}else {
								ArrayList<Alltransactions> al1=new ArrayList<>();
								al1.add(new Alltransactions(x,name,formattedDate,"Money is debit by children from wallet and "+temp2));
								Main.transaction.put(id, al1);
							}
							System.out.println("Your transaction is successfull");
						}else {
							System.out.println("Sorry! You don't have permission to withdrawn money more than 50$");
							System.out.println("Want to raise Request?\n1. Yes\n2. No\n");
							int temp1=input.nextInt();
							if(temp1==1) {
								if(Main.request.containsKey(9)) {
									ArrayList<Allrequest> al1=Main.request.get(9);
									al1.add(new Allrequest(id,9,"Child try to debit money more than 50$",false,2,false));
									Main.request.put(9, al1);
								}else {
									ArrayList<Allrequest> al1=new ArrayList<>();
									al1.add(new Allrequest(id,9,"Child try to debit money more than 50$",false,2,false));
									Main.request.put(9, al1);
								}
								System.out.println("Request Raised Successfully!!");
							}
						}
					}
				}
			}else {
				System.out.println("No sufficient Funds!!");
				System.out.println("Want to raise Request?\n1. Yes\n2. No\n");
				int temp1=input.nextInt();
				if(temp1==1) {
					if(Main.request.containsKey(9)) {
						ArrayList<Allrequest> al1=Main.request.get(9);
						al1.add(new Allrequest(id,9,"Please add some money to wallet",false,1,false));
						Main.request.put(9, al1);
					}else {
						ArrayList<Allrequest> al1=new ArrayList<>();
						al1.add(new Allrequest(id,9,"Please add some money to wallet",false,1,false));
						Main.request.put(9, al1);
					}
					System.out.println("Request Raised Successfully!!");
				}
			}
		}else {
			System.out.println("Please Enter Valid number");
		}
	}
}

class child1 extends childrens{
	child1(String n,int i)
	{
		name=n;
		id=i;
	}
}
class child2 extends childrens{
	child2(String n,int i)
	{
		name=n;
		id=i;
	}
}
class child3 extends childrens{
	child3(String n,int i)
	{
		name=n;
		id=i;
	}
}
class child4 extends childrens{
	child4(String n,int i)
	{
		name=n;
		id=i;
	}
}
class child5 extends childrens{
	child5(String n,int i)
	{
		name=n;
		id=i;
	}
}
class child6 extends childrens{
	child6(String n,int i)
	{
		name=n;
		id=i;
	}
}
class child7 extends childrens{
	child7(String n,int i)
	{
		name=n;
		id=i;
	}
}
class child8 extends childrens{
	child8(String n,int i)
	{
		name=n;
		id=i;
	}
}

// Dad class that do such things - explained using Methods
public class Main{
	public static int wallet=400;
	public static int Mom_bank=500;
	public static int Dad_bank=500;
	
	static HashMap<Integer,ArrayList<Alltransactions>> transaction=new HashMap<>();  
	static HashMap<Integer,ArrayList<Allrequest>> request=new HashMap<>(); //only for id - 9 and 10
	
	public static void see_balance_in_accounts()
	{
		System.out.println("Mom Bank Balance is: "+Main.Mom_bank);
		System.out.println("Dad Bank Balance is: "+Main.Dad_bank);
		System.out.println("Wallet Balance is: "+wallet);
	}
	
	public static int show_menu_children() {
		Scanner input=new Scanner(System.in);
		System.out.println("What do you want to do?\n"
				+ "1. Want to Access Wallet for Debit Money\n"
				+ "2. Exit");
		int temp=input.nextInt();
		return temp;
		
	}
	/*
	public static void show_pcounts() {
		System.out.println("child1: "+child1.pCount);
		System.out.println("child2: "+child2.pCount);
		System.out.println("child3: "+child3.pCount);
		System.out.println("child4: "+child4.pCount);
		System.out.println("child5: "+child5.pCount);
		System.out.println("child6: "+child6.pCount);
		System.out.println("child7: "+child7.pCount);
		System.out.println("child8: "+child8.pCount);
	}*/
	public static void main(String[] args) {
		Scanner input=new Scanner(System.in);
		System.out.println("Welcome to Digital Wallet Banking System -ID Based");
		
		child1 ch1=new child1("child1",1);
		child2 ch2=new child2("child2",2);
		child3 ch3=new child3("child3",3);
		child4 ch4=new child4("child4",4);
		child5 ch5=new child5("child5",5);
		child6 ch6=new child6("child6",6);
		child7 ch7=new child7("child7",7);
		child8 ch8=new child8("child8",8);
		Mom ch9=new Mom("Mom",9);
		Dad ch10=new Dad("Dad",10);
		
		System.out.println("Thanks for updating Balance!!");
		System.out.println("Can you tell me your id?\n"
				+ "1. if you are child1\n"
				+ "2. if you are child2\n"
				+ "3. if you are child3\n"
				+ "4. if you are child4\n"
				+ "5. if you are child5\n"
				+ "6. if you are child6\n"
				+ "7. if you are child7\n"
				+ "8. if you are child8\n"
				+ "9. if you are Mom\n"
				+ "10. if you are Dad");
		int temp=input.nextInt();
		do {
			if(temp==1) {
				int x=show_menu_children();
				if(x==1) {
					ch1.Debit_from_wallet();
				}
			}else if(temp==2) {
				int x=show_menu_children();
				if(x==1) {
					ch2.Debit_from_wallet();
				}
			}else if(temp==3) {
				int x=show_menu_children();
				if(x==1) {
					ch3.Debit_from_wallet();
				}
			}else if(temp==4) {
				int x=show_menu_children();
				if(x==1) {
					ch4.Debit_from_wallet();
				}
			}else if(temp==5) {
				int x=show_menu_children();
				if(x==1) {
					ch5.Debit_from_wallet();
				}
			}else if(temp==6) {
				int x=show_menu_children();
				if(x==1) {
					ch6.Debit_from_wallet();
				}
			}else if(temp==7) {
				int x=show_menu_children();
				if(x==1) {
					ch7.Debit_from_wallet();
				}
			}else if(temp==8) {
				int x=show_menu_children();
				if(x==1) {
					ch8.Debit_from_wallet();
				}
			}else if(temp==9) {
				System.out.println("What you want to do?\n"
						+ "1. credit money to Wallet from Bank?\n"
						+ "2. debit money from wallet\n"
						+ "3. Get all transactions\n"
						+ "4. See All requests\n"
						+ "5. See All Notifications\n"
						+ "6. See Balance\n"
						+ "7. Exit");
				int temp1=input.nextInt();
				do {
					if(temp1==1) {
						ch9.add_money_from_bank();
					}else if(temp1==2) {
						ch9.take_money_from_wallet();
					}else if(temp1==3) {
						ch9.Wallet_transactions();
					}else if(temp1==4) {
						ch9.see_all_requests();
					}else if(temp1==5) {
						ch9.Notifications();
					}else if(temp1==6) {
						see_balance_in_accounts();
					}else {
						break;
					}
					System.out.println("What you want to do?\n"
							+ "1. credit money to Wallet from Bank?\n"
							+ "2. debit money from wallet\n"
							+ "3. Get all transactions\n"
							+ "4. See All requests\n"
							+ "5. See All Notifications\n"
							+ "6. See Balance\n"
							+ "7. Exit");
					temp1=input.nextInt();
				}while(temp1>=1 && temp1<7);
				
			}else if(temp==10)
			{
				System.out.println("What you want to do?\n"
						+ "1. credit money to Wallet from Bank?\n"
						+ "2. debit money from wallet\n"
						+ "3. Get all transactions\n"
						+ "4. See All requests\n"
						+ "5. See All Notifications\n"
						+ "6. See Balance\n"
						+ "7. Block any family member\n"
						+ "8. Unblock any family member\n"
						+ "9. Exit");
				int temp1=input.nextInt();
				do {
					if(temp1==1) {
						ch10.add_money_from_bank();
					}else if(temp1==2) {
						ch10.take_money_from_wallet();
					}else if(temp1==3) {
						ch10.Wallet_transactions();
					}else if(temp1==4) {
						ch10.see_all_requests();
					}else if(temp1==5) {
						ch10.Notifications();
					}else if(temp1==6) {
						see_balance_in_accounts();
					}else if(temp1==7) {
						ch10.block_memeber();
					}else if(temp1==8) {
						ch10.unblock_member();
					}else {
						break;
					}
					System.out.println("What you want to do?\n"
							+ "1. credit money to Wallet from Bank?\n"
							+ "2. debit money from wallet\n"
							+ "3. Get all transactions\n"
							+ "4. See All requests\n"
							+ "5. See All Notifications\n"
							+ "6. See Balance\n"
							+ "7. Block any family member\n"
							+ "8. Unblock any family member\n"
							+ "9. Exit");
					temp1=input.nextInt();
				}while(temp1>=1 && temp1<9);
				
			}
			System.out.println("Can you tell me your id?\n"
					+ "1. if you are child1\n"
					+ "2. if you are child2\n"
					+ "3. if you are child3\n"
					+ "4. if you are child4\n"
					+ "5. if you are child5\n"
					+ "6. if you are child6\n"
					+ "7. if you are child7\n"
					+ "8. if you are child8\n"
					+ "9. if you are Mom\n"
					+ "10. if you are Dad\n"
					+ "11. Exit");
			temp=input.nextInt();
		}while(temp>=1 && temp<=10);
		System.out.println("Successfully Logout");
	}
}
