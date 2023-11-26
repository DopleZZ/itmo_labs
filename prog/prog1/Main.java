import java.util.Random;




public class Main 
{
	public static void main(String[] args)
	{
		long[] c = new long[7];
		int number = 5;
		for (int i=0;i< c.length;i++)
		{
			c[i]=number;
			number = number + 2;
			
		}
		Random randD = new Random();
		double number2;
		double[] x = new double[15];
		for (int i=0;i<x.length;i++)
		{
			number2 = randD.nextDouble(-10,15);

			x[i]=number2;
		} 
		

		double[][] d = new double[7][15];
		for (int i=0;i<=6;i++)
		{
			for (int j=0;j<=14;j++)
			{
				if (i==5){
					d[i][j]=0.5/((1.0/2.0)+Math.tan((0.5+x[j])/x[j]));
				}
				else if (i==7|i==9|i==11){
					d[i][j]=Math.pow(Math.pow((Math.cos(x[j])/1.0)/3.0,3.0),-3);
				}
				else {
					d[i][j] = Math.pow(Math.pow(Math.pow(1.0-Math.pow(x[j]/0.5,2.0),-3.0),3.0), 
					(2.0/3.0)*(Math.log(Math.pow(Math.sin(Math.pow(Math.pow(3.0/(x[j]+1),x[j])/Math.PI-Math.pow(3.0/4.0*x[j],2.0),
					Math.atan((x[j]+2.5)/25.0))),2.0)))-3.0);
				}
			}
		}
		for(double[] row:d)
		{
			for (double i:row)
			{	
				int count = 0;
				for (int k=0;k<row.length;k++){
					if (Double.isNaN(row[k])){
						count+=1;
					}
				}
				if (count==15){
					System.out.println("Наны есть??? а если найду?????????");
					break;
				}
				else{
				String st = String.format("%.2f",i);
				System.out.printf("%5s",st);
				System.out.print("\t");
					}
			}
			System.out.println();
		}

	}
}
