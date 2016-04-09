import java.util.ArrayList;

public class Solution {
	
	public static void main(String[] args) {
		//int[]steps = {2,5,10,8};
		int[]steps = {3,5,1,6};
		//int[]steps = {4};
		//int[]steps = {1,3,1,4,2,5};
		//int[]steps = {};
		System.out.println(solution(steps, 7, 3));
	}

	public static int solution(int[]A, int x, int d){
		int progress = 0;
		boolean leaf[] = new boolean[x+1]; // keep track of available leaves
		leaf[x] = true; // destination leaf
		boolean progressUpdated = false;
		
		if(A.length == 0) return -1; // frog unable to jump
		if(d == x) return 0; // frog can jump to destination without a leave
		
		for( int i = 0; i < A.length; i++){
			leaf[A[i]] = true; // leaf at position A[i] now available
			
			if(progress + d >= A[i] && progress < A[i]){
				progress = A[i];
				progressUpdated = true;
				while(progressUpdated){
					progressUpdated = false;
					for(int j = 1; j <= d; j++){  
						if(progress + j >= x) return i;
						if( progress + j < x && leaf[progress + j] ){   // check if progress can be extended 
							progress = progress + j; 
							progressUpdated = true;
						}
					}
				}
			}
		}
		return -1;
	}
}
