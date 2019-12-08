import java.util.*; 
import java.io.*;

class Main {
  
  public static int Pow(int num, int pow){
    if (pow == 0){
      return num; //case of power of 0
    }
    else {
      int multiplier = 10; //case of a power greater than 0
      while (pow > 1){
        multiplier *= 10;
        pow--;
      }
      num = num*multiplier;
      return num;
    }
  }
  public static void sortAscend(int arr[]){
    int n = arr.length;
    for (int i = 0; i < n-1; i++){
      for (int j = 0; j < n - i - 1;j++){
        if (arr[j] < arr[j+1]){
          int tmp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = tmp;
        }
      }
    }
  }

  public static int KaprekarsConstant(int num) {
    int cycles = 0;
    while (num != 6174){
      int numChar[] = new int[4]; //puls apart int to be transposed
      int i = 0; //counter
      int transposeNum = 0; //reverse int
      int tempNum = num; //allows safe manipulation of num.
      while (tempNum > 0){
        //System.out.print((tempNum % 10));
        numChar[i] =(tempNum % 10);
        tempNum = tempNum/10;
        i++;
      }
      sortAscend(numChar);
      /*
      System.out.println();
      for (int j = 0; j < numChar.length; j++){
        System.out.print(numChar[j]);
        System.out.println();
      }*/
      for (int j = 0; j <= numChar.length - 1; j++){
          tempNum += Pow(numChar[j], j); //transposes pulled apart number at returns it as an int.
      }
      //System.out.println(tempNum);
      int n = numChar.length - 1;
      for (int j = 0; j <= numChar.length - 1; j++){
          transposeNum += Pow(numChar[j], n); //transposes pulled apart number at returns it as an int.
          n--;
      }
     // System.out.println(transposeNum);
     // System.out.println(num);
      num = transposeNum - tempNum;
      cycles++;
    }
    return cycles;
  }

  public static void main (String[] args) {  
    // keep this function call here     
    Scanner s = new Scanner(System.in);
    System.out.print(KaprekarsConstant(s.nextLine())); 
  }

}