package application;

public class Xianc {

	public static void main(String[] args) {
		Runnable runnable = new PrintMe();
		Thread thread1 = new Thread(runnable);
		Thread thread2 = new Thread(runnable);
		Thread thread3 = new Thread(runnable);
		
		thread1.setName("thread1");
		thread2.setName("thread2");
		thread3.setName("thread3");
		
		thread1.start();
		thread2.start();
		thread3.start();
		
	}

}

class PrintMe implements Runnable
{
	public void run(){
		
		for(int i=0; i<10; i++)
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