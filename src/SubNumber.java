import java.util.Scanner;

public class SubNumber {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int testCases=Integer.parseInt(sc.nextLine());
        for(int t=0;t<testCases;++t){
            int N=sc.nextInt();
            int K=sc.nextInt();
            sc.nextLine();
            String input=sc.nextLine();
            int prefix[]=new int[N];
            prefix[0]=input.charAt(0)-'0';
            for(int index=1;index<N;++index){
                prefix[index]=prefix[index-1]^(input.charAt(index)-'0');
                // System.out.println(prefix[index]);
            }
            int rem=0;
            int maximum=0;
            int resultingIndex=N;
            preComputing(K);
            for(int i=N-1;i>0;i--){
                rem=(((input.charAt(i)-'0')*position[N-i-1])+rem)%K ;
                if(rem==0 && prefix[i-1]>=maximum && input.charAt(i)!='0'){
                    maximum=prefix[i-1];
                    resultingIndex=i;
                }
            }
            if(resultingIndex==N){
                System.out.println("-1");
            }
            else{
                String result=input.substring(resultingIndex);
                int nonZeroIndex=0;
                for(int i=0;i<result.length();++i){
                    if(result.charAt(i)!= '0'){
                        nonZeroIndex=i;
                        break;
                    }
                }
                System.out.println(result.substring(nonZeroIndex));
            }
        }
    }
    static int position[]=new int[100005];
    public static void preComputing(int k){
        position[0]=1;
        for(int i=1;i<position.length;++i){
            position[i]=(position[i-1]*10)%k;
        }
    }
}
