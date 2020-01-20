/**
 * 
 * @author 冷亚麻色的？
 * 
 * Question:can you explain the behavior of your program?
 * 
 * 因为从main线程开始运行以后
 * 三个线程就开始同时运行了
 * 并且由操作系统调度
 * 程序本身无法确定线程的调度顺序
 * 
 *
 */

public class Main 
{
	public static void main (String[] args)
	{
		Runnable runnable = new PrintMe();
		Thread first = new Thread(runnable);
		Thread second = new Thread(runnable);
		Thread third = new Thread(runnable);
		first.setName("first");
		second.setName("second");
		third.setName("third");
		first.start();
		second.start();
		third.start();
	}
}

class PrintMe implements Runnable
{
	public void run ()
	{
		int cnt = 10;
		while (cnt-- > 0)
		{
			System.out.println(Thread.currentThread().getName());
			try
			{
				Thread.sleep(2000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}