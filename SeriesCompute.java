public class SeriesCompute {
 /**
  * My program assumes you always pass valid alphabets.
  * For Non alphabet strings, program may behave wierd as no error handle is done for them
  * @param args
  */
 public static void main(String[] args) {
  SeriesCompute computer = new SeriesCompute();

  //TESTING for computeForAlphabets
  System.out.println(computer.computeForAlphabets("A"));
  System.out.println(computer.computeForAlphabets("B"));
  System.out.println(computer.computeForAlphabets("C"));
  System.out.println(computer.computeForAlphabets("E"));
  System.out.println(computer.computeForAlphabets("F"));
  System.out.println(computer.computeForAlphabets("Z"));
  System.out.println(computer.computeForAlphabets("GREP"));

  //TESTING for smallestSeries
  // System.out.println(computer.smallestSeries(1));
  // System.out.println(computer.smallestSeries(4));
  // System.out.println(computer.smallestSeries(5));
  // System.out.println(computer.smallestSeries(20));
  // System.out.println(computer.smallestSeries(283883));
  // System.out.println(computer.smallestSeries(1984549879));
 }

 public int computeForAlphabets(String input){
  if(input == null || input.length() == 0){
   return 0;
  }
  input = input.toUpperCase();
  int sum = 0;
  for(int i=0;i<input.length();i++){
   sum += compute((int)input.charAt(i) - 64);
  }
  return sum;
 }

 public String smallestSeries(int input){
  String series = "";
  int last_max = 26;
  while(input > 0){
   for(int i=last_max;i>0;i--){
    int temp = compute(i);
    //To further optimze this we can use a MOD (%) operator, this will
    //prove good if the input number is huge. Will find many Z's in one shot
    if(temp <= input){
     input -= temp;
     last_max = i;
     series += ((char)(i + 64));
     break;
    }
   }
  }
  return series;
 }

 public int compute(int n){
  if (n < 0){
   return 0;
  }
  if (n == 1){
   return 1;
  }
  return n + 2 * compute(n-1);
 }
}
