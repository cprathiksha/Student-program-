import java.util.*;
public class student
{
	public static void main(String args[])
	{
		int n;
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of student");
		n=sc.nextInt();
		
		int mark[][]=new int[n][5];
		for(int i=0;i<n;i++)
		{
			System.out.println("Student "+(i+1));
			System.out.println("Enter Regno :");
			mark[i][0]=sc.nextInt();
			System.out.println("Enter marks 1");
			mark[i][1]=sc.nextInt();
			System.out.println("Enter marks 2");
			mark[i][2]=sc.nextInt();
			System.out.println("Enter marks 3");
			mark[i][3]=sc.nextInt();
			mark[i][4]=0;
			
		
			//System.out.println("hello "+mark[i][5]);
		}
		for(int i=0;i<n;i++)
		{

			System.out.print("Regno \t");
						System.out.print("Sub-1 \t");
						System.out.print("Sub-2 \t");
						System.out.print("Sub-3 \t");
			System.out.print("Total \n");
			for( i=0;i<n;i++)
						{
							for(int j=i+1;j<n;j++)
							{
								if(mark[i][4]>mark[j][4])
								{
									int[] temp=mark[i];
									mark[i]=mark[j];
									mark[j]=temp;
								}
							}
							System.out.println(mark[i][0]+"\t"+mark[i][1]+"\t"+mark[i][2]+"\t"+mark[i][3]+"\t"+mark[i][4]);
			}
		}
		try
		{
			System.out.println("---------------Thread-1--------------");
			System.out.println("The total marks for each student as follows");
			marks t1=new marks(mark,n,1);
			t1.start();
			t1.join();
			System.out.println("---------------Thread-2--------------");
			System.out.println("The avgerage marks in each subject");
			marks t2=new marks(mark,n,2);
			t2.start();
			t2.join();
			System.out.println("---------------Thread-3--------------");
			System.out.println("Student marks in decending order ");
			marks t3=new marks(mark,n,3);
			t3.start();
			t3.join();
		}
		catch(Exception e)
		{}
	}
}
class marks extends Thread
{
	int m[][],n,t;
	marks(int mark[][],int num,int tno)
	{
		m=mark;
		t=tno;
		n=num;
		for(int i=0;i<n;i++)
		{
			m[i][4]=m[i][1]+m[i][2]+m[i][3];
		}
	}
	public void run()
	{
		if(t==1)
		{
			System.out.print("Student no. \t");
			System.out.print("Regno \t");
			System.out.print("Total \n");
			for(int i=0;i<n;i++)
			{
				System.out.print("Student :"+(i+1)+": ");
				System.out.println("\t"+m[i][0]+"\t"+m[i][4]);
			}
		}
		else if(t==2)
		{

			System.out.print("Subject no. \t");
			System.out.print("Total \n");
			float a1=0,a2=0,a3=0;
			for(int i=0;i<n;i++)
			{
				a1=a1+(float)m[i][1];
				a2=a2+(float)m[i][2];
				a3=a3+(float)m[i][3];
			}

				System.out.println("Subject 1 :\t"+a1);
				System.out.println("Subject 2 :\t"+a2);
				System.out.println("Subject 3 :\t"+a3);

		}
		else
		{
			System.out.print("Regno \t");
			System.out.print("Total \n");
			int[][] mark=m.clone();
			int num[]=new int[n];
			int std[]=new int[n];
			int tempno[]=new int[n];
			for(int i=0;i<n;i++)
			{
					std[i]=(i+1);
			}
			for(int i=0;i<n;i++)
			{
				//System.out.print("Student :"+(i+1)+": ");
				for(int j=i+1;j<n;j++)
				{
					if(mark[i][4]<mark[j][4])
					{
						int[] temp=mark[i];
						//std[i]=(j);
						//System.out.println(std[i]);
						mark[i]=mark[j];
						mark[j]=temp;
						
						tempno[i]=std[i];
						std[i]=std[j];
						std[j]=tempno[i];
					}
				}
				System.out.println("Student "+std[i]+": "+mark[i][0]+" \t "+mark[i][4]);
			}
		}

	}
}