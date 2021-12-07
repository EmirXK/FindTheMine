import java.util.Scanner;

public class stargame {

    public static void main(String[] args) {
        String[][] arrString = new String[8][8];
        int chance;
        int enter_x=10,enter_y=10,chosen_x,chosen_y;
        Scanner scan = new Scanner(System.in);
        createArr(arrString, "X");
        printArr(arrString);
        chosen_x = (int)(Math.random()*7);
        chosen_y = (int)(Math.random()*7);

        while(enter_x != chosen_x || enter_y != chosen_y){
            
            System.out.print("Enter x coordinate:");
            enter_x = scan.nextInt();
            System.out.print("Enter y coordinate:");
            enter_y = scan.nextInt();
            System.out.println();
        
            if(enter_x-1 != chosen_x || enter_y-1 != chosen_y){
                chance = (int)(Math.random()*99)+1;

                if(chance<51){
                    arrString[enter_y-1][enter_x-1] = String.valueOf(Math.abs(enter_x-chosen_x-1));
                    printArr(arrString);
                }
                else{
                    arrString[enter_y-1][enter_x-1] = String.valueOf(Math.abs(enter_y-chosen_y-1));
                    printArr(arrString);
                }

            }

            else{
                arrString[enter_y-1][enter_x-1] = "*";
                printArr(arrString);
                System.out.println();
                System.out.println("You found the star!!");
                break;
            }
        }

        scan.close();
    }

    public static void printArr(String[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static void createArr(String[][] array,String str) {
        for (int index = 0; index < array.length; index++) {
            for (int i = 0; i < array[index].length; i++) {
                array[index][i] = str;
            }
        }
    }
}