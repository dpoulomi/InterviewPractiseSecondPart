public class PowerofX {

    public static void main(String[] args)
    {
        PowerofX powerofX= new PowerofX();
        float x = 2;
        int y = -3;
        System.out.printf("%f", powerofX.power(x, y));
    }

    private float power(float x, int y) {
        float result = 0;
        if(y == 0){
            return 1;
        }
        result = power(x , y/2);

        if(y % 2 ==0){
            return result * result;
        }else{
            if( y > 0){
                return x * result * result;

            }else{
                return  (result * result)/x;
            }

        }

    }


}
