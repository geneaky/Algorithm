import java.util.Arrays;
import java.util.Random;

public class StanleyPYFungPaperSort {

  public static void main(String[] args) {

    Random random = new Random();
    random.setSeed(System.currentTimeMillis());

    Integer[] numbers = new Integer[10];

    for(int i = 0; i < 10; i++){
      numbers[i] = random.nextInt();
    }

    Integer[] nums = simplest_sort(numbers);

    Arrays.sort(numbers);

    if(Arrays.equals(numbers,nums)){
      System.out.println("SORTED !!!");
    }else{
      System.out.println("NOT SORTED !!!");
    }


  }

  private static Integer[] simplest_sort(Integer[] numbers){
    Integer[] nums = numbers.clone();
    for(int i  = 0; i < nums.length; i++){
      for(int j = 0; j < nums.length; j++){
        if(nums[i] < nums[j]){
          Integer temp = nums[i];
          nums[i] = nums[j];
          nums[j] = temp;
        }
      }
    }

    return nums;

  }
}
