import javax.swing.*;
class Date
{
	static final int tue=3;
	static final int wed=4;
	String date,sday;
	int day,month,year;
	int anchor,a,b,c,d;
	int leep;
	Date()
	{
		date="";
		day=month=year=0;
		anchor=a=b=c=d=leep=0;
	}
	void setData()
	{
		date=JOptionPane.showInputDialog(null,"Enter Date in 'dd/mm/yyyy' format :-");
		convert();
	}
	void setData(String str)
	{
		date=str;
		convert();
	}
	void convert()
	{
		try
		{
			//d=date.charAt(0)+date.charAt(1);
			//m=date.charAt(3)+date.charAt(4);
			//y=date.charAt(6)+date.charAt(7)+date.charAt(8)+date.charAt(9);
			String [] tmp=date.split("/");
			/*for (String i: tmp)
			{

			}*/
			day=Integer.parseInt(tmp[0]);
			month=Integer.parseInt(tmp[1]);
			year=Integer.parseInt(tmp[2]);
/*			d=""+day+"/"+month+"/"+year;
			JOptionPane.showMessageDialog(null,d);	
*/			
			if(day>31)
			{
				JOptionPane.showMessageDialog(null,"Please enter a realistic day..!!");
				System.exit(0);
			}
			if(month>12)
			{
				JOptionPane.showMessageDialog(null,"Please enter a realistic month..!!");
				System.exit(0);
			}
			if(year>=2000 && year<2100)
			{
				anchor=tue;
			}
			else if (year>=1900 && year<2000) 
			{
				anchor=wed;
			}
			else
			{
				JOptionPane.showMessageDialog(null,"Please enter a year between 20th & 21st century..!!");
				System.exit(0);
			}
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null,"Please enter date in 'dd/mm/yyyy' format");
			System.exit(0);
		}
		calculate();
	}
	void calculate()
	{
		int yr=year%100;
//		System.out.println(yr);
		a=yr/12;
//		if(a==0)
//			a=1;
		b=yr%12;
//		if(b==0)
//			b=1;
		c=b/4;
//		if(c==0)
//			c=1;
		d=a+b+c;
		int t1=d%7;
		while(t1>7)
			t1%=7;
		int doom=anchor+t1;
		while(doom>7)
			doom-=7;
		leep();
		int t2=0,t3=0;
		if(month==10)
		{
			t2=day-10;
			if(t2>0)
			{
				while(t2>7)
					t2-=7;
				t3=doom+t2;
				while(t3>7)
					t3-=7;
			}
			else if(t2<0)
			{
				while(t2<-7)
					t2+=7;
				t3=doom+t2;
				while(t3<-7)
					t3+=7;
			}
		}
		else if(month==8)
		{
			t2=day-8;
			if(t2>0)
			{
				while(t2>7)
					t2-=7;
				t3=doom+t2;
				while(t3>7)
					t3-=7;
			}
			else if(t2<0)
			{
				while(t2<-7)
					t2+=7;
				t3=doom+t2;
				while(t3<-7)
					t3+=7;
			}
		}
		else if(month==6)
		{
			t2=day-6;
			if(t2>0)
			{
				while(t2>7)
					t2-=7;
				t3=doom+t2;
				while(t3>7)
					t3-=7;
			}
			else if(t2<0)
			{
				while(t2<-7)
					t2+=7;
				t3=doom+t2;
				while(t3<-7)
					t3+=7;
			}
		}
		else if(month==4)
		{
			t2=day-4;
			if(t2>0)
			{
				while(t2>7)
					t2-=7;
				t3=doom+t2;
				while(t3>7)
					t3-=7;
			}
			else if(t2<0)
			{
				while(t2<-7)
					t2+=7;
				t3=doom+t2;
				while(t3<-7)
					t3+=7;
			}
		}
		else if(month==12)
		{
			t2=day-12;
			if(t2>0)
			{
				while(t2>7)
					t2-=7;
				t3=doom+t2;
				while(t3>7)
					t3-=7;
			}
			else if(t2<0)
			{
				while(t2<-7)
					t2+=7;
				t3=doom+t2;
				while(t3<-7)
					t3+=7;
			}
		}
		else if(month==2)
		{
			t2=day-leep;
			if(t2>0)
			{
				while(t2>7)
					t2-=7;
				t3=doom+t2;
				while(t3>7)
					t3-=7;
			}
			else if(t2<0)
			{
				while(t2<-7)
					t2+=7;
				t3=doom+t2;
				while(t3<-7)
					t3+=7;
			}
		}
		else if(month==1 || month ==3|| month ==5|| month ==7)
		{
			do
			{
				day+=7;
			}while(day<32);
			day-=31;
			String nd=day+"/"+(month+1)+"/"+year;
			System.out.println(nd);
			setData(nd);
			System.exit(0);
		}
		else if(month==9)
		{
			do
			{
				day+=7;
			}while(day<32);
			day-=30;
			String nd=day+"/"+(month+1)+"/"+year;
			System.out.println(nd);
			setData(nd);
			System.exit(0);
		}
		if(t3==0)
			t3=doom+1;
		if(t3<0)
			t3+=7;
		findDay(t3);
		//System.out.println(a+" "+b+" "+c+" "+d+" "+t1+" "+doom+" "+leep+" "+t2+" "+t3);
	}
	void findDay(int iday)
	{
		switch (iday) 
		{
			case 1:
				sday="Sunday";
				break;
			case 2:
				sday="Monday";
				break;
			case 3:
				sday="Tuesday";
				break;
			case 4:
				sday="Wednesday";
				break;
			case 5:
				sday="Thursday";
				break;
			case 6:
				sday="Friday";
				break;
			case 7:
				sday="Saturday";
				break;
		}
		JOptionPane.showMessageDialog(null,"I guess "+sday+"...!!");
	}
	void leep()
	{
		leep=28;
		if(year%4==0)
			leep=29;
	}
	public static void main(String[] args) {
		Date dat=new Date();
		dat.setData();
	}
}