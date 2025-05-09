package exception;

public class ExceptionDemo {
// checked and unchecked(within my boundary)
    // Exception : IOException(checked), RuntimeException(unchecked)
    public static void main(String[] args) {
        System.out.println("hello");
        String[] arr = {"1","10","abc5","20"};
        int l = arr.length;
        for (int i = 0; i < l; i++) {
            String no = null;
            try {
                if(i==1)
                    no = arr[6];
                else
                    no=arr[i];
                int n = Integer.parseInt(no);
                System.out.println(n * n);
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println("could not process "+no+" as index out of range");
                System.out.println(e.getMessage());
                e.printStackTrace();
            }
            catch (NumberFormatException e){
                System.out.println("could not process for other data types");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }


    }
}
