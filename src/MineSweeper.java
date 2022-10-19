import java.util.*;
public class MineSweeper {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		int a;
		int b;

		Scanner sc= new Scanner(System.in);
		System.out.println("Alan Büyüklüğünü Girin:");
		a=sc.nextInt();
		
		System.out.println ("Mayın Sayısını Belirleyin:");
		b=sc.nextInt();
		

		
		int [][] table= SweeperTable(a,b);
		
		int l= table.length;
		
/*		for (int i=0; i<l ; i ++) {
			for (int j=0 ; j<l; j++) {
			System.out.print(table[i][j]);
			}
			
			System.out.println();
		}
*/		
		Play(table);
		
		
		
		
		
	}
	
	
	
	public static int[][] SweeperTable(int squaresize, int MineQuantity) {
		Random rand= new Random();
		int [][] minefield;
		
		minefield = new int[squaresize][squaresize];

		for (int i = 0; i < MineQuantity; i++) {
			
			int vertical=rand.nextInt(squaresize);
			int horizontal=rand.nextInt(squaresize);
			
			minefield[vertical][horizontal]=1;
			
		}
		
		
		for (int h=0; h<squaresize ; h++) {
			
			for (int j=0 ; j<squaresize ; j++) {

				System.out.print(minefield[h][j] + " ");
				
			}
			
			int b=0;
			
			for (int k = 0  ; k < squaresize; k++) {
				
				for (int t= 0 ; t< squaresize ; t++) {
					
					
			b = b + minefield[k][t];
			
					
					
				}
				
			}
			
			if (b < (MineQuantity)) {
				
				
				while (b<MineQuantity) {
				
				int h1=rand.nextInt(squaresize);
				int h2=rand.nextInt(squaresize);
				
				minefield[h1][h2]=1;
				
			}
			
			}
			
			
			System.out.println();
			
		}
		
		return minefield;
		
		
	}
	
	
	public static void Play (int[][] minefield) {
		
		int a;
		int b;
		int r=0;
		Scanner sc = new Scanner (System.in);
		
		
		do {
		
		System.out.println("X Koordinatı");
		
		a=sc.nextInt();
		
		System.out.println("Y Koordinatı");
				b=sc.nextInt();

		if (minefield[a][b]==1) {
			System.out.println("GAME OVER!!!");
		}else {
		
			if(a>0 && b>0) {
			r = minefield[a-1][b]+minefield[a+1][b]+minefield[a][b-1]+minefield[a][b+1]+minefield[a+1][b-1]+minefield[a-1][b-1]+minefield[a+1][b+1]+minefield[a-1][b+1] ;
		} else if(a==0 && b>0) {
			
			r =minefield[a+1][b]+minefield[a][b-1]+minefield[a][b+1]+minefield[a+1][b-1]+minefield[a+1][b+1];

			
		}else if(a>0 && b==0) {
			
			r = minefield[a-1][b]+minefield[a+1][b]+minefield[a][b+1]+minefield[a+1][b+1]+minefield[a-1][b+1] ;

			
		} else if (a== 0 && b== 0) {
			r= minefield[a][b+1]+minefield[a+1][b]+minefield[a+1][b+1];
		} else if (a==minefield.length && b<minefield.length) {
			
			r = minefield[a-1][b]+minefield[a][b-1]+minefield[a][b+1]+minefield[a-1][b-1]+minefield[a-1][b+1] ;
			
		} else if  (a<minefield.length && b==minefield.length) {
			
			r = minefield[a-1][b]+minefield[a+1][b]+minefield[a][b-1]+minefield[a+1][b-1]+minefield[a-1][b-1];
			
		}else if  (a==minefield.length && b==minefield.length) {
			
			r = minefield[a-1][b]+minefield[a][b-1]+minefield[a-1][b-1];
			
		}
		}
				
			
		
			System.out.println(r);
		}
		while ( minefield[a][b]==0 );
	}

}
