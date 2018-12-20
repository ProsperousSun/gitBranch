package sumrize;

public class Try_Catch {

    public static void main(String[] args) {
        int[] arr=new int[5];
        arr[0]=1;
        arr[1]=0;
        arr[2]=3;
        arr[3]=4;
        arr[4]=5;
        try {
            ExceptionPractice(arr);
        }catch (Exception e){
            System.out.println("----------------");
            System.out.println(e);
        }

    }

    private static void ExceptionPractice(int[] xx) throws Exception {
        try {
           int x=2/0;
        }catch (Exception e){
            System.out.println("Exception"+e);
            throw new Exception(e);
        }
    }

}
